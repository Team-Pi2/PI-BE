package com.oasis.flowershop.domain.chat.application.service;

import com.oasis.flowershop.domain.chat.application.dto.CreateChatRoomRequest;
import com.oasis.flowershop.domain.chat.application.event.ChatRoomCreateEvent;
import com.oasis.flowershop.domain.chat.application.exception.NotFoundChatException;
import com.oasis.flowershop.domain.chat.application.model.ChatRoomModel;
import com.oasis.flowershop.domain.chat.application.model.converter.ChatRoomModelConverter;
import com.oasis.flowershop.domain.chat.application.usecase.ChatCreateUseCase;
import com.oasis.flowershop.domain.chat.application.usecase.ChatGetUseCase;
import com.oasis.flowershop.domain.chat.persistence.*;
import com.oasis.flowershop.domain.chat.persistence.converter.ChatEntityConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService
        implements ChatGetUseCase, ChatCreateUseCase {

    private final RoomRepository roomRepository;
    private final ChatRepository chatRepository;
    private final TagRepository tagRepository;
    private final ChatEntityConverter chatEntityConverter;
    private final ChatRoomModelConverter chatModelConverter;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public List<ChatRoomModel> findAll(){
        List<ChatEntity> entities = chatRepository.findAll();
        List<ChatRoomModel> models = entities.stream()
                .map(chatModelConverter::from)
                .sorted(Comparator.comparing(ChatRoomModel::getMember))
                .toList();

        return models;
    }

    @Override
    public List<ChatRoomModel> findByKeyword(String keyword){
        List<ChatEntity> entities = chatRepository.findAll();
        List<ChatRoomModel> models = entities.stream()
                .map(chatModelConverter::from)
                .filter(model -> model.getTitle().contains(keyword))
                .sorted(Comparator.comparing(ChatRoomModel::getMember).reversed())
                .toList();

        return models;
    }

    @Override
    @Transactional
    public Long createChatRoom(CreateChatRoomRequest request){
        ChatEntity entity = chatEntityConverter.toEntity(request);
        ChatEntity saved = create(entity);
        ChatRoomCreateEvent event = ChatRoomCreateEvent.of(saved.getChatId(), request.getTags());
        eventPublisher.publishEvent(event);
        return saved.getChatId();
    }

    @Override
    public ChatRoomModel findOne(Long chatId) {
        ChatEntity entity = find(chatId);
        ChatRoomModel model = chatModelConverter.from(entity);

        return model;
    }

    public void createMember(Long chatId){
        Random random = new Random();
        for(long i=0; i<random.nextInt(3,20); i++) {
            Long roomId = roomRepository.save(
                    RoomEntity.builder()
                            .chatId(chatId)
                            .memberId(i)
                            .build()).getRoomId();
            log.info("생성된 id : "+roomId);
        }
    }

    private ChatEntity create(ChatEntity entity) {
        return chatRepository.save(entity);
    }

    private ChatEntity find(Long chatId){
        return chatRepository.findById(chatId)
                .orElseThrow(NotFoundChatException::new);
    }

}

package com.oasis.flowershop.domain.chat.application.event;

import com.oasis.flowershop.domain.chat.persistence.RoomEntity;
import com.oasis.flowershop.domain.chat.persistence.RoomRepository;
import com.oasis.flowershop.domain.chat.persistence.TagEntity;
import com.oasis.flowershop.domain.chat.persistence.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChatRoomCreateEventListener {

    private final TagRepository tagRepository;
    private final RoomRepository roomRepository;
    private long memberCnt=10;

    @EventListener
    public void createTags(ChatRoomCreateEvent event){
        List<TagEntity> entities = event.getTags().stream()
                        .map(t->TagEntity.of(event.getChatId(), t))
                        .toList();
        tagRepository.saveAll(entities);
        createDefaultRoom(event);
        memberCnt+=10;
    }

    private void createDefaultRoom(ChatRoomCreateEvent event){
        for(long i=memberCnt; i<memberCnt+10; i++) {
            RoomEntity entity = roomRepository.save(RoomEntity.builder().chatId(event.getChatId()).memberId(i).build());
            log.info("새로운 채팅방 생성 : " + entity.getRoomId());
        }
    }
}

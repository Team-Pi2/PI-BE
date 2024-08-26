package com.oasis.flowershop.domain.chat.application.support;

import com.oasis.flowershop.domain.chat.persistence.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultRoomCreator {

    private final RoomRepository roomRepository;

    public void createDefaultRoom(){
        
    }

}

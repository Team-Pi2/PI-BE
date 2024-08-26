package com.oasis.flowershop.domain.chat.application.exception;

import com.oasis.flowershop.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class NotFoundChatException extends BusinessException {

    private static final String FAIL_CODE = "2000";

    public NotFoundChatException(){
        super(FAIL_CODE, HttpStatus.BAD_REQUEST);
    }

    @Override
    public String getMessage(){ return "채팅방을 찾을 수 없습니다."; }

}

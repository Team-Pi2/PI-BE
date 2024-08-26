package com.oasis.flowershop.domain.order.application.exception;

import com.oasis.flowershop.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends BusinessException {

    private static final String FAIL_CODE = "1000";

    public CategoryNotFoundException(){
        super(FAIL_CODE, HttpStatus.BAD_REQUEST);
    }

    @Override
    public String getMessage(){ return "해당 카테고리가 존재하지 않습니다."; }

}

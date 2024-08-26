package com.oasis.flowershop.domain.plant.application.exception;

import com.oasis.flowershop.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class NotFoundPlantException extends BusinessException {

    private static final String FAIL_CODE = "3000";

    public NotFoundPlantException(){
        super(FAIL_CODE, HttpStatus.BAD_REQUEST);
    }

    @Override
    public String getMessage(){ return "해당 식물을 찾을 수 없습니다.";}

}

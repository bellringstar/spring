package com.example.exception.exception;

import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@Slf4j
@Order(value = 1)
//여러개 있을 때 순서
@RestControllerAdvice (basePackages = "com.example.exception.controller")
//RestApi에서 발생하는 예외 감지 global 모든 ApiController의 에러를 잡음
//basePackage를 통해 특정 페지키만을 확인도 가능
//basePacageClasses의 경우는 특정 클래스만을 타겟으로도 가능
public class RestApiExceptionHandler {

//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity exception(Exception e){
//        log.error("RestApiExceptionHandler", e);
//
//        return ResponseEntity.status(200).build();
//    }

    //구체적으로 설정해줘서 여기서 잡음
    @ExceptionHandler(value = { IndexOutOfBoundsException.class })
    public ResponseEntity outOfBound(IndexOutOfBoundsException e){
        log.error("IndexOutOfBoundsException", e);

        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement(NoSuchElementException e){
        log.error("",e);
        Api<Object> response = Api.builder().resultCode(String.valueOf(HttpStatus.NOT_FOUND.value())).resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}

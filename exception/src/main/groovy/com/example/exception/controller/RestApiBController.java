package com.example.exception.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/b")
@Slf4j
public class RestApiBController {

    @GetMapping("")
    public void hello(){
        throw new NumberFormatException("number format exception");
    }

//    @ExceptionHandler(value = {NumberFormatException.class}) //로컬에 달아주면 글로벌로 가지 않고 해당 컨트롤러 내부에서 해결
//    public ResponseEntity numberFormatException(NumberFormatException e){
//        log.error("RestApiBController", e);
//
//        return ResponseEntity.ok().build();
//    }
}

package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

    //http://localhost:8080/api/v1
//    @GetMapping("")
//    public UserRequest user(){
//        var user = new UserRequest();
//        user.setName("홍길동");
//        user.setAge(15);
//        user.setEmail("hongh@gamic.com");
//        user.setPhoneNumber("123-123-213");
//
//        return user; 자동으로 JSON으로 변환 후 200 status
//    }
//}

    @GetMapping("")
    public ResponseEntity<UserRequest> user(){
        var user = new UserRequest();
        user.setName("홍길동");
        user.setAge(15);
        user.setEmail("hongh@gamic.com");
        user.setPhoneNumber("123-123-213");

        var response = ResponseEntity
                .status(HttpStatus.CREATED)
                .header("x-custom", "hi")
                .body(user);

        return response;
    }
}




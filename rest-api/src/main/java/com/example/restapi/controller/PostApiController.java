package com.example.restapi.controller;


import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post(
            @RequestBody BookRequest bookRequest
    ){
        System.out.println("bookRequest = " + bookRequest);
        return bookRequest.toString();
    }

    @PostMapping("/user")
    public UserRequest userPost(@RequestBody UserRequest userRequest){
        System.out.println("userRequest = " + userRequest);
        return userRequest;
    }
}

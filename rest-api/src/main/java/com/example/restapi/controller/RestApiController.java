package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hell(){
        var html = "<html><body><h1>Hello World!</h1></body></html>";

        return html;
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable String message,
                       @PathVariable int age,
                       @PathVariable boolean isMan){
        //Integer : null 할당 가능, int: null 불가능, 기본값 0
        System.out.println("message = " + message);
        System.out.println("age = " + age);
        System.out.println("isMan = " + isMan);
        return message.toUpperCase();
    }

    //http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=12&issued_day=31
    @GetMapping(path="/book")
    public void queryParam(@RequestParam String category,
                           @RequestParam String issuedYear,
                           @RequestParam(name = "issued-month") String issuedMonth,
                           @RequestParam String issued_day
                           ){
        System.out.println("category = " + category);
        System.out.println("issuedYear = " + issuedYear);
        System.out.println("issuedMonth = " + issuedMonth);
        System.out.println("issued_day = " + issued_day);
    }

    //http://localhost:8080/api/book?category=IT&issuedYear=2023&issuedMonth=12&issuedDay=31
    @GetMapping(path="/book2")
    public void queryParamDto(BookQueryParam bookQueryParam){
        System.out.println("bookQueryParam = " + bookQueryParam);
    }

    //ToDo Parameter 2가지를 int로 받아 두 수의 덧셈 곱셈을 리턴
    @GetMapping(path="/cal")
    public void calc(@RequestParam int a, @RequestParam int b){
        System.out.println("a+b = " + (a+b));
        System.out.println("a*b = " + (a*b));
    }

    @DeleteMapping(path={"/user/{username}/delete", "/user/{username}/del"})
    public void delete(@PathVariable String username){
        log.info("user-name : {}", username);
    }

}

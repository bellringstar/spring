package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController  {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity){
        return userService.save(userEntity);
    }


    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable long id){
        var response = userService.findById(id);
        return response.get();
    }


//    @DeleteMapping("/{id}/delete")
//    public void delete(@PathVariable long id){
//        userService.delete(id);
//    }

    @GetMapping("/score")
    public List<UserEntity> filterScore(@RequestParam int score){
        return userService.filterScore(score);
    }

    @GetMapping("/min_max")
    public List<UserEntity> filterScore(@RequestParam int min, @RequestParam int max){
        return userService.filterScore(min, max);
    }

}

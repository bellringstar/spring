package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public UserEntity save(UserEntity user){

        return userRepository.save(user);

    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(long id){
        return userRepository.findById(id);
    }

    public void delete(UserEntity id){
        userRepository.delete(id);
    }

    public List<UserEntity> filterScore(int score){
        return userRepository.findAllByScoreGreaterThan(score);
    }

    public List<UserEntity> filterScore(int min, int max){
        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(min, max);
    }



}

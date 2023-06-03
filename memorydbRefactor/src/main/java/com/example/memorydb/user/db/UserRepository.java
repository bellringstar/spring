package com.example.memorydb.user.db;


import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // select * from user where score >= {score}

    //키워드로 지정 된 메서드 By 뒤론느 where절 = query method 추천
    public List<UserEntity> findAllByScoreGreaterThan(int score);

    // select * from user where score>=?? and score<=??
    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    // native query  ?1 = 첫번째 파라미터 ?2 = 두번째 파라미터
//    @Query(
//            "select u from user u where u.score >=?1 AND u.score <= ?2"
//    )
//    @Query(value = "select * from user as u  where u.score >=?1 AND u.score <= ?2",nativeQuery = true)
//    List<UserEntity> score(int min, int max);


    // named parameter 추천
    @Query(
            value = "select * from user as u  where u.score >=:min AND u.score <=:max",nativeQuery = true
    )
    List<UserEntity> score(
            @Param(value = "min") int min,
            @Param(value = "max") int max
    );


}

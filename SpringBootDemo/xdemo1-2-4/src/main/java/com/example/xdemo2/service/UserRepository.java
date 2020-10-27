package com.example.xdemo2.service;

import com.example.xdemo2.model.User;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value="select * from user ",nativeQuery=true)
    List<User> getAllUser();

    @Query(value="select * from user where id =?1",nativeQuery=true)
    User getOneById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "insert into user(id, name, mobile, email) values (?1, ?2, ?3, ?4)",nativeQuery = true)
    int createUser(Integer id,String name,String email,String mobile);

    @Transactional
    @Modifying
    @Query(value = "delete from user where id = ?1",nativeQuery = true)
    int deleteUserByID(Integer id);


    //重写方法
    List<User> findByEmail(String email);


}



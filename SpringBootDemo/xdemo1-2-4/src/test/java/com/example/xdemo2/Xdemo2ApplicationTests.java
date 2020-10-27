package com.example.xdemo2;

import com.example.xdemo2.model.User;
import com.example.xdemo2.service.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.GeneratedValue;

@SpringBootTest
class Xdemo2ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void Test1(){
        System.out.println(userRepository.getAllUser());
        System.out.println(userRepository.getOneById(4));
    }

    @Test
    public void Test2(){
        User user = new User();
        user.setId(6);
        user.setName("胖胖");
        user.setEmail("617384672@qq.com");
        user.setMobile("113456");
        System.out.println(userRepository.createUser(user.getId(),user.getName(),user.getEmail(),user.getMobile()));
        System.out.println();
    }
    @Test
    public void Test3(){
        System.out.println(userRepository.deleteUserByID(6));
    }


    @Test
    public void Test4(){

        System.out.println(userRepository.findByEmail("289938"));
    }





}

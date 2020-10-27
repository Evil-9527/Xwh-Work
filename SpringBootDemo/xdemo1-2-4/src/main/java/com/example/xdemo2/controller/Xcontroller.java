package com.example.xdemo2.controller;

import com.example.xdemo2.model.User;
import com.example.xdemo2.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/Xuser")
public class Xcontroller {

    private static final Logger logger = LoggerFactory.getLogger(Xcontroller.class);

    // 用户Servic对象
    @Autowired
    private UserRepository userRepository;

    /**
     * 所有用户信息取得
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getAllUser() {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            List<User> list = this.userRepository.getAllUser();
            result.put("status", "ok");
            result.put("list", list);
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 指定用户信息取得
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Object getUserDetail(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            User user = this.userRepository.getOneById(id);
            if (user != null) {
                result.put("status", "ok");
                result.put("user", user);
            } else {
                result.put("status", "failure");
                result.put("errMsg", "用户不存在");
            }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 创建用户信息
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Object createUser(@RequestParam(value = "id", required = true) Integer id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "mobile", required = false) String mobile,
                             @RequestParam(value = "email", required = false) String email) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setMobile(mobile);
            user.setEmail(email);
            int cnt = this.userRepository.createUser(user.getId(),user.getName(),user.getEmail(),user.getMobile());
            if (cnt > 0) {
                result.put("status", "ok");
                result.put("user", user);
            } else {
                result.put("status", "failure");
                result.put("errMsg", "用户创建失败");
            }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 指定用户信息删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object deleteUser(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            int cnt = this.userRepository.deleteUserByID(id);
            if (cnt > 0) {
                result.put("status", "ok");
            } else {
                result.put("status", "failure");
                result.put("errMsg", "用户删除失败");
            }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }
}
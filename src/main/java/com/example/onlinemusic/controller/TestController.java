package com.example.onlinemusic.controller;

import com.example.onlinemusic.model.User;
import com.example.onlinemusic.tools.ResponseBodyMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 12629
 * @Date 2022/5/11 14:57
 * @Description：
 */
@RestController
@RequestMapping("/hhhh")
public class TestController {

    @RequestMapping("/test")
    public ResponseBodyMessage<User> login(@RequestParam String username,
                                           @RequestParam String password) {
        System.out.println("username "+username);
        System.out.println("password "+password);

        User user = new User();

        if(username.equals("bit") && password.equals("123456")) {
            user.setUsername(username);
            user.setPassword(password);
            return new ResponseBodyMessage<>(0,"登录成功！",user);
        }else {
            return new ResponseBodyMessage<>(0,"登录失败！",null);
        }
    }
}

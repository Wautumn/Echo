package com.wang.store.service;

import com.wang.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: WHQ
 * @Date: 2019/5/4 10:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JWTServiceTest {
    @Autowired
    JWTService jwtService;

    @Autowired
    UserService userService;


    @Test
    public void create() throws Exception {
        User user = userService.IfExist("w");

        String token = jwtService.createToken(user);

        System.out.println(token);


    }

    @Test
    public void verify() throws Exception {
        int id=jwtService.verifyToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoidyIsInVzZXJpZCI6IjEifQ.t_AX8bYe8fo8GT5NLna2x_YfkslKJMJydAIYpjsLrB4");
        System.out.println(id);
    }
}

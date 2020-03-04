package cn.enjoy.controller;

import cn.enjoy.vo.Product;
import cn.enjoy.vo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mla
 * @description
 * @prjectName microcloud
 * @className UserController
 * @date 2020/3/1  14:19
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value="/get/{id}")
    @HystrixCommand
    public User get(@PathVariable("id") long id) {
        User user = new User();
        user.setUserId(12L);
        user.setUserName("username");
        user.setUserCode("usercode");
        return user;
    }
}

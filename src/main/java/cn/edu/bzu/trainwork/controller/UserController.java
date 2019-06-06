package cn.edu.bzu.trainwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wowx on 2019/5/30.
 */
@Controller
public class UserController {
    @RequestMapping("/user")
    public  String userAdd()
    {
        return "user";
    }
}

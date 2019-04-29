package cn.edu.bzu.trainwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wowx on 2019/4/26.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
    @RequestMapping("/system/userlist")
    public String userlist()
    {
        return "/system/userlist";
    }
}

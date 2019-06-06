package cn.edu.bzu.trainwork.controller;

import cn.edu.bzu.trainwork.common.TableDataInfo;
import cn.edu.bzu.trainwork.entity.Traininfo;
import cn.edu.bzu.trainwork.service.ITraininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wowx on 2019/5/31.
 */
@RestController
@RequestMapping("/ccinfo")
public class TraininfoController {
    @Autowired
    ITraininfoService traininfoService;

    @PostMapping(value = "/list")
    public TableDataInfo list() {
        return getDataTable(traininfoService.findAll());
    }

    @PostMapping("add")
    public String  add(Traininfo traininfo)
    {
        System.out.println("add");
        traininfoService.save(traininfo);
        return "success";
    }
    @DeleteMapping("del/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        System.out.println("del");
        traininfoService.del(id);
        return "success";
    }
    /**
     * 响应请求分页数据
     */

    protected TableDataInfo getDataTable(List <?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(list.size());
        return rspData;
    }

}
package cn.edu.bzu.trainwork.controller;

import cn.edu.bzu.trainwork.common.AjaxResult;
import cn.edu.bzu.trainwork.common.BaseController;
import cn.edu.bzu.trainwork.common.page.PageDomain;
import cn.edu.bzu.trainwork.common.page.TableDataInfo;
import cn.edu.bzu.trainwork.entity.Traininfo;
import cn.edu.bzu.trainwork.service.ITraininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by wowx on 2019/5/31.
 */
@Controller
@RequestMapping("/ccinfo")
public class TraininfoController extends BaseController {
    @Autowired
    ITraininfoService traininfoService;

     @GetMapping()
    public String ccinfo()
     {
         return "ccinfo/traininfo";
     }
     @GetMapping("add")
     public String add()
     {
         return "ccinfo/add";
     }

    @PostMapping(value = "/list")
    @ResponseBody
    public TableDataInfo list(PageDomain pageDomain) {

       TableDataInfo tableDataInfo= getDataTable(traininfoService.findAll(pageDomain));
       if(pageDomain.getQueryParams()!=null)
       {
             tableDataInfo =getDataTable(traininfoService.findCreateTime(pageDomain));
       }

        return tableDataInfo;
    }

    @PostMapping("search")
    @ResponseBody
    public  TableDataInfo search(HttpServletRequest request){
        Enumeration enu=request.getParameterNames();
        System.out.println("search");
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));}
            return null;
    }



    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Traininfo traininfo)
    {
        traininfo.setCreateTime(new Date());
        traininfoService.save(traininfo);
        return success();
    }
    @PostMapping("editsave")
    @ResponseBody
    public  AjaxResult editsave(Traininfo traininfo)
    {
        traininfoService.update(traininfo);
        return success();

    }
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Integer id)
    {

        traininfoService.del(id);
        return success();
    }
    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id)
    {
        Traininfo traininfo=traininfoService.findById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("ccinfo/edit");
        modelAndView.addObject("traininfo",traininfo);
        return  modelAndView;
    }
}
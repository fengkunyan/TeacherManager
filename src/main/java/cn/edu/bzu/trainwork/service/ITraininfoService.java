package cn.edu.bzu.trainwork.service;

import cn.edu.bzu.trainwork.common.page.PageDomain;
import cn.edu.bzu.trainwork.entity.Traininfo;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by wowx on 2019/5/31.
 */
public interface ITraininfoService {
    public Page<Traininfo> findAll(PageDomain pageDomain);
    public Traininfo save(Traininfo traininfo);
    public void del(Integer id);
    public Traininfo update(Traininfo traininfo);
    public Traininfo findById(Integer id);
    public  Long count();
    public Page<Traininfo> findCreateTime(PageDomain pageDomain);

}

package cn.edu.bzu.trainwork.service;

import cn.edu.bzu.trainwork.entity.Traininfo;

import java.util.List;

/**
 * Created by wowx on 2019/5/31.
 */
public interface ITraininfoService {
    public List<Traininfo> findAll();
    public Traininfo save(Traininfo traininfo);
    public void del(Integer id);
}

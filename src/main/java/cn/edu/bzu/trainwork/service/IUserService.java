package cn.edu.bzu.trainwork.service;

import cn.edu.bzu.trainwork.entity.Traininfo;

import java.util.List;

/**
 * Created by wowx on 2019/5/30.
 */
public interface IUserService {
    public List<Traininfo> findAll();
}

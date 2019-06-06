package cn.edu.bzu.trainwork.service.impl;

import cn.edu.bzu.trainwork.dao.TraininfoDao;
import cn.edu.bzu.trainwork.entity.Traininfo;
import cn.edu.bzu.trainwork.service.ITraininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wowx on 2019/5/31.
 */
@Service
public class TraininfoServiceImpl implements ITraininfoService {
    @Autowired
    TraininfoDao traininfoDao;
    public List<Traininfo> findAll()
    {
        return traininfoDao.findAll();
    }
    public Traininfo save(Traininfo traininfo)
    {
        return traininfoDao.save(traininfo);
    }
    public void del(Integer id)
    {
        traininfoDao.deleteById(id);
    }
}

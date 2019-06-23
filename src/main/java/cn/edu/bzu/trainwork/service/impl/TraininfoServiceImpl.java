package cn.edu.bzu.trainwork.service.impl;

import cn.edu.bzu.trainwork.common.page.PageDomain;
import cn.edu.bzu.trainwork.dao.TraininfoDao;
import cn.edu.bzu.trainwork.entity.Traininfo;
import cn.edu.bzu.trainwork.service.ITraininfoService;
import cn.edu.bzu.trainwork.utils.DateUtils;
import cn.edu.bzu.trainwork.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wowx on 2019/5/31.
 */
@Service
public class TraininfoServiceImpl implements ITraininfoService {
    @Autowired
    TraininfoDao traininfoDao;

    public Page <Traininfo> findAll(PageDomain pageDomain) {
        Pageable pageable = PageRequest.of(pageDomain.getPage() - 1, pageDomain.getRows());
        Page page = traininfoDao.findAll(pageable);

        return page;
    }

    public Traininfo save(Traininfo traininfo) {
        return traininfoDao.save(traininfo);
    }

    public void del(Integer id) {
        traininfoDao.deleteById(id);
    }

    public Traininfo findById(Integer id) {
        return traininfoDao.findById(id).get();
    }

    @Override
    public Long count() {
        return traininfoDao.count();
    }

    public Traininfo update(Traininfo traininfo) {
        Traininfo traininfoPo = traininfoDao.findById(traininfo.getInfoId()).get();
        traininfoPo.setTitle(traininfo.getTitle());
        traininfoPo.setContent(traininfo.getContent());
        return traininfoDao.save(traininfoPo);
    }

    @Override
    public Page <Traininfo> findCreateTime(PageDomain pageDomain) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");

        if (!StringUtils.isEmpty(pageDomain.getSortOrder()))
        {
            sort = sort.by(Sort.Direction.fromString(pageDomain.getSortOrder()),pageDomain.getSortName());
        }
        Pageable pageable = PageRequest.of(pageDomain.getPage() - 1, pageDomain.getRows(), sort);
        return traininfoDao.findByCreateTimeBetween(DateUtils.dateTime(DateUtils.YYYY_MM_DD,pageDomain.getQueryParams().get("beginDate")),
               DateUtils.dateTime(DateUtils.YYYY_MM_DD,pageDomain.getQueryParams().get("endDate")),pageable);
    }
    }


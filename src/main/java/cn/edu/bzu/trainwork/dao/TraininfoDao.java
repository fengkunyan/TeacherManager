package cn.edu.bzu.trainwork.dao;

import cn.edu.bzu.trainwork.common.page.PageDomain;
import cn.edu.bzu.trainwork.entity.Traininfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * Created by wowx on 2019/5/30.
 */
public interface TraininfoDao  extends JpaRepository<Traininfo,Integer> {

    Page<Traininfo> findAll(Pageable pageable);
    Page<Traininfo> findByCreateTimeBetween(Date createTimeBeging , Date createTimeEnd, Pageable pageable);
}

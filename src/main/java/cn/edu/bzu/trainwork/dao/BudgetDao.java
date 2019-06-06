package cn.edu.bzu.trainwork.dao;

import cn.edu.bzu.trainwork.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wowx on 2019/5/30.
 */
public interface BudgetDao extends JpaRepository<Budget,Integer> {
}

package cn.edu.bzu.trainwork.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by wowx on 2019/5/30.
 */
@Entity
public class Budget {
    private int budgetId;
    private String title;
    private Double ysje;
    private Double hfje;
    private String ysyear;

    @Id
    @Column(name = "budget_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "ysje", nullable = true, precision = 0)
    public Double getYsje() {
        return ysje;
    }

    public void setYsje(Double ysje) {
        this.ysje = ysje;
    }

    @Basic
    @Column(name = "hfje", nullable = true, precision = 0)
    public Double getHfje() {
        return hfje;
    }

    public void setHfje(Double hfje) {
        this.hfje = hfje;
    }

    @Basic
    @Column(name = "ysyear", nullable = true, length = 200)
    public String getYsyear() {
        return ysyear;
    }

    public void setYsyear(String ysyear) {
        this.ysyear = ysyear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return budgetId == budget.budgetId &&
                Objects.equals(title, budget.title) &&
                Objects.equals(ysje, budget.ysje) &&
                Objects.equals(hfje, budget.hfje) &&
                Objects.equals(ysyear, budget.ysyear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(budgetId, title, ysje, hfje, ysyear);
    }
}

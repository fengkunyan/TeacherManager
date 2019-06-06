package cn.edu.bzu.trainwork.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by wowx on 2019/5/30.
 */
@Entity
public class Pxshenbao {
    private int id;
    private String name;
    private String organization;
    private String pxconent;
    private String address;
    private Timestamp begindate;
    private Timestamp enddate;
    private long userId;
    private String txuser;
    private int budgetId;
    private Double feiyong;
    private String pxfile;
    private Byte audit;
    private Byte ccstatus;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 150)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "organization", nullable = false, length = 100)
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Basic
    @Column(name = "pxconent", nullable = false, length = -1)
    public String getPxconent() {
        return pxconent;
    }

    public void setPxconent(String pxconent) {
        this.pxconent = pxconent;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "begindate", nullable = false)
    public Timestamp getBegindate() {
        return begindate;
    }

    public void setBegindate(Timestamp begindate) {
        this.begindate = begindate;
    }

    @Basic
    @Column(name = "enddate", nullable = false)
    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "txuser", nullable = true, length = 200)
    public String getTxuser() {
        return txuser;
    }

    public void setTxuser(String txuser) {
        this.txuser = txuser;
    }

    @Basic
    @Column(name = "budget_id", nullable = false)
    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    @Basic
    @Column(name = "feiyong", nullable = true, precision = 0)
    public Double getFeiyong() {
        return feiyong;
    }

    public void setFeiyong(Double feiyong) {
        this.feiyong = feiyong;
    }

    @Basic
    @Column(name = "pxfile", nullable = true, length = 200)
    public String getPxfile() {
        return pxfile;
    }

    public void setPxfile(String pxfile) {
        this.pxfile = pxfile;
    }

    @Basic
    @Column(name = "audit", nullable = true)
    public Byte getAudit() {
        return audit;
    }

    public void setAudit(Byte audit) {
        this.audit = audit;
    }

    @Basic
    @Column(name = "ccstatus", nullable = true)
    public Byte getCcstatus() {
        return ccstatus;
    }

    public void setCcstatus(Byte ccstatus) {
        this.ccstatus = ccstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pxshenbao pxshenbao = (Pxshenbao) o;
        return id == pxshenbao.id &&
                userId == pxshenbao.userId &&
                budgetId == pxshenbao.budgetId &&
                Objects.equals(name, pxshenbao.name) &&
                Objects.equals(organization, pxshenbao.organization) &&
                Objects.equals(pxconent, pxshenbao.pxconent) &&
                Objects.equals(address, pxshenbao.address) &&
                Objects.equals(begindate, pxshenbao.begindate) &&
                Objects.equals(enddate, pxshenbao.enddate) &&
                Objects.equals(txuser, pxshenbao.txuser) &&
                Objects.equals(feiyong, pxshenbao.feiyong) &&
                Objects.equals(pxfile, pxshenbao.pxfile) &&
                Objects.equals(audit, pxshenbao.audit) &&
                Objects.equals(ccstatus, pxshenbao.ccstatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, organization, pxconent, address, begindate, enddate, userId, txuser, budgetId, feiyong, pxfile, audit, ccstatus);
    }
}

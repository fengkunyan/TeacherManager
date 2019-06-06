package cn.edu.bzu.trainwork.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by wowx on 2019/5/30.
 */
@Entity
public class Pxjiesuan {
    private int pxjiesuanId;
    private int pxshenbaoId;
    private long userId;
    private Timestamp begindate;
    private Timestamp enddate;
    private String txuser;
    private Double hfje;
    private String pxzj;
    private Byte audit;
    private Byte bxstatus;

    @Id
    @Column(name = "pxjiesuan_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPxjiesuanId() {
        return pxjiesuanId;
    }

    public void setPxjiesuanId(int pxjiesuanId) {
        this.pxjiesuanId = pxjiesuanId;
    }

    @Basic
    @Column(name = "pxshenbao_id", nullable = false)
    public int getPxshenbaoId() {
        return pxshenbaoId;
    }

    public void setPxshenbaoId(int pxshenbaoId) {
        this.pxshenbaoId = pxshenbaoId;
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
    @Column(name = "txuser", nullable = true, length = 200)
    public String getTxuser() {
        return txuser;
    }

    public void setTxuser(String txuser) {
        this.txuser = txuser;
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
    @Column(name = "pxzj", nullable = true, length = -1)
    public String getPxzj() {
        return pxzj;
    }

    public void setPxzj(String pxzj) {
        this.pxzj = pxzj;
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
    @Column(name = "bxstatus", nullable = true)
    public Byte getBxstatus() {
        return bxstatus;
    }

    public void setBxstatus(Byte bxstatus) {
        this.bxstatus = bxstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pxjiesuan pxjiesuan = (Pxjiesuan) o;
        return pxjiesuanId == pxjiesuan.pxjiesuanId &&
                pxshenbaoId == pxjiesuan.pxshenbaoId &&
                userId == pxjiesuan.userId &&
                Objects.equals(begindate, pxjiesuan.begindate) &&
                Objects.equals(enddate, pxjiesuan.enddate) &&
                Objects.equals(txuser, pxjiesuan.txuser) &&
                Objects.equals(hfje, pxjiesuan.hfje) &&
                Objects.equals(pxzj, pxjiesuan.pxzj) &&
                Objects.equals(audit, pxjiesuan.audit) &&
                Objects.equals(bxstatus, pxjiesuan.bxstatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pxjiesuanId, pxshenbaoId, userId, begindate, enddate, txuser, hfje, pxzj, audit, bxstatus);
    }
}

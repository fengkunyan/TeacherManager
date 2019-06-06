package cn.edu.bzu.trainwork.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * Created by wowx on 2019/5/30.
 */
@Entity
public class Traininfo {
    private int infoId;
    private String title;
    private String content;
    private Integer viewCount;
    private Date createTime;
    private long userId;

    @Id
    @Column(name = "info_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
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
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "view_count", nullable = true)
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traininfo traininfo = (Traininfo) o;
        return infoId == traininfo.infoId &&
                userId == traininfo.userId &&
                Objects.equals(title, traininfo.title) &&
                Objects.equals(content, traininfo.content) &&
                Objects.equals(viewCount, traininfo.viewCount) &&
                Objects.equals(createTime, traininfo.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infoId, title, content, viewCount, createTime, userId);
    }
}

package cn.edu.bzu.trainwork.common.page;


import java.util.HashMap;
import java.util.Map;

/**
 * 分页数据
 * 
 * @author wowx
 */
public class PageDomain
{
    /** 当前记录起始索引 */
    private Integer page;
    /** 每页显示记录数 */
    private Integer rows;
    /** 排序列 */
    private String sortName;
    /** 排序的方向 "desc" 或者 "asc". */
    private String sortOrder;
    private Map<String, String> queryParams;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Map <String,String> getQueryParams() {

        return queryParams;
    }

    public void setQueryParams(Map <String, String> queryParams) {
        this.queryParams = queryParams;
    }


}

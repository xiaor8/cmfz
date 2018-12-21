package com.baizhi.dto;

import com.baizhi.entity.Banner;

import java.util.List;
import java.io.Serializable;

public class BannerDto implements Serializable {
    private List<Banner> rows;
    private Integer total;

    public List<Banner> getRows() {
        return rows;
    }

    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}

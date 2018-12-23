package com.baizhi.dto;

import com.baizhi.entity.Album;
import java.util.List;

import java.io.Serializable;

public class AlbumDto implements Serializable {
    private List<Album> rows;
    private Integer total;

    public List<Album> getRows() {
        return rows;
    }

    public void setRows(List<Album> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}

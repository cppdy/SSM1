package com.jeff.entity;

import java.util.List;

/**
 * @description: easyUI数据封装类
 * @author: Jeff
 * @date: 2019年02月20日 22:54:13
 */
public class EasyUIDatagrid {
    // 当前页显示的数据
    private List<?> rows;
    // 表中总个数
    private long total;

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}

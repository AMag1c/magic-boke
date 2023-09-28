package com.magic.domain;

import java.util.List;

public class PageBean<T> {
    //标记
    private Integer code=0;
    //总行数
    private long totalCount;
    //当前页
    private long current;

    //每页显示条数
    private long size;

    private List<T>  pojo;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public List<T> getPojo() {
        return pojo;
    }

    public void setPojo(List<T> pojo) {
        this.pojo = pojo;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "code=" + code +
                ", totalCount=" + totalCount +
                ", current=" + current +
                ", size=" + size +
                ", pojo=" + pojo +
                '}';
    }
}

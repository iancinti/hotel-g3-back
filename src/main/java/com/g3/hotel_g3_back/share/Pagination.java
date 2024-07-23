package com.g3.hotel_g3_back.share;

import java.util.List;

public class Pagination<T> {
    private List<T> list;
    private int total;

    public Pagination() {
    }

    public Pagination(List<T> list, int total) {
        this.list = list;
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

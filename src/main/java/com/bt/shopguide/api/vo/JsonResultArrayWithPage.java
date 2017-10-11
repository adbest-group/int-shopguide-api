package com.bt.shopguide.api.vo;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by caiting on 2017/9/29.
 */
public class JsonResultArrayWithPage extends JsonResultArray {
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    private int pageIndex = 1;
    private int pageSize = 20;
    private int totalCount = 0;
}

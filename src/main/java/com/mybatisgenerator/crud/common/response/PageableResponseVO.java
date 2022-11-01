package com.mybatisgenerator.crud.common.response;

import com.mybatisgenerator.crud.common.request.PageableRequest;
import com.mybatisgenerator.crud.web.vo.user.request.UserPageableRequestVO;
import com.mybatisgenerator.crud.web.vo.user.response.UserItemResponseVO;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

public class PageableResponseVO<T> {
    protected static final long DEFAULT_RECORDS = 1;

    private Long records = DEFAULT_RECORDS;

    private List<T> items;

    private Integer pages;
    private Integer page;

    public PageableResponseVO(Integer records, List<T> items, PageableRequest pageable) {
        this((long) records, items, pageable);
    }

    public PageableResponseVO(Long records, List<T> items, PageableRequest pageable) {
        if (ObjectUtils.isNotEmpty(records)) {
            this.records = records;
        }
        this.items = items;
        this.pages = (int) Math.ceil((double) this.records / pageable.getRpp());
        this.page = pageable.getPage();
    }
}

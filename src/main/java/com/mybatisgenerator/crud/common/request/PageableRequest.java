package com.mybatisgenerator.crud.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageableRequest {
    /**
     * First index will start by 1
     */
    public static final Integer DEFAULT_PAGE = 1;
    public static final Integer DEFAULT_RPP = 10;


    @Min(1)
    private Integer page = DEFAULT_PAGE;

    @Min(1)
    @Max(100)
    private Integer rpp = DEFAULT_RPP;

    private Sort.Direction direction;

    private String property;

    public int getOffset() {
        return (getPage() - 1) * getRpp();
    }

    public final int getNumberOfRows() {
        return getRpp();
    }
}

package com.mybatisgenerator.crud.product.biz.dto;

import lombok.Data;
import com.mybatisgenerator.crud.common.request.PageableRequest;

@Data
public class ProductDTO extends PageableRequest  {
    private String id;
    private String description;
    private String keywords;
}

package com.mybatisgenerator.crud.product.web.vo.request;

import com.mybatisgenerator.crud.common.request.PageableRequest;
import lombok.Data;

@Data
public class ProductPageableRequestVO extends PageableRequest {
    private String keywords;
}

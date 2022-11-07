package com.mybatisgenerator.crud.data;

import com.mybatisgenerator.crud.product.biz.dto.ProductDTO;
import com.mybatisgenerator.crud.product.web.vo.request.ProductPageableRequestVO;

public class ProductData {
    public ProductDTO getCreateData()
    {
        ProductDTO ProductDTO = new ProductDTO();
        ProductDTO.setDescription("test description");
        return ProductDTO;
    }

    public ProductPageableRequestVO getPageableData()
    {
        ProductPageableRequestVO request = new ProductPageableRequestVO();
        request.setPage(1);
        request.setRpp(10);

        return request;
    }
    public ProductDTO getUpdateData()
    {
        ProductDTO ProductDTO = new ProductDTO();
        ProductDTO.setDescription("test description update");
        return ProductDTO;
    }
}

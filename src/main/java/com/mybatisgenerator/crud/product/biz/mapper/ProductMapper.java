package com.mybatisgenerator.crud.product.biz.mapper;

import com.mybatisgenerator.crud.product.biz.dto.ProductDTO;
import com.mybatisgenerator.crud.common.mapper.AbstractMapperObjects;
import com.mybatisgenerator.crud.product.web.vo.request.ProductCreationRequestVO;
import com.mybatisgenerator.crud.product.web.vo.request.ProductPageableRequestVO;
import com.mybatisgenerator.crud.product.web.vo.request.ProductUpdateRequestVO;
import com.mybatisgenerator.crud.product.web.vo.response.ProductItemResponseVO;
import com.mybatisgenerator.crud.product.web.vo.response.ProductResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ProductMapper extends AbstractMapperObjects<ProductDTO, ProductItemResponseVO, ProductResponseVO, ProductCreationRequestVO, ProductUpdateRequestVO, ProductPageableRequestVO>  {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
}

package com.mybatisgenerator.crud.product.biz.dao;

import com.mybatisgenerator.crud.product.biz.dto.ProductDTO;
import com.mybatisgenerator.crud.common.dao.AbstractDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO extends AbstractDAO<ProductDTO> {
}

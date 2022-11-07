package com.mybatisgenerator.crud.product.biz.service.impl;

import com.mybatisgenerator.crud.product.biz.dao.ProductDAO;
import com.mybatisgenerator.crud.product.biz.dto.ProductDTO;
import com.mybatisgenerator.crud.product.biz.service.ProductService;
import com.mybatisgenerator.crud.common.dao.SequenceDAO;
import com.mybatisgenerator.crud.product.web.vo.request.ProductPageableRequestVO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO dao;
    private final SequenceDAO sequenceDAO;

    @Override
    public ProductDTO create(ProductDTO ProductDTO) {

        ProductDTO.setId(sequenceDAO.nextvalFormatted("product_seq"));
        dao.create(ProductDTO);

        return dao.findOneById(ProductDTO.getId());
    }

    @Override
    public ProductDTO update(String id, ProductDTO ProductDTO) {

        dao.update(id, ProductDTO);

        return dao.findOneById(id);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public ProductDTO findOne(String id) {

        ProductDTO ProductDTO =  this.findById(id);

        return ProductDTO;
    }
    protected ProductDTO findById(String id)
    {
        ProductDTO Product = dao.findOneById(id);
        if(ObjectUtils.isEmpty(Product))
            throw new RuntimeException("Product Not found");
        return Product;
    }

    @Override
    public Page<ProductDTO> findAll(ProductDTO ProductDTO, ProductPageableRequestVO pageableRequestVO) {
        Integer count = dao.count(ProductDTO.getKeywords());
        List<ProductDTO> items = new ArrayList<>();
        if(count > 0)
        {
            items = dao.findAll(ProductDTO.getKeywords(), pageableRequestVO.getRpp(), pageableRequestVO.getOffset());
        }

        return new PageImpl<>(items, PageRequest.of(pageableRequestVO.getPage() - 1, pageableRequestVO.getRpp()), count);
    }

}

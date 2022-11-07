package com.mybatisgenerator.crud.product.web.controller;

import com.mybatisgenerator.crud.product.biz.dto.ProductDTO;
import com.mybatisgenerator.crud.product.biz.mapper.ProductMapper;
import com.mybatisgenerator.crud.product.biz.service.ProductService;
import com.mybatisgenerator.crud.common.controller.AbstractController;
import com.mybatisgenerator.crud.common.response.PageableResponseVO;
import com.mybatisgenerator.crud.common.response.ResponseBuilderMessage;
import com.mybatisgenerator.crud.common.response.ResponseMessage;
import com.mybatisgenerator.crud.product.web.vo.request.ProductCreationRequestVO;
import com.mybatisgenerator.crud.product.web.vo.request.ProductPageableRequestVO;
import com.mybatisgenerator.crud.product.web.vo.request.ProductUpdateRequestVO;
import com.mybatisgenerator.crud.product.web.vo.response.ProductItemResponseVO;
import com.mybatisgenerator.crud.product.web.vo.response.ProductResponseVO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController implements AbstractController<ProductItemResponseVO, ProductResponseVO, ProductCreationRequestVO, ProductUpdateRequestVO, ProductPageableRequestVO> {
    private final ProductService ProductService;

    @SneakyThrows
    @Override
    public ResponseMessage<ProductResponseVO> findOne(@PathVariable String id)
    {
        ProductDTO Product = this.ProductService.findOne(id);
        ProductResponseVO ProductResponseVO = new ProductResponseVO();
        ProductMapper.INSTANCE.copyDtoToResponseVo(Product, ProductResponseVO);

        return new ResponseBuilderMessage<ProductResponseVO>()
                .success()
                .addData(ProductResponseVO)
                .build();
    }

    @SneakyThrows
    @Override
    public ResponseMessage<PageableResponseVO<ProductItemResponseVO>> findWithPage(@Valid ProductPageableRequestVO pageableRequestVO)
    {
        ProductDTO ProductDTO = new ProductDTO();
        ProductMapper.INSTANCE.copyPageRequestVoToDto(pageableRequestVO, ProductDTO);
        Page<ProductDTO> page = this.ProductService.findAll(ProductDTO, pageableRequestVO);
        List<ProductItemResponseVO> items = new ArrayList<>();
        ProductMapper.INSTANCE.copyListDtoToResponseVo(page.getContent(), items);

        return new ResponseBuilderMessage<PageableResponseVO<ProductItemResponseVO>>()
                .success()
                .addData(new PageableResponseVO<>(page.getTotalElements(), items, pageableRequestVO))
                .build();
    }

    @SneakyThrows
    @Override
    public ResponseMessage<ProductResponseVO> create(@Valid ProductCreationRequestVO requestVO)
    {
        ProductDTO createDto = new ProductDTO();
        ProductMapper.INSTANCE.copyCreateRequestVoToDto(requestVO, createDto);
        ProductDTO Product =  this.ProductService.create(createDto);
        ProductResponseVO response = new ProductResponseVO();
        ProductMapper.INSTANCE.copyDtoToResponseVo(Product, response);

        return new ResponseBuilderMessage<ProductResponseVO>()
                .success()
                .addData(response)
                .build();
    }
    @SneakyThrows
    @Override
    public ResponseMessage<ProductResponseVO> update(@Valid @RequestBody ProductUpdateRequestVO requestVO, @PathVariable String id)
    {
        ProductDTO update = new ProductDTO();
        ProductMapper.INSTANCE.copyUpdateRequestVoToDto(requestVO, update);
        ProductDTO Product = this.ProductService.update(id, update);
        ProductResponseVO response = new ProductResponseVO();
        ProductMapper.INSTANCE.copyDtoToResponseVo(Product, response);

        return new ResponseBuilderMessage<ProductResponseVO>()
                .success()
                .addData(response)
                .build();
    }
    @SneakyThrows
    @Override
    public ResponseMessage<Void> delete(@PathVariable String id)
    {
        this.ProductService.delete(id);

        return new ResponseBuilderMessage<Void>()
                .success()
                .build();
    }
}

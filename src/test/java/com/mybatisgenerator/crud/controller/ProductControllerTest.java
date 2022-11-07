package com.mybatisgenerator.crud.controller;

import com.mybatisgenerator.crud.AbstractTestCase;
import com.mybatisgenerator.crud.product.biz.dto.ProductDTO;
import com.mybatisgenerator.crud.product.biz.service.ProductService;
import com.mybatisgenerator.crud.data.ProductData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest extends AbstractTestCase {
    private static final String END_POINT = "/api/products";
    @Autowired
    private ProductService service;

    @Test
    @Order(1)
    public void should_get_product_list() throws Exception {

        callGetAPI(END_POINT  + "/find-with-page", null);
    }
    @Test
    @Order(2)
    public void should_create_product() throws Exception {
        callPostAPI(END_POINT + "/create", new ProductData().getCreateData(), null);
    }

    @Test
    @Order(3)
    public void should_get_product_by_id() throws Exception {
        callGetAPI(END_POINT + "/find-one/"+ service.findAll(new ProductDTO(), new ProductData().getPageableData()).getContent().get(0).getId(), null);
    }
    @Test
    @Order(4)
    public void should_update_product() throws Exception {

        String id = service.findAll(new ProductDTO(), new ProductData().getPageableData()).getContent().get(0).getId();

        ProductDTO update = new ProductData().getUpdateData();
        update.setId(id);

        callPostAPI(END_POINT  + "/update/" + id,  update, null);
    }

    @Test
    @Order(5)
    public void should_delete_product() throws Exception
    {
        callPostAPI(END_POINT+ "/delete/" + service.findAll(new ProductDTO(), new ProductData().getPageableData()).getContent().get(0).getId(), new ProductDTO(), null);
    }
}

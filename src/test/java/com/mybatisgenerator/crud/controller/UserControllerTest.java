package com.mybatisgenerator.crud.controller;

import com.mybatisgenerator.crud.AbstractTestCase;
import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.biz.service.UserService;
import com.mybatisgenerator.crud.data.UserData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest extends AbstractTestCase {
    private static final String END_POINT = "/api/users";
    @Autowired
    private UserService service;

    @Test
    @Order(1)
    public void should_get_user_list() throws Exception {

        callGetAPI(END_POINT  + "/find-with-page", null);
    }
    @Test
    @Order(2)
    public void should_create_user() throws Exception {
        callPostAPI(END_POINT + "/create", new UserData().getCreateData(), null);
    }

    @Test
    @Order(3)
    public void should_get_user_by_id() throws Exception {
        callGetAPI(END_POINT + "/find-one/"+ service.findAll(new UserDTO(), new UserData().getPageableData()).getContent().get(0).getId(), null);
    }
    @Test
    @Order(4)
    public void should_update_user() throws Exception {

        String id = service.findAll(new UserDTO(), new UserData().getPageableData()).getContent().get(0).getId();

        UserDTO update = new UserData().getUpdateData();
        update.setId(id);

        callPostAPI(END_POINT  + "/update/" + id,  update, null);
    }

    @Test
    @Order(5)
    public void should_delete_user() throws Exception
    {
        callPostAPI(END_POINT+ "/delete/" + service.findAll(new UserDTO(), new UserData().getPageableData()).getContent().get(0).getId(), new UserDTO(), null);
    }
}

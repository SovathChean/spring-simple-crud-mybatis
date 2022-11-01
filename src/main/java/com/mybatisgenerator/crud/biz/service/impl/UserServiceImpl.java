package com.mybatisgenerator.crud.biz.service.impl;

import com.mybatisgenerator.crud.biz.dao.user.UserDAO;
import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.biz.service.UserService;
import com.mybatisgenerator.crud.common.request.PageableRequest;
import com.mybatisgenerator.crud.web.vo.user.request.UserPageableRequestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO dao;

    @Override
    public void create(UserDTO userDTO) {

    }

    @Override
    public void update(String id, UserDTO userDTO) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public UserDTO findOne(String id) {
        return null;
    }

    @Override
    public Page<UserDTO> findAll(UserDTO UserDTO, UserPageableRequestVO pageableRequestVO) {
        return null;
    }

}

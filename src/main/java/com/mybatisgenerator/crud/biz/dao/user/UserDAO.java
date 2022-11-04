package com.mybatisgenerator.crud.biz.dao.user;

import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.common.request.PageableRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface UserDAO {

    UserDTO create(UserDTO userDTO);
    UserDTO update(String id, UserDTO userDTO);
    void delete(String id);
    UserDTO findOneById(String id);
    List<UserDTO> findAll(@Param("keywords") String keywords, @Param("page") PageableRequest page);
    Integer count(@Param("keywords") String keywords, @Param("page") PageableRequest page);
}

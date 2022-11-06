package com.mybatisgenerator.crud.biz.dao.user;

import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.common.request.PageableRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDAO {

    void create(UserDTO userDTO);
    void update(@Param("id") String id, UserDTO user);
    void delete(String id);
    UserDTO findOneById(String id);
    List<UserDTO> findAll(@Param("keywords") String keywords, @Param("pageSize") int pageSize, @Param("offset") int offset);
    Integer count(@Param("keywords") String keywords);
}

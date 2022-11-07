package com.mybatisgenerator.crud.common.dao;

import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AbstractDAO<DTO> {
    void create(DTO dto);
    void update(@Param("id") String id, DTO dto);
    void delete(String id);
    UserDTO findOneById(String id);
    List<UserDTO> findAll(@Param("keywords") String keywords, @Param("pageSize") int pageSize, @Param("offset") int offset);
    Integer count(@Param("keywords") String keywords);
}

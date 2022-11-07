package com.mybatisgenerator.crud.biz.dao.user;

import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.common.dao.AbstractDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO extends AbstractDAO<UserDTO> {
}

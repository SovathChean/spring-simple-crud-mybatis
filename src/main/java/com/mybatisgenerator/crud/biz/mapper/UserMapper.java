package com.mybatisgenerator.crud.biz.mapper;

import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.common.mapper.AbstractMapperObjects;
import com.mybatisgenerator.crud.web.vo.user.request.UserCreationRequestVO;
import com.mybatisgenerator.crud.web.vo.user.request.UserPageableRequestVO;
import com.mybatisgenerator.crud.web.vo.user.request.UserUpdateRequestVO;
import com.mybatisgenerator.crud.web.vo.user.response.UserItemResponseVO;
import com.mybatisgenerator.crud.web.vo.user.response.UserResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserMapper extends AbstractMapperObjects<UserDTO, UserItemResponseVO, UserResponseVO, UserCreationRequestVO, UserUpdateRequestVO, UserPageableRequestVO>  {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}

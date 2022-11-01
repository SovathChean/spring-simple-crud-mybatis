package com.mybatisgenerator.crud.biz.service;

import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.common.service.AbstractService;
import com.mybatisgenerator.crud.web.vo.user.request.UserPageableRequestVO;

public interface UserService extends AbstractService<UserDTO, UserPageableRequestVO> {
}

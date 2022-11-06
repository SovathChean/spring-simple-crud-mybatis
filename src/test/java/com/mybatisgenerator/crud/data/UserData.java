package com.mybatisgenerator.crud.data;

import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.common.request.PageableRequest;
import com.mybatisgenerator.crud.web.vo.user.request.UserPageableRequestVO;

public class UserData {
    public UserDTO getCreateData()
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setDescription("test description");
        return userDTO;
    }

    public UserPageableRequestVO getPageableData()
    {
        UserPageableRequestVO request = new UserPageableRequestVO();
        request.setPage(1);
        request.setRpp(10);

        return request;
    }
    public UserDTO getUpdateData()
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setDescription("test description update");
        return userDTO;
    }
}

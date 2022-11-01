package com.mybatisgenerator.crud.web.controller.user;

import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.biz.mapper.UserMapper;
import com.mybatisgenerator.crud.biz.service.UserService;
import com.mybatisgenerator.crud.common.controller.AbstractController;
import com.mybatisgenerator.crud.common.response.PageableResponseVO;
import com.mybatisgenerator.crud.common.response.ResponseBuilderMessage;
import com.mybatisgenerator.crud.common.response.ResponseMessage;
import com.mybatisgenerator.crud.web.vo.user.request.UserCreationRequestVO;
import com.mybatisgenerator.crud.web.vo.user.request.UserPageableRequestVO;
import com.mybatisgenerator.crud.web.vo.user.request.UserUpdateRequestVO;
import com.mybatisgenerator.crud.web.vo.user.response.UserItemResponseVO;
import com.mybatisgenerator.crud.web.vo.user.response.UserResponseVO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController implements AbstractController<UserItemResponseVO, UserResponseVO, UserCreationRequestVO, UserUpdateRequestVO, UserPageableRequestVO> {
    private final UserService userService;

    @SneakyThrows
    @Override
    public ResponseMessage<UserResponseVO> findOne(@PathVariable String id)
    {
        UserDTO User = this.userService.findOne(id);
        UserResponseVO UserResponseVO = new UserResponseVO();
        UserMapper.INSTANCE.copyDtoToResponseVo(User, UserResponseVO);

        return new ResponseBuilderMessage<UserResponseVO>()
                .success()
                .addData(UserResponseVO)
                .build();
    }

    @SneakyThrows
    @Override
    public ResponseMessage<PageableResponseVO<UserItemResponseVO>> findWithPage(@Valid UserPageableRequestVO pageableRequestVO)
    {
        UserDTO userDTO = new UserDTO();
        UserMapper.INSTANCE.copyPageRequestVoToDto(pageableRequestVO, userDTO);
        Page<UserDTO> page = this.userService.findAll(userDTO, pageableRequestVO);
        List<UserItemResponseVO> items = new ArrayList<>();
        UserMapper.INSTANCE.copyListDtoToResponseVo(page.getContent(), items);

        return new ResponseBuilderMessage<PageableResponseVO<UserItemResponseVO>>()
                .success()
                .addData(new PageableResponseVO<>(page.getTotalElements(), items, pageableRequestVO))
                .build();
    }

    @SneakyThrows
    @Override
    public ResponseMessage<UserResponseVO> create(@Valid UserCreationRequestVO requestVO)
    {
        UserDTO createDto = new UserDTO();
        UserMapper.INSTANCE.copyCreateRequestVoToDto(requestVO, createDto);
        this.userService.create(createDto);
        UserResponseVO response = new UserResponseVO();
        UserMapper.INSTANCE.copyDtoToResponseVo(createDto, response);

        return new ResponseBuilderMessage<UserResponseVO>()
                .success()
                .addData(response)
                .build();
    }
    @SneakyThrows
    @Override
    public ResponseMessage<UserResponseVO> update(@Valid @RequestBody UserUpdateRequestVO requestVO, @PathVariable String id)
    {
        UserDTO update = new UserDTO();
        UserMapper.INSTANCE.copyUpdateRequestVoToDto(requestVO, update);
        this.userService.update(id, update);
        UserResponseVO response = new UserResponseVO();
        UserMapper.INSTANCE.copyDtoToResponseVo(update, response);

        return new ResponseBuilderMessage<UserResponseVO>()
                .success()
                .addData(response)
                .build();
    }
    @SneakyThrows
    @Override
    public ResponseMessage<Void> delete(@PathVariable String id)
    {
        this.userService.delete(id);

        return new ResponseBuilderMessage<Void>()
                .success()
                .build();
    }
}

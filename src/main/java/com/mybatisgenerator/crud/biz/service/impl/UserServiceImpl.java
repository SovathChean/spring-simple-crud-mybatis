package com.mybatisgenerator.crud.biz.service.impl;

import com.mybatisgenerator.crud.biz.dao.user.UserDAO;
import com.mybatisgenerator.crud.biz.dto.user.UserDTO;
import com.mybatisgenerator.crud.biz.service.UserService;
import com.mybatisgenerator.crud.common.dao.SequenceDAO;
import com.mybatisgenerator.crud.web.vo.user.request.UserPageableRequestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO dao;
    private final SequenceDAO sequenceDAO;

    @Override
    public UserDTO create(UserDTO userDTO) {

        userDTO.setId(sequenceDAO.nextvalFormatted("user_seq"));
        dao.create(userDTO);

        return dao.findOneById(userDTO.getId());
    }

    @Override
    public UserDTO update(String id, UserDTO userDTO) {

        dao.update(id, userDTO);

        return dao.findOneById(userDTO.getId());
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public UserDTO findOne(String id) {
        return dao.findOneById(id);
    }

    @Override
    public Page<UserDTO> findAll(UserDTO userDTO, UserPageableRequestVO pageableRequestVO) {
        Integer count = dao.count(userDTO.getKeywords(), pageableRequestVO);
        List<UserDTO> items = new ArrayList<>();
        if(count > 0)
        {
            items = dao.findAll(userDTO.getKeywords(), pageableRequestVO);
        }

        return new PageImpl<>(items, PageRequest.of(pageableRequestVO.getPage() - 1, pageableRequestVO.getRpp()), count);
    }

}

package com.mybatisgenerator.crud.common.service;

import org.springframework.data.domain.Page;

public interface AbstractService<DTO, PageableRequestDTO> {
    DTO create(DTO dto);
    DTO update(String id, DTO dto);
    void delete(String id);
    DTO findOne(String id);
    Page<DTO> findAll(DTO UserDTO, PageableRequestDTO pageableRequestVO);
}


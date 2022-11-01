package com.mybatisgenerator.crud.common.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface AbstractMapperObjects  <DTO, RESPONSE_ITEM_VO, RESPONSE_DETAIL_VO, CREATE_REQUEST_VO, UPDATE_REQUEST_VO, PAGE_REQUEST_VO>{

    void copyUpdateRequestVoToDto(UPDATE_REQUEST_VO requestVo, @MappingTarget DTO dto);

    void copyCreateRequestVoToDto(CREATE_REQUEST_VO requestVo, @MappingTarget DTO dto);

    void copyDtoToResponseVo(DTO dto, @MappingTarget RESPONSE_DETAIL_VO responseVo);

    void copyPageRequestVoToDto(PAGE_REQUEST_VO pageRequestVo, @MappingTarget DTO dto);

    void copyListDtoToResponseVo(List<DTO> dtoList, @MappingTarget List<RESPONSE_ITEM_VO> responseVoList);
}

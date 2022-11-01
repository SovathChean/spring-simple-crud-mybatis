package com.mybatisgenerator.crud.common.controller;

import com.mybatisgenerator.crud.common.request.PageableRequest;
import com.mybatisgenerator.crud.common.response.PageableResponseVO;
import com.mybatisgenerator.crud.common.response.ResponseBuilderMessage;
import com.mybatisgenerator.crud.common.response.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AbstractController <RESPONSE_ITEM_VO, RESPONSE_DETAIL_VO, REQUEST_CREATE_VO, REQUEST_UPDATE_VO, REQUEST_PAGE_VO extends PageableRequest> {
    @PostMapping("create")
    default ResponseMessage<RESPONSE_DETAIL_VO> create(@Valid @RequestBody REQUEST_CREATE_VO requestCreateVo) {
        return new ResponseBuilderMessage<RESPONSE_DETAIL_VO>().success().build();
    }

    @PostMapping("update/{id}")
    default ResponseMessage<RESPONSE_DETAIL_VO> update(@Valid @RequestBody REQUEST_UPDATE_VO requestUpdateVo, @PathVariable String id){
        return new ResponseBuilderMessage<RESPONSE_DETAIL_VO>().success().build();
    }

    @PostMapping("delete/{id}")
    default ResponseMessage<Void> delete(@PathVariable String id)  {
        return new ResponseBuilderMessage<Void>().success().build();
    }

    @GetMapping("find-with-page")
    default ResponseMessage<PageableResponseVO<RESPONSE_ITEM_VO>> findWithPage(@Valid REQUEST_PAGE_VO request) {
        return new ResponseBuilderMessage<PageableResponseVO<RESPONSE_ITEM_VO>>().success().build();
    }

    @GetMapping("find-one/{id}")
    default ResponseMessage<RESPONSE_DETAIL_VO> findOne(@PathVariable String id) {
        return new ResponseBuilderMessage<RESPONSE_DETAIL_VO>().success().build();
    }
}

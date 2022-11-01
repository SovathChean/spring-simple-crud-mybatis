package com.mybatisgenerator.crud.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseMessage<T> {
    private String resultCode;
    private String resultMessage;
    private Integer totalRows;
    private Boolean result;
    private T body;
    private String traceId;
    private String error;
    @JsonIgnore
    private HttpStatus status;
    public ResponseMessage(){}
}
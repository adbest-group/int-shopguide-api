package com.bt.shopguide.api.controller.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by caiting on 2017/9/29.
 */
@ControllerAdvice(basePackages = "com.bt.shopguide.api.controller.jsonp")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdvice(){
        super("callback","jsonp");
    }

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().add("Access-Control-Allow-Origin","*");
        super.beforeBodyWriteInternal(bodyContainer, contentType, returnType, request, response);
    }
}

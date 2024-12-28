package com.babalola.feignclientinterceptor.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiKeyRequestInterceptor implements RequestInterceptor {

    private final String apiKey;

    public ApiKeyRequestInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void apply(RequestTemplate template) {
        log.info("Adding API key to request");
        template.header("X-API-Key", apiKey);
    }
}
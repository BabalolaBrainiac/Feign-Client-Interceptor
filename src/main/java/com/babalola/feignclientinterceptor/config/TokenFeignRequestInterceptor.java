package com.babalola.feignclientinterceptor.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.Map;
import java.util.Base64;
import java.util.TreeMap;


public class TokenFeignRequestInterceptor implements RequestInterceptor {
    private static final String AUTHORIZATION_TYPE = "Bearer ";
    private static final String BASIC_AUTHORIZATION_TYPE = "BASIC ";
    private final String authApiSecreitKey;
    private final String authApiClientId;

    private OauthFeignTokenService oauthFeignTokenService;

    public TokenFeignRequestInterceptor(String authApiSecreitKey, String authApiClientId) {
        this.authApiSecreitKey = authApiSecreitKey;
        this.authApiClientId = authApiClientId;
    }

    @Override
    public void apply(RequestTemplate template) {
        Map<String, String> request = new TreeMap<>();
        request.put("grant_type", "client_credentials");
        String tokenBase64 = Base64.getEncoder().encodeToString((authApiClientId + ":" + authApiSecreitKey).getBytes());

        String token = oauthFeignTokenService.getToken(request, BASIC_AUTHORIZATION_TYPE.concat(tokenBase64));
        System.out.println("oauth-reponse "+ token);
        System.out.println("token "+ token);
        template.header("Authorization", AUTHORIZATION_TYPE.concat(token));

    }
}


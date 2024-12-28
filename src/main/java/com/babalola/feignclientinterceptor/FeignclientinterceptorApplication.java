package com.babalola.feignclientinterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignclientinterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignclientinterceptorApplication.class, args);
    }

}

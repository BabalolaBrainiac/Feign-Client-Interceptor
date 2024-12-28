package com.babalola.feignclientinterceptor.client;

import com.babalola.feignclientinterceptor.config.FeignClientConfig;
import com.babalola.feignclientinterceptor.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "jsonPlaceholderClient",
        url = "${api.jsonplaceholder.url:https://jsonplaceholder.typicode.com}",
        configuration = FeignClientConfig.class
)
public interface JsonPlaceholderClient {

    @GetMapping("/posts")
    List<Post> getAllPosts();

    @GetMapping("/posts/{id}")
    Post getPostById(@PathVariable("id") Long id);

    @PostMapping("/posts")
    Post createPost(@RequestBody Post post);
}
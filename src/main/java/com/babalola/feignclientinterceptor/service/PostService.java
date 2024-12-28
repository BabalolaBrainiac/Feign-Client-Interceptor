package com.babalola.feignclientinterceptor.service;

import com.babalola.feignclientinterceptor.client.JsonPlaceholderClient;
import com.babalola.feignclientinterceptor.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public List<Post> getAllPosts() {
        log.info("Fetching all posts");
        return jsonPlaceholderClient.getAllPosts();
    }

    public Post getPostById(Long id) {
        log.info("Fetching post with id: {}", id);
        return jsonPlaceholderClient.getPostById(id);
    }

    public Post createPost(Post post) {
        log.info("Creating new post");
        return jsonPlaceholderClient.createPost(post);
    }
}
package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public Post save(Post post){
        postMapper.createPost(post);
        return post;
    }
}

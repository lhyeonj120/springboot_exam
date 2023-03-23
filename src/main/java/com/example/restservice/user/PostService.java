package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public Post save(Post post){
        postMapper.createPost(post);
        return post;
    }
    public List<Post> retrieveAllPostByUser(int id){
        return postMapper.retrieveAllPostByUser(id);
    }
}

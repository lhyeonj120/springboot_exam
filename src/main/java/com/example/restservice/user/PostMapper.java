package com.example.restservice.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    public void createPost(Post post);
    public List<Post> retrieveAllPostByUser(int id);
}

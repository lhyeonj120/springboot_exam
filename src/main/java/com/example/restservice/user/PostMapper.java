package com.example.restservice.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    public void createPost(Post post);
}

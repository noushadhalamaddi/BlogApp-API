package com.blogapp.service;

import com.blogapp.dtopayload.PostDto;
import com.blogapp.dtopayload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostByID(Long id);

    PostDto updatePost(PostDto postDto, long id);

    void deleteById(long id);
}

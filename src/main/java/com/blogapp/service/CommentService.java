package com.blogapp.service;

import com.blogapp.dtopayload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentByPostId(long postId);

    CommentDto updateCommentById(long postId, long id, CommentDto commentDto);

    void deleteComment(long postId, long id);
}

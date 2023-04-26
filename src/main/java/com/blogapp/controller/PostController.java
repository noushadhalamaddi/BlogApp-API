package com.blogapp.controller;


import com.blogapp.dtopayload.PostDto;
import com.blogapp.dtopayload.PostResponse;
import com.blogapp.service.PostService;
import com.blogapp.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;



    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto post = postService.createPost(postDto);
        return new ResponseEntity<>(post,HttpStatus.CREATED);
    }

    @GetMapping
    public PostResponse getAllPosts
            (@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false)int pageNo,
             @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false)int pageSize,
             @RequestParam(value="sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY, required = false)String sortBy,
             @RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIR,required = false)String sortDir
             ){
        return postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostByID(@PathVariable("id") Long id){
        PostDto postByID = postService.getPostByID(id);
        return new ResponseEntity<>(postByID,HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable("id") long id){
        PostDto updatePostDto = postService.updatePost(postDto, id);
        return new ResponseEntity<>(updatePostDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") long id){
        postService.deleteById(id);
        return new ResponseEntity<>("Post Successfully Deleted", HttpStatus.OK);

    }
}

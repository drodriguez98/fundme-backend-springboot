package com.campusdual.fundme.controller;

import com.campusdual.fundme.api.ICommentService;
import com.campusdual.fundme.model.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/private/comments")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping(value = "/get")
    public CommentDTO queryComment (@RequestBody CommentDTO comment) { return this.commentService.queryComment(comment); }

    @GetMapping(value = "/all")
    public List<CommentDTO> queryAllComments() { return this.commentService.queryAllComments(); }

    @PostMapping(value = "/add")
    public int insertComment (@RequestBody CommentDTO comment) { return this.commentService.insertComment(comment); }

    @PutMapping(value = "/update")
    public int updateComment (@RequestBody CommentDTO comment) { return this.commentService.updateComment(comment); }

    @PostMapping(value = "/delete")
    public int deleteComment (@RequestBody CommentDTO comment) { return this.commentService.deleteComment(comment); }

}
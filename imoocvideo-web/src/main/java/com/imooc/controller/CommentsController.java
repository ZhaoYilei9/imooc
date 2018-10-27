package com.imooc.controller;

import com.imooc.pojo.Comments;
import com.imooc.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
    @RequestMapping("list")
    public ResponseEntity getAllComments(){
        List<Comments> comments = commentsService.getAll();
        if (comments == null || comments.size() < 1){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(comments);

    }
}

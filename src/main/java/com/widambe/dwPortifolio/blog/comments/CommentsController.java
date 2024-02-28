package com.widambe.dwPortifolio.blog.comments;

import com.widambe.dwPortifolio.api.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blogComments")
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments(){
        return ResponseEntity.ok(commentsService.getAllComments());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> postComment(
            @RequestBody CommentPostRequest commentPostRequest
    ){
        return ResponseEntity.ok(commentsService.postComment(commentPostRequest));
    }

}

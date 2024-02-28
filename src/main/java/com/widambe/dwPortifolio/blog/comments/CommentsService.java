package com.widambe.dwPortifolio.blog.comments;

import com.widambe.dwPortifolio.api.ApiResponse;
import com.widambe.dwPortifolio.blog.BlogPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    private final CommentRepository commentRepository;
    private final BlogPostRepository blogPostRepository;

    public CommentsService(CommentRepository commentRepository, BlogPostRepository blogPostRepository) {
        this.commentRepository = commentRepository;
        this.blogPostRepository = blogPostRepository;
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public ApiResponse postComment(CommentPostRequest commentPostRequest){
        var blog = blogPostRepository.findBlogPostById(commentPostRequest.getBlogId());
        String message;
        if (blog.isEmpty()){
            message = "Blog Not found";
            return ApiResponse.builder().save(false).message(message).build();
        }
        var comment = Comment.builder()
                .blogPost(blog.get())
                .comment(commentPostRequest.getComment())
                .name(commentPostRequest.getName())
                .build();
        commentRepository.save(comment);
        message = "Comment Saves";
        return ApiResponse.builder().save(true).message(message).build();
    }

}

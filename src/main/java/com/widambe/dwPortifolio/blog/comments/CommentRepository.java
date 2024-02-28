package com.widambe.dwPortifolio.blog.comments;

import com.widambe.dwPortifolio.blog.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findCommentsByBlogPost(BlogPost blogPost);
}

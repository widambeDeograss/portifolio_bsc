package com.widambe.dwPortifolio.blog.comments;

import com.widambe.dwPortifolio.blog.BlogPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dw_blog-comments")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private BlogPost blogPost;
    private String comment;
}

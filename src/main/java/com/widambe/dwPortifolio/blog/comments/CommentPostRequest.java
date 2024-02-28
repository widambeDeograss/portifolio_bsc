package com.widambe.dwPortifolio.blog.comments;

import com.widambe.dwPortifolio.blog.BlogSection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentPostRequest {
    private String name;

    private Long blogId;

    private String comment;
}


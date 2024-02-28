package com.widambe.dwPortifolio.blog;

import com.widambe.dwPortifolio.user.User;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostRequest {
    private String userEmail;
    private String category;

    private List<BlogSection> sections;

    private String tags;
    private Integer likes;
}

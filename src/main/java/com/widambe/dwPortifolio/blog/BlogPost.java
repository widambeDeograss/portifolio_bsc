package com.widambe.dwPortifolio.blog;

import com.widambe.dwPortifolio.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dw_blog")
public class BlogPost {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;

    private String category;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BlogSection> sections;

    private String tags;
    private Integer likes;
    @CreationTimestamp
    private LocalDateTime createdAt;

}

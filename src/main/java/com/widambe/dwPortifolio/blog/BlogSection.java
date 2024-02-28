package com.widambe.dwPortifolio.blog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogSection {
    private String type;

    @Column(columnDefinition = "TEXT")
    private String content;
    @Id
    @GeneratedValue
    private Long id;

}

package com.widambe.dwPortifolio.sitereviews;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class SiteReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String site;
    private Integer resume_downloads;
    private Integer work_views;
    private Integer site_visits;
}

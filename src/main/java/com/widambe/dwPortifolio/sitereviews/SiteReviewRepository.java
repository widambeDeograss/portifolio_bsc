package com.widambe.dwPortifolio.sitereviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteReviewRepository extends JpaRepository<SiteReviews, Integer> {
    Optional<SiteReviews> findBySite(String site);
}

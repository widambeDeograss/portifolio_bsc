package com.widambe.dwPortifolio.sitereviews;

import com.widambe.dwPortifolio.api.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/site_reviews")
public class SIteReviewsController {
    private final SiteReviewService siteReviewService;

    public SIteReviewsController(SiteReviewService siteReviewService) {
        this.siteReviewService = siteReviewService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> gen_site_review(
     @RequestBody SiteReviews site_request
    ){
     return ResponseEntity.ok(siteReviewService.generate_site_review(site_request));
    }

    @GetMapping
    public ResponseEntity<List<SiteReviews>> get_site(){
        return ResponseEntity.ok(siteReviewService.get_site_review());
    }

    @GetMapping("/{site}")
    public ResponseEntity<ApiResponse> update_site_reviews(
            @PathVariable String site){
        return ResponseEntity.ok(siteReviewService.addReviews(site));
    }

}

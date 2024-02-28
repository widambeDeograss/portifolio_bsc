package com.widambe.dwPortifolio.sitereviews;

import com.widambe.dwPortifolio.api.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteReviewService {

    private final SiteReviewRepository repository;

    public SiteReviewService(SiteReviewRepository repository) {
        this.repository = repository;
    }

    public ApiResponse generate_site_review(SiteReviews site_name){
        String responseMessage;
        Optional<SiteReviews> siteByName =  repository.findBySite(site_name.getSite());
        if (siteByName.isPresent()){
            throw new IllegalStateException(("Site already exists"));
        }
        repository.save(site_name);
        responseMessage = "Site created Successfully";
        return ApiResponse.builder().message(responseMessage).build();
    }

    public List<SiteReviews> get_site_review(){

        return  repository.findAll();
    }

    public ApiResponse addReviews(String site_name){
        String responseMessage;
        var site = repository.findBySite(site_name)
                .orElseThrow();

        site.setResume_downloads(site.getResume_downloads() + 1);
        site.setSite_visits(site.getSite_visits() + 1);
        site.setWork_views(site.getWork_views() + 1);

        repository.save(site);

        responseMessage = "Site reviews updated successfully";

        return ApiResponse.builder().message(responseMessage).build();
    }
}

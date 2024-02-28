package com.widambe.dwPortifolio.blog;

import com.widambe.dwPortifolio.api.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/dw_blogs")
public class BlogPostController {
  private final BlogPostService blogPostService;

  public BlogPostController(BlogPostService blogPostService) {
    this.blogPostService = blogPostService;
  }

  @PostMapping
    public ResponseEntity<ApiResponse> createBlog(@RequestBody BlogPostRequest blogPost){
      return ResponseEntity.ok(blogPostService.createBlog(blogPost));
  }

  @GetMapping
    public ResponseEntity<List<BlogPost>> getBlogs(){

    return ResponseEntity.ok(blogPostService.getAllBlogs());
  }

  @GetMapping(path="bdlogId")
   public ResponseEntity<Optional<BlogPost>> getBlog(@PathVariable("blogId") Long blogId){
      return ResponseEntity.ok(blogPostService.getBlogbyId(blogId));
  }

  @DeleteMapping(path="blogId")
    public ResponseEntity<ApiResponse> deleteBlog(@PathVariable("blogId") Long blogId){
      return ResponseEntity.ok(blogPostService.deleteBlog(blogId));
  }

  @PutMapping(path="blodId")
    public  ResponseEntity<ApiResponse> editBlog(@PathVariable("blogId") Long blogId, @RequestBody BlogPost blogPost){
      return null;
  }


}

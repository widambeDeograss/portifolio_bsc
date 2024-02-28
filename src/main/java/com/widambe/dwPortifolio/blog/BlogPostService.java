package com.widambe.dwPortifolio.blog;

import com.widambe.dwPortifolio.api.ApiResponse;
import com.widambe.dwPortifolio.user.User;
import com.widambe.dwPortifolio.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
    private final BlogPostRepository blogPostRepository;

    @Autowired
    private final UserRepository userRepository;

    public BlogPostService(BlogPostRepository blogPostRepository, UserRepository userRepository) {
        this.blogPostRepository = blogPostRepository;
        this.userRepository = userRepository;
    }

    public ApiResponse createBlog(BlogPostRequest post){
        User user = userRepository.findByEmail(post.getUserEmail()).get();
        String message;
        if (user.getId() == null){
            message = "The user not found";
            return ApiResponse.builder().message(message).save(false).build();
        }
        System.out.println(post.getSections());
        var blog = BlogPost.builder()
                .user(user)
                .sections(post.getSections())
                .category(post.getCategory())
                .likes(0)
                .tags(post.getTags())
                .build();
        blogPostRepository.save(blog);

        message = "BlogPost saved successfully";
        return ApiResponse.builder().message(message).save(true).build();
    }

    public List<BlogPost> getAllBlogs(){
        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getBlogbyId(Long blogId){
        return blogPostRepository.findBlogPostById(blogId);
    }

    public ApiResponse deleteBlog(Long blogId){
       boolean exists = blogPostRepository.existsById(blogId);
        if (!exists){
            throw new IllegalStateException(
                    "Blog WITH IS" + blogId + " doest exist"
            );
        }
        String message = "deleted successfully";
        blogPostRepository.deleteById(blogId);
        return ApiResponse.builder().message(message).build();
    }
    @Transactional
    public ApiResponse updateBlog(BlogPostRequest blogPut, Long blogId){
        boolean exists = blogPostRepository.existsById(blogId);
        BlogPost blog;
        blog = blogPostRepository.findById(blogId).get();
        User user = userRepository.findByEmail(blogPut.getUserEmail()).get();
        if (!exists){
            throw new IllegalStateException(
                    "Blog WITH this" + blogId + " doest exist"
            );
        }
        String message = "Blog edited successfully";
        if (user.getId() != null){
            blog.setUser(user);
            blog.setSections(blogPut.getSections());
            blog.setLikes(blogPut.getLikes());
            blog.setTags(blogPut.getTags());
        }

        return ApiResponse.builder().message(message).save(true).build();
    }

}

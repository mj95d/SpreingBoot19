package com.example.demo19.Controller;


import com.example.demo19.Model.Blog;
import com.example.demo19.Service.BlogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {


    private BlogService blogService;

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
    List<Blog> blog = blogService.getAllBlogs();
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/{id}")
    public ResponseEntity addAll(@PathVariable Blog blog) {
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("blog added");
    }

    @GetMapping("/title/{title}")
    public Blog getBlogByTitle(@PathVariable String title) {
        return blogService.getBlogByTitle(title);
    }

    @GetMapping("/category/{category}")
    public List<Blog> getBlogsByCategory(@PathVariable String category) {
        return blogService.getBlogsByCategory(category);
    }

    @PostMapping("/create")
    public Blog createBlog(@Valid @RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @PutMapping("/update/{id}")
    public Blog updateBlog(@PathVariable Long id, @Valid @RequestBody Blog blogDetails) {
        return blogService.updateBlog(id, blogDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/publish")
    public ResponseEntity<Blog> publishBlog(@PathVariable Long id) {
        blogService.publishBlog(id);
        return ResponseEntity.ok().build();
    }
}
package com.example.demo19.Service;

import com.example.demo19.Model.Blog;
import com.example.demo19.Repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
@Service
public class BlogService {

    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public void addBlog(Blog blog) {
        blogRepository.findAll(id)
                .orElseThrow(ResolutionException::new);
    }

    public Blog getBlogByTitle(String title) {
        return blogRepository.findByTitle(title)
                .orElseThrow(ResolutionException::new);
    }
    public List<Blog> getBlogsByCategory(String category) {
        return blogRepository.findByCategory(category);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }





    public Blog updateBlog(Long id, Blog blogDetails) {
        Blog blog = getAllBlogs(id);
        blog.setTitle(blogDetails.getTitle());
        blog.setCategory(blogDetails.getCategory());
        blog.setBody(blogDetails.getBody());
        blog.setPublished(blogDetails.isPublished());
        return blogRepository.save(blog);
    }

    public void deleteBlog(Long id) {
        Blog blog = getAllBlogs(id);
        blogRepository.delete(blog);
    }

    public void publishBlog(Long id) {
        Blog blog = getAllBlogs(id);
        blog.setPublished(true);
        blogRepository.save(blog);
    }

}
package com.example.demo19.Repository;

import com.example.demo19.Model.Blog;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//public interface BlogRepository  extends JpaRepository<Blog,Integer> {
    @Repository
    public interface BlogRepository extends JpaRepository<Blog, Long> {
        Optional<Blog> findByTitle(String title);
        List<Blog> findByCategory(String category);
    }



//
//    Lambda:
//    Optional<Blog> findByTitleIgnoreCase(String title);
//    List<Blog> findByCategoryIgnoreCase(String category);


//
//QueryDSL:
//

//    Optional<Blog> findOne(Predicate predicate);
//    List<Blog> findAll(Predicate predicate);


//   Data مواصفات
//
//    Optional<Blog> findOne(Specification<Blog> spec);
//    List<Blog> findAll(Specification<Blog> spec);


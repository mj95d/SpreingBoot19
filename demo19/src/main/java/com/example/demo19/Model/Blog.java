package com.example.demo19.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(4) not null")
    @NotEmpty(message = "title is required")
    private String title;

    @Column(columnDefinition = "varchar(4) not null")
    @NotBlank(message = "category is required")
    private String category;

    @Column(columnDefinition = "text not null")
    @NotBlank(message = "body is required")
    @Size(max = 300, message = "body cannot be longer than 300 characters")
    private String body;

    @Column(columnDefinition = "boolean default false")
    private boolean isPublished = false;}
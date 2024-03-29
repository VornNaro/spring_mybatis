package com.kshrd.btb_spring_data_mybatis_class_demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book {
    private Integer bookId;
    private String title;
    private LocalDateTime published_date = LocalDateTime.now();
    private Author author;
    private List<Category> categories = new ArrayList<>();
}

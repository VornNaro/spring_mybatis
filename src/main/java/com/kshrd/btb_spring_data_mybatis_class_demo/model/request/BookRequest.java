package com.kshrd.btb_spring_data_mybatis_class_demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookRequest {
    private String title;
    private Timestamp published_date = new Timestamp(System.currentTimeMillis());
    private Integer authorId;
    private List<Integer> categoriesId = new ArrayList<>();
}










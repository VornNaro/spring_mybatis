package com.kshrd.btb_spring_data_mybatis_class_demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Author {

    private Integer authorId;
    private String authorName;
    private String gender;

}

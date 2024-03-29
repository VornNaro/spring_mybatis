package com.kshrd.btb_spring_data_mybatis_class_demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Category {
    private Integer categoryId;
    private String name;
}

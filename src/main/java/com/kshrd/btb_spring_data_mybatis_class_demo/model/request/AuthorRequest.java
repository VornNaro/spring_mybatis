package com.kshrd.btb_spring_data_mybatis_class_demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthorRequest {
    private String name;
    private String gender;

}

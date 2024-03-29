package com.kshrd.btb_spring_data_mybatis_class_demo.repository;

import com.kshrd.btb_spring_data_mybatis_class_demo.model.entity.Category;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.request.BookRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryRepository {

    @Select("""
         SELECT c.id, c.name FROM book_category bc 
         INNER JOIN categories c ON c.id = bc.category_id 
         WHERE bc.book_id = #{bookId}
         """)
    @Result(property = "categoryId", column = "id")
    List<Category> getCategoryByBookId(Integer bookId);





}

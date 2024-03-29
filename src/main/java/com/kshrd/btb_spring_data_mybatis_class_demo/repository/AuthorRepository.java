package com.kshrd.btb_spring_data_mybatis_class_demo.repository;

import com.kshrd.btb_spring_data_mybatis_class_demo.model.entity.Author;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.request.AuthorRequest;
import com.kshrd.btb_spring_data_mybatis_class_demo.service.AuthorService;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorRepository {

    @Select("SELECT * FROM authors")

    @Results(
            id = "authorMapper",
            value = {
                    @Result(property = "authorId", column = "id"),
                    @Result(property = "authorName", column = "name")
            }
    )
    List<Author> findAllAuthor();

    @Select("SELECT * FROM authors WHERE id = #{authorId}")
    @ResultMap("authorMapper")
    Author findAuthorById(Integer authorId);

    @Delete("DELETE FROM authors WHERE id = #{authorId}")
    @ResultMap("authorMapper")
    boolean removeAuthorById(Integer authorId);


    @Select("INSERT INTO authors (name,gender) " +
            "VALUES (#{request.name},#{request.gender}) " +
            "RETURNING id")
    Integer saveAuthor(@Param("request") AuthorRequest authorRequest);

    @Select("UPDATE authors " +
            "SET name = #{request.name},gender= #{request.gender} WHERE id = #{authorId} "
            + "RETURNING id")
    Integer editAuthorById(@Param("request") AuthorRequest authorRequest, Integer authorId);


}

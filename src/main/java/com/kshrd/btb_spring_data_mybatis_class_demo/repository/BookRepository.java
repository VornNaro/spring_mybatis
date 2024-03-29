package com.kshrd.btb_spring_data_mybatis_class_demo.repository;

import com.kshrd.btb_spring_data_mybatis_class_demo.model.entity.Book;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.request.BookRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookRepository {

    @Select("SELECT * FROM books " +
            "LIMIT #{size} " +
            "OFFSET ${size} * (#{page} - 1)")
    @Results(
            id = "BookMapper",
            value = {
                    @Result(property = "bookId",column = "id"),
                    @Result(property = "author", column = "author_id",
                            one = @One(select = "com.kshrd.btb_spring_data_mybatis_class_demo.repository.AuthorRepository.findAuthorById")
                    ),
                    @Result(property = "categories", column = "id",
                            many = @Many(select = "com.kshrd.btb_spring_data_mybatis_class_demo.repository.CategoryRepository.getCategoryByBookId")
                    )
            })

    List<Book> findAllBook(Integer page, Integer size);

    @Select("SELECT * FROM books WHERE id = #{bookId}")
    @ResultMap("BookMapper")
    Book findBookById(Integer bookId);

    @Select("INSERT INTO books (title,published_date,author_id) " +
            "VALUES (#{request.title}, #{request.published_date},#{request.authorId}) " +
            "RETURNING id")
    Integer saveBook(@Param("request") BookRequest bookRequest);

    @Select("INSERT INTO book_category(book_id, category_id) " +
            "VALUES (#{bookId}, #{categoryId})")
    Integer saveCategoryByBookId(Integer bookId, Integer categoryId);



}

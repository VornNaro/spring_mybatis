package com.kshrd.btb_spring_data_mybatis_class_demo.service;

import com.kshrd.btb_spring_data_mybatis_class_demo.model.entity.Book;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.request.BookRequest;

import java.util.List;

public interface BookService {
    List<Book> getAllBook(Integer page, Integer size);
    Book getBookById(Integer bookId);

    Integer addNewBook(BookRequest bookRequest);
}

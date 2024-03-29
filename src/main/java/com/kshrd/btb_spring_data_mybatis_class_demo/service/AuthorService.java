package com.kshrd.btb_spring_data_mybatis_class_demo.service;

import com.kshrd.btb_spring_data_mybatis_class_demo.model.entity.Author;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.request.AuthorRequest;

import java.util.List;

public interface AuthorService {
  List<Author> getAllAuthors();
  Author getAuthorById(Integer authorId);

  boolean deleteAuthorById(Integer authorId);

  Integer createNewAuthor(AuthorRequest authorRequest);

  Integer updateAuthor(AuthorRequest authorRequest, Integer authorId);


}

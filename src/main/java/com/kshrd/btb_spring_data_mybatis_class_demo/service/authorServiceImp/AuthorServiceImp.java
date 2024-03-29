package com.kshrd.btb_spring_data_mybatis_class_demo.service.authorServiceImp;

import com.kshrd.btb_spring_data_mybatis_class_demo.model.entity.Author;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.request.AuthorRequest;
import com.kshrd.btb_spring_data_mybatis_class_demo.repository.AuthorRepository;
import com.kshrd.btb_spring_data_mybatis_class_demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImp implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAllAuthor();
    }

    @Override
    public Author getAuthorById(Integer authorId) {
        return authorRepository.findAuthorById(authorId);
    }

    @Override
    public boolean deleteAuthorById(Integer authorId) {
        return authorRepository.removeAuthorById(authorId);
    }

    @Override
    public Integer createNewAuthor(AuthorRequest authorRequest) {
        return authorRepository.saveAuthor(authorRequest);
    }

    @Override
    public Integer updateAuthor(AuthorRequest authorRequest, Integer authorId) {
        return authorRepository.editAuthorById(authorRequest, authorId);
    }
}

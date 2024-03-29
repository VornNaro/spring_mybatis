package com.kshrd.btb_spring_data_mybatis_class_demo.service.bookServiceImp;

import com.kshrd.btb_spring_data_mybatis_class_demo.model.entity.Book;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.request.BookRequest;
import com.kshrd.btb_spring_data_mybatis_class_demo.repository.BookRepository;
import com.kshrd.btb_spring_data_mybatis_class_demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
   private final BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getAllBook(Integer page, Integer size) {
        return bookRepository.findAllBook(page, size);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Override
    public Integer addNewBook(BookRequest bookRequest) {

        Integer storeBookId = bookRepository.saveBook(bookRequest);
        if (storeBookId != null){
            for (Integer categoryId: bookRequest.getCategories()){
                bookRepository.saveCategoryByBookId(storeBookId,categoryId);3,1,2
            }
        }

        return storeBookId;
    }


}

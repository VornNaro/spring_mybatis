package com.kshrd.btb_spring_data_mybatis_class_demo.controller;

import com.kshrd.btb_spring_data_mybatis_class_demo.model.entity.Book;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.request.BookRequest;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.response.AuthorResponse;
import com.kshrd.btb_spring_data_mybatis_class_demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get all Book
    @GetMapping("/all")
    public ResponseEntity<AuthorResponse<List<Book>>> getAllBook(
            @RequestParam Integer page,
            @RequestParam Integer size
    ){
        AuthorResponse<List<Book>> response = AuthorResponse.<List<Book>>builder()
                .message("Get data book success")
                .payload(bookService.getAllBook(page, size))
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();

        return ResponseEntity.ok(response) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Integer bookId){
        Book storeBook = bookService.getBookById(bookId);
        if (storeBook != null){
            AuthorResponse<Book> response = AuthorResponse.<Book>builder()
                    .message("Get data book success")
                    .payload(storeBook)
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();

            return ResponseEntity.ok(response) ;
        }
 return null;
    }

    // Post new book
    @PostMapping("/addNewBook")
    public ResponseEntity<?> postBook(@RequestBody BookRequest bookRequest){
        Integer bookId = bookService.addNewBook(bookRequest);
        if (bookId != null) {
            return ResponseEntity.ok(bookService.getBookById(bookId));
        }
        return null;
    }

















//    @PostMapping("/newAuthor")
//    @Operation(summary = "Add new author")
//    public ResponseEntity<Book> addNewBook(@RequestBody BookRequest bookRequest){
//
//        Integer storeNewBook = bookService.addNewBook(bookRequest);
//        if (storeNewBook != null){
//            return ResponseEntity.ok(bookService.getBookById(storeNewBook));
//        }
//        return null;
//    }
}

















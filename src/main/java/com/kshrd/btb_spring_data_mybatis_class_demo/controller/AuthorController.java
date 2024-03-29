package com.kshrd.btb_spring_data_mybatis_class_demo.controller;

import com.kshrd.btb_spring_data_mybatis_class_demo.model.entity.Author;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.request.AuthorRequest;
import com.kshrd.btb_spring_data_mybatis_class_demo.model.response.AuthorResponse;
import com.kshrd.btb_spring_data_mybatis_class_demo.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public ResponseEntity<AuthorResponse<List<Author>>> getAllAuthor(){
        AuthorResponse<List<Author>> response = AuthorResponse.<List<Author>>builder()
                .message("Get data success")
                .payload(authorService.getAllAuthors())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();

        return ResponseEntity.ok(response) ;
    }

    // Get Author By Id
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse<Author>> getAuthorById(
            @PathVariable("id") Integer authorId){
        AuthorResponse<Author> response = null;
        if (authorService.getAuthorById(authorId) != null){
            response = AuthorResponse.<Author>builder()
                    .message("Get data success")
                    .payload(authorService.getAuthorById(authorId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();

        }else {
            response = AuthorResponse.<Author>builder()
                    .message("Get data not success")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Integer authorId){
        boolean storeRemoveAuthor = authorService.deleteAuthorById(authorId);
        AuthorResponse<Author> response = null;
        if (storeRemoveAuthor){
            response = AuthorResponse.<Author>builder()
                    .message("delete data success")
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response = AuthorResponse.<Author>builder()
                    .message("delete data not success")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.ok(response);
    }


    @PostMapping("/addNewAuthor")
    @Operation(summary = "Add new author")
    public ResponseEntity<AuthorResponse<Author>> addNewAuthor(
            @RequestBody AuthorRequest authorRequest
            )
    {
       Integer storeAuthorId = authorService.createNewAuthor(authorRequest);
       AuthorResponse<Author> response = null;
       if (storeAuthorId != null){
            response = AuthorResponse.<Author>builder()
                   .message("Post data author success")
                   .payload(authorService.getAuthorById(storeAuthorId))
                   .httpStatus(HttpStatus.OK)
                   .timestamp(new Timestamp(System.currentTimeMillis()))
                   .build();
       }else {
           response = AuthorResponse.<Author>builder()
                   .message("Post data author not success")
                   .httpStatus(HttpStatus.BAD_REQUEST)
                   .timestamp(new Timestamp(System.currentTimeMillis()))
                   .build();
           return ResponseEntity.ok(response);
       }
        return ResponseEntity.ok(response);
    }
    // Update author
    @PutMapping("/update/{id}")
    @Operation(summary = "Update author")
    public ResponseEntity<AuthorResponse<Author>> updateAuthorById(
            @RequestBody AuthorRequest authorRequest,
            @PathVariable("id") Integer authorId
    ){
        AuthorResponse<Author> response = null;
        Integer storeUpdateById = authorService.updateAuthor(authorRequest, authorId);
        if (storeUpdateById != null){
            response = AuthorResponse.<Author>builder()
                    .message("Post data author success")
                    .payload(authorService.getAuthorById(storeUpdateById))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else {
            response = AuthorResponse.<Author>builder()
                    .message("Post data author not success")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(response);
    }







}

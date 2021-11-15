package com.example.bookstore.controller;

import com.example.bookstore.dto.ResponseDTO;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/books")
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create() {
        return ResponseEntity.ok().body(ResponseUtils.response_OK(bookService.create()));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllBookBySortAsc(){
        return ResponseEntity.ok().body(ResponseUtils.response_OK(bookService.sortByTitle()));
    }

    @GetMapping("/title-contain-{keyword}")
    public ResponseEntity<ResponseDTO> getAllBookTitleContainKeyword(@PathVariable("keyword") String keyword){
        return ResponseEntity.ok().body(ResponseUtils.response_OK(bookService.findByTitle(keyword)));
    }

}

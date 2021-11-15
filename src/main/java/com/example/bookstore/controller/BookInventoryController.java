package com.example.bookstore.controller;

import com.example.bookstore.dto.ResponseDTO;
//import com.example.bookstore.dto.requests.CreateBookRequest;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookInventoryService;
import com.example.bookstore.service.BookService;
import com.example.bookstore.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/book-inventories")
public class BookInventoryController {
    @Autowired
    private final BookInventoryService bookInventoryService;

    public BookInventoryController(BookInventoryService bookInventoryService) {
        this.bookInventoryService = bookInventoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAllInventories(){
        return ResponseEntity.ok().body(ResponseUtils.response_OK(bookInventoryService.createInventories()));
    }

    @GetMapping("out-of-stock")
    public ResponseEntity<ResponseDTO> getAllBookOutOfStock(){
        return ResponseEntity.ok().body(ResponseUtils.response_OK(bookInventoryService.findOutOfStock()));
    }
}

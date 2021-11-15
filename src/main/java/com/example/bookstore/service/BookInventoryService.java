package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookInventory;
import com.example.bookstore.repository.BookInventoryRepository;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInventoryService {

    public BookInventoryService(BookInventoryRepository bookInventoryRepository,
                                BookRepository bookRepository) {
        this.bookInventoryRepository = bookInventoryRepository;
        this.bookRepository = bookRepository;
    }

    BookInventoryRepository bookInventoryRepository;

    BookRepository bookRepository;

    public List<BookInventory> createInventories(){
        List<Book> books = bookRepository.getBooks();
        return bookInventoryRepository.createBookInventories(books);
    }


    public List<Book> findOutOfStock(){
        return bookInventoryRepository.getBooksByAmount(0);
    }
}

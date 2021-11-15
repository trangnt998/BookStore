package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;


    public List<Book> findAll(){
        return bookRepository.getAll();
    }

    public List<Book> create(){
       return bookRepository.createBook();
    }

    public List<Book> sortByTitle(){
        ArrayList<Book> books = (ArrayList<Book>) bookRepository.getBooks();
        ArrayList<Book> sortedBook = (ArrayList<Book>) books.clone();

        Collections.sort(sortedBook, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
               return b1.getTitle().compareTo(b2.getTitle());
            }
        });

        return sortedBook;
    }


    public List<Book> findByTitle(String key){
        return bookRepository.getBooksContainKeywordTitle(key);
    }

}

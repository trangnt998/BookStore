package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookInventory;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class BookRepository {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public BookRepository() {
        books = new ArrayList<>();
    }

    public List<Book> createBook(){
        Faker faker = new Faker(new Locale("EN"));
        for (int i = 0; i < 1000; i++){
            Book book = new Book(faker.regexify("[a-z0-9]{7}")+i, faker.book().title(),faker.book().author());
            books.add(book);
        }
        return books;
    }

    public List<Book> getAll(){
        return books;
    }

    public List<Book> getBooksContainKeywordTitle(String keyword){
        ArrayList<Book> result = new ArrayList<>();
        ArrayList<Book> books = (ArrayList<Book>) getAll();
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getTitle().contains(keyword)){
                result.add(books.get(i));
            }
        }
        return result;
    }




//    public static void main(String[] args) {
//        BookRepository bookRepository = new BookRepository();
//        for (int i = 0; i < 10; i++){
//            System.out.println(bookRepository.books.get(i).toString());
//        }
//    }

}

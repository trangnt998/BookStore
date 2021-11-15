package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class BookInventoryRepository {
    private List<BookInventory> bookInventories;
    @Autowired
    BookRepository bookRepository;


//    public BookInventoryRepository(List<Book> books) {
//        Random random = new Random();
//        bookInventories = new ArrayList<>();
//        for (int i = 0; i < 1000; i++){
//            BookInventory bookInventory = new BookInventory(i,books.get(i).getId(), random.nextInt(101), LocalDateTime.now());
//            bookInventories.add(bookInventory);
//        }
//    }


    public List<BookInventory> getBookInventories() {
        return bookInventories;
    }
    public BookInventoryRepository() {
        bookInventories = new ArrayList<>();
    }

    //tạo số lượng tồn kho cho các đầu sách, số lượng ngẫu nhiên từ 0 đến 100
    public List<BookInventory> createBookInventories(List<Book> books){
        //ArrayList<BookInventory> bookInventories = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < books.size(); i++){
            BookInventory bookInventory = new BookInventory(i,books.get(i).getId(), random.nextInt(101), LocalDateTime.now());
            bookInventories.add(bookInventory);
        }

        return bookInventories;
    }



    public List<Book> getBooksByAmount(int amount){
        List<Book> books = new ArrayList<>();
        List<Book> allbooks = bookRepository.getAll();

        for (int i = 0; i < bookInventories.size(); i++){
            if (bookInventories.get(i).getAmount() == amount){
                String bookId = bookInventories.get(i).getBookId();
                for (int j = 0; j < allbooks.size();j++){
                    if (allbooks.get(j).getId().equals(bookId)){
                        books.add(allbooks.get(j));
                        break;
                    }
                }
            }
        }
        return books;
    }

//
//   public static void main(String[] args) {
//
////          Test create Book's inventory
////        BookRepository bookRepository = new BookRepository();
////        List<BookInventory> bookInventories = createBookInventories(bookRepository.createBook());
////        for (int i = 0; i < bookInventories.size(); i++){
////            System.out.println(bookInventories.get(i).toString());
////        }
//
//
//        //Test get book out of stock
////        BookRepository bookRepository = new BookRepository();
////        List<BookInventory> bookInventories = createBookInventories(bookRepository.createBook());
////        for (int i = 0; i < bookInventories.size(); i++){
////            if (bookInventories.get(i).getAmount() == 0){
////                System.out.println(bookInventories.get(i).toString());
////            }
////        }
//

//
//    }


}

package com.example.bookstore.model;

import java.time.LocalDateTime;

public class BookInventory{
    private int id; //số tự động tăng
    private String bookId;
    private int amount; //số sách còn lại trong kho
    private LocalDateTime updateDate; //ngày, giờ cập nhật lại

    public BookInventory() {
    }

    public BookInventory(int id, String bookId, int amount, LocalDateTime updateDate) {
        this.id = id;
        this.bookId = bookId;
        this.amount = amount;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "BookInventory{" +
                "id=" + id +
                ", bookId='" + bookId + '\'' +
                ", amount=" + amount +
                ", updateDate=" + updateDate +
                '}';
    }
}
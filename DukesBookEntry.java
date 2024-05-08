package com.example.jsf;

public class DukesBookEntry {
    private String bookName;
    private int copies;
    private double price;
    DukesBookEntry(){

    }
    DukesBookEntry(String bookName, int copies, double price) {
        this.bookName = bookName;
        this.copies = copies;
        this.price = price;
    }
    //Getter and Setters
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

package com.example.jsf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class DukesCart {

    private ArrayList<DukesBookEntry> bookList;
    private double taxRate;
    private double taxAmount;
    private double shippingAmount;
    private double totalCost;
    private String state;

    public DukesCart() {
        bookList = new ArrayList<DukesBookEntry>();
        bookList.add(new DukesBookEntry("Book1", 5, 10.0));
        bookList.add(new DukesBookEntry("Book2", 3, 5.0));
        bookList.add(new DukesBookEntry("Book3", 2, 7.50));
        bookList.add(new DukesBookEntry("Book4", 3, 8.0));
        bookList.add(new DukesBookEntry("Book5", 4, 6.0));
    }

    public ArrayList<DukesBookEntry> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<DukesBookEntry> bookList) {
        this.bookList = bookList;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxAmount() {
        double subtotal = this.getSubTotal();
        return subtotal * taxRate;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(double shippingAmount) {
        this.shippingAmount = shippingAmount;
    }
    public double getSubTotal() {
        double subTotal = 0;
        for (DukesBookEntry entry : bookList) {
            subTotal += entry.getPrice() * entry.getCopies();
        }
        return subTotal;
    }

    public double getTotalCost() {
        totalCost = getSubTotal() + getTaxAmount() + getShippingAmount();
        return this.totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public double calcTaxAmount() {
        taxAmount = getSubTotal() * taxRate;
        return this.taxAmount;
    }
    public double calcShippingCost(){
        shippingAmount = getShippingAmount() * 0.10;
        return this.shippingAmount;
    }

    //calculates grandTotalCost
    public double calcGrandTotalCost(){
        double subtotal = this.getSubTotal();
        double shipping = this.calcShippingCost();
        return 0.0;
    }
}

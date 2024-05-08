package com.example.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

@Named(value = "checkoutPage")
@RequestScoped

public class CheckoutPage {
    //Variables and Objects
    private String state;
    private double taxAmount;
    private double subtotal;
    private double orderTotal;
    private double shippingCharges;
    private double grandTotal;
    private DukesCart cart;
    String formatted_OrderTotal;
    String formatted_Subtotal;
    String formatted_TaxAmount;
    String formatted_ShippingCharges;
    String formatted_GrandTotal;
    private ArrayList<DukesBookEntry> bookEntries;
    private ArrayList<StateTax> stateTaxes;

    public CheckoutPage() {
    }

    public DukesCart getCart() {
        return cart;
    }

    public void checkoutProcess(){
        //initialize objects
        stateTaxes = new ArrayList<>();
        cart = new DukesCart();

        stateTaxes.add(new StateTax("California", 0.725));
        stateTaxes.add(new StateTax("Tennessee", 0.07));
        stateTaxes.add(new StateTax("Louisiana", 0.045));
        stateTaxes.add(new StateTax("SouthCarolina", 0.06));
        stateTaxes.add(new StateTax("NorthCarolina", 0.0424));
        stateTaxes.add(new StateTax("Florida", 0.06));
        stateTaxes.add(new StateTax("Georgia", 0.04));
        stateTaxes.add(new StateTax("Alabama", 0.04));
        stateTaxes.add(new StateTax("Pennsylvania", 0.06));
        stateTaxes.add(new StateTax("Arizona", 0.560));

        formatted_OrderTotal = calculateOrderTotal();
        formatted_TaxAmount = calculateTax(state, orderTotal);
        formatted_Subtotal = calculateSubtotal(orderTotal, taxAmount);
        formatted_ShippingCharges = calculateShipping(orderTotal);
        formatted_GrandTotal = calculateGrandTotal();
    }
    // Calculates total for order
    public String calculateOrderTotal(){
        NumberFormat us_Formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        //for each book in list multiply copy by price
        for(DukesBookEntry book : this.getCart().getBookList()){
            orderTotal+= book.getCopies() * book.getPrice();
        }
        return us_Formatter.format(orderTotal);
    }
    //Calculates subtotal of cart
    public String calculateSubtotal(double orderTotal, double taxAmount){
        subtotal = orderTotal + taxAmount;
        NumberFormat us_Formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return us_Formatter.format(subtotal);
    }
    //Calculates tax(finish)
    public String calculateTax(String state, double orderTotal) {
        //compute tax
        double taxRate = 0.0;
        for(StateTax stateTax : stateTaxes){
            if(state.equals(stateTax.getStateName())){
                taxRate = stateTax.getTaxRate();
            }
        }

        taxAmount = orderTotal * taxRate;
        //local formatting
        NumberFormat us_Formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return us_Formatter.format(taxAmount);
    }
    //Calculates shipping charges
    public String calculateShipping(double orderTotal) {
        // code to calculate shipping charges based on order total
        //10% of purchase price
        NumberFormat us_Formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        shippingCharges = orderTotal * 0.10;
        return us_Formatter.format(shippingCharges);
    }
    public String calculateGrandTotal(){
        NumberFormat us_Formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        grandTotal = subtotal + shippingCharges;
        return us_Formatter.format(grandTotal);
    }
    public String displayOrderSummary() {
        // code to display order sub-total, tax amount, shipping charges, and grand total
        return "<p style=\"color:red\"> </>"
                + "TOTAL: " + formatted_OrderTotal + "<br/>"
                + "TAX AMOUNT:" + formatted_TaxAmount + "<br/>"
                + "SUBTOTAL: " + formatted_Subtotal + "<br/>"
                + "SHIPPING: " + formatted_ShippingCharges + "<br/>"
                + "GRAND TOTAL:" + formatted_GrandTotal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

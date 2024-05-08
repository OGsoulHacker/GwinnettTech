/*
 * This program process taxes
 */
package com.example.jsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.text.NumberFormat;
import java.util.*;
/**
 *
 * @author apach
 */
@Named(value = "processTax")
@RequestScoped


public class ProcessTax
{
    //Declare the locale object
    private Locale locale = Locale.getDefault();

    private double income;
    private int status;

    public ProcessTax() {
    }

    // Getters and Setters

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    //Variables for processing information
    double tx;
    String formatted_Income;
    String formatted_Tax;

    //Function to get the result and formatting
    public void cal_Tax()
    {
        //Compute tax
        tx = ComputeTax.computeTax(status, income);

        //local Formatting
        NumberFormat us_Formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        formatted_Income = us_Formatter.format(income);
        formatted_Tax = us_Formatter.format(tx);
    }


    // Display the results
    public String getResult()
    {
        return "<p style=\"color:red\"> </>"
                + "Taxable Amount: " + formatted_Income + "<br />"
                + "Filling Status: " + status + "<br />"
                + "Tax: " + formatted_Tax + "</p>";
    }
}




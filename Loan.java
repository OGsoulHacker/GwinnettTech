
package com.example.jsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.text.NumberFormat;

import java.util.*;

@Named(value = "loan")
@RequestScoped

public class Loan implements java.io.Serializable {
        private Locale locale = Locale.getDefault();
        private double annualInterestRate;
        private int numberOfYears;
        private double loanAmount;
        private java.util.Date loanDate;

        /**
         * Default constructor
         */
        public Loan() {
            this(2.5, 1, 1000);
        }

        /**
         * Construct a loan with specified annual interest rate, number of years,
         * and loan amount
         */
        public Loan(double annualInterestRate, int numberOfYears,
                    double loanAmount) {
            this.annualInterestRate = annualInterestRate;
            this.numberOfYears = numberOfYears;
            this.loanAmount = loanAmount;
            loanDate = new java.util.Date();
        }

        /**
         * Return annualInterestRate
         */
        public double getAnnualInterestRate() {
            return annualInterestRate;
        }

        /**
         * Set a new annualInterestRate
         */
        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

        /**
         * Return numberOfYears
         */
        public int getNumberOfYears() {
            return numberOfYears;
        }

        /**
         * Set a new numberOfYears
         */
        public void setNumberOfYears(int numberOfYears) {
            this.numberOfYears = numberOfYears;
        }

        /**
         * Return loanAmount
         */
        public double getLoanAmount() {
            return loanAmount;
        }

        /**
         * Set a newloanAmount
         */
        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }
        double payment;
        String formatted_loan_amount;
        String formatted_monthly_payment;
        String formatted_total_payment;

        /**
         * Find monthly payment
         */
        public double getMonthlyPayment() {
            double monthlyInterestRate = annualInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate / (1
                    - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
            return monthlyPayment;
        }

        /**
         * Find total payment
         */
        public double getTotalPayment() {
            double totalPayment = getMonthlyPayment() * numberOfYears * 12;
            return totalPayment;
        }

        public void cal_payment()
        {
            //Compute tax
            payment = getTotalPayment();

            //local Formatting
            NumberFormat num_Formatter = NumberFormat.getCurrencyInstance(locale.getDefault());
            formatted_loan_amount = num_Formatter.format(loanAmount);
            formatted_total_payment = num_Formatter.format(payment);
            formatted_monthly_payment = num_Formatter.format((payment/numberOfYears)/12);
        }
        public void reset(){
            setLoanAmount(0);
            setAnnualInterestRate(0);
            setNumberOfYears(0);
            getTotalPayment();
        }
        /**
         * Return loan date
         */
        public java.util.Date getLoanDate() {
            return loanDate;
        }
    // Display the results
        public String getResult()
        {
            return "<p style=\"color:red\"> </>"
                    + "Loan Amount: " + formatted_loan_amount + "<br />"
                    + "Annual Interest Rate: " + annualInterestRate + "<br />"
                    + "Number of Years: " + numberOfYears + "</p>"
                    + "Monthly Payment: " + formatted_monthly_payment + "</p>"
                    + "Total Payment: " + formatted_total_payment + "</p>";
        }

    }
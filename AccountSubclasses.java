package hello;
import java.util.Date;
/*Part 1: The Account class:
    Design a class named Account that contains:
        - private in data field named id for the account (default 0)
        - private double data field named balance for the account (default 0)
        - private double data field named annualInterestRate:
            >stores the current interest rate (default 0) Assume that all accounts have the same interest rate
        - private Date data field named dateCreated that stores date account was created
        - no-arg constructor that creates a default account
        - constructor that creates an account with the specified id and initial balance
        - accessor and mutator methods for:
            >id
            > balance
            > interestRate
        - accessor method for dateCreated
        - method named getMonthlyInterest() that returns the monthly interest
        - method named withdraw that withdraws a specified amount from the account
        - method named deposit that deposits a specified amount to the account

    Write a test program that:
        - creates an Account object with and ID of 1122
        - balance of $20,000
        - annual interest rate of 4.5%
        - Use the withdraw method to withdraw $2,500
        - use the deposit method to deposit $3,000
        - print the balance, monthly interest, date the account was created
=========================================================================================================
  Part 2: Subclasses of Account
 In programming exercise 9.7 The Account class was defined to model a bank account. An account has
 the properties: account number, balance, annual interest rate, and date created, It also has methods to
 deposit and withdraw funds.
    Create 2 subclasses for checking and saving accounts
        - checking account has an overdraft limit
        - savings account can be overdrawn

    Write a test program that creates objects of:
        - Account
        - SavingsAccount
        - CheckingAccount
        calls their toString method
*/
public class AccountSubclasses {
        public static void main(String[] args) {

            SavingsAccount savings = new SavingsAccount(123, 50000);
            CheckingAccount checking = new CheckingAccount(124, 85000, -20);

            System.out.println("SavingsAccount : ");
            System.out.println("Account Number : "+ savings.acc_num);
            System.out.println("Balance : " + savings.balance+ "\n");

            System.out.println("CheckingAccount : ");
            System.out.println("Account Number : " + checking.acc_num);
            System.out.println("Balance : " + checking.balance);

            withdrawAccount(savings,20000);
            withdrawAccount(checking,50000);

            System.out.println("\nAfter withdrawal...\n");
            System.out.println("SavingsAccount : ");
            System.out.println("Account Number : "+ savings.acc_num);
            System.out.println("Balance : " + savings.balance+ "\n");

            System.out.println("CheckingAccount : ");
            System.out.println("Account Number : " + checking.acc_num);
            System.out.println("Balance : " + checking.balance);
    }
}
class Account
{
    int acc_num;
    double balance;
    String date;


//instance variables, different for every Account
    private int id;
    private double balance;
    private Date dateCreated;

//class variable, same for all Accounts

    private static double annualInterestRate=0;

//no-arg constructor
    public Account()
    {
        id=0;
        balance=0;
        dateCreated=new Date();
    }

//parametrized constructor
    public Account(int id, int balance)
    {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

//accessor/Getter methods
    public int getId()
    {
        return id;
    }

    public double getBalance()
    {
        return balance;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public static double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

//mutator/Setter methods
    public void setId(int id)
    {
        this.id = id;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double annualInterestRate)
    {
        Account.annualInterestRate = annualInterestRate;
    }

//method to return monthly interest rate
    public static double getMonthlyInterestRate()
    {
        return annualInterestRate/12;
    }

//method to return monthly interest for an Account
    public double getMonthlyInterest()
    {
        return (getMonthlyInterestRate()/100)*balance;
    }

//method to withdraw from balance
    public void withdraw(double amount)
    {
        if(amount <= balance)
            balance -= amount;
    }

//method to deposit into balance
    public void deposit(double amount)
    {
        balance += amount;
    }
}
    class SavingsAccount extends Account{
        SavingsAccount(int id, double balance)
        {
            super(id,balance);
        }
    }

    class CheckingAccount extends Account{
        double overdraw_limit;

        CheckingAccount(int id, double balance, double overdraftLimit)
        {
            super(id,balance);
            this.overdraw_limit = overdraftLimit;
        }

        static void withdrawAccount(Account account, double amount)
        {
            account.withdraw(amount);
            System.out.println(amount + " rs is withdrawn from account number " + account.acc_num);
        }
    }

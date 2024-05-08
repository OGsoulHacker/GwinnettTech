package com.example.jsf;

import java.sql.*;
import java.util.ArrayList;

public class StateTax {
    private String stateName;
    private double taxRate;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public StateTax(String stateName, double taxRate) {
        this.stateName = stateName;
        this.taxRate = taxRate;
    }
}
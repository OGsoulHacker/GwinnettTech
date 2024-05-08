package com.example.hellofx;

import java.text.NumberFormat;
import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//=============================================================================
/*36.6: Convert Dollars
write a program that convert U.S. dollars to:
Canadian dollars
German marks(euros)
British pounds
The user will enter the U.S. dollar amount and the conversion rate
Then the user will click the Convert button to display the converted amount.
 */
//=============================================================================
public class ConvertDollars extends Application {
    //Declare UI parts
    //TextFields
    TextField dollarTxt;
    TextField canadaTxt;
    TextField euroTxt;
    TextField poundTxt;
    TextField canadaExch;
    TextField euroExch;
    TextField poundExch;
    //Button
    Button convert;
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        //Creates grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
    //Section for USD
        //Creates a label
        //0, row 0, with columnspan 2 (occupies 2 columns) and rowspan 1
        pane.add(new Label("Enter Dollar Amount"), 0, 0, 2, 1);
        //Text field for entering dollar amount
        dollarTxt = new TextField();
        dollarTxt.setAlignment(Pos.CENTER_RIGHT);//Sets text alignment
        pane.add(dollarTxt,1,1,3,1);//column 1,row 1,columnspan 3,rowspan 1
        convert = new Button("CONVERT");//Button object for convert
        //adding action listener to the button to call update method
        convert.setOnAction(e -> update());
        pane.add(convert,4,1);//
        //Add labels to pane
        pane.add(new Label("Display Exchange"), 0, 2, 2, 1);//column 0,row 2,columnspan 2,rowspan 1
        pane.add(new Label("Exchange Rate"), 1, 3);//
        pane.add(new Label("Converted Amount"), 3, 3);//
   //Section for Canadian Dollars
        pane.add(new Label ("Canadian Dollars"),0,4);
        //Text field for entering canadian dollar exchange rate
        canadaExch = new TextField();
        //Sets alignment
        canadaExch.setAlignment(Pos.CENTER_RIGHT);
        pane.add(canadaExch,1,4,2,1);//
        //Text field for displaying the amount in canadian dollars
        canadaTxt = new TextField();
        canadaTxt.setAlignment(Pos.CENTER_RIGHT);//
        pane.add(canadaTxt,3,4,2,1);//
   //Section for euros
        pane.add(new Label ("German marks (euros)"),0,5);
        //Text field for euros
        euroExch = new TextField();
        euroExch.setAlignment(Pos.CENTER_RIGHT);//Sets alignment
        pane.add(euroExch, 1, 5, 2, 1);//
        //text field for displaying the amount in euros
        euroTxt = new TextField();
        euroTxt.setAlignment(Pos.CENTER_RIGHT);//Sets alignment
        pane.add(euroTxt, 3, 5, 2, 1);//
   //Section for British pounds
        pane.add(new Label("British Pounds"), 0, 6);//
        //text field for entering the exchange rate for british pounds
        poundExch = new TextField();
        poundExch.setAlignment(Pos.CENTER_RIGHT);
        pane.add(poundExch, 1, 6, 2, 1);//
        //text field for displaying amount in british pounds
        poundTxt = new TextField();
        poundTxt.setAlignment(Pos.CENTER_RIGHT);//Sets alignment
        pane.add(poundTxt, 3, 6, 2, 1);//
    //Setting the scene and displaying the scene
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise36_06");
        primaryStage.show();
    }
    void update(){
        try {
            //Getting input from text fields
            double USD = Double.parseDouble(dollarTxt.getText());
            double canDollarEx = Double.parseDouble(canadaExch.getText());
            double euroDollarEx = Double.parseDouble(euroExch.getText());
            double poundEx = Double.parseDouble(poundExch.getText());
            //Canada
            //NumberFormat object to display amount in Canadian Dollars
            NumberFormat numFormat = NumberFormat.getCurrencyInstance(Locale.CANADA);
            //Locates amount in canadian dollars and formatting and displaying it
            //on the corresponding text field.
            canadaTxt.setText(numFormat.format(USD * canDollarEx));
            //Euro
            numFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
            euroTxt.setText(numFormat.format(USD * euroDollarEx));
            //British pounds
            numFormat = NumberFormat.getCurrencyInstance(Locale.UK);
            poundTxt.setText(numFormat.format(USD * poundEx));
        }catch (Exception e){
            //Invalid data
        }
    }
    public static void main(String[] args) {
        launch(args);

    }
}


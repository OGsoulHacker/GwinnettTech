package com.example.hellofx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DecimalFormat;

public class BMIclient extends Application {
    //Variables
    private double weight;
    private double height;
    //Create button
    Button submitbt = new Button();
    //Create text fields
    TextField weighttf = new TextField();
    TextField heighttf = new TextField();
    // IO streams
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        //Setup Pane elements
        Pane pane = new Pane();
        ScrollPane sPane = new ScrollPane();
        //Setup button
        submitbt.setText("Submit");
        // Text area to display contents
        TextArea ta = new TextArea();
        //Create scrollpane for text area
        //ScrollPane sPane = new ScrollPane(ta);
        //Create Hbox for button
        HBox buttons = new HBox(submitbt);
        buttons.setSpacing(10); //gap between cells
        buttons.setAlignment(Pos.CENTER);
        //Setup text fields
        weighttf.setMaxWidth(50);
        heighttf.setMaxWidth(50);
        //Create label for text fields
        Label weightlbl = new Label();
        Label heightlbl = new Label();
        //Set label for text fields
        weightlbl.setText("Weight in pounds");
        heightlbl.setText("Height in inches");
        //Setup HBoxes to hold the label + text field
        //Weight Hbox
        HBox weighthbox = new HBox(weightlbl, weighttf);
        weighthbox.setMaxWidth(400);
        weighthbox.setSpacing(5);
        weighthbox.setAlignment(Pos.CENTER_LEFT);
        //Height Hbox
        HBox heighthbox = new HBox(heightlbl, heighttf);
        heighthbox.setMaxWidth(400);
        heighthbox.setSpacing(5);
        heighthbox.setAlignment(Pos.CENTER_LEFT);
        // Hbox for button and height to align
        HBox bhHBox = new HBox(heighthbox, buttons);

        //Output Hbox
        HBox bmihbox = new HBox(ta);
        bmihbox.setMaxWidth(400);
        bmihbox.setSpacing(5);
        bmihbox.setAlignment(Pos.CENTER);

        //Setup Vbox
        VBox fields = new VBox(weighthbox, bhHBox);
        fields.setSpacing(3);
        //Setup VBox to hold fields and button vbox and hbox
        VBox paneElements = new VBox(fields, bmihbox);
        paneElements.setSpacing(3);
        paneElements.setAlignment(Pos.CENTER);

        pane.getChildren().add(paneElements);
        sPane.setContent(pane);
        // Create a scene and place it in the stage
        Scene scene = new Scene(sPane, 360, 130);//Creates scene
        primaryStage.setTitle("Exericse_33_02: BMI Client"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        //Register event handler
        submitbt.setOnAction(e -> {
            try {
                // Get the height from the text field
                double height = Double.parseDouble(heighttf.getText().trim());
                // Get the weight from the text field
                double weight = Double.parseDouble(weighttf.getText().trim());
                // Send the bmi to the server
                toServer.writeDouble(weight);
                toServer.flush();
                toServer.writeDouble(height);
                toServer.flush();
                // Get bmi from the server
                double bmi = fromServer.readDouble();
                // Display to the text area
                ta.appendText("Weight is " + weight + "\n");
                ta.appendText("Height is " + height + "\n");
                if (bmi < 18.5)
                    ta.appendText("BMI is " + df.format(bmi) + " Underweight");
                else if (bmi < 25)
                    ta.appendText("BMI is " + df.format(bmi) + " Normal");
                else if (bmi < 30)
                    ta.appendText("BMI is: " + df.format(bmi) + " Overweight");
                else
                    ta.appendText("BMI is: " + df.format(bmi) +" Obese");
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        });
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);
            // Socket socket = new Socket("130.254.204.36", 8000);
            // Socket socket = new Socket("drake.Armstrong.edu", 8000);
            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());
            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            ta.appendText(ex.toString() + '\n');
        }
    }
    //for server below
    private void submit(double weight, double height){

    }
}

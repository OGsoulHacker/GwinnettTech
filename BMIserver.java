package com.example.hellofx;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
public class BMIserver extends Application {
    public void start(Stage primaryStage){
        // Text area for displaying contents
        TextArea ta = new TextArea();
        // Create a scene and place it in the stage
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);//Creates scene
        primaryStage.setTitle("Exericse_33_02: BMI Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        //constants
        final double KILOGRAMS_PER_POUND = 0.45359237;
        final double METERS_PER_INCH = 0.0254;
        //Create thread
        new Thread( () -> {
            try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                        ta.appendText("Server started at " + new Date() + '\n'));
                // Listen for a connection request
                Socket socket = serverSocket.accept();
                // Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());
                while (true) {
                    // Receive radius from the client
                    double weight = inputFromClient.readDouble();
                    double height = inputFromClient.readDouble();
                    //Compute BMI
                    double weightInkilograms = weight * KILOGRAMS_PER_POUND;
                    double heightInMeters = height * METERS_PER_INCH;
                    double bmi = weightInkilograms / (heightInMeters * heightInMeters);
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);

                    // Send bmi back to the client
                    outputToClient.writeDouble(bmi);

                    Platform.runLater(() -> {
                        //Output for server
                        ta.appendText("Weight received from client: "
                                + weight + '\n');
                        ta.appendText("Height received from client: " + height + '\n');
                       // ta.appendText("BMI is: " + df.format(bmi));
                        // Display result
                        if (bmi < 18.5)
                            ta.appendText("BMI is " + df.format(bmi) + " Underweight");
                        else if (bmi < 25)
                            ta.appendText("BMI is " + df.format(bmi) + " Normal");
                        else if (bmi < 30)
                            ta.appendText("BMI is: " + df.format(bmi) + " Overweight");
                        else
                            ta.appendText("BMI is: " + df.format(bmi) +" Obese");
                    });
                }
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
    public static void main(String[] args) {
        launch(args);
    }
}


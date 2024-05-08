package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
/*Traffic Lights
Write a program that simulates a traffic light.
    Program lets the user select one of three traffic lights:
        - Red
        - Yellow
        - Green
    > When a radio button is selected, the light is turned on.
    > Only one light can be on at a time
    > When the program starts no light is on
*/
public class TrafficLights extends Application {
    private double paneWidth = 200;  //Sets pane width
    private double paneHeight = 100; //Sets pane height
    //declaring UI components
    private Circle redCircle, yellowCircle, greenCircle;
    private RadioButton rbRed, rbYellow, rbGreen;

    @Override//Override the start method in the application class
    public void start(Stage primaryStage) {
        //*********************************************************************
        //creating a Rectangle to represent the traffic light box
        //*********************************************************************
        Rectangle box = new Rectangle(50, 50, 100, 300);
        //using white color as background
        box.setFill(Color.WHITE);
        //and black outline
        box.setStroke(Color.BLACK);
        //*********************************************************************
        //creating three circle objects for the three lights, using no fill color, but
        //using black color for the outline
        //*********************************************************************
        redCircle = new Circle(100, 100, 40);
        redCircle.setFill(Color.TRANSPARENT);
        redCircle.setStroke(Color.BLACK);

        yellowCircle = new Circle(100, 200, 40);
        yellowCircle.setFill(Color.TRANSPARENT);
        yellowCircle.setStroke(Color.BLACK);

        greenCircle = new Circle(100, 300, 40);
        greenCircle.setFill(Color.TRANSPARENT);
        greenCircle.setStroke(Color.BLACK);
        //creating a group and adding the box and lights
        Group lights = new Group(box, redCircle, yellowCircle, greenCircle);
        //*********************************************************************
        //Creates 3 Radio Buttons
        //*********************************************************************
        rbRed = new RadioButton("Red");
        rbYellow = new RadioButton("Yellow");
        rbGreen = new RadioButton("Green");

        //using a ToggleGroup, so that only one btn can be selected at a time
        ToggleGroup tg = new ToggleGroup();
        rbRed.setToggleGroup(tg);
        rbYellow.setToggleGroup(tg);
        rbGreen.setToggleGroup(tg);

        //adding action listener to all three radio buttons to call updateLights
        //method
        rbRed.setOnAction(e -> updateLights());
        rbYellow.setOnAction(e -> updateLights());
        rbGreen.setOnAction(e -> updateLights());

        //creating an HBox using radio buttons, aligning center
        HBox buttons = new HBox(rbRed, rbYellow, rbGreen);
        buttons.setSpacing(20); //gap between cells
        buttons.setAlignment(Pos.CENTER);

        //creating a VBox containing lights and radio buttons hbox, aligning center
        VBox vbox = new VBox(lights, buttons);
        vbox.setSpacing(20); //gap between cells
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20)); //padding

        //setting up and displaying the scene
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_03");
        primaryStage.show();
    }
    //handler method that updates changes in light as per current selection
    public void updateLights() {
        //if red button is selected, setting redLight's fill to RED and rest to
        //transparent (can also use white)
        if (rbRed.isSelected()) {
            redCircle.setFill(Color.RED);
            yellowCircle.setFill(Color.TRANSPARENT);
            greenCircle.setFill(Color.TRANSPARENT);
        } //if yellow is selected, setting yellowLight's fill to YELLOW
        else if (rbYellow.isSelected()) {
            redCircle.setFill(Color.TRANSPARENT);
            yellowCircle.setFill(Color.YELLOW);
            greenCircle.setFill(Color.TRANSPARENT);
        } //if green is selected, setting greenLight's fill to GREEN
        else if (rbGreen.isSelected()) {
            redCircle.setFill(Color.TRANSPARENT);
            yellowCircle.setFill(Color.TRANSPARENT);
            greenCircle.setFill(Color.GREEN);
        }
    }
}

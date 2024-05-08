package com.example.hellofx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;


public class DisplayRectangle extends Application {
    @Override // override the start method in the application class
    public void start(Stage primaryStage) {
        //Creates rectangle, set rectangle properties
        Group group = new Group();//Creates group
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setX(20);//Sets X coordinate
        rectangle1.setY(20);//Sets Y coordinate
        rectangle1.setWidth(100);//Sets rectangle width
        rectangle1.setHeight(100);//Sets rectangle height
        group.getChildren().addAll(rectangle1);//Adding rectangle to the group
        Scene scene = new Scene(group,200,300,Color.BLUE);

        //Creates scene and places it on stage
        primaryStage.setTitle("Display Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();//Display the stage
    }
}
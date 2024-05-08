package com.example.hellofx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/*Draw lines using arrow keys
    Write a program that draws line segments using the arrow keys.
    The line starts from (100,100) in the pane and draws toward
    east, north, west or south when the right-arrow key,
    up-arrow key, left-arrow key, or down-arrow key is pressed.
*/
public class DrawLines extends Application{
    @Override
    public void start(Stage primaryStage){
        //Create pane and set its properties
        Pane pane = new Pane();
        // Create a polyline
        Polyline polyline = new Polyline(100.0, 100.0);
        polyline.setFill(Color.WHITE);
        polyline.setStroke(Color.BLUE);
        pane.getChildren().add(polyline);
        ObservableList<Double> list = polyline.getPoints();

        // Create and register handler
        pane.setOnKeyPressed(e -> {
            double x = 0, y = 0;
            double length = 10;
            //switch statement for line direction
            switch (e.getCode()) {
                case DOWN -> {
                    x = list.get(list.size() - 2);
                    y = list.get(list.size() - 1) + length;
                }
                case UP -> {
                    x = list.get(list.size() - 2);
                    y = list.get(list.size() - 1) - length;
                }
                case RIGHT -> {
                    x = list.get(list.size() - 2) + length;
                    y = list.get(list.size() - 1);
                }
                case LEFT -> {
                    x = list.get(list.size() - 2) - length;
                    y = list.get(list.size() - 1);
                }
            }
            list.add(x);
            list.add(y);
        });

        //Create Scene
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Draw Lines");//Display the title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();//Display the stage

        pane.requestFocus(); // Pane is focused to receive key input
    }
}

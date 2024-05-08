package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/*Display the mouse position
Write a program that displays the mouse position(coordinates) when the mouse
button is clicked.
*/
public class MousePosition_1 extends Application {
    @Override//Override the start method in the application class
    public void start(Stage primaryStage) {
        double width = 400;
        double height = 400;

        //Create a pane and set its properties
        Text text = new Text();
        Pane pane = new Pane(text);

        pane.setOnMouseClicked(e -> {
            updateMousePosition(e, text);
        });
        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("Mouse Position");//Set stage title
        primaryStage.setScene(scene);//Place the scene in the stage
        primaryStage.show();//Display the stage
        System.out.println(primaryStage.getX() + primaryStage.getY());
    }
    public void updateMousePosition(MouseEvent e, Text text) {
        text.setX(e.getX() + 2);
        text.setY(e.getY() - 2);
        text.setText("(" + e.getX() + ", " + e.getY() + ")");
        text.setVisible(true);
    }
}

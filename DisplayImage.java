package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
/*Display Image
    Write a program that displays 4 images in a grid pane
*/
public class DisplayImage extends Application{
    @Override // override the start method in the application class
    public void start(Stage primaryStage) {
        //Creates grid pane and sets its properties to hold the image views
        GridPane pane = new GridPane();

        //Place nodes in the pane
        //Create image1, Add image to grid pane
        pane.add(new ImageView(new Image("C:\\Users\\count\\IdeaProjects\\HelloFx\\image\\flag1.gif")),0,0);
        //Create image2, Add image to grid pane
        pane.add(new ImageView(new Image("C:\\Users\\count\\IdeaProjects\\HelloFx\\image\\flag2.gif")),0,1);
        //Create image3, Add image to grid pane
        pane.add(new ImageView(new Image("C:\\Users\\count\\IdeaProjects\\HelloFx\\image\\flag3.gif")),1,0);
        //Create image4, Add image to grid pane
        pane.add(new ImageView(new Image("C:\\Users\\count\\IdeaProjects\\HelloFx\\image\\flag4.gif")),1,1);

        //Creates Scene and places images in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Images");//Sets stage title
        primaryStage.setScene(scene);//Places scene in the stage
        primaryStage.show();//Displays stage
    }
}

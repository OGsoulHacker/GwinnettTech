package com.example.hellofx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/*Create a miles/kilometer converter
Write a program that converts miles and kilometers.
If you enter a value in the Mile text and press the enter key,
the corresponding kilometer measurement is displayed in the
kilometer text field.
Likewise, if you enter a value in the kilometer text and press the enter key
the corresponding miles is displayed in the Mile text field
*/
public class MilesKilometersConverter extends Application {
    private TextField kilometers;
    private TextField miles;
    private final double convert = 1.60230732254464;
    @Override
    public void start(Stage primaryStage){

        kilometers = new TextField ();
        miles = new TextField ();

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(50, 5, 5, 5));

        grid.add(new Label("Miles : "), 0, 0);
        grid.add(new Label("Kilometers : "), 0, 1);
        grid.add(miles, 1, 0);
        grid.add(kilometers, 1, 1);
        //******************************************************************
        //Event handlers
        //******************************************************************
        kilometers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    double kilo = Double.parseDouble(kilometers.getText());
                    double mile = kilo/convert;
                    miles.setText(mile+"");
                }catch(Exception ex){
                }
            }
        });
        miles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    double mile = Double.parseDouble(miles.getText());
                    double kilo = mile*convert;
                    kilometers.setText(kilo+"");
                }catch(Exception ex){
                }
            }
        });
        HBox hbox = new HBox(grid);
        hbox.setSpacing(10);
        BackgroundFill background_fill = new BackgroundFill(Color.LIME,
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        hbox.setBackground(background);
        Scene scene = new Scene(hbox, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



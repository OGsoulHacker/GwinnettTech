package com.example.hellofx;
import com.sun.javafx.menu.MenuItemBase;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import java.io.*;
public class AddressBook extends Application{
    //Variables
    final int NAME = 32;
    final int STREET = 32;
    final int CITY = 20;
    final int STATE = 2;
    final int ZIP = 5;
    protected int count = 0;

    //Create Buttons
    Button addbt = new Button();
    Button firstbt = new Button();
    Button nextbt = new Button();
    Button previousbt = new Button();
    Button lastbt = new Button();
    Button updatebt = new Button();

    //Create Text fields
    TextField nametf = new TextField();
    TextField streettf = new TextField();
    TextField citytf = new TextField();
    TextField statetf = new TextField();
    TextField ziptf = new TextField();


    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        //Creates and registers the event handlers

        Pane pane = new Pane();
        //Setup Pane elements

        //Setup buttons
        addbt.setText("Add");
        firstbt.setText("First");
        nextbt.setText("Next");
        previousbt.setText("Previous");
        lastbt.setText("Last");
        updatebt.setText("Update");

        HBox buttons = new HBox(addbt, firstbt, nextbt, previousbt, lastbt, updatebt);
        buttons.setSpacing(10); //gap between cells
        buttons.setAlignment(Pos.CENTER);

        //Setup text fields
        nametf.setMinWidth(300);
        streettf.setMinWidth(300);
        citytf.setMinWidth(150);
        statetf.setMaxWidth(35);
        ziptf.setMaxWidth(50);

        //Create Labels for text fields
        Label namelbl = new Label();
        Label streetlbl = new Label();
        Label citylbl = new Label();
        Label statelbl = new Label();
        Label ziplbl = new Label();

        namelbl.setText("Name");
        streetlbl.setText("Street");
        citylbl.setText("City");
        statelbl.setText("State");
        ziplbl.setText("Zip");

        //Setup HBoxes to hold the label + text field
        HBox namehbox = new HBox(namelbl, nametf);
        namehbox.setMaxWidth(400);
        namehbox.setSpacing(5);
        namehbox.setAlignment(Pos.CENTER);

        HBox streethbox = new HBox(streetlbl, streettf);
        streethbox.setMaxWidth(400);
        streethbox.setSpacing(5);
        streethbox.setAlignment(Pos.CENTER);

        HBox citystateziphbox = new HBox(citylbl, citytf, statelbl, statetf, ziplbl, ziptf);
        citystateziphbox.setMaxWidth(400);
        citystateziphbox.setSpacing(5);

        //Setup VBox to hold the text field HBoxes
        VBox fields = new VBox(namehbox, streethbox, citystateziphbox);
        fields.setSpacing(3);

        //Setup VBox to hold fields and button vbox and hbox
        VBox paneElements = new VBox(fields, buttons);
        paneElements.setSpacing(3);
        paneElements.setAlignment(Pos.CENTER);

        pane.getChildren().add(paneElements);

        addbt.setOnAction(e -> add());//Button pane for add
        firstbt.setOnAction(e -> first());//Button pane for first
        nextbt.setOnAction(e -> next());//Button pane for next
        previousbt.setOnAction(e -> previous());//Button pane for previous
        lastbt.setOnAction(e -> last());//Button pane for last
        updatebt.setOnAction(e -> update());//Button pane for update

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 360, 130);//Creates scene
        primaryStage.setTitle("Exericse_17_09: Address Book"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
//Write an address to a file via Add button
    private void add() {
        //Creates a random access file for Add
        try (
              RandomAccessFile inout =
                      new RandomAccessFile("AddressBook.dat", "rw");
        ) {
            inout.seek(inout.length());
            count++;
            write(inout);
        }
        catch (FileNotFoundException ex) {}
        catch (IOException ex) {}
        catch (IndexOutOfBoundsException ex) {}
    }

//Reads the first address from the file via First button
    private void first() {
        //Creates a random access file for First button
        try (
              RandomAccessFile inout =
                      new RandomAccessFile("AddressBook.dat", "rw");
        ) {
            if (inout.length() > 0) {
                inout.seek(0);
                read(inout);
                System.out.println("Reading address #1");
                count = 1;
            }
            else {
                System.out.println("Address is empty!");
            }
        }
        catch (IOException ex) {}
    }

//Reads the next address from the file via Next button
    private void next() {
        //Creates a random access file for Next button
        try (
              RandomAccessFile inout =
                      new RandomAccessFile("AddressBook.dat", "rw");
        ) {
            if (count * 91 < inout.length()) {
                inout.seek(count * 91);
                read(inout);
                count++;
                System.out.println("Reading address #" + count);
            }
            else {
                System.out.println("End of file!");
            }
        }
        catch (IOException ex) {}
    }

//Reads the previous address from the file via Previous button
    private void previous() {
        //Creates a random access file for Previous button
        try (
              RandomAccessFile inout =
                      new RandomAccessFile("AddressBook.dat", "rw");
        ) {
            if (count > 1)
                count--;
            else
                count = 1;
            inout.seek((count * 91) - 91);
            read(inout);
            System.out.println("Reading address #" + count);
        }
        catch (IOException ex) {}
    }

//Reads the last address from the file via Last button
    private void last() {
        //Creates a random access file for Last button
        try (
              RandomAccessFile inout =
                      new RandomAccessFile("AddressBook.dat", "rw");
        ) {
            count = ((int)inout.length()) / 91;
            inout.seek((count * 91) - 91);
            read(inout);
            System.out.println("Reading address #" + count);
        }
        catch (IOException ex) {}
    }

//Edits an address in file via Update button
    private void update() {
        //Creates a random access file for Update button
        try (
              RandomAccessFile inout =
                      new RandomAccessFile("AddressBook.dat", "rw");
        ) {
            inout.seek(count * 91 - 91);
            write(inout);
        }
        catch (FileNotFoundException ex) {}
        catch (IOException ex) {}
    }

//Writes the address to the file
    private void write(RandomAccessFile inout) throws IOException {
        inout.write(fixedLength(nametf.getText().getBytes(), NAME));//Text field pane for Name
        inout.write(fixedLength(streettf.getText().getBytes(), STREET));//Text field pane for Street
        inout.write(fixedLength(citytf.getText().getBytes(), CITY));//Text field pane for City
        inout.write(fixedLength(statetf.getText().getBytes(), STATE));//Text field pane for State
        inout.write(fixedLength(ziptf.getText().getBytes(), ZIP));//Text field pane for Zip
        System.out.println("Address #" + count + " saved!");
    }

//Reads address from the file
    private void read(RandomAccessFile inout) throws IOException {
        int pos;
        byte[] name = new byte[NAME];
        pos = inout.read(name);
        nametf.setText(new String(name));

        byte[] street = new byte[STREET];
        pos += inout.read(street);
        streettf.setText(new String(street));

        byte[] city = new byte[CITY];
        pos += inout.read(city);
        citytf.setText(new String(city));

        byte[] state = new byte[STATE];
        pos += inout.read(state);
        statetf.setText(new String(state));

        byte[] zip = new byte[ZIP];
        pos += inout.read(zip);
        ziptf.setText(new String(zip));
    }

//Returns a byte[] of fixed-length
    private byte[] fixedLength(byte[] x, int n) {
        byte[] b = new byte[n];
        for (int i = 0; i < x.length; i++) {
            b[i] = x[i];
        }
        return b;
    }
}

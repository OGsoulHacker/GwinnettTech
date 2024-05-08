package com.example.hellofx;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.*;

//create text fields for each button
//Make sure in each method is referencing the textfields
//create 4th sql query for last method
public class MidtermProject_testing extends Application {
    Statement statement;
    Connection connection;
    Label lblTotal = new Label("\n" +
            "Print order total (not including the freight cost) for a given order number");
    Label lblOrderDetails = new Label("Print all order details for a given order number");
    Label lblCustomers = new Label("Print the names and cities of all customers in a given state");
    Label lblEmployees = new Label("Print the names of all employees who have a birthday in a given year");
    TextField tfOrderTotal = new TextField();
    TextField tfOrderDetails = new TextField();
    TextField tfCustomers = new TextField();
    TextField tfEmployees = new TextField();
    TableView tableView = new TableView();
    private ResultSet resultSet;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create UI controls
        Label titleLabel = new Label("Northwind Database Query Tool");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");

        Button btnOrderTotal = new Button("Order Total");
        Button btnOrderDetails = new Button("Order Details");
        Button btnCustomers = new Button("Customers");
        Button btnEmployees = new Button("Employee");
        // Add panes to main layout
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 800, 600);

        VBox labelVbox = new VBox(lblTotal,lblOrderDetails,lblCustomers,lblEmployees);
        VBox tfVbox = new VBox(tfOrderTotal,tfOrderDetails,tfCustomers,tfEmployees);
        VBox btnVbox = new VBox(btnOrderTotal,btnOrderDetails,btnCustomers,btnEmployees);
        HBox hbox = new HBox(labelVbox,tfVbox,btnVbox);
        hbox.setSpacing(5);
        hbox.setAlignment(Pos.CENTER_LEFT);
        tableView.setMinWidth(800);
        pane.setCenter(new ScrollPane(tableView));
        pane.setTop(hbox);
        pane.setBottom(tableView);
        primaryStage.setTitle("Northwind Database Query Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
        //a query object
        initializeDB();
        //Sets actions for each button
        // Set event handlers for buttons
        btnOrderTotal.setOnAction(e -> orderTotal());

        btnOrderDetails.setOnAction(e -> orderDetails());

        btnCustomers.setOnAction(e -> showCustomers());

        btnEmployees.setOnAction(e -> showEmployees());

    }//End of primary method

    //Initializes database connection
    public void initializeDB() {
        try {
            // Load the JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver loaded");
            // Establish a connection
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
            System.out.println("Database connected");
            // Create a statement
            Statement stmt = connection.createStatement();
            System.out.println("Statement connected");
            // Fill the list with the table names
            DatabaseMetaData dbMetaData = connection.getMetaData();
            System.out.println("MetaData created");
            ResultSet tableNames = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
            System.out.println("ResultSet created");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showContents(ResultSet resultSet) {
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try {
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                // We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i + 1));

                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        if (param == null || param.getValue() == null || param.getValue().get(j) == null) {
                            return null;
                        }
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tableView.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }
            while (resultSet.next()) {
                // Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    // Iterate Column
                    row.add(resultSet.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);
            }
            // Add to TableView
            tableView.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Building Data");
        }
    }
    //Order total method
    public void orderTotal() {
        try {
            clear();
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
            String query = "SELECT ProductID, Quantity, UnitPrice, Discount FROM [Order Details] WHERE OrderID = " + tfOrderTotal.getText() + " ORDER BY Quantity ASC";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            showContents(resultSet);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//Order Number method
    public void orderDetails() {
        try {
            clear();
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
            String query = "SELECT OrderDate, Freight, ProductID, Quantity, UnitPrice, Discount FROM Orders inner join [Order Details] on OrderID = " + tfOrderDetails.getText();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            showContents(resultSet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
//Show Customers method
    public void showCustomers() {
        try {
            clear();
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
            String query = "SELECT Customers.CompanyName AS [Company Name], "
                    + "Customers.City AS [City] "
                    + "FROM Customers "
                    + "WHERE Region = '" + tfCustomers.getText() + "' "
                    + "ORDER BY City";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            showContents(resultSet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
//Show Employees method
    public void showEmployees () {
        try {
            clear();
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
            String query = "SELECT * FROM Employees WHERE year(BirthDate) = " + tfEmployees.getText();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            showContents(resultSet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
//Clear method
    public void clear(){
        tableView.getItems().clear();
        tableView.getColumns().clear();
    }
}

//package com.example.hellofx;
//import javafx.application.Application;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//
//public class MidtermProject1 extends Application {
//    Statement statement;
//    Connection connection;
//    GridPane gridPane = new GridPane();
//    Label lblTotal = new Label("Order Total");
//    Label lblOrderDetails = new Label("Order Details");
//    Label lblCustomers = new Label("Customers");
//    Label lblEmployees = new Label("Employees");
//    TextField tfOrderTotal = new TextField();
//    TextField tfOrderDetails = new TextField();
//    TextField tfCustomers = new TextField();
//    TextField tfEmployees = new TextField();
//    Button btTotal = new Button("Execute");
//    Button btOrderDetails = new Button("Execute");
//    Button btCustomers = new Button("Execute");
//    Button btEmployees = new Button("Execute");
//    String textTotal = tfOrderTotal.toString();
//    String textDetails = tfOrderDetails.toString();
//    String textCustomers = tfCustomers.toString();
//    String textEmployees = tfEmployees.toString();
//    String orderNumberStr = tfOrderDetails.getText();
//    TableView tableView = new TableView();
//    private ResultSet resultSet;
//
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create UI controls
//        Label titleLabel = new Label("Northwind Database Query Tool");
//        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
//
//        Button orderTotalBtn = new Button("Order Total");
//        Button orderDetailsBtn = new Button("Order Details");
//        Button customersBtn = new Button("Customers");
//
//        Label stateLabel = new Label("State:");
//        TextField stateTextField = new TextField();
//        Button stateCustomersBtn = new Button("Customers in State");
//
//        Label orderNumberLabel = new Label("Order Number:");
//        TextField orderNumberTextField = new TextField();
//        Button orderNumberDetailsBtn = new Button("Order Details");
//
//        TextArea resultTextArea = new TextArea();
//        resultTextArea.setEditable(false);
//        resultTextArea.setPrefRowCount(15);
//
//        // Add UI controls to panes
//        HBox buttonPane = new HBox(10);
//        buttonPane.getChildren().addAll(orderTotalBtn, orderDetailsBtn, customersBtn);
//
//        GridPane orderTotalPane = new GridPane();
//        orderTotalPane.setHgap(10);
//        orderTotalPane.setVgap(10);
//        orderTotalPane.addRow(0, new Label("Order Number:"), new TextField());
//        orderTotalPane.add(new Label("Order Total:"), 0, 1);
//        orderTotalPane.add(new TextField(), 1, 1);
//
//        GridPane orderDetailsPane = new GridPane();
//        orderDetailsPane.setHgap(10);
//        orderDetailsPane.setVgap(10);
//        orderDetailsPane.addRow(0, orderNumberLabel, orderNumberTextField, orderNumberDetailsBtn);
//        orderDetailsPane.add(new Label("Order Date:"), 0, 1);
//        orderDetailsPane.add(new TextField(), 1, 1);
//        orderDetailsPane.add(new Label("Freight Charge:"), 0, 2);
//        orderDetailsPane.add(new TextField(), 1, 2);
//        TableView<ObservableList<String>> orderDetailsTable = new TableView<>();
//        orderDetailsTable.setEditable(false);
//        orderDetailsTable.setPrefHeight(200);
//        orderDetailsPane.add(orderDetailsTable, 0, 3, 2, 1);
//
//        VBox customersPane = new VBox(10);
//        customersPane.getChildren().addAll(stateLabel, stateTextField, stateCustomersBtn, resultTextArea);
//
//        // Add panes to main layout
//        BorderPane root = new BorderPane();
//        root.setTop(titleLabel);
//        root.setCenter(buttonPane);
//        root.setBottom(orderTotalPane);
//        root.setRight(orderDetailsPane);
//        root.setLeft(customersPane);
//
//        // Create a scene and place it in the stage
//        Scene scene = new Scene(root, 800, 600);
//        primaryStage.setTitle("Northwind Database Query Tool");
//        // Set event handlers for buttons
//        orderTotalBtn.setOnAction(e -> {
//            orderTotalPane.setVisible(true);
//            orderDetailsPane.setVisible(false);
//            customersPane.setVisible(false);
//        });
//        orderDetailsBtn.setOnAction(e -> {
//            orderTotalPane.setVisible(false);
//            orderDetailsPane.setVisible(true);
//            customersPane.setVisible(false);
//        });
//
//        customersBtn.setOnAction(e -> {
//            orderTotalPane.setVisible(false);
//            orderDetailsPane.setVisible(false);
//            customersPane.setVisible(true);
//        });
//        //Action handler to get the customers state
//        stateCustomersBtn.setOnAction(e -> {
//            String state = stateTextField.getText();
//            if (state == null || state.isEmpty()) {
//                resultTextArea.setText("Please enter a state.");
//                return;
//            }
//
//            String query = "SELECT CompanyName, ContactName, ContactTitle, City, Region, PostalCode, Country " +
//                    "FROM Customers " +
//                    "WHERE Region='" + state + "'";
//
//            try {
//                ResultSet resultSet = statement.executeQuery(query);
//                resultTextArea.clear();
//                while (resultSet.next()) {
//                    resultTextArea.appendText(resultSet.getString("CompanyName") + "\t" +
//                            resultSet.getString("ContactName") + "\t" +
//                            resultSet.getString("ContactTitle") + "\t" +
//                            resultSet.getString("City") + "\t" +
//                            resultSet.getString("Region") + "\t" +
//                            resultSet.getString("PostalCode") + "\t" +
//                            resultSet.getString("Country") + "\n");
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        });
//        return orderNumberDetailsBtn.setOnAction(e -> {
//            String orderNumberStr = orderNumberTextField.getText();
//            if (orderNumberStr == null || orderNumberStr.isEmpty()) {
//                resultTextArea.setText("Please enter an order number.");
//                return;
//            }
//            int orderNumber = Integer.parseInt(orderNumberStr);
//            String query = "SELECT OrderDate, Freight " +
//                    "FROM Orders " +
//                    "WHERE OrderID=" + orderNumber;
//            try {
//                ResultSet resultSet = statement.executeQuery(query);
//                if (resultSet.next()) {
//                    String orderDate = resultSet.getString("OrderDate");
//                    double freight = resultSet.getDouble("Freight");
//                    orderDetailsPane.getChildren().remove(orderDetailsTable);
//                    query = "SELECT ProductName, Quantity, UnitPrice " +
//                            "FROM [Order Details] " +
//                            "JOIN Products ON [Order Details].ProductID = Products.ProductID " +
//                            "WHERE OrderID=" + orderNumber;
//                    resultSet = statement.executeQuery(query);
//
//                    ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
//                    while (resultSet.next()) {
//                        ObservableList<String> row = FXCollections.observableArrayList();
//                        row.add(resultSet.getString("ProductName"));
//                        row.add(resultSet.getString("Quantity"));
//                        row.add(resultSet.getString("UnitPrice"));
//                        data.add(row);
//                    }
//                    orderDetailsTable.setItems(data);
//                    TableColumn<ObservableList<String>, String> productNameCol = new TableColumn<>("Product Name");
//                    productNameCol.setCellValueFactory(param -> param.getValue().get(0));
//                    TableColumn<ObservableList<String>, String> quantityCol = new TableColumn<>("Quantity");
//                    quantityCol.setCellValueFactory(param -> param.getValue().get(1));
//                    TableColumn<ObservableList<String>, String> unitPriceCol = new TableColumn<>("Unit Price");
//                    unitPriceCol.setCellValueFactory(param -> param.getValue().get(2));
//                    orderDetailsTable.getColumns().setAll(productNameCol, quantityCol, unitPriceCol);
//                    orderDetailsPane.add(orderDetailsTable, 0, 3, 2, 1);
//
//                    orderDetailsPane.getChildren().remove(resultTextArea);
//                    resultTextArea.setText("Order Date: " + orderDate + "\n" +
//                            "Freight Charge: " + freight);
//                    orderDetailsPane.add(resultTextArea, 0, 4, 2, 1);
//                }
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//    }
//        private void showContents(ResultSet resultSet) {
//            ObservableList<ObservableList> data = FXCollections.observableArrayList();
//            try {
//                for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
//                    // We are using non property style for making dynamic table
//                    final int j = i;
//                    TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i + 1));
//
//                    // col.setCellValueFactory(TextFieldTableCell.forTableColumn());
//                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
//                            if (param == null || param.getValue() == null || param.getValue().get(j) == null) {
//                                return null;
//                            }
//                            return new SimpleStringProperty(param.getValue().get(j).toString());
//                        }
//                    });
//                    tableView.getColumns().addAll(col);
//                    System.out.println("Column [" + i + "] ");
//                }
//                while (resultSet.next()) {
//                    // Iterate Row
//                    ObservableList<String> row = FXCollections.observableArrayList();
//                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
//                        // Iterate Column
//                        row.add(resultSet.getString(i));
//                    }
//                    System.out.println("Row [1] added " + row);
//                    data.add(row);
//                }
//                // Add to TableView
//                tableView.setItems(data);
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Error Building Data");
//            }
//        }
////Order total method
//        public void orderTotal(TextField tfState) {
//            String state = tfState.getText();
//            try {
//                Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
//                String query = "SELECT CompanyName, ContactName, ContactTitle, City, Region, PostalCode, Country " +
//                        "FROM Customers " +
//                        "WHERE Region='" + state + "'";
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
////Order Number method
//        public void orderNumber() {
//            try {
//                Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
//                String query = "SELECT OrderID, UnitPrice * Quantity FROM \"Order Details\" WHERE OrderID = " + tfOrderDetails.getText();
//                statement = connection.createStatement();
//                resultSet = statement.executeQuery(query);
//                showContents(resultSet);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        public void showCustomers() {
//            try {
//                Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
//                String query = "SELECT Customers.CompanyName AS [Company Name], "
//                        + "Customers.City AS [City] "
//                        + "FROM Customers "
//                        + "WHERE Region = '" + tfCustomers.getText() + "' "
//                        + "ORDER BY City";
//
//                statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
//                showContents(resultSet);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        public void showEmployees() {
//            try {
//                Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Data/Northwind.mdb");
//                String query = "SELECT * FROM Employees WHERE year(BirthDate) = " + tfEmployees.getText();
//                statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
//                showContents(resultSet);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        public void clear () {
//
//        }
//    }
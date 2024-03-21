package bank.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Connn {
    Connection connection;
    Statement statement;
    public Connn(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","");
            System.out.println("DATABASE CONNECTED");
            statement = connection.createStatement();



        }catch (Exception e){
            e.printStackTrace();
            System.out.println("database error");
        }


    }

    public void getCustomers(JTable table){
        try{
            // Example: Retrieve customer information from multiple tables
            String sqlQuery = "SELECT DISTINCT * FROM login t1 " +
                    "JOIN signup t2 ON t1.form_no = t2.form_no " +
                    "JOIN signuptwo t3 ON t1.form_no = t3.form_no " +
                    "JOIN signupthree t4 ON t1.form_no = t4.form_no " +
                    "JOIN bank t5 ON t1.pin = t5.pin " ;
//                    "WHERE t1.pin = 'pin' OR t1.form_no = 'form_no'";

            String sqlQuery2 = "SELECT t2.form_no, t2.name, t2.father_name, t2.gender, t2.address, t3.AccountNumber, t2.DOB, t4.card_number " +
                    "FROM login t1 " +
                    "JOIN signup t2 ON t1.form_no = t2.form_no " +
                    "JOIN signuptwo t3 ON t1.form_no = t3.form_no " +
                    "JOIN signupthree t4 ON t1.form_no = t4.form_no " ;
//                    "JOIN bank t5 ON t1.pin = t5.pin";

            ResultSet resultset = statement.executeQuery(sqlQuery2);


            table.setModel(buildTableModel(resultset));




            while (resultset.next()){
                System.out.println(resultset.getString(2));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        };

    }










//     Helper method to convert ResultSet to DefaultTableModel
    private static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Create column names array
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }

        // Create data array
        Object[][] data = new Object[20][columnCount]; // Adjust row count as needed

        int row = 0;
        while (resultSet.next()) {
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                data[row][columnIndex - 1] = resultSet.getObject(columnIndex);
            }
            row++;
        }

        return new DefaultTableModel(data, columnNames);
    }

//    private static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        int columnCount = metaData.getColumnCount();
//
//        // Create column names array
//        String[] columnNames = new String[columnCount];
//        for (int column = 1; column <= columnCount; column++) {
//            columnNames[column - 1] = metaData.getColumnLabel(column); // Use getColumnLabel() instead of getColumnName()
//        }
//
//        // Create data array
//        Object[][] data = new Object[100][columnCount]; // Adjust row count as needed
//
//        int row = 0;
//        while (resultSet.next()) {
//            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
//                data[row][columnIndex - 1] = resultSet.getObject(columnIndex);
//            }
//            row++;
//        }
//
//        // Create a DefaultTableModel with data and column names
//        DefaultTableModel model = new DefaultTableModel(data, columnNames);
//
//        // Set column identifiers (column labels) for the model
//        model.setColumnIdentifiers(columnNames);
//
//        return model;
//    }





























}

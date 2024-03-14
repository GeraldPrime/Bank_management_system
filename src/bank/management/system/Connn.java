package bank.management.system;

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
}

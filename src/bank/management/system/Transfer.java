package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Transfer extends JFrame implements ActionListener {
    String pin;
    static String form_no;
    TextField textamount,textaccount,textname,textsurname;

    JButton b1, b2 ,b3;
    Transfer(String pin, String form_no){
        this.pin = pin;
        Transfer.form_no = form_no;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO TRANSFER");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,400,35);
        l3.add(label1);

        textamount = new TextField();
        textamount.setBackground(new Color(65,125,128));
        textamount.setForeground(Color.WHITE);
        textamount.setBounds(460,210,320,25);
        textamount.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textamount);


        JLabel label2 = new JLabel("ENTER RECIPIENTS ACCOUNT NUMBER");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460,240,400,35);
        l3.add(label2);

        textaccount = new TextField();
        textaccount.setBackground(new Color(65,125,128));
        textaccount.setForeground(Color.WHITE);
        textaccount.setBounds(460,270,320,25);
        textaccount.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textaccount);

        b3 = new JButton("confirm recipient");
        b3.setBounds(469,300,140,30);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        l3.add(b3);


        JLabel label3 = new JLabel("Name :");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(410,350,60,35);
        l3.add(label3);

        textname = new TextField();
        textname.setBackground(new Color(65,125,128));
        textname.setForeground(Color.WHITE);
        textname.setBounds(500,350,190,33);
        textname.setFont(new Font("Raleway", Font.ITALIC,16));
        textname.setEditable(false);
        l3.add(textname);

        JLabel label4 = new JLabel("Surname :");
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("System", Font.BOLD, 16));
        label4.setBounds(410,400,80,35);
        l3.add(label4);

        textsurname = new TextField();
        textsurname.setBackground(new Color(65,125,128));
        textsurname.setForeground(Color.WHITE);
        textsurname.setBounds(500,400,190,33);
        textsurname.setFont(new Font("Raleway", Font.ITALIC,16));
        textsurname.setEditable(false);
        
        l3.add(textsurname);







        b1 = new JButton("SEND");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);




        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textamount.getText();
            String account = textaccount.getText().trim();
            String name = textname.getText();
            String surname = textsurname.getText();
            Date date = new Date();


            if (e.getSource() == b3) {
                Connn c = new Connn();
                System.out.println("obi is here");

                if (textaccount.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the account number");
                } else {
                    ResultSet resultSet = c.statement.executeQuery("SELECT * FROM signuptwo WHERE AccountNumber = '" + account + "'");
                    System.out.println("obi came here");

                    if (resultSet.next()) {
                        String form = resultSet.getString("form_no");

                        System.out.println("form and account number "+form+ " "+account);

                        ResultSet results = c.statement.executeQuery("SELECT * FROM signup WHERE form_no = '" + form + "'");

                        System.out.println("obi actua1409962938076890ly got here");
                        if(results.next()){
                            System.out.println("the names"+ results.getString("name")+ results.getString("father_name"));
                            textname.setText(results.getString("name"));
                            textsurname.setText(results.getString("father_name"));
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error: unable to send.");
                    }
                }
            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin, form_no);
            }





            if (e.getSource() == b1) {
                    Connn c = new Connn();
                if (textamount.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to transfer");
                } else {
                    ResultSet resultSet = c.statement.executeQuery("SELECT * FROM signuptwo WHERE AccountNumber = '" + account + "'");
                    System.out.println("obi came here");


                    if (resultSet.next()) {
                        String form = resultSet.getString("form_no");

                        System.out.println("form and account number "+form+ " "+account);

                        ResultSet results = c.statement.executeQuery("SELECT * FROM login WHERE form_no = '" + form + "'");

                        System.out.println("obi actualy got here");
                        if(results.next()){
                            String Pin = results.getString("pin");

                            ResultSet finalresult = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + Pin + "'");

                            if (finalresult.next()){
                                int balance = finalresult.getInt("balance");

                                ResultSet myresult = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");

                                if(myresult.next()) {
                                    int mybalance = myresult.getInt("balance");
                                    if (mybalance < Integer.parseInt(amount)) {
                                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                                        return;
                                    }

                                    int newBalance = balance + Integer.parseInt(amount);
                                    int mynewBalance = mybalance - Integer.parseInt(amount);

                                    // Update the balance in the receiver bank table
                                    c.statement.executeUpdate("UPDATE bank SET balance = " + newBalance + " WHERE pin = '" + Pin + "'");

                                    // Update the balance in the sender bank table
                                    c.statement.executeUpdate("UPDATE bank SET balance = " + mynewBalance + " WHERE pin = '" + pin + "'");


                                    // Insert the deposit transaction into the receiver transaction table
                                    c.statement.executeUpdate("INSERT INTO bank (pin, date, type, amount, balance) " +
                                            "VALUES ('" + Pin + "', '" + date + "', " +
                                            "'transfer', '" + amount + "', '" + newBalance + "')");

                                    // Insert the deposit transaction into the sender transaction table
                                    c.statement.executeUpdate("INSERT INTO bank (pin, date, type, amount, balance) " +
                                            "VALUES ('" + pin + "', '" + date + "', " +
                                            "'transfer', '" + amount + "', '" + mynewBalance + "')");

                                    JOptionPane.showMessageDialog(null, "$. "+amount+" sent Successfully");
                                }

                            }




                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Account not found.");
                    }
                }
            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin, form_no);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }








    public static void main(String[] args) {
        new Transfer("", form_no);
    }
}


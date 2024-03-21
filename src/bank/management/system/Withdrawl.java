package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    TextField textField;

    static String form_no;

    JButton b1, b2;
    Withdrawl(String pin, String form_no){
        this.pin=pin;

        Withdrawl.form_no =form_no;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS $.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,700,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);


        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
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
            String amount = textField.getText();
            Date date = new Date();

            if (e.getSource() == b1) {
                if (textField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    Connn c = new Connn();
                    ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                    if (resultSet.next()) {
                        int balance = resultSet.getInt("balance");

                        if (Integer.parseInt(amount) == 0) {
                            JOptionPane.showMessageDialog(null, "You cannot withdraw zero. Please enter a valid amount.");
                            return;
                        }
                        if ( balance < Integer.parseInt(amount)){
                            JOptionPane.showMessageDialog(null, "Insuffient Balance");
                            return;
                        }

                        int newBalance = balance - Integer.parseInt(amount);

                        // Update the balance in the bank table
                        c.statement.executeUpdate("UPDATE bank SET balance = " + newBalance + " WHERE pin = '" + pin + "'");

                        // Insert the deposit transaction into the transaction table
                        c.statement.executeUpdate("INSERT INTO bank (pin, date, type, amount, balance) " +
                                "VALUES ('" + pin + "', '" + date + "', " +
                                "'withdrawal', '" + amount + "', '" + newBalance + "')");

                        JOptionPane.showMessageDialog(null, "$" + amount + " withdrawn successfully.");
                        setVisible(false);
                        new main_Class(pin, form_no);
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
        new Withdrawl("", form_no);
    }
}

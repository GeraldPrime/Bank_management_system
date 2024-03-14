package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
     static String form_no;
    int amount;
    FastCash(String pin, String form_no){
        this.pin =pin;
        FastCash.form_no =form_no;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setBounds(445,180,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,23));
        l3.add(label);

        b1 = new JButton("$. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(410,274,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("$. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(700,274,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("$. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(410,318,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("$. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(700,318,150,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("$. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(410,362,150,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("$. 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(700,362,150,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(700,406,150,35);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b7) {
            setVisible(false);
            new main_Class(pin, form_no);
        }else {
//            String amount = ((JButton)e.getSource()).getText().substring(4);
            if (e.getSource()==b1){
                this.amount = 100;
            }else if (e.getSource()==b2){
                this.amount = 500;
            }else if (e.getSource()==b3){
                this.amount = 1000;
            }else if (e.getSource()==b4){
                this.amount = 2000;
            }else if (e.getSource()==b5){
                this.amount = 5000;
            }else if (e.getSource()==b6){
                this.amount = 10000;
            }
            Connn c = new Connn();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");

                if (resultSet.next()){
                    int balance = resultSet.getInt("balance");

                    if (e.getSource() != b7 && balance < this.amount){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    int newBalance = balance - this.amount;

                    // Update the balance in the bank table
                    c.statement.executeUpdate("UPDATE bank SET balance = " + newBalance + " WHERE pin = '" + pin + "'");

                    // Insert the deposit transaction into the transaction table
                    c.statement.executeUpdate("INSERT INTO bank (pin, date, type, amount, balance) " +
                            "VALUES ('" + pin + "', '" + date + "', " +
                            "'withdrawal', '" + amount + "', '" + newBalance + "')");

                    JOptionPane.showMessageDialog(null, "$. "+amount+" Debited Successfully");
                }




            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new main_Class(pin, form_no);
        }


    }

    public static void main(String[] args) {
        new FastCash("", form_no);
    }
}

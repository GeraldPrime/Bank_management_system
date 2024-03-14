package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    String pin;
    static String form_no;
    main_Class(String pin, String form_no){
        this.pin = pin;
        main_Class.form_no = form_no;

        System.out.println(form_no);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(430,180,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(410,274,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(700,274,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(410,318,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(700,318,150,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(410,362,150,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(700,362,150,35);
        b6.addActionListener(this);
        l3.add(b6);

        b8 = new JButton("VIEW PROFILE");
        b8.setForeground(Color.WHITE);
        b8.setBackground(new Color(65,125,128));
        b8.setBounds(410,406,150,35);
        b8.addActionListener(this);
        l3.add(b8);


        b9 = new JButton("TRANSFER");
        b9.setForeground(Color.WHITE);
        b9.setBackground(new Color(65,125,128));
        b9.setBounds(410,450,150,35);
        b9.addActionListener(this);
        l3.add(b9);


        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(700,406,150,35);
        b7.addActionListener(this);
        l3.add(b7);

        b10 = new JButton("DELETE ACCOUNT");
        b10.setForeground(Color.WHITE);
        b10.setBackground(new Color(65,125,128));
        b10.setBounds(700,450,150,35);
        b10.addActionListener(this);
        l3.add(b10);



        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
           new Deposit(pin,form_no);
            System.out.println("going with "+pin +" "+form_no);
            setVisible(false);
        }else if (e.getSource()==b7){
            System.exit(0);
        } else if (e.getSource()==b2) {
            new Withdrawl(pin,form_no);
            setVisible(false);
        } else if (e.getSource()==b6) {
            new BalanceEnquriy(pin,form_no);
            setVisible(false);
        } else if (e.getSource()==b3) {
            new FastCash(pin,form_no);
            setVisible(false);
        } else if (e.getSource()==b5) {
            new Pin(pin,form_no);
            setVisible(false);
        } else if (e.getSource()==b4) {
            new mini(pin,form_no);
        } else if (e.getSource()==b8) {
            new Profile(pin,form_no);

        }else if (e.getSource()==b9) {
            new Transfer(pin,form_no);

        }else if (e.getSource()==b10) {

            try {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete? This action is irreversible and will permanently delete all your records.");

                if (confirm == JOptionPane.YES_OPTION) {
                    Connn c = new Connn();
                    c.connection.setAutoCommit(false); // Start transaction

                    int affectedrows1 = c.statement.executeUpdate("DELETE FROM bank WHERE pin = '" + pin + "'");
                    int affectedrows2 = c.statement.executeUpdate("DELETE FROM login WHERE pin = '" + pin + "'");
                    int affectedrows3 = c.statement.executeUpdate("DELETE FROM signup WHERE form_no = '" + form_no + "'");
                    int affectedrows4 = c.statement.executeUpdate("DELETE FROM signuptwo WHERE form_no = '" + form_no + "'");
                    int affectedrows5 = c.statement.executeUpdate("DELETE FROM signupthree WHERE form_no = '" + form_no + "'");

                    if (affectedrows1 > 0 && affectedrows2 > 0 && affectedrows3 > 0 && affectedrows4 > 0 && affectedrows5 > 0) {
                        c.connection.commit(); // Commit transaction
                        JOptionPane.showMessageDialog(null, "Record deleted successfully!");
                        setVisible(false);

                        new Login();
                    } else {
                        c.connection.rollback(); // Rollback transaction if any deletion failed
                        JOptionPane.showMessageDialog(null, "No records found to delete.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Operation canceled.");
                }
            } catch (Exception E) {
                E.printStackTrace();
                // Handle exception appropriately, such as logging or displaying an error message to the user
            }



        }
    }

    public static void main(String[] args) {
        new main_Class("", form_no);
    }
}

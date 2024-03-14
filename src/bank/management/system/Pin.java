package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    static String form_no;
    Pin(String pin, String form_no){
        this.pin =pin;
        this.form_no = form_no;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430,180,400,35);
        l3.add(label1);


        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430,220,150,35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(600,220,180,25);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(430,250,400,35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(600,255,180,25);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p2);



        b1 = new JButton("CHANGE");
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



        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PINs do not match");
                return;
            }

            Connn c = new Connn();

            // Check if the new PIN already exists in the database
            String pinCheckQuery = "SELECT COUNT(*) FROM login WHERE pin = '" + pin1 + "'";
            ResultSet pinCheckResult = c.statement.executeQuery(pinCheckQuery);
            pinCheckResult.next();
            int pinCount = pinCheckResult.getInt(1);

            if (pinCount > 0) {
                JOptionPane.showMessageDialog(null, "The entered PIN already exists. Please choose a different PIN.");
                return;
            }

            if (e.getSource() == b1) {
                if (pin1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a new PIN");
                    return;
                }

                // Update the PIN in the database
                String updateQuery = "UPDATE login SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";
                c.statement.executeUpdate(updateQuery);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new main_Class(pin1, form_no);
            } else if (e.getSource() == b2) {
                new main_Class(pin, form_no);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Pin("", form_no);
    }
}

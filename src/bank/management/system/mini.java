package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class mini extends JFrame implements ActionListener {
    String pin;
    static String form_no;
    JButton button;
    mini(String pin, String form_no){
        this.pin = pin;
        mini.form_no = form_no;


//        getContentPane().setBackground(new Color(255,204,204));




        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2 = new JLabel("JAVA GROUP 4");
        label2.setFont(new Font("System", Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        // Set layout to BorderLayout
        setLayout(new BorderLayout());

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/sky.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(400,600,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
//        iiimage.setBounds(0,0,850,700);
        iiimage.setLayout(new BorderLayout()); // Set layout of JLabel to BorderLayout

        add(iiimage);

        setVisible(true);



        try{
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while (resultSet.next()){
                label3.setText("Card Number:  "+ resultSet.getString("card_number").substring(0,4) + "XXXXXXXX"+ resultSet.getString("card_number").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }


        try {
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "' ORDER BY date DESC LIMIT 5");
            while (resultSet.next()) {
                // Fetch transaction details from the current row
                String date = resultSet.getString("date");
                String type = resultSet.getString("type");
                String amount = resultSet.getString("amount");

                // Concatenate the transaction details with HTML markup
                String transactionHtml = "<html>" + date + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + type + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + amount + "<br><br><html>";

                // Append the transaction to label1
                label1.setText(transactionHtml + label1.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try{
//
//            Connn c = new Connn();
//            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
//            while (resultSet.next()){
//
//                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");
//
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//


        try{

            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");

            if (resultSet.next()){
                int balance = resultSet.getInt("balance");
                label4.setText("Your Total Balance is $ "+balance);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new mini("", form_no);
    }
}

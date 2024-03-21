package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class Admin extends JFrame implements ActionListener {

    JTable table;






    JButton savebtn,freezebtn,exit,searchbtn,unfreezebtn;

    JTextField textName ,textFname, textEmail,textAdd,textcity,textState, textincome,textReligion,textEducation,
            textBVN, textAccType, textCardNum, textGender, textStatus, textAccNo,textAccPin,textAccBal,textsearch;
    JDateChooser dateChooser;





    Admin(){

        super ("APPLICATION FORM");


        JLabel label2 = new JLabel("ADMIN DASHBOARD");
        label2.setFont(new Font("Ralway",Font.BOLD, 25  ));
        label2.setBounds(250,30,600,30);
        add(label2);




        table = new JTable();
        table.setBounds(750,10,650,600);
        add(table);
        Connn conn= new Connn();
        conn.getCustomers(table);



        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(10,150,80,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD, 14));
        textName.setBounds(80,150,250,30);
        add(textName);

        JLabel labelfName = new JLabel("SURNAME :");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(350,150,150,30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD, 14));
        textFname.setBounds(480,150,250,30);
        add(textFname);

        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(10,200,100,30);
        add(labelG);

        textGender = new JTextField();
        textGender.setFont(new Font("Raleway",Font.BOLD, 14));
        textGender.setBounds(80,200,250,30);
        add(textGender);



        JLabel DOB = new JLabel("Date of Birth");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(350,200,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(480,200,250,30);
        add(dateChooser);



        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(10,250,100,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD, 14));
        textEmail.setBounds(80,250,250,30);
        add(textEmail);


        JLabel labelMs = new JLabel("Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(350,250,100,30);
        add(labelMs);

        textStatus = new JTextField();
        textStatus.setForeground(new Color(105,105,105));
        textStatus.setBounds(480,250,250,30);
        add(textStatus);



        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(10,300,100,30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD, 14));
        textAdd.setBounds(110,300,220,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(350,300,100,30);
        add(labelCity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD, 14));
        textcity.setBounds(480,300,250,30);
        add(textcity);

        JLabel labelPin = new JLabel("Income :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(350,350,100,30);
        add(labelPin);

        textincome = new JTextField();
        textincome.setFont(new Font("Rale-way",Font.BOLD, 14));
        textincome.setBounds(480,350,250,30);
        add(textincome);

        JLabel labelstate = new JLabel("State :");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelstate.setBounds(10,350,100,30);
        add( labelstate);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD, 14));
        textState.setBounds(80,350,250,30);
        add(textState);

        //----------new form----------
        JLabel labelreligion = new JLabel("Religion :");
        labelreligion.setFont(new Font("Raleway", Font.BOLD, 20));
        labelreligion.setBounds(10,400,100,30);
        add( labelreligion);

        textReligion = new JTextField();
        textReligion.setFont(new Font("Raleway",Font.BOLD, 14));
        textReligion.setBounds(110,400,220,30);
        add(textReligion);

        JLabel labelEducaton = new JLabel("Education :");
        labelEducaton.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEducaton.setBounds(350,400,100,30);
        add(labelEducaton);

        textEducation = new JTextField();
        textEducation.setFont(new Font("Rale-way",Font.BOLD, 14));
        textEducation.setBounds(480,400,250,30);
        add(textEducation);

        JLabel labelAccNo = new JLabel("ACC NO. :");
        labelAccNo.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAccNo.setBounds(10,450,100,30);
        add( labelAccNo);

        textAccNo = new JTextField();
        textAccNo.setFont(new Font("Raleway",Font.BOLD, 14));
        textAccNo.setBounds(110,450,220,30);
        textAccNo.setEditable(false);
        add(textAccNo);

        JLabel labelBVN = new JLabel("BVN :");
        labelBVN.setFont(new Font("Raleway", Font.BOLD, 20));
        labelBVN.setBounds(350,450,100,30);
        add(labelBVN);

        textBVN = new JTextField();
        textBVN.setFont(new Font("Rale-way",Font.BOLD, 14));
        textBVN.setBounds(480,450,250,30);
        textBVN.setEditable(false);
        add(textBVN);



        //--------third form-----------
        JLabel labelAccType = new JLabel("AccType :");
        labelAccType.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAccType.setBounds(10,500,100,30);
        add( labelAccType);

        textAccType = new JTextField();
        textAccType.setFont(new Font("Raleway",Font.BOLD, 14));
        textAccType.setBounds(110,500,220,30);
        textAccType.setEditable(false);
        add(textAccType);

        JLabel labelCardNum = new JLabel("Card Num :");
        labelCardNum.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCardNum.setBounds(350,500,100,30);
        add(labelCardNum);

        textCardNum = new JTextField();
        textCardNum.setFont(new Font("Rale-way",Font.BOLD, 14));
        textCardNum.setBounds(480,500,250,30);
        textCardNum.setEditable(false);
        add(textCardNum);

//        -------------------------------------

        JLabel labelAccPin = new JLabel("Pin :");
        labelAccPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAccPin.setBounds(10,550,100,30);
        add( labelAccPin);

        textAccPin = new JTextField();
        textAccPin.setFont(new Font("Raleway",Font.BOLD, 14));
        textAccPin.setBounds(110,550,220,30);
        textAccPin.setEditable(false);
        add(textAccPin);

        JLabel labelAccBal = new JLabel("Acc Bal :");
        labelAccBal.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAccBal.setBounds(350,550,100,30);
        add(labelAccBal);

        textAccBal = new JTextField();
        textAccBal.setFont(new Font("Rale-way",Font.BOLD, 14));
        textAccBal.setBounds(480,550,250,30);
        textAccBal.setEditable(false);

        add(textAccBal);

//--------------------------------------------------------------

        JLabel labelsearch = new JLabel("Search Customer (By form_no) :");
        labelsearch.setFont(new Font("Raleway", Font.BOLD, 20));
        labelsearch.setBounds(750,620,400,30);
        add(labelsearch);

        textsearch = new JTextField();
        textsearch.setFont(new Font("Rale-way",Font.BOLD, 14));
        textsearch.setBounds(750,660,200,30);
        add(textsearch);

        searchbtn = new JButton("Search");
        searchbtn.setFont(new Font("Raleway",Font.BOLD, 14));
        searchbtn.setBackground(Color.BLACK);
        searchbtn.setForeground(Color.WHITE);
        searchbtn.setBounds(970,660,120,30);
//        next.addActionListener(this);
        add(searchbtn);





        savebtn = new JButton("Save");
        savebtn.setFont(new Font("Raleway",Font.BOLD, 14));
        savebtn.setBackground(Color.BLACK);
        savebtn.setForeground(Color.WHITE);
        savebtn.setBounds(150,660,80,30);
//        next.addActionListener(this);
        add(savebtn);

        freezebtn = new JButton("FREEZE");
        freezebtn.setFont(new Font("Raleway",Font.BOLD, 14));
        freezebtn.setBackground(Color.BLACK);
        freezebtn.setForeground(Color.WHITE);
        freezebtn.setBounds(280,660,100,30);
//        next.addActionListener(this);
        add(freezebtn);

        unfreezebtn = new JButton("UNFREEZE");
        unfreezebtn.setFont(new Font("Raleway",Font.BOLD, 14));
        unfreezebtn.setBackground(Color.BLACK);
        unfreezebtn.setForeground(Color.WHITE);
        unfreezebtn.setBounds(430,660,120,30);
//        next.addActionListener(this);
        add(unfreezebtn);



        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway",Font.BOLD, 14));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBounds(600,660,80,30);
        exit.addActionListener(this);
        add(exit);




//        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(1500,800);
        setLocation(10,40);


        // Set layout to BorderLayout
        setLayout(new BorderLayout());

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/boat.png"));
        Image iii2 = iii1.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
//        iiimage.setBounds(0,0,850,700);
        iiimage.setLayout(new BorderLayout()); // Set layout of JLabel to BorderLayout

        add(iiimage);

        setVisible(true);



     searchbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            String name = textName.getText();
//            String surname = textFname.getText();
//            String gender = textGender.getText();
//            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
//            String email = textEmail.getText();
//            String status = textStatus.getText();
//            String address = textAdd.getText();
//            String city =textcity.getText();
//            String state = textState.getText();
//            String income = textincome.getText();
            String form_no= textsearch.getText();
//            String balance = textAccBal.getText();
//
//
//            String religion = textReligion.getText();
//            String education = textEducation.getText();


            Connn c = new Connn();
            System.out.println("the value"+true);


            if (form_no.isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Please enter form number to search");
                return;
            }

            try{

                ResultSet resultSet = c.statement.executeQuery("select * from signup where form_no = '"+form_no+"'");
                while (resultSet.next()){
                    textName.setText(resultSet.getString("name"));
                    textFname.setText(resultSet.getString("father_name"));
                    textGender.setText(resultSet.getString("gender"));

//                dateChooser.setDate(resultSet.getDate("DOB"));
//                String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).setText(resultSet.getString());

                    ((JTextField) dateChooser.getDateEditor().getUiComponent()).setText(resultSet.getString("DOB"));
                    textEmail.setText(resultSet.getString("email"));
                    textStatus.setText(resultSet.getString("marital_status"));
                    textAdd.setText(resultSet.getString("address"));
                    textcity.setText(resultSet.getString("city"));
                    textState.setText(resultSet.getString("state"));
//                    textPin.setText(resultSet.getString("pincode"));

                }
            }catch (Exception E ){
                System.out.println("error from signup");
                System.out.println(E.getMessage());
//                E.printStackTrace();
            }
            try{

                ResultSet resultSet = c.statement.executeQuery("select * from signuptwo where form_no = '"+form_no+"'");
                while (resultSet.next()){
                    textincome.setText(resultSet.getString("income"));
                    textReligion.setText(resultSet.getString("religion"));
                    textEducation.setText(resultSet.getString("education"));
                    textAccNo.setText(resultSet.getString("AccountNumber"));
                    textBVN.setText(resultSet.getString("BVN"));

                }
            }catch (Exception E ){
                System.out.println("error fro signuptwo");
                System.out.println(E.getMessage());
//                E.printStackTrace();
            }
            try{

                ResultSet resultSet = c.statement.executeQuery("select * from signupthree where form_no = '"+form_no+"'");
                if (resultSet.next()){
                    textAccType.setText(resultSet.getString("account_type"));
                    textCardNum.setText(resultSet.getString("card_number"));

                    String pin = resultSet.getString("pin");
                    textAccPin.setText(pin);

                    ResultSet resultSet2 = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                    if (resultSet2.next()){
                        int newbalance = resultSet2.getInt("balance");

                        textAccBal.setText(" $"+newbalance);

//                        textAccBal.setText(resultSet2.getString("balance"));

                    }
                }
            }catch (Exception E ){
                System.out.println("error from signupthree ");
                System.out.println(E.getMessage());
//                E.printStackTrace();
            }
//            try {
//                ResultSet resultSet = c.statement.executeQuery("select * from signupthree where form_no = '"+form_no+"'");
//
//
//                ResultSet resultSet2 = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
//                    while (resultSet2.next()){
//
//                        textAccBal.setText(resultSet2.getString("balance"));
//
//                    }
//
//
//            }catch (Exception E)   {
//                System.out.println(E.getMessage());
//            }




        }



    });


        freezebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String form_no = textsearch.getText();

                Connn c = new Connn();

                if (form_no.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Please enter a form number to search");
                    return;
                }else {
                    try {
                        ResultSet result1 = c.statement.executeQuery("select * from login where form_no = '"+form_no+"'");
                        if (result1.next()){
                            if(Objects.equals(result1.getString("freeze"), "true")){
                                JOptionPane.showMessageDialog(null, "Account is already frozen");
                                return;
                            }
                        }
                        // Update the PIN in the database
                        String updateQuery = "UPDATE login SET freeze = '" + true + "' WHERE form_no = '" + form_no + "'";
                        c.statement.executeUpdate(updateQuery);

                        JOptionPane.showMessageDialog(null, "ACCOUNT FROZEN SUCCESSFULLY");


                    } catch (Exception E) {
                        System.out.println(E.getMessage());
                    }
                }


            }
        });
        unfreezebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String form_no = textsearch.getText();

                Connn c = new Connn();

                if (form_no.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Please enter a form number to search");
                    return;
                }else {

                    try {

                        ResultSet result1 = c.statement.executeQuery("select * from login where form_no = '"+form_no+"'");
                        if (result1.next()){
                            if(Objects.equals(result1.getString("freeze"), "false")){
                                JOptionPane.showMessageDialog(null, "Account is not frozen");
                                return;
                            }
                        }

                        // Update the PIN in the database
                        String updateQuery = "UPDATE login SET freeze = '" + false + "' WHERE form_no = '" + form_no + "'";
                        c.statement.executeUpdate(updateQuery);

                        JOptionPane.showMessageDialog(null, "Account is now unfrozen");


                    } catch (Exception E) {
                        System.out.println(E.getMessage());
                    }
                }


            }
        });
        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                String surname = textFname.getText();
                String gender = textGender.getText();
                String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                String email = textEmail.getText();
                String status = textStatus.getText();
                String address = textAdd.getText();
                String city =textcity.getText();
                String state = textState.getText();
                String income = textincome.getText();
                String form_no= textsearch.getText();
//                String balance = textAccBal.getText();


                String religion = textReligion.getText();
                String education = textEducation.getText();


                Connn c = new Connn();


                if (name.isEmpty() || surname.isEmpty() || gender.isEmpty() || dob.isEmpty() || email.isEmpty() || status.isEmpty() || address.isEmpty() ||city.isEmpty() || state.isEmpty() || income.isEmpty() || religion.isEmpty() || education.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter all fields");
                    return;
                }

                try{
                    // Update the PIN in the database
                    String updateQuery = "UPDATE signup SET name = '" + name + "',father_name='"+surname+"', gender='"+gender+"', DOB='"+dob+"',email='"+email+"',marital_status='"+status+"',address='"+address+"',city='"+city+"',state='"+state+"' WHERE form_no = '" + form_no + "'";
                    c.statement.executeUpdate(updateQuery);

                    String updateQuery2 = "UPDATE signuptwo SET religion = '" + religion + "',education='"+education+"',income='"+income+"' WHERE form_no = '" + form_no + "'";
                    c.statement.executeUpdate(updateQuery2);


                    JOptionPane.showMessageDialog(null, "Information updated successfully successfully");
                    Connn conn= new Connn();
                    conn.getCustomers(table);


                }catch(Exception E){
                    JOptionPane.showMessageDialog(null, "Unable to update");
                    System.out.println(E.getMessage());
                }


            }
        });



    }







    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public static void main(String[] args) {
        new Admin();
    }
}

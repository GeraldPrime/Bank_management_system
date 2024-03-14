package bank.management.system;


import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Profile extends JFrame implements ActionListener {
    String pin;
    static String form_no;
    JButton button;


    //started
    JRadioButton r1,r2,m1,m2,m3;
    JButton next,exit;

    JTextField textName ,textFname, textEmail,textAdd,textcity,textState,textPin,textReligion,textEducation,
            textBVN, textAccType, textCardNum, textGender, textStatus, textAccNo;
    JDateChooser dateChooser;




    Profile(String pin, String form_no){
        super ("CUSTOMER PROFILE");
        this.pin = pin;
        Profile.form_no = form_no;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);



        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD,22));
        label3.setBounds(290,90,600,30);
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(50,150,80,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD, 14));
        textName.setBounds(120,150,250,30);
        add(textName);

        JLabel labelfName = new JLabel("SURNAME :");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(440,150,150,30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD, 14));
        textFname.setBounds(570,150,250,30);
        add(textFname);

        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(50,200,100,30);
        add(labelG);

        textGender = new JTextField();
        textGender.setFont(new Font("Raleway",Font.BOLD, 14));
        textGender.setBounds(120,200,250,30);
        add(textGender);



        JLabel DOB = new JLabel("Date of Birth");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(440,200,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(570,200,250,30);
        add(dateChooser);



        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(50,250,100,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD, 14));
        textEmail.setBounds(120,250,250,30);
        add(textEmail);


        JLabel labelMs = new JLabel("Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(440,250,100,30);
        add(labelMs);

        textStatus = new JTextField();
        textStatus.setForeground(new Color(105,105,105));
        textStatus.setBounds(570,250,250,30);
        add(textStatus);



        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(50,300,100,30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD, 14));
        textAdd.setBounds(150,300,220,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(440,300,100,30);
        add(labelCity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD, 14));
        textcity.setBounds(570,300,250,30);
        add(textcity);

        JLabel labelPin = new JLabel("CityCode :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(440,350,100,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Rale-way",Font.BOLD, 14));
        textPin.setBounds(570,350,250,30);
        add(textPin);

        JLabel labelstate = new JLabel("State :");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelstate.setBounds(50,350,100,30);
        add( labelstate);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD, 14));
        textState.setBounds(120,350,250,30);
        add(textState);

        //----------new form----------
        JLabel labelreligion = new JLabel("Religion :");
        labelreligion.setFont(new Font("Raleway", Font.BOLD, 20));
        labelreligion.setBounds(50,400,100,30);
        add( labelreligion);

        textReligion = new JTextField();
        textReligion.setFont(new Font("Raleway",Font.BOLD, 14));
        textReligion.setBounds(150,400,220,30);
        add(textReligion);

        JLabel labelEducaton = new JLabel("Education :");
        labelEducaton.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEducaton.setBounds(440,400,100,30);
        add(labelEducaton);

        textEducation = new JTextField();
        textEducation.setFont(new Font("Rale-way",Font.BOLD, 14));
        textEducation.setBounds(570,400,250,30);
        add(textEducation);

        JLabel labelAccNo = new JLabel("ACC NO. :");
        labelAccNo.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAccNo.setBounds(50,450,100,30);
        add( labelAccNo);

        textAccNo = new JTextField();
        textAccNo.setFont(new Font("Raleway",Font.BOLD, 14));
        textAccNo.setBounds(150,450,220,30);
        textAccNo.setEditable(false);
        add(textAccNo);

        JLabel labelBVN = new JLabel("BVN :");
        labelBVN.setFont(new Font("Raleway", Font.BOLD, 20));
        labelBVN.setBounds(440,450,100,30);
        add(labelBVN);

        textBVN = new JTextField();
        textBVN.setFont(new Font("Rale-way",Font.BOLD, 14));
        textBVN.setBounds(570,450,250,30);
        textBVN.setEditable(false);
        add(textBVN);



        //--------third form-----------
        JLabel labelAccType = new JLabel("AccType :");
        labelAccType.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAccType.setBounds(50,500,100,30);
        add( labelAccType);

        textAccType = new JTextField();
        textAccType.setFont(new Font("Raleway",Font.BOLD, 14));
        textAccType.setBounds(150,500,220,30);
        textAccType.setEditable(false);
        add(textAccType);

        JLabel labelCardNum = new JLabel("Card Num :");
        labelCardNum.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCardNum.setBounds(440,500,100,30);
        add(labelCardNum);

        textCardNum = new JTextField();
        textCardNum.setFont(new Font("Rale-way",Font.BOLD, 14));
        textCardNum.setBounds(570,500,250,30);
        textCardNum.setEditable(false);
        add(textCardNum);




        next = new JButton("Save");
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(250,600,80,30);
//        next.addActionListener(this);
        add(next);

        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway",Font.BOLD, 14));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBounds(600,600,80,30);
        exit.addActionListener(this);
        add(exit);

//        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(950,700);
        setLocation(360,40);


        // Set layout to BorderLayout
        setLayout(new BorderLayout());

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/boat.png"));
        Image iii2 = iii1.getImage().getScaledInstance(950,700,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
//        iiimage.setBounds(0,0,850,700);
        iiimage.setLayout(new BorderLayout()); // Set layout of JLabel to BorderLayout

        add(iiimage);

        setVisible(true);

        //---the database operations---

        try{
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from signup where form_no = '"+form_no+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textFname.setText(resultSet.getString("father_name"));
                textGender.setText(resultSet.getString("gender"));

//                dateChooser.setDate(resultSet.getDate("DOB"));
//                String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).setText(resultSet.getString());
                textEmail.setText(resultSet.getString("email"));
                textStatus.setText(resultSet.getString("marital_status"));
                textAdd.setText(resultSet.getString("address"));
                textcity.setText(resultSet.getString("city"));
                textState.setText(resultSet.getString("state"));
                textPin.setText(resultSet.getString("pincode"));

            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        try{
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from signuptwo where form_no = '"+form_no+"'");
            while (resultSet.next()){
                textReligion.setText(resultSet.getString("religion"));
                textEducation.setText(resultSet.getString("education"));
                textAccNo.setText(resultSet.getString("AccountNumber"));
                textBVN.setText(resultSet.getString("BVN"));

            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        try{
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from signupthree where form_no = '"+form_no+"'");
            while (resultSet.next()){
                textAccType.setText(resultSet.getString("account_type"));
                textCardNum.setText(resultSet.getString("card_number"));

            }
        }catch (Exception e ){
            e.printStackTrace();
        }


        next.addActionListener(new ActionListener() {
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
                String pincode = textPin.getText();

                Connn c = new Connn();


                if (name.isEmpty() || surname.isEmpty() || gender.isEmpty() || dob.isEmpty() || email.isEmpty() || status.isEmpty() || address.isEmpty() ||city.isEmpty() || state.isEmpty() || pincode.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Please enter all fields");
                    return;
                }

                try{
                // Update the PIN in the database
                String updateQuery = "UPDATE signup SET name = '" + name + "',father_name='"+surname+"', gender='"+gender+"', DOB='"+dob+"',email='"+email+"',marital_status='"+status+"',address='"+address+"',city='"+city+"',state='"+state+"',pincode='"+pincode+"' WHERE form_no = '" + form_no + "'";
                c.statement.executeUpdate(updateQuery);

                JOptionPane.showMessageDialog(null, "Information updated successfully successfully");
                setVisible(false);
                new main_Class(pin, form_no);

                }catch(Exception E){
                    System.out.println(E.getMessage());
                }


            }
        });





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Profile("", form_no);
    }
}

package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class ViewCustomer extends JFrame implements ActionListener {


    JButton back;

    String username;



    ViewCustomer(String username){


        this.username = username;



        setTitle("Customer Profile");


        setSize(950,650);


        setLocationRelativeTo(null);


        setLayout(null);



        getContentPane().setBackground(
        new Color(245,247,250)
        );





        // ================= HEADER =================


        JPanel header =
        new JPanel();


        header.setBounds(
        0,
        0,
        950,
        80
        );


        header.setBackground(
        new Color(25,42,86)
        );


        header.setLayout(null);



        JLabel title =
        new JLabel(
        "CUSTOMER PROFILE"
        );


        title.setBounds(
        300,
        20,
        400,
        40
        );


        title.setForeground(Color.WHITE);


        title.setFont(
        new Font(
        "Segoe UI",
        Font.BOLD,
        28
        ));


        header.add(title);


        add(header);








        // ================= PROFILE CARD =================



        JPanel card =
        new JPanel();



        card.setBounds(
        80,
        120,
        790,
        330
        );



        card.setBackground(Color.WHITE);


        card.setLayout(null);



        add(card);








        JLabel userTitle =
        createLabel(
        "Username"
        );


        userTitle.setBounds(
        50,
        40,
        120,
        30
        );



        card.add(userTitle);




        JLabel labelusername =
        createValue();


        labelusername.setBounds(
        190,
        40,
        200,
        30
        );


        card.add(labelusername);







        addField(
        card,
        "ID",
        50,
        90
        );

        JLabel labelid =
        createValue();

        labelid.setBounds(
        190,
        90,
        200,
        30
        );

        card.add(labelid);







        addField(
        card,
        "Name",
        50,
        140
        );


        JLabel labelname =
        createValue();


        labelname.setBounds(
        190,
        140,
        200,
        30
        );


        card.add(labelname);








        addField(
        card,
        "Gender",
        50,
        190
        );


        JLabel labelgender =
        createValue();


        labelgender.setBounds(
        190,
        190,
        200,
        30
        );


        card.add(labelgender);










        addField(
        card,
        "Phone",
        430,
        40
        );


        JLabel labelphone =
        createValue();


        labelphone.setBounds(
        560,
        40,
        200,
        30
        );


        card.add(labelphone);







        addField(
        card,
        "Email",
        430,
        90
        );


        JLabel labelemail =
        createValue();


        labelemail.setBounds(
        560,
        90,
        200,
        30
        );


        card.add(labelemail);








        addField(
        card,
        "Address",
        430,
        140
        );


        JLabel labeladdress =
        createValue();


        labeladdress.setBounds(
        560,
        140,
        200,
        30
        );


        card.add(labeladdress);








        addField(
        card,
        "Country",
        430,
        190
        );


        JLabel labelcountry =
        createValue();


        labelcountry.setBounds(
        560,
        190,
        200,
        30
        );


        card.add(labelcountry);









        // ================= BUTTON =================



        back =
        new JButton(
        "Back"
        );


        back.setBounds(
        400,
        500,
        140,
        45
        );


        back.setBackground(
        new Color(
        25,118,210
        ));



        back.setForeground(
        Color.WHITE
        );


        back.setFont(
        new Font(
        "Segoe UI",
        Font.BOLD,
        15
        ));



        back.addActionListener(this);


        add(back);








        // ================= DATABASE =================


        try{


            Conn c =
            new Conn();



            String query =
            "select * from customer where username='"+username+"'";



            ResultSet rs =
            c.s.executeQuery(query);



            while(rs.next()){


                labelusername.setText(
                rs.getString("username")
                );


                labelid.setText(
                rs.getString("id")
                );


                labelname.setText(
                rs.getString("name")
                );


                labelgender.setText(
                rs.getString("gender")
                );


                labelphone.setText(
                rs.getString("phone")
                );


                labelemail.setText(
                rs.getString("email")
                );


                labeladdress.setText(
                rs.getString("address")
                );


                labelcountry.setText(
                rs.getString("country")
                );


            }


        }

        catch(Exception e){

            e.printStackTrace();

        }






        setVisible(true);


    }







    private JLabel createLabel(String text){


        JLabel l =
        new JLabel(text);



        l.setFont(
        new Font(
        "Segoe UI",
        Font.BOLD,
        15
        ));



        return l;

    }






    private JLabel createValue(){


        JLabel l =
        new JLabel();


        l.setFont(
        new Font(
        "Segoe UI",
        Font.PLAIN,
        15
        ));



        l.setForeground(
        new Color(
        70,70,70
        ));



        return l;

    }







    private void addField(
    JPanel panel,
    String text,
    int x,
    int y){



        JLabel l =
        createLabel(text);



        l.setBounds(
        x,
        y,
        120,
        30
        );



        panel.add(l);

    }







    public void actionPerformed(ActionEvent e){


        if(e.getSource()==back){


            setVisible(false);


        }


    }






    public static void main(String args[]){


        new ViewCustomer("Rambo");


    }


}
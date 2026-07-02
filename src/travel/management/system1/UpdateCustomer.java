package travel.management.system1;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class UpdateCustomer extends JFrame implements ActionListener {



    JLabel Labelusername, Labelname;

    JTextField tfid, tfnumber, tfgender,
            tfcountry, tfaddress, tfphone, tfemail;


    JButton update, back;


    String username;



    UpdateCustomer(String username){



        this.username=username;



        setTitle("Update Customer");


        setSize(1000,650);


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
                1000,
                80
        );


        header.setBackground(
                new Color(25,42,86)
        );


        header.setLayout(null);



        JLabel title =
                new JLabel(
                "UPDATE CUSTOMER DETAILS"
                );


        title.setBounds(
                280,
                20,
                500,
                40
        );


        title.setForeground(Color.WHITE);


        title.setFont(
                new Font(
                "Segoe UI",
                Font.BOLD,
                28)
        );


        header.add(title);


        add(header);








        // ================= CARD =================



        JPanel card =
                new JPanel();


        card.setBounds(
                80,
                120,
                600,
                420
        );


        card.setLayout(null);


        card.setBackground(Color.WHITE);


        add(card);







        Labelusername =
                new JLabel();


        Labelusername.setBounds(
                200,
                40,
                200,
                30
        );


        card.add(
                createRow(card,"Username",Labelusername,40)
        );







        tfid =
                new JTextField();


        card.add(
                createField(card,"ID",tfid,90)
        );



        tfnumber =
                new JTextField();


        card.add(
                createField(card,"Number",tfnumber,140)
        );




        Labelname =
                new JLabel();


        card.add(
                createRow(card,"Name",Labelname,190)
        );




        tfgender =
                new JTextField();


        card.add(
                createField(card,"Gender",tfgender,240)
        );




        tfcountry =
                new JTextField();


        card.add(
                createField(card,"Country",tfcountry,290)
        );




        tfaddress =
                new JTextField();


        card.add(
                createField(card,"Address",tfaddress,340)
        );




        tfphone =
                new JTextField();


        card.add(
                createField(card,"Phone",tfphone,390)
        );




        tfemail =
                new JTextField();


        card.add(
                createField(card,"Email",tfemail,440)
        );









        // ================= BUTTONS =================



        update =
                new JButton("UPDATE");


        update.setBounds(
                200,
                560,
                130,
                40
        );


        update.setBackground(
                new Color(46,134,222)
        );


        update.setForeground(Color.WHITE);


        update.addActionListener(this);


        add(update);





        back =
                new JButton("BACK");


        back.setBounds(
                360,
                560,
                130,
                40
        );


        back.setBackground(
                new Color(231,76,60)
        );


        back.setForeground(Color.WHITE);


        back.addActionListener(this);


        add(back);







        // ================= IMAGE =================



        ImageIcon icon =
                new ImageIcon(
                "images/travel_bg.jpg"
                );



        Image img =
                icon.getImage()
                .getScaledInstance(
                        250,
                        250,
                        Image.SCALE_SMOOTH
                );



        JLabel image =
                new JLabel(
                new ImageIcon(img)
                );


        image.setBounds(
                720,
                180,
                250,
                250
        );


        add(image);








        // ================= FETCH DATA =================


        try{


            Conn c =
                    new Conn();



            ResultSet rs =
                    c.s.executeQuery(
                    "select * from customer where username='"+username+"'"
                    );



            while(rs.next()){



                Labelusername.setText(
                        rs.getString("username")
                );


                Labelname.setText(
                        rs.getString("name")
                );


                tfid.setText(
                        rs.getString("id")
                );


                tfnumber.setText(
                        rs.getString("number")
                );


                tfgender.setText(
                        rs.getString("gender")
                );


                tfcountry.setText(
                        rs.getString("country")
                );


                tfaddress.setText(
                        rs.getString("address")
                );


                tfphone.setText(
                        rs.getString("phone")
                );


                tfemail.setText(
                        rs.getString("email")
                );

            }


        }
        catch(Exception e){

            e.printStackTrace();

        }




        setVisible(true);

    }







    private JLabel createRow(
            JPanel panel,
            String name,
            JLabel value,
            int y){



        JLabel label =
                new JLabel(name);


        label.setBounds(
                40,
                y,
                120,
                30
        );


        label.setFont(
                new Font(
                "Segoe UI",
                Font.BOLD,
                14)
        );


        panel.add(label);



        value.setBounds(
                200,
                y,
                200,
                30
        );


        return value;

    }







    private JTextField createField(
            JPanel panel,
            String name,
            JTextField field,
            int y){



        JLabel label =
                new JLabel(name);



        label.setBounds(
                40,
                y,
                120,
                30
        );


        label.setFont(
                new Font(
                "Segoe UI",
                Font.BOLD,
                14)
        );



        panel.add(label);




        field.setBounds(
                200,
                y,
                250,
                30
        );



        return field;

    }









    public void actionPerformed(ActionEvent ae){



        if(ae.getSource()==update){


            try{


                Conn c =
                        new Conn();



                String query =

                "update customer set " +

                "id='"+tfid.getText()+"'," +

                "number='"+tfnumber.getText()+"'," +

                "gender='"+tfgender.getText()+"'," +

                "country='"+tfcountry.getText()+"'," +

                "address='"+tfaddress.getText()+"'," +

                "phone='"+tfphone.getText()+"'," +

                "email='"+tfemail.getText()+"'" +

                " where username='"+Labelusername.getText()+"'";



                c.s.executeUpdate(query);



                JOptionPane.showMessageDialog(
                        null,
                        "Customer Updated Successfully"
                );


                setVisible(false);



            }
            catch(Exception e){

                e.printStackTrace();

            }


        }



        else if(ae.getSource()==back){


            setVisible(false);


        }


    }





    public static void main(String args[]){


        new UpdateCustomer("Rambo");


    }


}
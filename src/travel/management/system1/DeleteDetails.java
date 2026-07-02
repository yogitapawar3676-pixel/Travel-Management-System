package travel.management.system1;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class DeleteDetails extends JFrame implements ActionListener {


    JButton delete, back;

    String username;



    JLabel labelusername,
           labelid,
           labelnumber,
           labelname,
           labelgender,
           labelcountry,
           labeladdress,
           labelphone,
           labelemail;





    DeleteDetails(String username){


        this.username=username;



        setTitle("Delete Customer");


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
                new Color(192,57,43)
        );


        header.setLayout(null);



        JLabel title =
                new JLabel(
                "DELETE CUSTOMER"
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
                28)
        );


        header.add(title);


        add(header);







        // ================= CARD =================



        JPanel card =
                new JPanel();


        card.setBounds(
                90,
                120,
                770,
                330
        );


        card.setBackground(Color.WHITE);


        card.setLayout(null);


        add(card);








        labelusername =
                createValue();


        addField(card,
                "Username",
                labelusername,
                50,
                40);





        labelid =
                createValue();


        addField(card,
                "ID",
                labelid,
                50,
                90);





        labelnumber =
                createValue();


        addField(card,
                "Number",
                labelnumber,
                50,
                140);





        labelname =
                createValue();


        addField(card,
                "Name",
                labelname,
                50,
                190);






        labelgender =
                createValue();


        addField(card,
                "Gender",
                labelgender,
                430,
                40);






        labelcountry =
                createValue();


        addField(card,
                "Country",
                labelcountry,
                430,
                90);






        labeladdress =
                createValue();


        addField(card,
                "Address",
                labeladdress,
                430,
                140);






        labelphone =
                createValue();


        addField(card,
                "Phone",
                labelphone,
                430,
                190);







        labelemail =
                createValue();


        addField(card,
                "Email",
                labelemail,
                430,
                240);









        // ================= BUTTONS =================



        delete =
                new JButton(
                "DELETE CUSTOMER"
                );


        delete.setBounds(
                260,
                510,
                180,
                45
        );


        delete.setBackground(
                new Color(192,57,43)
        );


        delete.setForeground(Color.WHITE);


        delete.setFont(
                new Font(
                "Segoe UI",
                Font.BOLD,
                14)
        );


        delete.addActionListener(this);


        add(delete);








        back =
                new JButton(
                "BACK"
                );


        back.setBounds(
                500,
                510,
                120,
                45
        );


        back.setBackground(
                new Color(52,73,94)
        );


        back.setForeground(Color.WHITE);



        back.addActionListener(this);


        add(back);









        // ================= LOAD DATA =================


        try{


            Conn c =
                    new Conn();



            ResultSet rs =
            c.s.executeQuery(
            "select * from customer where username='"+username+"'"
            );



            while(rs.next()){


                labelusername.setText(
                rs.getString("username"));


                labelid.setText(
                rs.getString("id"));


                labelnumber.setText(
                rs.getString("number"));


                labelname.setText(
                rs.getString("name"));


                labelgender.setText(
                rs.getString("gender"));


                labelcountry.setText(
                rs.getString("country"));


                labeladdress.setText(
                rs.getString("address"));


                labelphone.setText(
                rs.getString("phone"));


                labelemail.setText(
                rs.getString("email"));


            }


        }

        catch(Exception e){

            e.printStackTrace();

        }







        setVisible(true);


    }







    private JLabel createValue(){


        JLabel l =
                new JLabel();



        l.setFont(
                new Font(
                "Segoe UI",
                Font.PLAIN,
                15)
        );


        l.setForeground(
                new Color(80,80,80)
        );


        return l;

    }








    private void addField(
            JPanel panel,
            String name,
            JLabel value,
            int x,
            int y){



        JLabel label =
                new JLabel(name);



        label.setBounds(
                x,
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
                x+140,
                y,
                200,
                30
        );


        panel.add(value);


    }









    public void actionPerformed(ActionEvent ae){



        if(ae.getSource()==delete){



            int confirm =
            JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this customer?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );



            if(confirm==JOptionPane.YES_OPTION){



                try{


                    Conn c =
                    new Conn();



                    String query =
                    "delete from customer where username='"+username+"'";



                    c.s.executeUpdate(query);



                    JOptionPane.showMessageDialog(
                    null,
                    "Customer Deleted Successfully"
                    );



                    setVisible(false);



                }

                catch(Exception e){

                    e.printStackTrace();

                }


            }



        }



        else if(ae.getSource()==back){


            setVisible(false);


        }



    }






    public static void main(String args[]){


        new DeleteDetails("Rambo");


    }


}
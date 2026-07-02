package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {


    JTextField tfname, tfnumber, tfcountry, tfaddress, tfphone, tfemail;

    JRadioButton male, female;

    JButton save, back;

    String username;



    AddCustomer(String username){


        this.username = username;


        setTitle("Add Customer");

        setSize(1200,750);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        // ================= BACKGROUND IMAGE =================

        ImageIcon icon =
                new ImageIcon("images/travel_bg.jpg");


        Image image = icon.getImage();



        JPanel background = new JPanel(){


            protected void paintComponent(Graphics g){

                super.paintComponent(g);

                g.drawImage(
                        image,
                        0,
                        0,
                        getWidth(),
                        getHeight(),
                        this
                );

            }

        };


        background.setLayout(null);

        setContentPane(background);



        // ================= CARD =================


        JPanel card = new JPanel();

        card.setBounds(330,50,540,650);

        card.setLayout(null);


        card.setBackground(
                new Color(255,255,255,220)
        );


        background.add(card);



        JLabel title = new JLabel("ADD CUSTOMER");


        title.setBounds(140,20,300,40);


        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );


        title.setForeground(
                new Color(30,70,120)
        );


        card.add(title);




        addLabel(card,"Name",50,90);


        tfname = new JTextField();

        tfname.setBounds(180,90,280,35);

        card.add(tfname);




        addLabel(card,"Number",50,150);


        tfnumber = new JTextField();

        tfnumber.setBounds(180,150,280,35);

        card.add(tfnumber);




        addLabel(card,"Gender",50,210);



        male = new JRadioButton("Male");

        male.setBounds(180,210,80,30);



        female = new JRadioButton("Female");

        female.setBounds(270,210,100,30);



        ButtonGroup bg = new ButtonGroup();

        bg.add(male);

        bg.add(female);



        card.add(male);

        card.add(female);






        addLabel(card,"Country",50,270);


        tfcountry = new JTextField();

        tfcountry.setBounds(180,270,280,35);

        card.add(tfcountry);






        addLabel(card,"Address",50,330);


        tfaddress = new JTextField();

        tfaddress.setBounds(180,330,280,35);

        card.add(tfaddress);






        addLabel(card,"Phone",50,390);


        tfphone = new JTextField();

        tfphone.setBounds(180,390,280,35);

        card.add(tfphone);






        addLabel(card,"Email",50,450);


        tfemail = new JTextField();

        tfemail.setBounds(180,450,280,35);

        card.add(tfemail);







        save = new JButton("SAVE CUSTOMER");


        save.setBounds(80,540,190,45);


        save.setBackground(
                new Color(46,134,222)
        );


        save.setForeground(Color.WHITE);


        save.addActionListener(this);


        card.add(save);







        back = new JButton("BACK");


        back.setBounds(300,540,120,45);


        back.addActionListener(this);


        card.add(back);




        setVisible(true);


    }







    private void addLabel(JPanel panel,String text,int x,int y){


        JLabel label = new JLabel(text);


        label.setBounds(x,y,120,30);


        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );


        panel.add(label);

    }








    public void actionPerformed(ActionEvent ae){



        if(ae.getSource()==save){



            String gender="";



            if(male.isSelected()){

                gender="Male";

            }

            else if(female.isSelected()){

                gender="Female";

            }






            try{


                Conn c = new Conn();



                String customerId =
                        "CUST" + System.currentTimeMillis();





                String query =

                "insert into customer(username,id,number,name,gender,country,address,phone,email) values('"

                + username + "','"

                + customerId + "','"

                + tfnumber.getText() + "','"

                + tfname.getText() + "','"

                + gender + "','"

                + tfcountry.getText() + "','"

                + tfaddress.getText() + "','"

                + tfphone.getText() + "','"

                + tfemail.getText()

                + "')";





                c.s.executeUpdate(query);





                JOptionPane.showMessageDialog(
                        null,
                        "Customer Added Successfully"
                );



                setVisible(false);



            }

            catch(Exception e){


                e.printStackTrace();


                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage()
                );


            }


        }


        else if(ae.getSource()==back){


            setVisible(false);


        }


    }






    public static void main(String args[]){


        new AddCustomer("Rambo");


    }

}
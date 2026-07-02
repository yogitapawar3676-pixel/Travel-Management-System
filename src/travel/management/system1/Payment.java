package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Payment extends JFrame implements ActionListener {

    JTextField tfamount;
    JRadioButton card, upi, netbank;
    JButton pay, back;

    String username;


    Payment(String username) {

        this.username = username;


        setBounds(500,200,520,420);
        setLayout(null);
        setTitle("Payment Module");


        getContentPane().setBackground(new Color(245,247,250));


        // TITLE
        JLabel title = new JLabel("PAYMENT");
        title.setFont(new Font("Segoe UI",Font.BOLD,28));
        title.setBounds(200,20,200,40);
        add(title);



        // AMOUNT

        JLabel amount = new JLabel("Amount (₹)");

        amount.setBounds(50,90,120,30);
        add(amount);



        tfamount = new JTextField();

        tfamount.setBounds(200,90,220,30);
        add(tfamount);



        // PAYMENT METHOD

        JLabel method = new JLabel("Payment Method");

        method.setBounds(50,140,150,30);
        add(method);



        card = new JRadioButton("Card");

        card.setBounds(200,140,80,30);


        upi = new JRadioButton("UPI");

        upi.setBounds(290,140,80,30);



        netbank = new JRadioButton("Net Banking");

        netbank.setBounds(200,180,150,30);



        ButtonGroup bg = new ButtonGroup();

        bg.add(card);
        bg.add(upi);
        bg.add(netbank);



        add(card);
        add(upi);
        add(netbank);



        // PAY BUTTON

        pay = new JButton("Pay Now");

        pay.setBounds(120,260,120,40);

        pay.setBackground(new Color(46,204,113));

        pay.setForeground(Color.WHITE);

        pay.addActionListener(this);

        add(pay);




        // BACK BUTTON

        back = new JButton("Back");

        back.setBounds(260,260,120,40);

        back.setBackground(new Color(231,76,60));

        back.setForeground(Color.WHITE);

        back.addActionListener(this);

        add(back);



        setVisible(true);

    }




    public void actionPerformed(ActionEvent ae){


        if(ae.getSource()==pay){


            String amount = tfamount.getText().trim();

            String method = "";



            if(amount.isEmpty()){

                JOptionPane.showMessageDialog(null,
                "Enter amount");

                return;
            }



            if(!card.isSelected() &&
               !upi.isSelected() &&
               !netbank.isSelected()){


                JOptionPane.showMessageDialog(null,
                "Select Payment Method");

                return;

            }




            if(card.isSelected()){

                method="Card";

            }

            else if(upi.isSelected()){

                method="UPI";

            }

            else if(netbank.isSelected()){

                method="Net Banking";

            }



            try{


                Conn c = new Conn();



                // SAVE PAYMENT DATABASE

                String query =
                "INSERT INTO payment(username,amount,method,status) VALUES('"
                +username+"','"
                +amount+"','"
                +method+"','SUCCESS')";



                c.s.executeUpdate(query);



                // CREATE TRANSACTION ID

                String transactionId =
                "TXN" + System.currentTimeMillis();



                // GENERATE PDF INVOICE

                InvoiceGenerator.generateInvoice(
                        username,
                        amount,
                        method,
                        transactionId
                );




                JOptionPane.showMessageDialog(null,

                "Payment Successful!\nInvoice Generated\nTransaction ID: "
                +transactionId);



                setVisible(false);



            }
            catch(Exception e){

                e.printStackTrace();

                JOptionPane.showMessageDialog(null,
                "Payment Failed");

            }


        }



        else if(ae.getSource()==back){

            setVisible(false);

        }


    }





    public static void main(String args[]){

        new Payment("Rambo");

    }

}
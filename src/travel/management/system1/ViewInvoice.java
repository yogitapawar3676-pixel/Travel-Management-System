package travel.management.system1;

import javax.swing.*;
import java.awt.*;

public class ViewInvoice extends JFrame {

    ViewInvoice(String username){

        setBounds(300,100,800,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("INVOICE CENTER");
        l1.setBounds(250,20,300,40);
        l1.setFont(new Font("Tahoma",Font.BOLD,22));
        add(l1);

        JLabel l2 = new JLabel("All invoices are saved as PDF in project folder.");
        l2.setBounds(150,120,500,30);
        add(l2);

        JLabel l3 = new JLabel("Use Transaction ID to track payments.");
        l3.setBounds(150,160,500,30);
        add(l3);

        setVisible(true);
    }
}
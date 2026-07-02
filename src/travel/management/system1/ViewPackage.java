package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewPackage extends JFrame implements ActionListener {

    JButton back;

    JLabel labelusername, labelpackage, labelpersons,
            labelid, labelnumber, labelphone, labelprice;

    ViewPackage(String username) {

        setTitle("View Package");
        setBounds(450, 200, 900, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);

        // HEADER
        JLabel text = new JLabel("VIEW BOOKED PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 16));
        text.setBounds(60, 10, 400, 30);
        add(text);

        // LABELS
        addLabel("Username", 50);
        labelusername = addValue(50);

        addLabel("Package", 90);
        labelpackage = addValue(90);

        addLabel("Total Persons", 130);
        labelpersons = addValue(130);

        addLabel("ID", 170);
        labelid = addValue(170);

        addLabel("Number", 210);
        labelnumber = addValue(210);

        addLabel("Phone", 250);
        labelphone = addValue(250);

        addLabel("Price", 290);
        labelprice = addValue(290);

        // BACK BUTTON
        back = new JButton("BACK");
        back.setBounds(130, 350, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // IMAGE
        java.net.URL url = getClass().getClassLoader().getResource("icons/bookedDetails.jpg");

if(url != null) {

    ImageIcon i1 = new ImageIcon(url);
    Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
    JLabel image = new JLabel(new ImageIcon(i2));
    image.setBounds(450, 20, 500, 400);
    add(image);

} else {
    System.out.println("❌ Image not found: bookedDetails.jpg");
}

        // DATABASE FIX (IMPORTANT)
        try {
            Conn c = new Conn();

            String query = "select * from bookpackage where username='" + username + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {

                labelusername.setText(rs.getString(1));
                labelpackage.setText(rs.getString(2));
                labelpersons.setText(rs.getString(3));
                labelid.setText(rs.getString(4));
                labelnumber.setText(rs.getString(5));
                labelphone.setText(rs.getString(6));
                labelprice.setText(rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading package details");
        }

        setVisible(true);
    }

    private void addLabel(String text, int y) {
        JLabel l = new JLabel(text);
        l.setBounds(40, y, 120, 25);
        add(l);
    }

    private JLabel addValue(int y) {
        JLabel l = new JLabel();
        l.setBounds(180, y, 200, 25);
        add(l);
        return l;
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage("Rambo");
    }
}
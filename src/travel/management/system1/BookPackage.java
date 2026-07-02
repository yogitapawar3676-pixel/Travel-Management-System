package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfpersons;

    String username;

    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;

    JButton checkprice, bookpackage, back;

    BookPackage(String username) {

        this.username = username;

        setTitle("Book Package");
        setSize(1050, 650);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(245, 247, 250));

        // HEADER
        JPanel header = new JPanel();
        header.setBounds(0, 0, 1050, 80);
        header.setBackground(new Color(25, 42, 86));
        header.setLayout(null);

        JLabel title = new JLabel("BOOK PACKAGE");
        title.setBounds(380, 20, 400, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        header.add(title);

        add(header);

        // CARD
        JPanel card = new JPanel();
        card.setBounds(70, 120, 550, 420);
        card.setBackground(Color.WHITE);
        card.setLayout(null);
        add(card);

        // USERNAME
        labelusername = new JLabel();
        addField(card, "Username", labelusername, 40);

        // PACKAGE
        JLabel packLabel = new JLabel("Select Package");
        packLabel.setBounds(40, 90, 150, 30);
        packLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        card.add(packLabel);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(220, 90, 220, 30);
        card.add(cpackage);

        // PERSONS
        tfpersons = new JTextField("1");
        addField(card, "Total Persons", tfpersons, 140);

        // ID
        labelid = new JLabel();
        addField(card, "ID", labelid, 190);

        // NUMBER
        labelnumber = new JLabel();
        addField(card, "Number", labelnumber, 240);

        // PHONE
        labelphone = new JLabel();
        addField(card, "Phone", labelphone, 290);

        // PRICE
        labelprice = new JLabel();
        addField(card, "Total Price", labelprice, 340);

        // BUTTONS
        checkprice = new JButton("CHECK PRICE");
        checkprice.setBounds(90, 570, 150, 40);
        styleButton(checkprice);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("BOOK");
        bookpackage.setBounds(270, 570, 150, 40);
        styleButton(bookpackage);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("BACK");
        back.setBounds(450, 570, 120, 40);
        styleButton(back);
        back.addActionListener(this);
        add(back);

        // IMAGE (IMPORTANT - YOUR ORIGINAL IMAGE KEPT)
        java.net.URL url = getClass().getClassLoader().getResource("icons/bookpackage.jpg");

        if(url != null) {
            ImageIcon i1 = new ImageIcon(url);
            Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
            JLabel image = new JLabel(new ImageIcon(i2));
            image.setBounds(680, 150, 350, 350);
            add(image);
        } else {
            System.out.println("Image not found: bookpackage.jpg");
        }

        // DATABASE
        try {
    Conn c = new Conn();

    ResultSet rs = c.s.executeQuery(
        "select * from customer where username='" + username + "'"
    );

    if(rs.next()) {
        labelusername.setText(rs.getString("username"));
        labelid.setText(rs.getString("id"));
        labelnumber.setText(rs.getString("number"));
        labelphone.setText(rs.getString("phone"));
    } else {
        System.out.println("No customer found for: " + username);
    }

} catch(Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "BookPackage DB Error");
}

        setVisible(true);
    }

    // FIXED METHOD (THIS SOLVES YOUR ERROR)
    private void addField(JPanel panel, String labelText, JComponent comp, int y) {

    JLabel label = new JLabel(labelText);

    label.setBounds(40, y, 150, 30);
    label.setFont(new Font("Segoe UI", Font.BOLD, 14));
    panel.add(label);

    comp.setBounds(220, y, 220, 30);
    comp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    panel.add(comp);
}

    private void styleButton(JButton b) {
        b.setBackground(new Color(25, 118, 210));
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Segoe UI", Font.BOLD, 13));
        b.setFocusPainted(false);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == checkprice) {

            int cost = 0;

            String pack = cpackage.getSelectedItem();

            if (pack.equals("Gold Package")) cost = 12000;
            else if (pack.equals("Silver Package")) cost = 9000;
            else cost = 6000;

            int persons = Integer.parseInt(tfpersons.getText());
            cost = cost * persons;

            labelprice.setText("₹ " + cost);
        }

        else if (ae.getSource() == bookpackage) {

            try {
                Conn c = new Conn();

                c.s.executeUpdate(
                        "insert into bookpackage values('"
                                + labelusername.getText() + "','"
                                + cpackage.getSelectedItem() + "','"
                                + tfpersons.getText() + "','"
                                + labelid.getText() + "','"
                                + labelnumber.getText() + "','"
                                + labelphone.getText() + "','"
                                + labelprice.getText() + "')"
                );

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("Rambo");
    }
}
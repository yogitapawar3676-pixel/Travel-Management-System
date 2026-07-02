package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewHotel extends JFrame implements ActionListener {

    JButton back;
    JPanel container;

    ViewHotel(String username) {

        setTitle("View Hotels");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 242, 245));

        // HEADER
        JLabel title = new JLabel("AVAILABLE HOTELS");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setBounds(350, 20, 400, 40);
        add(title);

        // SCROLL PANEL
        container = new JPanel();
        container.setLayout(new GridLayout(0, 1, 15, 15));
        container.setBackground(new Color(240, 242, 245));

        JScrollPane scroll = new JScrollPane(container);
        scroll.setBounds(80, 80, 830, 450);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        add(scroll);

        // LOAD HOTELS FROM DB
        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM hotel");

            while (rs.next()) {

                JPanel card = createHotelCard(
                        rs.getString("name"),
                        rs.getString("costperperson"),
                        rs.getString("acroom"),
                        rs.getString("foodincluded")
                );

                container.add(card);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // BACK BUTTON
        back = new JButton("BACK");
        back.setBounds(430, 550, 120, 35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    // HOTEL CARD DESIGN
    private JPanel createHotelCard(String name, String cost, String ac, String food) {

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setPreferredSize(new Dimension(800, 120));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        JLabel hotelName = new JLabel(name);
        hotelName.setFont(new Font("Segoe UI", Font.BOLD, 18));
        hotelName.setBounds(20, 10, 300, 25);
        card.add(hotelName);

        JLabel price = new JLabel("₹ " + cost + " / person");
        price.setFont(new Font("Segoe UI", Font.BOLD, 14));
        price.setForeground(new Color(0, 102, 204));
        price.setBounds(20, 45, 200, 20);
        card.add(price);

        JLabel acLabel = new JLabel("AC Room: " + ac);
        acLabel.setBounds(20, 70, 200, 20);
        card.add(acLabel);

        JLabel foodLabel = new JLabel("Food: " + food);
        foodLabel.setBounds(20, 90, 200, 20);
        card.add(foodLabel);

        JButton select = new JButton("Select");
        select.setBounds(650, 40, 120, 35);
        select.setBackground(new Color(0, 153, 76));
        select.setForeground(Color.WHITE);
        select.setFocusPainted(false);

        select.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Selected: " + name);
        });

        card.add(select);

        return card;
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewHotel("Rambo");
    }
}
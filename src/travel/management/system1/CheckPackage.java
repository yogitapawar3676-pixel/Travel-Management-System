package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckPackage extends JFrame implements ActionListener {

    JButton bronzeBtn, silverBtn, goldBtn;

    public CheckPackage() {

        setTitle("Travel Packages");
        setSize(1400,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(245,247,252));

        JLabel heading = new JLabel("EXPLORE OUR AMAZING PACKAGES");
        heading.setFont(new Font("Segoe UI",Font.BOLD,34));
        heading.setForeground(new Color(30,45,70));
        heading.setBounds(350,25,700,40);
        add(heading);

        JLabel sub = new JLabel("Choose the best package for your unforgettable journey");
        sub.setFont(new Font("Segoe UI",Font.PLAIN,18));
        sub.setForeground(Color.GRAY);
        sub.setBounds(430,70,520,30);
        add(sub);

        JPanel bronzeCard = createCard(
                "BRONZE PACKAGE",
                "images/package1.jpg",
                "2 Days & 3 Nights",
                "₹ 6,000",
                new Color(255,140,0));

        bronzeCard.setBounds(60,150,380,520);
        add(bronzeCard);

        bronzeBtn = (JButton) bronzeCard.getComponent(bronzeCard.getComponentCount()-1);

        JPanel silverCard = createCard(
                "SILVER PACKAGE",
                "images/package2.jpg",
                "3 Days & 4 Nights",
                "₹ 8,500",
                new Color(52,152,219));

        silverCard.setBounds(500,150,380,520);
        add(silverCard);

        silverBtn = (JButton) silverCard.getComponent(silverCard.getComponentCount()-1);

        JPanel goldCard = createCard(
                "GOLD PACKAGE",
                "images/package3.jpg",
                "4 Days & 5 Nights",
                "₹ 12,000",
                new Color(241,196,15));

        goldCard.setBounds(940,150,380,520);
        add(goldCard);

        goldBtn = (JButton) goldCard.getComponent(goldCard.getComponentCount()-1);

        setVisible(true);
    }
        // ================= CREATE PACKAGE CARD =================

    private JPanel createCard(String title,
                              String imagePath,
                              String days,
                              String price,
                              Color color) {

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(220,220,220),2));

        // Package Title
        JLabel lblTitle = new JLabel(title);
        lblTitle.setBounds(20,15,300,30);
        lblTitle.setFont(new Font("Segoe UI",Font.BOLD,22));
        lblTitle.setForeground(color);
        card.add(lblTitle);

        // Package Image
        ImageIcon icon = null;

        try{
            java.net.URL url = ClassLoader.getSystemResource(imagePath);

            if(url != null){
                icon = new ImageIcon(url);
            }else{
                icon = new ImageIcon(imagePath);
            }

        }catch(Exception e){
            icon = new ImageIcon(imagePath);
        }

        Image img = icon.getImage().getScaledInstance(330,180,Image.SCALE_SMOOTH);

        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(20,55,330,180);
        card.add(image);

        // Duration
        JLabel duration = new JLabel(days);
        duration.setBounds(25,250,250,25);
        duration.setFont(new Font("Segoe UI",Font.BOLD,18));
        card.add(duration);

        // Features
        JTextArea details = new JTextArea(
                "✓ Deluxe Hotel Stay\n"
              + "✓ Daily Breakfast\n"
              + "✓ Free Sightseeing\n"
              + "✓ Travel Guide\n"
              + "✓ Pickup & Drop\n"
              + "✓ Free WiFi");
        details.setBounds(25,285,300,110);
        details.setFont(new Font("Segoe UI",Font.PLAIN,15));
        details.setEditable(false);
        details.setOpaque(false);
        card.add(details);

        // Price
        JLabel lblPrice = new JLabel(price);
        lblPrice.setBounds(120,405,180,35);
        lblPrice.setFont(new Font("Segoe UI",Font.BOLD,28));
        lblPrice.setForeground(color);
        card.add(lblPrice);

        // Button
        JButton btn = new JButton("BOOK NOW");
        btn.setBounds(90,455,180,40);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI",Font.BOLD,16));
        btn.addActionListener(this);
        card.add(btn);

        return card;
    }
        // ================= BUTTON ACTION =================

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bronzeBtn) {

            JOptionPane.showMessageDialog(
                    this,
                    "Bronze Package Selected!\nPrice : ₹6,000");

            // Uncomment if you want to open booking page
            // new BookPackage(username);

        } else if (ae.getSource() == silverBtn) {

            JOptionPane.showMessageDialog(
                    this,
                    "Silver Package Selected!\nPrice : ₹8,500");

            // new BookPackage(username);

        } else if (ae.getSource() == goldBtn) {

            JOptionPane.showMessageDialog(
                    this,
                    "Gold Package Selected!\nPrice : ₹12,000");

            // new BookPackage(username);

        }

    }

    // ================= MAIN =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new CheckPackage();
        });

    }

}
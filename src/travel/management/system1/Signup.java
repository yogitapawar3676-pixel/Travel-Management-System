package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;

    Signup() {

        // FULL SCREEN WINDOW
        setTitle("Create Account - TravelBoard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // BACKGROUND PANEL (Gradient UI)
        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                Color c1 = new Color(36, 59, 85);
                Color c2 = new Color(20, 30, 48);

                GradientPaint gp = new GradientPaint(0, 0, c1, 0, getHeight(), c2);
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        background.setLayout(null);
        setContentPane(background);

        // CENTER CARD (GLASS EFFECT)
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(450, 120, 500, 450);
        card.setBackground(new Color(255, 255, 255, 35));
        card.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 2));
        background.add(card);

        // TITLE
        JLabel title = new JLabel("Create Account");
        title.setBounds(150, 20, 300, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        card.add(title);

        // USERNAME
        JLabel jlusername = new JLabel("Username");
        jlusername.setBounds(50, 80, 150, 25);
        jlusername.setForeground(Color.WHITE);
        card.add(jlusername);

        tfusername = new JTextField();
        tfusername.setBounds(200, 80, 220, 30);
        card.add(tfusername);

        // NAME
        JLabel jlname = new JLabel("Name");
        jlname.setBounds(50, 130, 150, 25);
        jlname.setForeground(Color.WHITE);
        card.add(jlname);

        tfname = new JTextField();
        tfname.setBounds(200, 130, 220, 30);
        card.add(tfname);

        // PASSWORD
        JLabel jlpassword = new JLabel("Password");
        jlpassword.setBounds(50, 180, 150, 25);
        jlpassword.setForeground(Color.WHITE);
        card.add(jlpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(200, 180, 220, 30);
        card.add(tfpassword);

        // SECURITY
        JLabel jlsecurity = new JLabel("Security Q.");
        jlsecurity.setBounds(50, 230, 150, 25);
        jlsecurity.setForeground(Color.WHITE);
        card.add(jlsecurity);

        security = new Choice();
        security.add("Your Best friend name?");
        security.add("Your Mother name?");
        security.add("Your favourite dish");
        security.add("Your birth place");
        security.add("Your favourite cricketer");
        security.setBounds(200, 230, 220, 30);
        card.add(security);

        // ANSWER
        JLabel jlanswer = new JLabel("Answer");
        jlanswer.setBounds(50, 280, 150, 25);
        jlanswer.setForeground(Color.WHITE);
        card.add(jlanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(200, 280, 220, 30);
        card.add(tfanswer);

        // CREATE BUTTON
        create = new JButton("CREATE");
        create.setBounds(80, 360, 140, 40);
        create.setBackground(new Color(46, 204, 113));
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Segoe UI", Font.BOLD, 14));
        create.addActionListener(this);
        card.add(create);

        // BACK BUTTON
        back = new JButton("BACK");
        back.setBounds(260, 360, 140, 40);
        back.setBackground(new Color(231, 76, 60));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Segoe UI", Font.BOLD, 14));
        back.addActionListener(this);
        card.add(back);

        setVisible(true);
    }

    // YOUR ORIGINAL LOGIC (NOT CHANGED)
    public void actionPerformed(ActionEvent ac) {

        if (ac.getSource() == create) {

            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();

            String query = "insert into account1 values('"
                    + username + "','" + name + "','" + password + "','"
                    + question + "','" + answer + "')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new login();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ac.getSource() == back) {
            setVisible(false);
            new login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
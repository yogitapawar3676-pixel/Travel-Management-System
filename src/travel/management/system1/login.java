package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener {

    JTextField tfusername;
    JPasswordField tfpassword;

    JButton login, signup;

    public login() {

        setTitle("TravelBoard - Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // FULL SCREEN BACKGROUND PANEL
        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                Color c1 = new Color(20, 30, 48);
                Color c2 = new Color(36, 59, 85);

                GradientPaint gp = new GradientPaint(0, 0, c1, 0, getHeight(), c2);
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        background.setLayout(null);
        setContentPane(background);

        // ================= CENTER CARD FIX =================
        int cardWidth = 400;
        int cardHeight = 420;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - cardWidth) / 2;
        int y = (screenSize.height - cardHeight) / 2;

        JPanel card = new JPanel();
        card.setBounds(x, y, cardWidth, cardHeight);
        card.setLayout(null);
        card.setBackground(new Color(255, 255, 255, 40));
        card.setBorder(BorderFactory.createLineBorder(new Color(255,255,255,80), 2));

        background.add(card);

        // TITLE
        JLabel title = new JLabel("Welcome Back");
        title.setBounds(120, 30, 200, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        card.add(title);

        // USERNAME
        JLabel user = new JLabel("Username");
        user.setBounds(50, 100, 200, 25);
        user.setForeground(Color.WHITE);
        card.add(user);

        tfusername = new JTextField();
        tfusername.setBounds(50, 130, 300, 35);
        tfusername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        card.add(tfusername);

        // PASSWORD
        JLabel pass = new JLabel("Password");
        pass.setBounds(50, 180, 200, 25);
        pass.setForeground(Color.WHITE);
        card.add(pass);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(50, 210, 300, 35);
        card.add(tfpassword);

        // LOGIN BUTTON
        login = new JButton("LOGIN");
        login.setBounds(50, 270, 300, 40);
        login.setBackground(new Color(0, 153, 255));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Segoe UI", Font.BOLD, 16));
        login.setFocusPainted(false);
        login.addActionListener(this);
        card.add(login);

        // SIGNUP BUTTON
        signup = new JButton("Sign Up");
        signup.setBounds(50, 320, 300, 35);
        signup.setBackground(new Color(46, 204, 113));
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signup.setFocusPainted(false);
        signup.addActionListener(this);
        card.add(signup);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == login) {

            try {
                String user = tfusername.getText();
                String pass = tfpassword.getText();

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(
                        "select * from account1 where username='" + user + "' and password='" + pass + "'"
                );

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Successful");
                    setVisible(false);
                    new Dashboard(user);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Login");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
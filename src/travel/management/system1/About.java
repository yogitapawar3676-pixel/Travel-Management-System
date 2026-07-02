package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    JLabel title;
    JLabel project;
    JLabel developer;
    JLabel version;
    JLabel college;
    JLabel guide;
    JTextArea description;

    JButton back;

    About() {

        setTitle("About Travel Management System");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 247, 250));

        // ================= TITLE =================

        title = new JLabel("TRAVEL MANAGEMENT SYSTEM");

        title.setBounds(140, 20, 520, 40);

        title.setFont(new Font("Segoe UI", Font.BOLD, 28));

        title.setForeground(new Color(25, 118, 210));

        add(title);

        // ================= PROJECT =================

        project = new JLabel("Project : Java Travel Management System");

        project.setBounds(50, 90, 500, 30);

        project.setFont(new Font("Segoe UI", Font.BOLD, 18));

        add(project);

        // ================= DEVELOPER =================

        developer = new JLabel("Developed By : Yogita Pawar");

        developer.setBounds(50, 130, 500, 30);

        developer.setFont(new Font("Segoe UI", Font.PLAIN, 17));

        add(developer);

        // ================= VERSION =================

        version = new JLabel("Version : 1.0");

        version.setBounds(50, 170, 300, 30);

        version.setFont(new Font("Segoe UI", Font.PLAIN, 17));

        add(version);

        // ================= COLLEGE =================

        college = new JLabel("College : Your College Name");

        college.setBounds(50, 210, 400, 30);

        college.setFont(new Font("Segoe UI", Font.PLAIN, 17));

        add(college);

        // ================= GUIDE =================

        guide = new JLabel("Project Guide : Your Guide Name");

        guide.setBounds(50, 250, 450, 30);

        guide.setFont(new Font("Segoe UI", Font.PLAIN, 17));

        add(guide);

                // ================= DESCRIPTION =================

        description = new JTextArea();

        description.setBounds(50, 300, 680, 120);

        description.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        description.setEditable(false);

        description.setLineWrap(true);

        description.setWrapStyleWord(true);

        description.setBackground(new Color(245, 247, 250));

        description.setText(
                "Travel Management System is a desktop application developed "
              + "using Java Swing, AWT, JDBC and MySQL. It helps users manage "
              + "travel packages, hotel bookings, customer details, payments "
              + "and invoices through an easy-to-use graphical interface.\n\n"
              + "This project was developed as an academic project to "
              + "demonstrate Java programming, database connectivity and GUI development."
        );

        add(description);

        // ================= BACK BUTTON =================

        back = new JButton("Back");

        back.setBounds(320, 450, 140, 40);

        back.setFont(new Font("Segoe UI", Font.BOLD, 16));

        back.setBackground(new Color(25, 118, 210));

        back.setForeground(Color.WHITE);

        back.setFocusPainted(false);

        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        back.addActionListener(this);

        add(back);

        setVisible(true);
    }

    // ================= BUTTON ACTION =================

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {

            dispose();

        }
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        new About();

    }
}
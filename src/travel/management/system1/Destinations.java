package travel.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Destinations extends JFrame implements Runnable {

    JLabel imageLabel;
    JLabel placeName;

    JButton explore;
    JButton back;

    Thread thread;

    int index = 0;

    String images[] = {

            "desti1.jpg",
            "desti2.jpg",
            "desti3.jpg",
            "desti4.jpg",
            "desti5.jpg",
            "desti6.jpg",
            "desti7.jpg",
            "desti8.jpg",
            "desti9.png",
            "desti10.jpg"
    };

    String places[] = {

            "Kaas Pathar",
            "Mahabaleshwar",
            "Raigad Fort",
            "Rajgad Fort",
            "Lonavala",
            "Konkan",
            "Panhala",
            "Lake View",
            "Panchgani",
            "Lohagad"
    };

    Destinations() {

        setTitle("Explore Destinations");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(Color.BLACK);

        // ================= IMAGE LABEL =================

        imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 1600, 900);
        add(imageLabel);

        // ================= INFO PANEL =================

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBackground(new Color(0, 0, 0, 160));
        infoPanel.setBounds(0, 500, 1600, 300);
        add(infoPanel);

        // ================= PLACE NAME =================

        placeName = new JLabel();
        placeName.setBounds(80, 30, 800, 60);
        placeName.setForeground(Color.WHITE);
        placeName.setFont(new Font("Segoe UI", Font.BOLD, 45));
        infoPanel.add(placeName);

        // ================= EXPLORE BUTTON (FIXED) =================

        explore = new JButton("Explore Now");
        explore.setBounds(80, 140, 180, 45);
        explore.setFont(new Font("Segoe UI", Font.BOLD, 15));
        explore.setBackground(new Color(46, 134, 222));
        explore.setForeground(Color.WHITE);
        explore.setFocusPainted(false);
        explore.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // IMPORTANT FIX: Safe action handling
        explore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (index >= 0 && index < places.length) {
                    JOptionPane.showMessageDialog(null,
                            "Welcome to " + places[index]);
                }
            }
        });

        infoPanel.add(explore);

        // ================= BACK BUTTON =================

        back = new JButton("Back");
        back.setBounds(290, 140, 120, 45);
        back.setFont(new Font("Segoe UI", Font.BOLD, 15));
        back.setFocusPainted(false);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        infoPanel.add(back);

        // ================= START SLIDER =================

        thread = new Thread(this);
        thread.start();

        setVisible(true);
    }

 @Override
public void run() {

    try {

        while (true) {

            String path = "icons/" + images[index];

            URL url = ClassLoader.getSystemResource(path);

            if (url == null) {

                System.out.println("Image missing: " + path);

                index++;

                if (index == images.length) {
                    index = 0;
                }

                Thread.sleep(2000);
                continue;
            }

            ImageIcon icon = new ImageIcon(url);

            Image img = icon.getImage().getScaledInstance(
                    1600,
                    900,
                    Image.SCALE_SMOOTH
            );

            imageLabel.setIcon(new ImageIcon(img));

            placeName.setText(places[index]);

            index++;

            if (index == images.length) {
                index = 0;
            }

            Thread.sleep(3000);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {

    new Destinations();

}
}
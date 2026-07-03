package travel.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Destinations extends JFrame {

    JPanel cardsPanel;
    JTextField searchField;
    JButton searchBtn;

    String[] places = {
            "Mahabaleshwar",
            "Lonavala",
            "Raigad Fort",
            "Rajgad Fort",
            "Kaas Pathar",
            "Konkan",
            "Panchgani",
            "Panhala",
            "Lohagad",
            "Lake View"
    };

    String[] images = {
            "desti2.jpg",
            "desti5.jpg",
            "desti3.jpg",
            "desti4.jpg",
            "desti1.jpg",
            "desti6.jpg",
            "desti9.png",
            "desti7.jpg",
            "desti10.jpg",
            "desti8.jpg"
    };

    public Destinations() {

        setTitle("Explore Destinations");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // ================= HEADER =================

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(25,118,210));
        topPanel.setPreferredSize(new Dimension(100,90));

        JLabel heading = new JLabel("🌍 Explore Amazing Destinations");
        heading.setFont(new Font("Segoe UI",Font.BOLD,32));
        heading.setForeground(Color.WHITE);
        heading.setBorder(BorderFactory.createEmptyBorder(20,25,20,20));

        topPanel.add(heading,BorderLayout.WEST);

        // ================= SEARCH PANEL =================

        JPanel searchPanel = new JPanel();
        searchPanel.setOpaque(false);

        searchField = new JTextField(20);
        searchField.setFont(new Font("Segoe UI",Font.PLAIN,18));

        searchBtn = new JButton("Search");
        searchBtn.setFont(new Font("Segoe UI",Font.BOLD,15));
        searchBtn.setBackground(new Color(255,140,0));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setFocusPainted(false);

        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        topPanel.add(searchPanel,BorderLayout.EAST);

        add(topPanel,BorderLayout.NORTH);

        // ================= DESTINATION PANEL =================

        cardsPanel = new JPanel();

        cardsPanel.setBackground(new Color(245,245,245));

        cardsPanel.setLayout(new GridLayout(0,3,25,25));

        cardsPanel.setBorder(
                BorderFactory.createEmptyBorder(25,25,25,25)
        );

        JScrollPane scroll = new JScrollPane(cardsPanel);

        scroll.getVerticalScrollBar().setUnitIncrement(16);

        scroll.setBorder(null);

        add(scroll,BorderLayout.CENTER);

                // ================= ADD ALL CARDS =================

        for (int i = 0; i < places.length; i++) {
            cardsPanel.add(createCard(places[i], images[i]));
        }

        setVisible(true);

    }

    // ================= CREATE CARD =================

    private JPanel createCard(String place, String imageName) {

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setPreferredSize(new Dimension(320, 360));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));

        // ================= IMAGE =================

        JLabel imageLabel = new JLabel();

        ImageIcon icon = new ImageIcon(
                ClassLoader.getSystemResource("icons/" + imageName)
        );

        Image img = icon.getImage().getScaledInstance(
                300,
                180,
                Image.SCALE_SMOOTH
        );

        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setBounds(10,10,300,180);

        card.add(imageLabel);

        // ================= PLACE NAME =================

        JLabel name = new JLabel(place);
        name.setBounds(20,200,250,30);
        name.setFont(new Font("Segoe UI",Font.BOLD,22));

        card.add(name);

        // ================= LOCATION =================

        JLabel location = new JLabel("📍 Maharashtra");
        location.setBounds(20,235,180,25);
        location.setFont(new Font("Segoe UI",Font.PLAIN,16));
        location.setForeground(Color.GRAY);

        card.add(location);

        // ================= RATING =================

        JLabel rating = new JLabel("★★★★★");
        rating.setBounds(20,260,120,25);
        rating.setForeground(new Color(255,140,0));
        rating.setFont(new Font("Segoe UI",Font.BOLD,18));

        card.add(rating);

        // ================= EXPLORE BUTTON =================

        JButton explore = new JButton("Explore");

        explore.setBounds(85,305,150,40);

        explore.setBackground(new Color(25,118,210));
        explore.setForeground(Color.WHITE);

        explore.setFocusPainted(false);

        explore.setFont(new Font("Segoe UI",Font.BOLD,16));

        explore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                showDestinationDetails(place, imageName);

            }

        });

        card.add(explore);

        return card;

    }

    // ================= DESTINATION DETAILS WINDOW =================

private void showDestinationDetails(String place, String imageName) {

    JFrame frame = new JFrame(place);

    frame.setSize(900,650);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);

    // ================= IMAGE =================

    JLabel image = new JLabel();

    ImageIcon icon = new ImageIcon(
            ClassLoader.getSystemResource("icons/" + imageName)
    );

    Image img = icon.getImage().getScaledInstance(
            850,
            300,
            Image.SCALE_SMOOTH
    );

    image.setIcon(new ImageIcon(img));
    image.setBounds(20,20,850,300);

    frame.add(image);

    // ================= TITLE =================

    JLabel title = new JLabel(place);

    title.setBounds(30,340,400,40);

    title.setFont(new Font("Segoe UI",Font.BOLD,30));

    frame.add(title);

    // ================= DESCRIPTION =================

    JTextArea info = new JTextArea();

    info.setEditable(false);

    info.setLineWrap(true);
    info.setWrapStyleWord(true);

    info.setFont(new Font("Segoe UI",Font.PLAIN,18));

    info.setBounds(30,390,820,130);

    info.setText(
            "Best Time to Visit : October - February\n\n" +
            "Estimated Budget : ₹8,000 - ₹15,000\n\n" +
            "Things To Do :\n" +
            "• Sightseeing\n" +
            "• Photography\n" +
            "• Local Food\n" +
            "• Adventure Activities\n" +
            "• Nature Walk"
    );

    frame.add(info);

    // ================= BOOK BUTTON =================

    JButton book = new JButton("Book Now");

    book.setBounds(240,550,170,45);

    book.setBackground(new Color(25,118,210));
    book.setForeground(Color.WHITE);

    book.setFont(new Font("Segoe UI",Font.BOLD,16));

    book.setFocusPainted(false);

    book.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Booking page will open here."
            );

            // Example:
            // new BookPackage(username);

        }

    });

    frame.add(book);

    // ================= CLOSE BUTTON =================

    JButton close = new JButton("Close");

    close.setBounds(450,550,170,45);

    close.setBackground(Color.DARK_GRAY);

    close.setForeground(Color.WHITE);

    close.setFont(new Font("Segoe UI",Font.BOLD,16));

    close.setFocusPainted(false);

    close.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            frame.dispose();

        }

    });

    frame.add(close);

    frame.setVisible(true);

}

// ================= SEARCH FUNCTION =================

private void performSearch() {

    String search = searchField.getText().trim().toLowerCase();

    cardsPanel.removeAll();

    for (int i = 0; i < places.length; i++) {

        if (search.isEmpty() || places[i].toLowerCase().contains(search)) {

            cardsPanel.add(createCard(places[i], images[i]));

        }

    }

    cardsPanel.revalidate();
    cardsPanel.repaint();

}

// ================= MAIN METHOD =================

public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {

            new Destinations();

        }

    });

}
}

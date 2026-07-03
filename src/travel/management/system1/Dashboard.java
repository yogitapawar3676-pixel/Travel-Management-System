package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class Dashboard extends JFrame implements ActionListener {

    String username;

    // ================= Buttons =================

    JButton addPersonDetails, viewPersonDetails, updatePersonDetails,
            deletePersonDetails, checkPackages, bookPackages,
            viewPackages, viewHotels, searchHotel,
            destinations, bookHotels, viewBookedHotels,
            payments,  abouts, exits,

            btnCustomer,
            btnPackage,
            btnHotel,
            btnPayment;

    JPanel contentPanel;
    JPanel dashboardPanel;

    // Theme Colors
    Color NAVY = new Color(15, 23, 42);
    Color SIDEBAR = new Color(30, 41, 59);
    Color BG = new Color(241, 245, 249);
    Color CARD = Color.WHITE;
    Color BLUE = new Color(37, 99, 235);

    Dashboard(String username) {

        this.username = username;

        setTitle("Travel Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setBackground(NAVY);
        header.setPreferredSize(new Dimension(0, 70));
        header.setLayout(null);

        JLabel logo = new JLabel("✈ Travel Management System");
        logo.setBounds(25, 15, 500, 40);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        logo.setForeground(Color.WHITE);
        header.add(logo);

        JLabel notification = new JLabel("🔔");
        notification.setBounds(1120, 18, 30, 30);
        notification.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        notification.setForeground(Color.WHITE);
        header.add(notification);

        JLabel welcome = new JLabel("Welcome, " + username);
        welcome.setBounds(1160, 20, 250, 25);
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 16));
        welcome.setForeground(Color.WHITE);
        header.add(welcome);

        add(header, BorderLayout.NORTH);

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(260, 0));
        sidebar.setBackground(SIDEBAR);
        sidebar.setLayout(new BorderLayout());

        JLabel menuTitle = new JLabel(" MENU");
        menuTitle.setForeground(Color.WHITE);
        menuTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        menuTitle.setBorder(new EmptyBorder(20, 20, 20, 20));

        sidebar.add(menuTitle, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(SIDEBAR);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        addPersonDetails = createMenuButton("👤 Add Customer");
        viewPersonDetails = createMenuButton("📋 View Customer");
        updatePersonDetails = createMenuButton("✏ Update Customer");
        deletePersonDetails = createMenuButton("🗑 Delete Customer");

        checkPackages = createMenuButton("📦 Check Package");
        bookPackages = createMenuButton("🎒 Book Package");
        viewPackages = createMenuButton("📄 View Packages");

        viewHotels = createMenuButton("🏨 View Hotels");
        searchHotel = createMenuButton("🔍 Search Hotel");
        bookHotels = createMenuButton("🛏 Book Hotel");
        viewBookedHotels = createMenuButton("📑 Booked Hotels");

        destinations = createMenuButton("🌍 Destinations");
        payments = createMenuButton("💳 Payments");

        abouts = createMenuButton("ℹ About");
        exits = createMenuButton("🚪 Exit");

        menuPanel.add(addPersonDetails);
        menuPanel.add(viewPersonDetails);
        menuPanel.add(updatePersonDetails);
        menuPanel.add(deletePersonDetails);

        menuPanel.add(Box.createVerticalStrut(15));

        menuPanel.add(checkPackages);
        menuPanel.add(bookPackages);
        menuPanel.add(viewPackages);

        menuPanel.add(Box.createVerticalStrut(15));

        menuPanel.add(viewHotels);
        menuPanel.add(searchHotel);
        menuPanel.add(bookHotels);
        menuPanel.add(viewBookedHotels);

        menuPanel.add(Box.createVerticalStrut(15));

        menuPanel.add(destinations);
        menuPanel.add(payments);

        menuPanel.add(Box.createVerticalStrut(15));

        menuPanel.add(abouts);
        menuPanel.add(exits);

        JScrollPane scroll = new JScrollPane(menuPanel);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(SIDEBAR);

        sidebar.add(scroll, BorderLayout.CENTER);

        add(sidebar, BorderLayout.WEST);

        // ================= CONTENT PANEL =================

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(BG);

        dashboardPanel = new JPanel();
        dashboardPanel.setBackground(BG);
        dashboardPanel.setLayout(null);

        JLabel dashTitle = new JLabel("Dashboard");
        dashTitle.setBounds(30, 20, 400, 40);
        dashTitle.setFont(new Font("Segoe UI", Font.BOLD, 34));

        dashboardPanel.add(dashTitle);

        contentPanel.add(dashboardPanel);

        add(contentPanel, BorderLayout.CENTER);

                // ================= WELCOME PANEL =================

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(null);
        welcomePanel.setBackground(Color.WHITE);
        welcomePanel.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
        welcomePanel.setBounds(30, 80, 1100, 100);

        JLabel welcomeText = new JLabel("Welcome Back, " + username + " 👋");
        welcomeText.setBounds(30, 20, 500, 35);
        welcomeText.setFont(new Font("Segoe UI", Font.BOLD, 26));

        JLabel subtitle = new JLabel("Manage your complete Travel Management System from one place.");
        subtitle.setBounds(30, 55, 700, 20);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitle.setForeground(Color.GRAY);

        welcomePanel.add(welcomeText);
        welcomePanel.add(subtitle);

        dashboardPanel.add(welcomePanel);

        // ================= DASHBOARD CARDS =================

        JPanel customerCard = createCard(
                "👤 Customers",
                "125",
                new Color(37,99,235)
        );

        customerCard.setBounds(30,210,240,130);
        dashboardPanel.add(customerCard);


        JPanel packageCard = createCard(
                "📦 Packages",
                "18",
                new Color(16,185,129)
        );

        packageCard.setBounds(300,210,240,130);
        dashboardPanel.add(packageCard);


        JPanel hotelCard = createCard(
                "🏨 Hotels",
                "35",
                new Color(249,115,22)
        );

        hotelCard.setBounds(570,210,240,130);
        dashboardPanel.add(hotelCard);


        JPanel revenueCard = createCard(
                "💰 Revenue",
                "₹2.45L",
                new Color(168,85,247)
        );

        revenueCard.setBounds(840,210,240,130);
        dashboardPanel.add(revenueCard);

                // ================= RECENT BOOKINGS =================

        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(null);
        bookingPanel.setBackground(Color.WHITE);
        bookingPanel.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
        bookingPanel.setBounds(30,370,720,300);

        JLabel bookingTitle = new JLabel("Recent Bookings");
        bookingTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        bookingTitle.setBounds(20,15,250,30);
        bookingPanel.add(bookingTitle);

        String columns[] = {
                "Customer",
                "Hotel",
                "Package",
                "Amount",
                "Status"
        };

        String data[][] = {
                {"Rahul","Taj Hotel","Goa","₹12,500","Paid"},
                {"Sneha","ITC Grand","Kashmir","₹18,000","Pending"},
                {"Amit","Leela Palace","Kerala","₹9,000","Paid"},
                {"Priya","Radisson","Manali","₹15,000","Paid"},
                {"Yogita","Marriott","Jaipur","₹10,500","Pending"}
        };

        JTable table = new JTable(data, columns);

        table.setRowHeight(28);
        table.setFont(new Font("Segoe UI", Font.PLAIN,14));
        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        table.getTableHeader().setBackground(new Color(37,99,235));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20,60,680,210);

        bookingPanel.add(scrollPane);

        dashboardPanel.add(bookingPanel);

        // ================= QUICK ACTIONS =================

        JPanel quickPanel = new JPanel();
        quickPanel.setLayout(null);
        quickPanel.setBackground(Color.WHITE);
        quickPanel.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
        quickPanel.setBounds(780,370,300,300);

        JLabel quickTitle = new JLabel("Quick Actions");
        quickTitle.setBounds(20,15,200,30);
        quickTitle.setFont(new Font("Segoe UI",Font.BOLD,22));

        quickPanel.add(quickTitle);

        btnCustomer = createQuickButton("➕ Add Customer");
        btnCustomer.setBounds(35,60,220,40);
        btnCustomer.addActionListener(this);

        btnPackage = createQuickButton("📦 Book Package");
        btnPackage.setBounds(35,115,220,40);
        btnPackage.addActionListener(this);

        btnHotel = createQuickButton("🏨 Book Hotel");
        btnHotel.setBounds(35,170,220,40);
        btnHotel.addActionListener(this);

        btnPayment = createQuickButton("💳 Payment");
        btnPayment.setBounds(35,225,220,40);
        btnPayment.addActionListener(this);

        quickPanel.add(btnCustomer);
        quickPanel.add(btnPackage);
        quickPanel.add(btnHotel);
        quickPanel.add(btnPayment);

        dashboardPanel.add(quickPanel);

        setVisible(true);

    } // ===== END OF CONSTRUCTOR =====

     // ================= createQuickButton =================

    private JButton createQuickButton(String text){

        JButton button = new JButton(text);

        button.setBackground(new Color(37,99,235));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);

        button.setFont(new Font("Segoe UI",Font.BOLD,15));

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setBorder(BorderFactory.createEmptyBorder());

        return button;
    }

        private JButton createMenuButton(String text) {

        JButton button = new JButton(text);

        button.setMaximumSize(new Dimension(240, 45));
        button.setPreferredSize(new Dimension(240, 45));

        button.setBackground(SIDEBAR);
        button.setForeground(Color.WHITE);

        button.setFont(new Font("Segoe UI", Font.BOLD, 15));

        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(this);

        return button;
        }

        private JPanel createCard(String title, String value, Color color){

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));

        JPanel top = new JPanel();
        top.setBackground(color);
        top.setBounds(0,0,240,8);

        JLabel lblTitle = new JLabel(title);
        lblTitle.setBounds(20,20,200,25);
        lblTitle.setFont(new Font("Segoe UI",Font.BOLD,18));

        JLabel lblValue = new JLabel(value);
        lblValue.setBounds(20,60,200,40);
        lblValue.setFont(new Font("Segoe UI",Font.BOLD,30));
        lblValue.setForeground(color);

        panel.add(top);
        panel.add(lblTitle);
        panel.add(lblValue);

        return panel;
        }



        // ================= ACTIONS =================

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object src = ae.getSource();

        try {

            // ================= QUICK ACTIONS =================

            if (src == btnCustomer) {

                new AddCustomer(username);

            }
            else if (src == btnPackage) {

                new BookPackage(username);

            }
            else if (src == btnHotel) {

                new BookHotel(username);

            }
            else if (src == btnPayment) {

                new Payment(username);

            }


            // ================= CUSTOMER =================

            else if (src == addPersonDetails) {

                new AddCustomer(username);

            } else if (src == viewPersonDetails) {

                new ViewCustomer(username);

            } else if (src == updatePersonDetails) {

                new UpdateCustomer(username);

            } else if (src == deletePersonDetails) {

                new DeleteDetails(username);

            }

            // ================= PACKAGE =================

            else if (src == checkPackages) {

                new CheckPackage();

            } else if (src == bookPackages) {

                new BookPackage(username);

            } else if (src == viewPackages) {

                new ViewPackage(username);

            }

            // ================= HOTEL =================

            
            else if (src == viewHotels) {

                System.out.println("View Hotel clicked");

                new ViewHotel(username);


            } else if (src == searchHotel) {

                new SearchHotel();

            } else if (src == bookHotels) {

                new BookHotel(username);

            } else if (src == viewBookedHotels) {

                new ViewBookedHotel(username);

            }

            // ================= PAYMENT =================

            else if (src == payments) {

                new Payment(username);

            } 

            // ================= OTHER =================

            else if (src == destinations) {

                new Destinations();

            }else if (src == abouts) {

                new About();

        }
            
            else if (src == exits) {

                dispose();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // ================= MAIN =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new Dashboard("Admin");

            }

        });

    }

}

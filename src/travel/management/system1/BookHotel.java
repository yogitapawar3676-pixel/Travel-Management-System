package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class BookHotel extends JFrame implements ActionListener {

    String username;

    // Customer Details
    JLabel lblUsernameValue;
    JLabel lblIdValue;
    JLabel lblNumberValue;
    JLabel lblPhoneValue;

    // Hotel Details
    JComboBox<String> cbHotel;
    JComboBox<String> cbRoomType;
    JComboBox<String> cbAC;
    JComboBox<String> cbFood;

    JTextField tfPersons;
    JTextField tfDays;

    JCheckBox wifi;
    JCheckBox swimming;
    JCheckBox laundry;
    JCheckBox pickup;
    JCheckBox parking;

    JLabel lblHotelImage;

    // Price Summary
    JLabel lblRoomPrice;
    JLabel lblGST;
    JLabel lblExtra;
    JLabel lblGrandTotal;

    JButton btnCalculate;
    JButton btnBook;
    JButton btnReset;
    JButton btnBack;

    int roomCost = 0;
    int totalAmount = 0;

    public BookHotel(String username){

        this.username=username;

        setTitle("Book Hotel");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(null);

        getContentPane().setBackground(new Color(240,244,248));

        // ================= HEADER =================

        JPanel header=new JPanel();

        header.setBounds(0,0,1600,70);

        header.setBackground(new Color(20,30,48));

        header.setLayout(null);

        add(header);

        JLabel title=new JLabel("BOOK HOTEL");

        title.setForeground(Color.WHITE);

        title.setFont(new Font("Segoe UI",Font.BOLD,30));

        title.setBounds(40,15,400,40);

        header.add(title);

        JLabel subtitle=new JLabel("Choose your perfect stay");

        subtitle.setForeground(Color.LIGHT_GRAY);

        subtitle.setBounds(45,45,300,20);

        header.add(subtitle);

        // ================= CUSTOMER PANEL =================

        JPanel customerPanel=new JPanel();

        customerPanel.setLayout(null);

        customerPanel.setBounds(25,90,400,600);

        customerPanel.setBackground(Color.WHITE);

        customerPanel.setBorder(new LineBorder(new Color(220,220,220)));

        add(customerPanel);

        JLabel customerTitle=new JLabel("Customer Details");

        customerTitle.setFont(new Font("Segoe UI",Font.BOLD,20));

        customerTitle.setBounds(20,20,250,30);

        customerPanel.add(customerTitle);

        addLabel(customerPanel,"Username",70);

        lblUsernameValue=new JLabel();

        addValue(customerPanel,lblUsernameValue,70);

        addLabel(customerPanel,"ID",120);

        lblIdValue=new JLabel();

        addValue(customerPanel,lblIdValue,120);

        addLabel(customerPanel,"Number",170);

        lblNumberValue=new JLabel();

        addValue(customerPanel,lblNumberValue,170);

        addLabel(customerPanel,"Phone",220);

        lblPhoneValue=new JLabel();

        addValue(customerPanel,lblPhoneValue,220);

        // ================= BOOKING PANEL =================

        JPanel bookingPanel=new JPanel();

        bookingPanel.setLayout(null);

        bookingPanel.setBounds(450,90,500,600);

        bookingPanel.setBackground(Color.WHITE);

        bookingPanel.setBorder(new LineBorder(new Color(220,220,220)));

        add(bookingPanel);

        JLabel bookingTitle=new JLabel("Booking Details");

        bookingTitle.setFont(new Font("Segoe UI",Font.BOLD,20));

        bookingTitle.setBounds(20,20,250,30);

        bookingPanel.add(bookingTitle);

        JLabel hotelLabel=new JLabel("Select Hotel");

        hotelLabel.setBounds(30,80,150,25);

        bookingPanel.add(hotelLabel);

        cbHotel=new JComboBox<>();

        cbHotel.setBounds(200,80,230,30);

        bookingPanel.add(cbHotel);

        JLabel roomLabel=new JLabel("Room Type");

        roomLabel.setBounds(30,130,150,25);

        bookingPanel.add(roomLabel);

        cbRoomType=new JComboBox<>();

        cbRoomType.addItem("Standard");

        cbRoomType.addItem("Deluxe");

        cbRoomType.addItem("Premium");

        cbRoomType.addItem("Suite");

        cbRoomType.setBounds(200,130,230,30);

        bookingPanel.add(cbRoomType);

        JLabel personsLabel=new JLabel("Persons");

        personsLabel.setBounds(30,180,150,25);

        bookingPanel.add(personsLabel);

        tfPersons=new JTextField();

        tfPersons.setBounds(200,180,230,30);

        bookingPanel.add(tfPersons);

        JLabel daysLabel=new JLabel("Days");

        daysLabel.setBounds(30,230,150,25);

        bookingPanel.add(daysLabel);

        tfDays=new JTextField();

        tfDays.setBounds(200,230,230,30);

        bookingPanel.add(tfDays);

        JLabel acLabel=new JLabel("AC / NON AC");

        acLabel.setBounds(30,280,150,25);

        bookingPanel.add(acLabel);

        cbAC=new JComboBox<>();

        cbAC.addItem("AC");

        cbAC.addItem("Non AC");

        cbAC.setBounds(200,280,230,30);

        bookingPanel.add(cbAC);

        JLabel foodLabel=new JLabel("Food");

        foodLabel.setBounds(30,330,150,25);

        bookingPanel.add(foodLabel);

        cbFood=new JComboBox<>();

        cbFood.addItem("Included");

        cbFood.addItem("Not Included");

        cbFood.setBounds(200,330,230,30);

        bookingPanel.add(cbFood);

        JLabel serviceLabel=new JLabel("Extra Services");

        serviceLabel.setBounds(30,390,200,25);

        bookingPanel.add(serviceLabel);

        wifi=new JCheckBox("WiFi");

        swimming=new JCheckBox("Swimming Pool");

        laundry=new JCheckBox("Laundry");

        pickup=new JCheckBox("Airport Pickup");

        parking=new JCheckBox("Parking");

        wifi.setBounds(200,390,150,25);

        swimming.setBounds(200,420,180,25);

        laundry.setBounds(200,450,150,25);

        pickup.setBounds(200,480,180,25);

        parking.setBounds(200,510,150,25);

        bookingPanel.add(wifi);

        bookingPanel.add(swimming);

        bookingPanel.add(laundry);

        bookingPanel.add(pickup);

        bookingPanel.add(parking);

                // ================= RIGHT PANEL =================

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(980, 90, 500, 600);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(new LineBorder(new Color(220,220,220)));
        add(rightPanel);

        JLabel summaryTitle = new JLabel("Hotel Preview & Price");
        summaryTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        summaryTitle.setBounds(20,20,300,30);
        rightPanel.add(summaryTitle);

        lblHotelImage = new JLabel();

        lblHotelImage.setBounds(50,70,400,220);
        lblHotelImage.setHorizontalAlignment(JLabel.CENTER);
        lblHotelImage.setBorder(new LineBorder(Color.LIGHT_GRAY));

        
        rightPanel.add(lblHotelImage);

        JLabel priceTitle = new JLabel("Price Summary");

        priceTitle.setFont(new Font("Segoe UI",Font.BOLD,18));

        priceTitle.setBounds(20,320,200,30);

        rightPanel.add(priceTitle);

        JLabel roomLbl = new JLabel("Room Price");

        roomLbl.setBounds(40,370,150,25);

        rightPanel.add(roomLbl);

        lblRoomPrice = new JLabel("₹ 0");

        lblRoomPrice.setBounds(320,370,120,25);

        lblRoomPrice.setHorizontalAlignment(JLabel.RIGHT);

        rightPanel.add(lblRoomPrice);

        JLabel extraLbl = new JLabel("Extra Services");

        extraLbl.setBounds(40,410,150,25);

        rightPanel.add(extraLbl);

        lblExtra = new JLabel("₹ 0");

        lblExtra.setHorizontalAlignment(JLabel.RIGHT);

        lblExtra.setBounds(320,410,120,25);

        rightPanel.add(lblExtra);

        JLabel gstLbl = new JLabel("GST (18%)");

        gstLbl.setBounds(40,450,150,25);

        rightPanel.add(gstLbl);

        lblGST = new JLabel("₹ 0");

        lblGST.setHorizontalAlignment(JLabel.RIGHT);

        lblGST.setBounds(320,450,120,25);

        rightPanel.add(lblGST);

        JSeparator sp = new JSeparator();

        sp.setBounds(30,490,420,10);

        rightPanel.add(sp);

        JLabel totalLbl = new JLabel("Grand Total");

        totalLbl.setFont(new Font("Segoe UI",Font.BOLD,18));

        totalLbl.setBounds(40,510,180,30);

        rightPanel.add(totalLbl);

        lblGrandTotal = new JLabel("₹ 0");

        lblGrandTotal.setHorizontalAlignment(JLabel.RIGHT);

        lblGrandTotal.setFont(new Font("Segoe UI",Font.BOLD,20));

        lblGrandTotal.setForeground(new Color(39,174,96));

        lblGrandTotal.setBounds(250,510,180,30);

        rightPanel.add(lblGrandTotal);

        // ================= BUTTONS =================

        btnCalculate = new JButton("Calculate Price");

        btnCalculate.setBounds(40,550,160,40);

        btnCalculate.setBackground(new Color(52,152,219));

        btnCalculate.setForeground(Color.WHITE);

        btnCalculate.setFocusPainted(false);

        btnCalculate.addActionListener(this);

        rightPanel.add(btnCalculate);

        btnBook = new JButton("Book Now");

        btnBook.setBounds(210,550,120,40);

        btnBook.setBackground(new Color(46,204,113));

        btnBook.setForeground(Color.WHITE);

        btnBook.setFocusPainted(false);

        btnBook.addActionListener(this);

        rightPanel.add(btnBook);

        btnBack = new JButton("Back");

        btnBack.setBounds(340,550,100,40);

        btnBack.setBackground(new Color(231,76,60));

        btnBack.setForeground(Color.WHITE);

        btnBack.setFocusPainted(false);

        btnBack.addActionListener(this);

        rightPanel.add(btnBack);

        // ================= LOAD CUSTOMER =================

        try{

            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery(
                    "select * from customer where username='"+username+"'");

            if(rs.next()){

                lblUsernameValue.setText(rs.getString("username"));
                lblIdValue.setText(rs.getString("id"));
                lblNumberValue.setText(rs.getString("number"));
                lblPhoneValue.setText(rs.getString("phone"));

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        // ================= LOAD HOTELS =================

        try{

            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from hotel");

            while(rs.next()){

                cbHotel.addItem(rs.getString("name"));

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        setVisible(true);

    }

    // ================= HELPER METHODS =================

    public void addLabel(JPanel panel,String text,int y){

        JLabel l = new JLabel(text);

        l.setBounds(25,y,130,25);

        l.setFont(new Font("Segoe UI",Font.BOLD,15));

        panel.add(l);

    }

    public void addValue(JPanel panel,JLabel value,int y){

        value.setBounds(180,y,180,25);

        value.setFont(new Font("Segoe UI",Font.PLAIN,15));

        panel.add(value);

    }
        @Override
    public void actionPerformed(ActionEvent ae) {

        // ================= CALCULATE PRICE =================

        if (ae.getSource() == btnCalculate) {

            try {

                int persons = Integer.parseInt(tfPersons.getText());
                int days = Integer.parseInt(tfDays.getText());

                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(
                        "select * from hotel where name='" +
                                cbHotel.getSelectedItem() + "'");

                if (rs.next()) {

                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int acCharge = Integer.parseInt(rs.getString("acroom"));
                    int foodCharge = Integer.parseInt(rs.getString("foodincluded"));

                    roomCost = cost * persons * days;

                    int extras = 0;

                    // AC Charges
                    if (cbAC.getSelectedItem().equals("AC")) {
                        extras += acCharge * persons * days;
                    }

                    // Food Charges
                    if (cbFood.getSelectedItem().equals("Included")) {
                        extras += foodCharge * persons * days;
                    }

                    // Extra Services
                    if (wifi.isSelected())
                        extras += 300;

                    if (swimming.isSelected())
                        extras += 500;

                    if (laundry.isSelected())
                        extras += 400;

                    if (pickup.isSelected())
                        extras += 800;

                    if (parking.isSelected())
                        extras += 200;

                    int subtotal = roomCost + extras;

                    int gst = (int) (subtotal * 0.18);

                    totalAmount = subtotal + gst;

                    lblRoomPrice.setText("₹ " + roomCost);
                    lblExtra.setText("₹ " + extras);
                    lblGST.setText("₹ " + gst);
                    lblGrandTotal.setText("₹ " + totalAmount);

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid values.");

            }

        }

        // ================= BOOK HOTEL =================

        else if (ae.getSource() == btnBook) {

            try {

                Conn c = new Conn();

                String query =
                        "insert into bookhotel values('" +

                                lblUsernameValue.getText() + "','" +

                                cbHotel.getSelectedItem() + "','" +

                                tfPersons.getText() + "','" +

                                tfDays.getText() + "','" +

                                cbAC.getSelectedItem() + "','" +

                                cbFood.getSelectedItem() + "','" +

                                lblIdValue.getText() + "','" +

                                lblNumberValue.getText() + "','" +

                                lblPhoneValue.getText() + "','" +

                                "₹ " + totalAmount + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        this,
                        "Hotel Booked Successfully!");

                setVisible(false);

            }

            catch(Exception e){

                e.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Booking Failed");

            }

        }
                // ================= BACK BUTTON =================

        else if (ae.getSource() == btnBack) {

            setVisible(false);

        }

    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new BookHotel("Rambo");

            }

        });

    }

}
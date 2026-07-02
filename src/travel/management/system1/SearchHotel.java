package travel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SearchHotel extends JFrame implements ActionListener {

    JTextField searchField;
    JButton search;
    JTextArea result;

    SearchHotel(){

        setBounds(400,200,600,400);
        setLayout(null);

        JLabel title = new JLabel("Search Hotel");
        title.setBounds(250,20,150,30);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        add(title);


        JLabel name = new JLabel("Hotel Name");
        name.setBounds(50,80,100,25);
        add(name);


        searchField = new JTextField();
        searchField.setBounds(160,80,200,25);
        add(searchField);


        search = new JButton("Search");
        search.setBounds(380,80,100,25);
        search.addActionListener(this);
        add(search);



        result = new JTextArea();
        result.setBounds(50,140,450,150);
        add(result);


        setVisible(true);

    }


    public void actionPerformed(ActionEvent e){

        if(e.getSource()==search){

            String hotelName = searchField.getText();


            try{

                Conn c = new Conn();


                String query =
                "select * from hotel where name like '%"+hotelName+"%'";


                ResultSet rs = c.s.executeQuery(query);


                result.setText("");

                while(rs.next()){

                    result.append(
                    "Hotel Name : "
                    +rs.getString("name")
                    +"\nPrice : "
                    +rs.getString("costperperson")
                    +"\nAC Room : "
                    +rs.getString("acroom")
                    +"\nFood : "
                    +rs.getString("foodincluded")
                    +"\n\n"
                    );

                }


            }
            catch(Exception ex){

                ex.printStackTrace();

            }

        }

    }



    public static void main(String args[]){

        new SearchHotel();

    }

}
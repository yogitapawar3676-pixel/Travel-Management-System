
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 

/**
 *
 * @author akans
 */
package travel.management.system1;

import java.awt.*;
import javax.swing.*;

public class Paytm extends JFrame {

    public Paytm() {

        setLayout(null);

        setBounds(600, 220, 800, 600);

        setTitle("Paytm Payment");


        JLabel label = new JLabel("Paytm Payment Page");

        label.setFont(new Font("Raleway", Font.BOLD, 30));

        label.setBounds(200, 50, 400, 50);

        add(label);


        JButton back = new JButton("Back");

        back.setBounds(350, 150, 100, 40);

        back.addActionListener(e -> {

            setVisible(false);

        });

        add(back);


        getContentPane().setBackground(Color.WHITE);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }


    public static void main(String[] args) {

        new Paytm();

    }

}
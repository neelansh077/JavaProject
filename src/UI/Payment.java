package UI;

import javax.swing.*;
import java.awt.*;

public class Payment {
    public static void main(String[] args) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel welcome = new JLabel("Payment");
        welcome.setBounds(10, 10, 165, 25);
        welcome.setFont(new Font("Arial", Font.PLAIN, 28));
        panel.add(welcome);

        JLabel selectStation = new JLabel("Choose a Payment Method");
        selectStation.setBounds(90, 50, 250, 25);
        selectStation.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(selectStation);

        String[] animals = {"Lion PAY", "PAYTM", "Phone Pay", "GAND PAY"};
        JComboBox<String> comboBox = new JComboBox<>(animals);
        comboBox.setBounds(150, 65, 120, 45);
        panel.add(comboBox);

        JButton button = new JButton("Book Ticket");
        button.setBounds(150, 105, 100, 25);
        panel.add(button);

        frame.setVisible(true);




//        JLabel welcome = new JLabel("Welcome");
//        welcome.setBounds(10, 10, 80, 25);
//        panel.add(welcome);

//        JLabel userLabel = new JLabel("User");
//        userLabel.setBounds(10, 20, 80, 25);
//        panel.add(userLabel);

//        JTextField userText = new JTextField(20);
//        userText.setBounds(100, 20, 165, 25);
//        panel.add(userText);

//        JLabel passwordLabel = new JLabel("Password");
//        passwordLabel.setBounds(10, 50, 80, 25);
//        panel.add( passwordLabel);

//        JPasswordField passwordText = new JPasswordField();
//        passwordText.setBounds(100, 50, 165, 25);
//        panel.add(passwordText);

    }
}

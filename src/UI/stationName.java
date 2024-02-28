package UI;

import javax.swing.*;
import java.awt.*;

public class stationName {
    public static void main(String[] args) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel stationName = new JLabel("{Station_Name}");
        stationName.setBounds(10, 10, 200, 25);
        stationName.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(stationName);

        JLabel routeStart = new JLabel("Next train to {route_start}");
        routeStart.setBounds(10, 50, 200, 25);
        routeStart.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(routeStart);

        JTextField userText = new JTextField(20);
        userText.setBounds(10, 72, 200, 25);
        panel.add(userText);

        JLabel routeEnd = new JLabel("Next train to {route_end}");
        routeEnd.setBounds(10, 100, 200, 25);
        routeEnd.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(routeEnd);

        JTextField userTxt = new JTextField(20);
        userTxt.setBounds(10, 122, 200, 25);
        panel.add(userTxt);

        JLabel chooseDestination = new JLabel("Choose Destination");
        chooseDestination.setBounds(260, 75, 200, 25);
        chooseDestination.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(chooseDestination);

        // DROP DOWN AYEGA ISKE NEECHE
        String[] animals = {"Dog", "Cat", "Fish", "Lion"};
        JComboBox<String> comboBox = new JComboBox<>(animals);
        comboBox.setBounds(274, 95, 100, 35);
        panel.add(comboBox);

        JButton bookTicket = new JButton("Book Ticket");
        bookTicket.setBounds(274, 130, 100, 25);
        panel.add(bookTicket);
        frame.setVisible(true);
    }
}
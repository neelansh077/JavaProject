package UI;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

public class Manager {
    private JPanel panel;
    private JFrame frame;

    private String selStation;

    public Manager(){
        this.panel = new JPanel();
        this.frame = new JFrame();

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);
        // frame.setVisible(true);
        Welcome();
    }

    void Welcome() {

        JLabel welcome = new JLabel("Welcome");
        welcome.setBounds(150, 10, 165, 25);
        welcome.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(welcome);

        JLabel selectStation = new JLabel("Select Station");
        selectStation.setBounds(147, 50, 165, 25);
        selectStation.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(selectStation);

        String[] stations = { "Andheri W", "Lower Oshiwara", "Oshiwara" };
        JComboBox<String> comboBox = new JComboBox<>(stations);
        comboBox.setBounds(150, 65, 100, 35);
        panel.add(comboBox);

        JButton button = new JButton("Submit");
        button.setBounds(150, 105, 100, 25);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                selStation = comboBox.getItemAt(comboBox.getSelectedIndex());
                panel.removeAll();
                StationPage();
            }
        });
        panel.add(button);

        frame.setVisible(true);
    }

    void StationPage() {
        JLabel stationName = new JLabel(selStation);
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

        String[] animals = {"Dog", "Cat", "Fish", "Lion"};
        JComboBox<String> comboBox = new JComboBox<>(animals);
        comboBox.setBounds(274, 95, 100, 35);
        panel.add(comboBox);

        JButton bookTicket = new JButton("Book Ticket");
        bookTicket.setBounds(274, 130, 100, 25);
        panel.add(bookTicket);

        panel.revalidate();
        panel.repaint();
        // frame.setVisible(true);
    }

    void Payment(){
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
        
        panel.revalidate();
        panel.repaint();
        // frame.setVisible(true);
    }
}
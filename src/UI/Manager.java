package UI;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;

import Backend.*;

public class Manager {
    private JPanel panel;
    private JFrame frame;

    private String selStation;
    private String desStation;
    private int fare;
    private int sCardPin;
    private String sCardNum;
    private Data data = new Data();

    public Manager() {
        this.panel = new JPanel();
        this.frame = new JFrame();

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);
        // frame.setVisible(true);
        Welcome();
    }

    void Welcome() {

        JLabel welcome = new JLabel("Welcome");
        welcome.setBounds(200, 10, 165, 25);
        welcome.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(welcome);

        JLabel selectStation = new JLabel("Select Station");
        selectStation.setBounds(196, 70, 165, 25);
        selectStation.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(selectStation);

        String[] stations = data.getStationList();
        JComboBox<String> comboBox = new JComboBox<>(stations);
        comboBox.setBounds(200, 100, 100, 35);
        panel.add(comboBox);

        JButton button = new JButton("Submit");
        button.setBounds(200, 150, 100, 25);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

        JLabel routeStart = new JLabel("Next train to " + (data.getStationList()[0]));
        routeStart.setBounds(10, 50, 200, 25);
        routeStart.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(routeStart);

        JLabel userText = new JLabel("NA");
        for (int i = 0; i < data.getTrainCount(); i++) {
            if (data.getTrains()[i].getDirection() == 1
                    && data.getStationList()[data.getTrains()[i].getCurrStation() - 1] == selStation) {
                userText = new JLabel(String.valueOf(data.getTrains()[i].getTimeNextStation()));
            }
        }
        userText.setBounds(10, 72, 200, 25);
        panel.add(userText);

        JLabel routeEnd = new JLabel("Next train to " + data.getStationList()[data.getStationCount() - 1]);
        routeEnd.setBounds(10, 100, 200, 25);
        routeEnd.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(routeEnd);

        JLabel userTxt = new JLabel("NA");
        for (int i = 0; i < data.getTrainCount(); i++) {
            // System.out.println(data.getStationList()[data.getTrains()[i].getCurrStation()
            // + 1]);
            // System.out.println(String.valueOf(data.getTrains()[i].getTimeNextStation()));
            if (data.getTrains()[i].getDirection() == 0) {
                System.out.println(data.getTrains()[i].getCurrStation());
                if (data.getStationList()[data.getTrains()[i].getCurrStation() + 1] == selStation) {
                    userTxt = new JLabel(String.valueOf(data.getTrains()[i].getTimeNextStation()));
                }
            }
        }

        userTxt.setBounds(10, 122, 200, 25);
        panel.add(userTxt);

        JLabel chooseDestination = new JLabel("Choose Destination");
        chooseDestination.setBounds(260, 10, 200, 25);
        chooseDestination.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(chooseDestination);

        JComboBox<String> comboBox = new JComboBox<>(data.getStationList());
        comboBox.setBounds(274, 50, 100, 35);
        panel.add(comboBox);

        JButton bookTicket = new JButton("Book Ticket");
        bookTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                desStation = comboBox.getItemAt(comboBox.getSelectedIndex());
                data.endTimer();
                panel.removeAll();
                Payment();
            }
        });
        bookTicket.setBounds(274, 100, 100, 25);
        panel.add(bookTicket);

        JButton refresh = new JButton("Refresh");
        refresh.setBounds(274, 150, 100, 25);
        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // selStation = comboBox.getItemAt(comboBox.getSelectedIndex());
                panel.removeAll();
                StationPage();
            }
        });
        panel.add(refresh);

        panel.revalidate();
        panel.repaint();

        class updatePage extends TimerTask {
            public void run() {
                panel.removeAll();
                StationPage();
            }
        }

        data.timer.schedule(new updatePage(), 5000);
        // frame.setVisible(true);
    }

    int getIndex(String StationName) {
        for (int i = 0; i < data.getStationCount(); i++) {
            if (data.getStationList()[i] == StationName) {
                return i;
            }
        }
        return -1;
    }

    void calculateFare() {
        int distance = getIndex(desStation) - getIndex(selStation);
        this.fare = distance * 10;
    }

    void Payment() {
        calculateFare();

        JLabel welcome = new JLabel("Payment");
        welcome.setBounds(10, 10, 165, 25);
        welcome.setFont(new Font("Arial", Font.PLAIN, 28));
        panel.add(welcome);

        JLabel selectStation = new JLabel("Choose a Payment Method");
        selectStation.setBounds(140, 50, 250, 25);
        selectStation.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(selectStation);

        JLabel fare = new JLabel("Fare: " + this.fare);
        fare.setBounds(200, 75, 250, 25);
        fare.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(fare);

        String[] payment = { "Smart Card", "PAYTM", "Phone Pe", "G PAY", "BHIM UPI" };
        JComboBox<String> comboBox = new JComboBox<>(payment);
        comboBox.setBounds(200, 100, 120, 45);
        panel.add(comboBox);

        JButton button = new JButton("Book Ticket");
        button.setBounds(200, 150, 100, 25);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // selStation = comboBox.getItemAt(comboBox.getSelectedIndex());
                panel.removeAll();
                SmartCard();
            }
        });
        panel.add(button);

        panel.revalidate();
        panel.repaint();
        // frame.setVisible(true);
    }

    int validateSmartCard() {
        for (SmartCard card : data.getSmartCards()) {
            if (card.getCardNum().equals(sCardNum) && card.getCardPin() == sCardPin) {
                if (card.getBalance() > fare) {
                    card.setBalance(card.getBalance() - fare);
                    return card.getBalance();
                }
                return 1;
            }
        }
        return 0;
    }

    void SmartCard() {
        JLabel smartCard = new JLabel("Smart-Card");
        smartCard.setBounds(10, 10, 165, 25);
        smartCard.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(smartCard);

        JLabel txt = new JLabel("Scan your card on");
        txt.setBounds(30, 100, 500, 30);
        txt.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(txt);

        JLabel or = new JLabel("OR");
        or.setBounds(215, 118, 500, 30);
        or.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(or);

        JLabel txt2 = new JLabel("card machine");
        txt2.setBounds(52, 118, 500, 30);
        txt2.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(txt2);

        JLabel status = new JLabel("");
        status.setBounds(10, 200, 500, 30);
        status.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(status);

        JButton bal = new JButton("Add Balance");
        bal.setBounds(10, 230, 150, 30);
        bal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                addBalance();
            }
        });

        JLabel cardNumber = new JLabel("Enter Card Number");
        cardNumber.setBounds(260, 70, 500, 30);
        cardNumber.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(cardNumber);

        JTextField cardNum = new JTextField(20);
        cardNum.setBounds(265, 99, 150, 20);
        panel.add(cardNum);

        JLabel pin = new JLabel("Enter Pin");
        pin.setBounds(300, 130, 500, 30);
        pin.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(pin);

        JTextField enterPin = new JTextField(20);
        enterPin.setBounds(265, 159, 150, 20);
        panel.add(enterPin);

        JButton pay = new JButton("Pay");
        pay.setBounds(300, 189, 60, 30);
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sCardNum = (cardNum.getText());
                sCardPin = Integer.parseInt(enterPin.getText());
                int res = validateSmartCard();
                if (res == 0) {
                    status.setText("Incorrect Card Number or PIN");
                } else if (res == 1) {
                    status.setText("Card Balance Low");
                    panel.add(bal);

                } else {
                    status.setText("Payment Done, Remaining Balance: " + res);
                    panel.add(bal);
                }
            }
        });
        panel.add(pay);

        panel.revalidate();
        panel.repaint();
    }

    void addBalance() {
        JLabel title = new JLabel("Add Balance");
        title.setBounds(10, 10, 165, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(title);

        JLabel txt = new JLabel("Choose Amount: ");
        txt.setBounds(30, 100, 500, 30);
        txt.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(txt);

        JTextField balInput = new JTextField(20);
        balInput.setBounds(30, 150, 150, 20);
        panel.add(balInput);

        JLabel status = new JLabel("");
        status.setBounds(10, 175, 500, 30);
        status.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(status);

        JButton pay = new JButton("Add");
        pay.setBounds(30, 200, 60, 30);
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (SmartCard card : data.getSmartCards()) {
                    if (card.getCardNum().equals(sCardNum) && card.getCardPin() == sCardPin) {
                        card.setBalance(card.getBalance() + Integer.parseInt(balInput.getText()));
                        status.setText("Balance Updated, New Balance: " + card.getBalance());
                    }
                }
            }
        });
        panel.add(pay);

        panel.revalidate();
        panel.repaint();
    }
}
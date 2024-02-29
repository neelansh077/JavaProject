package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Manager {
    public Manager(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        Welcome welcome = new Welcome(panel, frame);
    }
}
package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class ParkingView extends JFrame {
        JFrame frame = new JFrame();

    public ParkingView(){
        createFrame();
    }

    public void createFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Parking View");
        JOptionPane.showMessageDialog(frame, "Parking View", "Parking View", JOptionPane.OK_OPTION);
        userlogInFrame();
    }

    public void modifyFrame(String title, JPanel panel) {
        frame.setVisible(false);
        frame.setTitle(title);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void userlogInFrame(){
        JPanel loginPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        loginPanel.add(loginButton);
        modifyFrame("Login", loginPanel);

    }

    public void userlogOutFrame(){
        JPanel logOutPanel = new JPanel();
        JButton logoutButton = new JButton("Logout");
        logOutPanel.add(logoutButton);
        modifyFrame("Logout", logOutPanel);
    }

}

package co.edu.uptc.view.panels;

import javax.swing.*;
import java.awt.*;

public abstract class MenuPanel extends JPanel {
    protected JLabel titleLabel;
    protected JPanel buttonPanel;

    public MenuPanel(String title) {
        setLayout(new BorderLayout());
        titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 10, 10));
        add(buttonPanel, BorderLayout.CENTER);

        setupButtons();
    }

    protected abstract void setupButtons();
}



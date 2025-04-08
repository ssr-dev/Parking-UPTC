package co.edu.uptc.view.panels;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

public abstract class MenuPanel extends JPanel implements ActionListener{

    public MenuPanel(String title, String imagePath) {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);

        JPanel buttonPanelWrapper = new JPanel(new GridBagLayout());
        buttonPanelWrapper.setBackground(Color.LIGHT_GRAY);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        buttonPanelWrapper.add(buttonPanel);
        mainPanel.add(buttonPanelWrapper, BorderLayout.CENTER);

        JLabel imageLabel = createImageLabel(imagePath);
        if (imageLabel != null) {
            JPanel imagePanel = new JPanel(new BorderLayout());
            imagePanel.setBackground(Color.LIGHT_GRAY);
            imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            imagePanel.add(imageLabel, BorderLayout.CENTER);
            mainPanel.add(imagePanel, BorderLayout.EAST);
        }

        add(mainPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        JButton logoutButton = new JButton("Cerrar sesión");
        logoutButton.setPreferredSize(new Dimension(150, 35));
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 14));
        logoutButton.setBackground(new Color(240, 200, 200));
        logoutButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        logoutButton.addActionListener(e -> logout());
        bottomPanel.add(logoutButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setupButtons(); // agrega los botones específicos del panel hijo
    }

    protected JPanel buttonPanel;

    protected abstract void setupButtons();

    protected void addStyledButton(String text, int y) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(300, 40));
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setFocusPainted(false);
        button.setBackground(new Color(220, 230, 245));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        buttonPanel.add(Box.createVerticalStrut(15)); // Espaciado entre botones
        buttonPanel.add(button);
    }

    private JLabel createImageLabel(String path) {
        try {
            if (path == null || path.isEmpty()) return null;
            ImageIcon icon = new ImageIcon(
                    Objects.requireNonNull(getClass().getClassLoader().getResource(path))
            );
            Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(img));
        } catch (Exception e) {
            System.err.println("No se pudo cargar la imagen: " + path);
            return null;
        }
    }

    protected void logout() {
        JOptionPane.showMessageDialog(this, "Sesión cerrada.");
    }
}


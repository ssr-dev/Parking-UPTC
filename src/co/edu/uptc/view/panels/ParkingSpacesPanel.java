package co.edu.uptc.view.panels;

import co.edu.uptc.presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingSpacesPanel extends JPanel implements ActionListener {
    private JLabel availableSpacesLabel;
    private JLabel alertTitle;
    private JLabel alertMessage;
    private Presenter presenter;
    private JButton backButton;

    public ParkingSpacesPanel(int availableSpaces, boolean isAvailable) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Parking UPTC", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        JLabel subtitleLabel = new JLabel("Espacios disponibles:", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        availableSpacesLabel = new JLabel(String.valueOf(availableSpaces), SwingConstants.CENTER);
        availableSpacesLabel.setFont(new Font("Arial", Font.BOLD, 48));
        availableSpacesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        availableSpacesLabel.setForeground(new Color(0, 102, 204));

        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        headerPanel.add(availableSpacesLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        add(headerPanel, BorderLayout.CENTER);

        // Panel inferior (alertas + botón)
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(Color.LIGHT_GRAY);
        southPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Panel de alerta
        JPanel alertPanel = new JPanel(new GridLayout(2, 1));
        alertPanel.setBackground(Color.LIGHT_GRAY);

        alertTitle = new JLabel("", SwingConstants.CENTER);
        alertTitle.setFont(new Font("Arial", Font.BOLD, 22));
        alertMessage = new JLabel("", SwingConstants.CENTER);
        alertMessage.setFont(new Font("Arial", Font.PLAIN, 16));

        if (!isAvailable) {
            alertTitle.setText("Alerta");
            alertTitle.setForeground(Color.RED);
            alertMessage.setText("Quedan menos de 5 espacios disponibles.");
        } else {
            alertTitle.setText("Disponibilidad óptima");
            alertTitle.setForeground(new Color(0, 153, 0));
            alertMessage.setText("Hay espacios libres para estacionar sin problemas");
        }

        alertPanel.add(alertTitle);
        alertPanel.add(alertMessage);
        southPanel.add(alertPanel, BorderLayout.CENTER);

        // Botón de volver
        backButton = new JButton("Atrás");
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(new Color(220, 220, 220));
        backButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        backButton.addActionListener(this);

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.setBackground(Color.LIGHT_GRAY);
        backButtonPanel.add(backButton);
        southPanel.add(backButtonPanel, BorderLayout.WEST);

        add(southPanel, BorderLayout.SOUTH);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton && presenter != null) {
            presenter.logOutToReceptionistMenu();
        }
    }
}

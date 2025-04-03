package co.edu.uptc.view.panels;

import javax.swing.*;
import java.awt.*;

public class VehicleEntryPanel extends JPanel {
    private JTextField licensePlateField;
    private JButton generateTicketButton;

    public VehicleEntryPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel title = new JLabel("Ingreso de Vehículo", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        licensePlateField = new JTextField();
        formPanel.add(new JLabel("Placa del vehículo:"));
        formPanel.add(licensePlateField);

        add(formPanel, BorderLayout.CENTER);

        generateTicketButton = new JButton("Generar Ticket");
        add(generateTicketButton, BorderLayout.SOUTH);
    }

    public String getLicensePlate() {
        return licensePlateField.getText().trim();
    }

    public JButton getGenerateTicketButton() {
        return generateTicketButton;
    }

    public void clearFields() {
        licensePlateField.setText("");
    }
}

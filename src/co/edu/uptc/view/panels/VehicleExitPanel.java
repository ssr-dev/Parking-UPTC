package co.edu.uptc.view.panels;
import javax.swing.*;
import java.awt.*;

public class VehicleExitPanel extends JPanel {
    private JTextField licensePlateField;
    private JButton confirmExitButton;

    public VehicleExitPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel title = new JLabel("Salida de Vehículo", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        licensePlateField = new JTextField();
        formPanel.add(new JLabel("Placa del vehículo:"));
        formPanel.add(licensePlateField);

        add(formPanel, BorderLayout.CENTER);

        confirmExitButton = new JButton("Confirmar Salida");
        add(confirmExitButton, BorderLayout.SOUTH);
    }

    public String getLicensePlate() {
        return licensePlateField.getText().trim();
    }

    public JButton getConfirmExitButton() {
        return confirmExitButton;
    }

    public void clearFields() {
        licensePlateField.setText("");
    }
}


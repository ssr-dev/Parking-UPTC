package co.edu.uptc.view.panels;

import javax.swing.*;
import java.awt.*;

public class CreateRecepcionistPanel extends JPanel {

    private JTextField docField, nameField, lastNameField, phoneField, addressField, emailField;
    private JComboBox<String> parkingComboBox;
    private JButton backButton, createButton;

    public CreateRecepcionistPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel title = new JLabel("Ingresar datos del usuario", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        docField = addField("Documento:", formPanel, gbc, y++);
        nameField = addField("Nombres:", formPanel, gbc, y++);
        lastNameField = addField("Apellidos:", formPanel, gbc, y++);
        phoneField = addField("Teléfono:", formPanel, gbc, y++);
        addressField = addField("Dirección:", formPanel, gbc, y++);
        emailField = addField("E-mail:", formPanel, gbc, y++);

        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Parqueadero:"), gbc);

        parkingComboBox = new JComboBox<>(new String[] { "Parqueadero 1", "Parqueadero 2" });
        gbc.gridx = 1;
        formPanel.add(parkingComboBox, gbc);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        backButton = new JButton("Atrás");
        createButton = new JButton("Crear usuario");

        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(createButton, BorderLayout.EAST);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JTextField addField(String label, JPanel panel, GridBagConstraints gbc, int y) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        panel.add(new JLabel(label), gbc);

        JTextField textField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textField, gbc);
        return textField;
    }

}

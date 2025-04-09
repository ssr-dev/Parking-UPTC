package co.edu.uptc.view.panels;
import co.edu.uptc.presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class ChangeCredentialsPanel extends JPanel {

    private JComboBox<String> receptionistComboBox;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton saveButton, cancelButton;
    private Presenter presenter;

    public ChangeCredentialsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);


        JLabel title = new JLabel("Cambiar Credenciales", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 10, 12, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        int y = 0;

        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        centerPanel.add(new JLabel("Recepcionista:"), gbc);

        receptionistComboBox = new JComboBox<>();
        gbc.gridx = 1;
        centerPanel.add(receptionistComboBox, gbc);
        y++;

    
        gbc.gridx = 0;
        gbc.gridy = y;
        centerPanel.add(new JLabel("Nuevo usuario:"), gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        centerPanel.add(usernameField, gbc);
        y++;


        gbc.gridx = 0;
        gbc.gridy = y;
        centerPanel.add(new JLabel("Nueva contraseña:"), gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        centerPanel.add(passwordField, gbc);
        y++;

        add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        cancelButton = new JButton("Cancelar");
        saveButton = new JButton("Guardar");

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}

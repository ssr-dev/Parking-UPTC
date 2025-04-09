package co.edu.uptc.view.panels;

import co.edu.uptc.presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeCredentialsPanel extends JPanel implements ActionListener {
    private Presenter presenter;
    private JTextField documentField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton searchButton, updateButton, backButton;
    private JPanel bottomPanel;

    public ChangeCredentialsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Título
        JLabel titleLabel = new JLabel("Cambio de contraseña", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Panel superior
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanel.add(new JLabel("Documento:"), gbc);

        documentField = new JTextField(20);
        gbc.gridx = 1;
        topPanel.add(documentField, gbc);

        searchButton = new JButton("Buscar");
        gbc.gridx = 2;
        topPanel.add(searchButton, gbc);

        add(topPanel, BorderLayout.CENTER);

        // Panel inferior oculto al inicio
        bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.setVisible(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        bottomPanel.add(new JLabel("Contraseña:"), gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        bottomPanel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        bottomPanel.add(new JLabel("Repetir contraseña:"), gbc);

        confirmPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        bottomPanel.add(confirmPasswordField, gbc);

        gbc.gridy++;
        gbc.gridx = 1;
        JLabel tipLabel = new JLabel("<html>• No debe contener caracteres especiales<br>• Mínimo 8 dígitos</html>");
        bottomPanel.add(tipLabel, gbc);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        updateButton = new JButton("Actualizar");
        backButton = new JButton("Atrás");
        buttonPanel.add(backButton);
        buttonPanel.add(updateButton);

        JPanel southWrapper = new JPanel(new BorderLayout());
        southWrapper.setBackground(Color.LIGHT_GRAY);
        southWrapper.add(bottomPanel, BorderLayout.CENTER);
        southWrapper.add(buttonPanel, BorderLayout.SOUTH);

        add(southWrapper, BorderLayout.SOUTH);

        // Listeners
        searchButton.addActionListener(this);
        updateButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public String getDocumentField() {
        return documentField.getText().trim();
    }

    public String getPasswordField() {
        return new String(passwordField.getPassword());
    }

    public String getConfirmPasswordField() {
        return new String(confirmPasswordField.getPassword());
    }

    public void showPasswordPanel() {
        bottomPanel.setVisible(true);
        revalidate();
        repaint();
    }

    public void cleanFields() {
        passwordField.setText("");
        confirmPasswordField.setText("");
        documentField.setText("");
        bottomPanel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String id = getDocumentField();
            if (presenter.changeCredentials()) {
                showPasswordPanel();
            } else {
                presenter.validateId();
            }
        } else if (e.getSource() == updateButton) {
            String pass = getPasswordField();
            String confirm = getConfirmPasswordField();
            presenter.updatePassword(pass, confirm);
        } else if (e.getSource() == backButton) {
            presenter.logOutToAdminMenu();
        }
    }
}

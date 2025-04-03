package co.edu.uptc.view.panels;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton loginButton;

    public LoginPanel() {
        setLayout(new GridBagLayout());

        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
        loginButton = new JButton("Iniciar sesión");
    }

    public void addComponentsToPanel() {
        GridBagConstraints config = new GridBagConstraints();
        config.insets = new Insets(5, 5, 5, 5);
        config.gridx = 0;
        config.gridy = 0;
        add(new JLabel("Usuario: "), config);

        config.gridx = 1;
        add(txtUsername, config);

        config.gridx = 0;
        config.gridy = 1;
        add(new JLabel("Contraseña: "), config);

        config.gridx = 1;
        add(txtPassword, config);

        config.gridx = 1;
        config.gridy = 2;
        add(loginButton, config);
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}

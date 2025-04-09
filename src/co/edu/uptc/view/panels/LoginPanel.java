package co.edu.uptc.view.panels;

import co.edu.uptc.presenter.Presenter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPanel extends JPanel implements ActionListener {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton loginButton;
    private Presenter presenter;

    public LoginPanel(Presenter presenter) {
        setLayout(new GridBagLayout());

        Font titleFont = new Font("Arial", Font.BOLD, 40);
        Font fieldFont = new Font("Arial", Font.PLAIN, 18);

        JLabel titleLabel = new JLabel("Inicio de Sesión");
        titleLabel.setFont(titleFont);

        txtUsername = new JTextField(15);
        txtUsername.setFont(fieldFont);
        txtUsername.setPreferredSize(new Dimension(200, 30));

        txtPassword = new JPasswordField(15);
        txtPassword.setFont(fieldFont);
        txtPassword.setPreferredSize(new Dimension(200, 30));

        loginButton = new JButton("Iniciar sesión");
        loginButton.setPreferredSize(new Dimension(125, 35));

        loginButton.addActionListener(this);
        addComponentsToPanel(titleLabel, fieldFont);
    }

    private void addComponentsToPanel(JLabel labelTitle, Font fieldFont) {
        GridBagConstraints config = new GridBagConstraints();
        config.insets = new Insets(10, 10, 10, 10);
        config.gridx = 0;
        config.gridy = 0;
        config.gridwidth = 2;
        add(labelTitle, config);

        config.gridy = 1;
        config.gridwidth = 1;
        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setFont(fieldFont);
        add(lblUser, config);

        config.gridx = 1;
        add(txtUsername, config);

        config.gridx = 0;
        config.gridy = 2;
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(fieldFont);
        add(lblPassword, config);

        config.gridx = 1;
        add(txtPassword, config);

        config.gridx = 1;
        config.gridy = 3;
        add(loginButton, config);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public String getTxtUsername() {
        return txtUsername.getText();
    }

    public String getTxtPassword() {
        return txtPassword.getText();
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void clearFiles() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            System.out.println("si se está haciendo");
            presenter.login();
            System.out.println("si se está haciendo x2");

        }
    }
}


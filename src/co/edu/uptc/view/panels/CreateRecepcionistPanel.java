package co.edu.uptc.view.panels;

import co.edu.uptc.presenter.Presenter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateRecepcionistPanel extends JPanel implements ActionListener{
    private Presenter presenter;
    private JTextField docField, nameField, lastNameField, phoneField, addressField, emailField;
    private JComboBox<String> parkingComboBox;
    private JButton backButton, createButton;

    public CreateRecepcionistPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel title = new JLabel("Ingresar datos del recepcionista", SwingConstants.CENTER);
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

        parkingComboBox = new JComboBox<>(new String[] {});
        gbc.gridx = 1;
        formPanel.add(parkingComboBox, gbc);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        backButton = new JButton("Atrás");
        createButton = new JButton("Crear recepcionista");

        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(createButton, BorderLayout.EAST);

        backButton.addActionListener(this);
        createButton.addActionListener(this);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setComboBox(String[] parking){
        parkingComboBox.setModel(new DefaultComboBoxModel<>(parking));

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
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void cleanFiles(){
        docField.setText("");
        nameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        addressField.setText("");
        emailField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
        }if (e.getSource() == createButton){
        }
    }

    public String getDocField() {
        return docField.getText();
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getLastNameField() {
        return lastNameField.getText();
    }

    public String getPhoneField() {
        return phoneField.getText();
    }

    public String getAddressField() {
        return addressField.getText();
    }

    public String getEmailField() {
        return emailField.getText();
    }

}
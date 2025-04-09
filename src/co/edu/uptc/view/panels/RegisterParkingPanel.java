package co.edu.uptc.view.panels;

import co.edu.uptc.model.Schedule;
import co.edu.uptc.presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RegisterParkingPanel extends JPanel implements ActionListener {

    private JTextField nameField, addressField, priceField;
    private JSpinner spacesSpinner;
    private JTextField weekdayOpenField, weekdayCloseField;
    private JTextField weekendOpenField, weekendCloseField;
    private JButton backButton, addButton;
    private Presenter presenter;

    public RegisterParkingPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel title = new JLabel("Ingresar datos del parqueadero", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        nameField = addTextField("Nombre:", formPanel, gbc, y++);
        addressField = addTextField("Dirección:", formPanel, gbc, y++);
        priceField = addTextField("Precio por hora:", formPanel, gbc, y++);

        gbc.gridx = 0;
        gbc.gridy = y;
        formPanel.add(new JLabel("Espacios disponibles:"), gbc);
        spacesSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 100, 1));
        gbc.gridx = 1;
        formPanel.add(spacesSpinner, gbc);
        y++;

        gbc.gridx = 0;
        gbc.gridy = y++;
        gbc.gridwidth = 2;
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(400, 1));
        formPanel.add(separator, gbc);

        gbc.gridy = y++;
        JLabel horarioLabel = new JLabel("Horario de atención", SwingConstants.CENTER);
        horarioLabel.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(horarioLabel, gbc);

        JPanel schedulePanel = new JPanel(new GridLayout(4, 2, 10, 10));
        schedulePanel.setBackground(Color.LIGHT_GRAY);
        weekdayOpenField = new JTextField();
        weekdayCloseField = new JTextField();
        weekendOpenField = new JTextField();
        weekendCloseField = new JTextField();

        schedulePanel.add(new JLabel("Apertura Lunes-Viernes:"));
        schedulePanel.add(weekdayOpenField);
        schedulePanel.add(new JLabel("Cierre Lunes-Viernes:"));
        schedulePanel.add(weekdayCloseField);
        schedulePanel.add(new JLabel("Apertura Fin de Semana:"));
        schedulePanel.add(weekendOpenField);
        schedulePanel.add(new JLabel("Cierre Fin de Semana:"));
        schedulePanel.add(weekendCloseField);

        gbc.gridy = y++;
        formPanel.add(schedulePanel, gbc);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        addButton = new JButton("Añadir");
        addButton.addActionListener(this);
        backButton = new JButton("Atrás");
        backButton.addActionListener(this);

        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(addButton, BorderLayout.EAST);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JTextField addTextField(String label, JPanel panel, GridBagConstraints gbc, int y) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        panel.add(new JLabel(label), gbc);

        JTextField textField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textField, gbc);
        return textField;
    }

    public void cleanFields() {
        nameField.setText("");
        addressField.setText("");
        priceField.setText("");
        spacesSpinner.setValue(1);
        weekdayOpenField.setText("");
        weekdayCloseField.setText("");
        weekendOpenField.setText("");
        weekendCloseField.setText("");
    }


    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getAddressField() {
        return addressField.getText();
    }

    public int getSpacesSpinner() {
        return (int) spacesSpinner.getValue();
    }

    public double getPriceByHour() {
        try {
            return Double.parseDouble(priceField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public List<Schedule> getSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule("weekday", weekdayOpenField.getText(), weekdayCloseField.getText()));
        schedules.add(new Schedule("weekend", weekendOpenField.getText(), weekendCloseField.getText()));
        return schedules;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            presenter.createParking();
        } else if (e.getSource() == backButton) {
            presenter.logOutToAdminMenu();
        }
    }
}

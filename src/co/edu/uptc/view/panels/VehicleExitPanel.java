package co.edu.uptc.view.panels;

import co.edu.uptc.presenter.Presenter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VehicleExitPanel extends JPanel implements ActionListener {
    private Presenter presenter;
    private JTextField licensePlateField;
    private JLabel totalAmountMoney;
    private JTextField moneyReceived;
    private JButton generateChangeMoney;
    private JLabel cashBack;
    private JTextField elapsedTime;
    private JButton confirmExitButton;
    private JLabel dateVehicleExit;
    private JButton searchPlate;
    private JButton backbutton;
    private JPanel platePanel;
    private JPanel detailsPanel;

    public VehicleExitPanel() {
        setLayout(new BorderLayout());

        // Panel superior
        platePanel = new JPanel(new FlowLayout());
        JLabel plateLabel = new JLabel("Placa del vehículo:");
        plateLabel.setFont(new Font("Arial", Font.BOLD, 25));
        licensePlateField = new JTextField(10);
        searchPlate = new JButton("Buscar");

        platePanel.add(plateLabel);
        platePanel.add(licensePlateField);
        platePanel.add(searchPlate);
        add(platePanel, BorderLayout.NORTH);

        // Panel central con detalles
        detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setVisible(false);

        totalAmountMoney = new JLabel("$...");
        cashBack = new JLabel("$...");
        dateVehicleExit = new JLabel("DD/MM/AAAA");
        moneyReceived = new JTextField(10);
        generateChangeMoney = new JButton("Generar cambio");
        elapsedTime = new JTextField(10);
        confirmExitButton = new JButton("Generar ticket");

        int y = 0;
        detailsPanel.add(createLabel("Total a pagar:", 25), gridBagConstraintsConfig(0, y));
        detailsPanel.add(totalAmountMoney, gridBagConstraintsConfig(1, y++));

        detailsPanel.add(createLabel("Recibido:", 25), gridBagConstraintsConfig(0, y));
        detailsPanel.add(moneyReceived, gridBagConstraintsConfig(1, y++));
        detailsPanel.add(generateChangeMoney, gridBagConstraintsConfig(2, y - 1));

        detailsPanel.add(createLabel("Cambio:", 25), gridBagConstraintsConfig(0, y));
        detailsPanel.add(cashBack, gridBagConstraintsConfig(1, y++));

        detailsPanel.add(createLabel("Tiempo:", 25), gridBagConstraintsConfig(0, y));
        detailsPanel.add(elapsedTime, gridBagConstraintsConfig(1, y++));

        detailsPanel.add(createLabel("Fecha salida:", 25), gridBagConstraintsConfig(0, y));
        detailsPanel.add(dateVehicleExit, gridBagConstraintsConfig(1, y++));

        JPanel confirmPanel = new JPanel(new FlowLayout());
        confirmPanel.add(confirmExitButton);
        detailsPanel.add(confirmPanel, gridBagConstraintsConfig(0, y++, 3));

        add(detailsPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backbutton = new JButton("Atrás");
        bottomPanel.add(backbutton);
        add(bottomPanel, BorderLayout.SOUTH);

        searchPlate.addActionListener(this);
        generateChangeMoney.addActionListener(this);
        confirmExitButton.addActionListener(this);
        backbutton.addActionListener(this);
    }

    public void setTotalAmountMoney(String totalAmount) {
        totalAmountMoney.setText("$ " + totalAmount);
    }

    public void setCashBack(String cashBackk) {
        cashBack.setText("$ " + cashBackk);
    }

    public void setDateVehicleExit(String date) {
        dateVehicleExit.setText(date);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private JLabel createLabel(String textLabel, int sizeLabel) {
        JLabel label = new JLabel(textLabel);
        label.setFont(new Font("Arial", Font.BOLD, sizeLabel));
        return label;
    }

    private GridBagConstraints gridBagConstraintsConfig(int x, int y) {
        return gridBagConstraintsConfig(x, y, 1);
    }

    private GridBagConstraints gridBagConstraintsConfig(int x, int y, int gridWidth) {
        GridBagConstraints config = new GridBagConstraints();
        config.gridx = x;
        config.gridy = y;
        config.gridwidth = gridWidth;
        config.insets = new Insets(10, 10, 10, 10);
        config.anchor = GridBagConstraints.WEST;
        return config;
    }

    public JButton getConfirmExitButton() {
        return confirmExitButton;
    }

    public void cleanFields() {
        licensePlateField.setText("");
        elapsedTime.setText("");
        moneyReceived.setText("");
    }

    public String getLicensePlate() {
        return licensePlateField.getText().trim();
    }

    public String getMoneyReceived() {
        return moneyReceived.getText().trim();
    }

    public String getElapsedTime() {
        return elapsedTime.getText().trim();
    }

    public JTextField getElapsedTimeField() {
        return elapsedTime;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchPlate) {
            if (presenter.validatePlatee()) {
                presenter.loadVehicleExitData();
            }
        } else if (e.getSource() == generateChangeMoney) {
            presenter.generateChange();
        } else if (e.getSource() == confirmExitButton) {
            presenter.confirmExit();
//        } else if (e.getSource() == goBackWindow) {
//            presenter.openReceptionistMenu();
        }
    }
}
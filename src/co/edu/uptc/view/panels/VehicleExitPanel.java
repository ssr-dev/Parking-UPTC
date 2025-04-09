package co.edu.uptc.view.panels;
import co.edu.uptc.presenter.Presenter;

import java.awt.*;
import javax.swing.*;

public class VehicleExitPanel extends JPanel {
    private JTextField licensePlateField;
    private JLabel totalAmountMoney;
    private JTextField moneyReceived;
    private JButton generateChangeMoney;
    private JLabel cashBack;
    private JTextField elapsedTime;
    private JButton confirmExitButton;
    private JButton goBackWindow;
    private JLabel dateVehicleExit;
    private JButton searchPlate;
    private Presenter presenter;

    public VehicleExitPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        
        JLabel title = new JLabel("Salida de Vehículo");
        title.setFont(new Font("Arial", Font.BOLD, 50));

        licensePlateField = new JTextField();
        searchPlate = new JButton("->");
        totalAmountMoney = new JLabel("$...");
        cashBack = new JLabel("$...");
        dateVehicleExit = new JLabel("DD/MM/AAAA");
        moneyReceived = new JTextField();
        generateChangeMoney = new JButton("Generar cambio");
        elapsedTime = new JTextField();
        goBackWindow = new JButton("Atrás");
        goBackWindow.setPreferredSize(new Dimension(300, 25));
        confirmExitButton = new JButton("Generar ticket");
        confirmExitButton.setPreferredSize(new Dimension(300, 25));
        formPanel.add(title, gridBagConstraintsConfig(0, 0, 1, 3));
        formPanel.add(createLabel("Placa del vehículo:", 25), gridBagConstraintsConfig(0, 1, 1, 1));
        formPanel.add(licensePlateField, gridBagConstraintsConfig(0, 2, 1, 1));
        formPanel.add(searchPlate, gridBagConstraintsConfig(1, 2, 1, 1));
        formPanel.add(createLabel("Total:", 25), gridBagConstraintsConfig(2, 1, 1, 1));
        formPanel.add(createLabel(totalAmountMoney.getText(), 33), gridBagConstraintsConfig(2, 2, 1, 1)); //método que retorna eso
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        GridBagConstraints configSelector = new GridBagConstraints();
        configSelector.gridx = 0;   
        configSelector.gridy = 3;   
        configSelector.gridwidth = GridBagConstraints.REMAINDER;  
        configSelector.fill = GridBagConstraints.HORIZONTAL;
        configSelector.gridheight = 1;
        configSelector.insets =  new Insets(20, 20, 20, 20); 
        formPanel.add(separator, configSelector);
        formPanel.add(createLabel("Recibido:", 25), gridBagConstraintsConfig(0, 4, 1, 2));
        formPanel.add(moneyReceived, gridBagConstraintsConfig(0, 5, 1, 2));
        formPanel.add(generateChangeMoney, gridBagConstraintsConfig(2, 5, 1, 1));
        formPanel.add(createLabel("Cambio:", 25), gridBagConstraintsConfig(0, 6, 1, 1));
        formPanel.add(createLabel(cashBack.getText(), 33), gridBagConstraintsConfig(0, 7, 1, 1));
        formPanel.add(createLabel("Tiempo:", 25), gridBagConstraintsConfig(1, 6, 1, 1));
        formPanel.add(elapsedTime, gridBagConstraintsConfig(2, 6, 1, 1));
        formPanel.add(createLabel("Fecha:", 25), gridBagConstraintsConfig(1, 7, 1, 1));
        formPanel.add(createLabel(dateVehicleExit.getText(), 33), gridBagConstraintsConfig(2, 7, 1, 1));
        add(formPanel);
        add(Box.createRigidArea(new Dimension(0, 450)));
        JPanel panelButtons = new JPanel(new GridLayout(1, 2, 100, 0));
        panelButtons.add(goBackWindow);
        panelButtons.add(confirmExitButton);
        add(panelButtons, BorderLayout.SOUTH);

    }


    public void setTotalAmountMoney(String totalAmount){
        totalAmountMoney.setText("$ "+totalAmount);
    }

    public void setCashBack(String cashBackk) {
        cashBack.setText("$ "+cashBackk);
    }

    public void setDateVehicleExit(String date) {
        dateVehicleExit.setText("$ "+date);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    
    private JLabel createLabel(String textLabel, int sizeLabel){
        JLabel label = new JLabel(textLabel);
        label.setFont(new Font("Arial", Font.BOLD, sizeLabel));
        return label;
    }
    
    
    private GridBagConstraints gridBagConstraintsConfig(int positionX, int positionY, int cellHeight, int cellWidth){
        GridBagConstraints config = new GridBagConstraints();
        config.gridx = positionX;
        config.gridy = positionY;
        config.gridheight = cellHeight;
        config.gridwidth = cellWidth;
        config.fill = GridBagConstraints.HORIZONTAL;
        config.anchor = GridBagConstraints.WEST;
        config.insets =  new Insets(5, 15, 5, 15);  
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

    

}


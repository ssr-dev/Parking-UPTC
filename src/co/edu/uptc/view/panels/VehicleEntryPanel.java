package co.edu.uptc.view.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class VehicleEntryPanel extends JPanel {
    private JTextField licensePlateField;
    private JButton generateTicketButton;
    private JLabel parkingSpaces;
    private JLabel alertTitle;
    private JLabel alertText;
    private JButton goBackWindow;

    public VehicleEntryPanel(int parkingSpacess) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel title = new JLabel("Ingreso de Vehículo", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        add(title, BorderLayout.NORTH);

        parkingSpaces = new JLabel(parkingSpacess+"");
        if (parkingSpacess == 0){
            alertTitle = new JLabel("ALERTA");
            alertText = new JLabel("No hay espacios disponibles en el parqueadero");
        }else if (parkingSpacess < 5 ){
            alertTitle = new JLabel("ADVERTENCIA");
            alertText = new JLabel("Quedan pocos espacios disponibles, estaciona pronto");
        } else {
            alertTitle = new JLabel("Disponibilidad óptima");
            alertText = new JLabel("Hay espacios libres para estacionar sin problemas");
        }
        alertTitle.setFont(new Font("Georgia", Font.BOLD, 25));
        JTextArea areaAlertText = new JTextArea(alertText.getText());
        areaAlertText.setLineWrap(true);
        areaAlertText.setWrapStyleWord(true);
        areaAlertText.setEditable(false);
        areaAlertText.setFocusable(false);
        areaAlertText.setOpaque(false);
        areaAlertText.setBorder(null);
        areaAlertText.setFont(new Font("Georgia", Font.ITALIC, 24));
        areaAlertText.setMaximumSize(new Dimension(315, 90));
        areaAlertText.setPreferredSize(new Dimension(315, 90)); 
        alertText.setPreferredSize(new Dimension(400, 50));
        licensePlateField = new JTextField();
        licensePlateField.setMaximumSize(new Dimension(320, 30)); 
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        JPanel rowPanel = new JPanel();

        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.X_AXIS));
        JLabel plate = new JLabel("Ingresar placa del vehículo: ");
        plate.setFont(new Font("Arial", Font.BOLD, 25));
        rowPanel.add(plate);
        rowPanel.add(Box.createRigidArea(new Dimension(10, 0))); 
        rowPanel.add(licensePlateField);

        formPanel.add(Box.createRigidArea(new Dimension(0, 70))); 
        formPanel.add(rowPanel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        formPanel.add(separator);
        formPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel panelTwo = new JPanel(new GridLayout(1, 0));
        JPanel leftJPanel = new JPanel(new GridBagLayout());
        GridBagConstraints config = new GridBagConstraints();
        config.gridx = 0;
        config.gridy = 0;
        config.anchor = GridBagConstraints.CENTER;
        config.insets = new Insets(10, 10, 10, 10); 
        JLabel labelSpaces = new JLabel("Espacios disponibles");
        labelSpaces.setFont(new Font("Arial", Font.BOLD, 20));
        leftJPanel.add(labelSpaces, config);
        config.gridy = 1;
        parkingSpaces.setFont(new Font("Arial", Font.BOLD, 35));
        leftJPanel.add(parkingSpaces, config);


        JPanel panelAvailableSpaces = new JPanel(new GridBagLayout());
        panelAvailableSpaces.setBorder(new MatteBorder(2, 2, 3, 3, Color.black));
        panelAvailableSpaces.add(areaAlertText, config);
        config.gridy=0;
        panelAvailableSpaces.add(alertTitle, config);

        panelTwo.add(leftJPanel);
        panelTwo.add(panelAvailableSpaces);
        formPanel.add(panelTwo);
        formPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        add(formPanel, BorderLayout.CENTER);
        JPanel panelButtons = new JPanel(new GridLayout(1, 2, 300, 0));
        goBackWindow = new JButton("Atrás");
        generateTicketButton = new JButton("Generar Ticket");
        panelButtons.add(goBackWindow);
        panelButtons.add(generateTicketButton);
        add(panelButtons, BorderLayout.SOUTH);
    }

    public void setParkingSpaces(String availableParkingSpaces){
        parkingSpaces.setText(availableParkingSpaces);
    }

    public void setAlertTitle(String textTitle){
        alertTitle.setText(textTitle);
    }

    public void setAlertText(String textAlert){
        alertText.setText(textAlert);
    }

    public String getLicensePlate() {
        return licensePlateField.getText().trim();
    }

    public JButton getGenerateTicketButton() {
        return generateTicketButton;
    }

    public void clearFields() {
        licensePlateField.setText("");
    }
}

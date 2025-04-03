package co.edu.uptc.view.panels;

import javax.swing.*;
import java.awt.*;

public class RecepcionistMenuPanel extends MenuPanel{

    public RecepcionistMenuPanel() {
        super("Menu recepcionista");
    }
    @Override
    protected void setupButtons() {
        addButton("Ingreso de un vehículo");
        addButton("Salida de un vehículo");
        addButton("Ver espacios disponibles en parqueadero");
        addButton("Cerrar sesión");
    }

    private void addButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        buttonPanel.add(button);
    }

}

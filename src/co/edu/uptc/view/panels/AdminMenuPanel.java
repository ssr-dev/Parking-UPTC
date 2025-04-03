package co.edu.uptc.view.panels;

import javax.swing.*;
import java.awt.*;

public class AdminMenuPanel extends MenuPanel {
    public AdminMenuPanel() {
        super("Menú Administrador");
    }

    @Override
    protected void setupButtons() {
        addButton("Crear Recepcionista");
        addButton("Registrar Parqueadero");
        addButton("Cambiar Credenciales del Recepcionista");
        addButton("Generar Reporte de Ventas");
    }

    private void addButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(button);
    }
}


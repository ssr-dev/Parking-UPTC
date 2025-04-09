package co.edu.uptc.view.panels;

import java.awt.event.ActionEvent;

public class AdminMenuPanel extends MenuPanel {
    public AdminMenuPanel() {
        super("Menú Administrador", "images/AdminImage.jpeg");
    }

    @Override
    protected void setupButtons() {
        addStyledButton("Crear recepcionista", 0);
        addStyledButton("Registrar parqueadero", 1);
        addStyledButton("Cambiar credenciales del recepcionista", 2);
        addStyledButton("Generar reporte de ventas", 3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


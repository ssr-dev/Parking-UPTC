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
        String command = e.getActionCommand();
        if (command.equals("Crear recepcionista")) {
            presenter.openCreateRecepcionist();
        } else if (command.equals("Registrar parqueadero")) {
            presenter.openCreateParking();
        } else if (command.equals("Cambiar credenciales del recepcionista")) {
            presenter.openChangeCredentials();
        } else if (command.equals("Generar reporte de ventas")) {
            presenter.generateReport();
        }
    }

}


package co.edu.uptc.view.panels;

import java.awt.event.ActionEvent;

public class RecepcionistMenuPanel extends MenuPanel {

    public RecepcionistMenuPanel() {
        super("Menú Recepcionista", "images/RecepcionistImage.png");
    }

    @Override
    protected void setupButtons() {
        addStyledButton("Registrar ingreso de vehículo", 0);
        addStyledButton("Registrar salida de vehículo", 1);
        addStyledButton("Consultar espacios disponibles", 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Registrar ingreso de vehículo")) {
            presenter.openVehiceEntry();
        } else if (command.equals("Registrar salida de vehículo")) {
            presenter.openVehicleExit();
        } else if (command.equals("Consultar espacios disponibles")) {
            presenter.openAvaliblesSpaces();
        }
    }
}



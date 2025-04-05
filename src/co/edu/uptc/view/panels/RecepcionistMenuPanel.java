package co.edu.uptc.view.panels;

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
}



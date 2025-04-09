package co.edu.uptc.view;

import co.edu.uptc.presenter.Presenter;
import co.edu.uptc.view.panels.*;

import java.awt.*;
import javax.swing.*;

public class ParkingView extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Presenter presenter;
    private LoginPanel loginPanel;
    private RecepcionistMenuPanel recepcionistMenuPanel;
    private AdminMenuPanel adminMenuPanel;
    private CreateRecepcionistPanel createRecepcionistPanel;
    private ParkingSpacesPanel parkingSpacesPanel;
    private ModifySchedulePanel modifySchedulePanel;
    private RegisterParkingPanel registerParkingPanel;
    private VehicleEntryPanel vehicleEntryPanel;
    private VehicleExitPanel vehicleExitPanel;


    public ParkingView() {
        setTitle("Sistema de parking UPTC");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        getContentPane().add(mainPanel);
        setVisible(true);
        createPanels();
        addPanels();
    }

    private void createPanels(){
        loginPanel = new LoginPanel();
//        recepcionistMenuPanel = new RecepcionistMenuPanel();
//        adminMenuPanel = new AdminMenuPanel();
//        createRecepcionistPanel = new CreateRecepcionistPanel();
//        vehicleEntryPanel = new VehicleEntryPanel();
//        vehicleExitPanel = new VehicleExitPanel();
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    private void addPanels() {
        mainPanel.add(loginPanel, "loginPanel");
//        mainPanel.add(recepcionistMenuPanel, "recepcionistMenuPanel");
//        mainPanel.add(createRecepcionistPanel, "createRecepcionistPanel");
//        mainPanel.add(adminMenuPanel, "adminMenuPanel");
    }

    private void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public RecepcionistMenuPanel getRecepcionistMenuPanel() {
        return recepcionistMenuPanel;
    }

    public AdminMenuPanel getAdminMenuPanel() {
        return adminMenuPanel;
    }

    public CreateRecepcionistPanel getCreateRecepcionistPanel() {
        return createRecepcionistPanel;
    }

    public VehicleEntryPanel getVehicleEntryPanel() {
        return vehicleEntryPanel;
    }

    public VehicleExitPanel getVehicleExitPanel() {
        return vehicleExitPanel;
    }

    public ParkingSpacesPanel getParkingSpacesPanel() {
        return parkingSpacesPanel;
    }

    public ModifySchedulePanel getModifySchedulePanel() {
        return modifySchedulePanel;
    }

    public RegisterParkingPanel getRegisterParkingPanel() {
        return registerParkingPanel;
    }


}


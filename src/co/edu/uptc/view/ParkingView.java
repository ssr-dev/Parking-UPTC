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
        loginPanel.setPresenter(presenter);
        recepcionistMenuPanel = new RecepcionistMenuPanel();
        recepcionistMenuPanel.setPresenter(presenter);
        adminMenuPanel = new AdminMenuPanel();
        adminMenuPanel.setPresenter(presenter);
        createRecepcionistPanel = new CreateRecepcionistPanel();
        createRecepcionistPanel.setPresenter(presenter);
        vehicleEntryPanel = new VehicleEntryPanel();
        vehicleEntryPanel.setPresenter(presenter);
        vehicleExitPanel = new VehicleExitPanel();
        vehicleExitPanel.setPresenter(presenter);
        parkingSpacesPanel = new ParkingSpacesPanel(0,false);
        parkingSpacesPanel.setPresenter(presenter);
        modifySchedulePanel = new ModifySchedulePanel();
        modifySchedulePanel.setPresenter(presenter);
        registerParkingPanel = new RegisterParkingPanel();
        registerParkingPanel.setPresenter(presenter);
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    private void addPanels() {
        mainPanel.add(loginPanel, "loginPanel");
        mainPanel.add(recepcionistMenuPanel, "recepcionistMenuPanel");
        mainPanel.add(adminMenuPanel, "adminMenuPanel");
        mainPanel.add(createRecepcionistPanel, "createRecepcionistPanel");
        mainPanel.add(parkingSpacesPanel, "parkingSpacesPanel");
        mainPanel.add(modifySchedulePanel, "modifySchedulePanel");
        mainPanel.add(vehicleEntryPanel, "vehicleEntryPanel");
        mainPanel.add(vehicleExitPanel, "vehicleExitPanel");
        mainPanel.add(registerParkingPanel, "registerParkingPanel");
    }

    public void setPresenter(Presenter presenter) {
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


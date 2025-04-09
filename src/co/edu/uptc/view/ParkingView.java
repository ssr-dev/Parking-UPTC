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
    private int avaliblesSpaces;
    private boolean isAvailable;
    private RecepcionistMenuPanel recepcionistMenuPanel;
    private AdminMenuPanel adminMenuPanel;
    private CreateRecepcionistPanel createRecepcionistPanel;
    private ParkingSpacesPanel parkingSpacesPanel;
    private ModifySchedulePanel modifySchedulePanel;
    private RegisterParkingPanel registerParkingPanel;
    private VehicleEntryPanel vehicleEntryPanel;
    private VehicleExitPanel vehicleExitPanel;
    private ChangeCredentialsPanel changeCredentials;
    private GenerateReportPanel generateReport;

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

    private void createPanels() {
        loginPanel = new LoginPanel();
        recepcionistMenuPanel = new RecepcionistMenuPanel();
        adminMenuPanel = new AdminMenuPanel();
        createRecepcionistPanel = new CreateRecepcionistPanel();
        vehicleEntryPanel = new VehicleEntryPanel();
        vehicleExitPanel = new VehicleExitPanel();
        parkingSpacesPanel = new ParkingSpacesPanel(avaliblesSpaces, isAvailable);
        modifySchedulePanel = new ModifySchedulePanel();
        registerParkingPanel = new RegisterParkingPanel();
        changeCredentials = new ChangeCredentialsPanel();
        generateReport = new GenerateReportPanel();
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    private void addPanels() {
        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(recepcionistMenuPanel, "recepcionistMenuPanel");
        mainPanel.add(adminMenuPanel, "adminMenuPanel");
        mainPanel.add(createRecepcionistPanel, "createRecepcionistPanel");
        mainPanel.add(parkingSpacesPanel, "parkingSpacesPanel");
        mainPanel.add(modifySchedulePanel, "modifySchedulePanel");
        mainPanel.add(vehicleEntryPanel, "vehicleEntryPanel");
        mainPanel.add(vehicleExitPanel, "vehicleExitPanel");
        mainPanel.add(registerParkingPanel, "registerParkingPanel");
        mainPanel.add(changeCredentials, "credentialsPanel");
        mainPanel.add(generateReport, "generateReport");
    }

    public void setPresenters(Presenter presenter) {
        this.presenter = presenter;
        loginPanel.setPresenter(presenter);
        recepcionistMenuPanel.setPresenter(presenter);
        adminMenuPanel.setPresenter(presenter);
        createRecepcionistPanel.setPresenter(presenter);
        parkingSpacesPanel.setPresenter(presenter);
        modifySchedulePanel.setPresenter(presenter);
        vehicleEntryPanel.setPresenter(presenter);
        vehicleExitPanel.setPresenter(presenter);
        registerParkingPanel.setPresenter(presenter);
        changeCredentials.setPresenter(presenter);
        generateReport.setPresenter(presenter);
    }

    public void setAvaliblesSpaces(int avaliblesSpaces) {
        this.avaliblesSpaces = avaliblesSpaces;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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

    public ChangeCredentialsPanel getChangeCredentials() {
        return changeCredentials;
    }

    public GenerateReportPanel getGenerateReport() {
        return generateReport;
    }
}


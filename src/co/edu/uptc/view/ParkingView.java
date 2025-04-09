package co.edu.uptc.view;

import co.edu.uptc.view.panels.*;
import java.awt.*;
import javax.swing.*;

public class ParkingView extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private LoginPanel loginPanel;
    private RecepcionistMenuPanel recepcionistMenuPanel;
    private AdminMenuPanel adminMenuPanel;
    private CreateRecepcionistPanel createRecepcionistPanel;


    public ParkingView() {
        setTitle("Sistema de parking UPTC");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
  
        recepcionistMenuPanel = new RecepcionistMenuPanel();
        addPanel(recepcionistMenuPanel,"Recepcionist");
 loginPanel = new LoginPanel();
addPanel(loginPanel, "LogIn");
 adminMenuPanel = new AdminMenuPanel();
 addPanel(adminMenuPanel,"Admin");
       createRecepcionistPanel = new CreateRecepcionistPanel();
        addPanel(createRecepcionistPanel,"CreateRecepcionist");
        //ParkingSpacesPanel parkingSpacesPanel = new ParkingSpacesPanel(15, true);
        //addPanel(parkingSpacesPanel,"parkingAvailabilityPanel");
//       VehicleExitPanel exitPanel = new VehicleExitPanel();
//        addPanel(exitPanel,"vehicleExitPanel");
//        RegisterParkingPanel RegisterParkingPanel=new RegisterParkingPanel();
//        addPanel(RegisterParkingPanel, "RegisterParking");
       //ModifySchedulePanel ModifySchedule=new ModifySchedulePanel();
        //addPanel(ModifySchedule, "ModifySchedule");
//        VehicleEntryPanel vehicleEntry = new VehicleEntryPanel();
//        addPanel(vehicleEntry, "VehicleEntry");
        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public void addPanel(JPanel panel, String panelName) {
        mainPanel.add(panel, panelName);
    }

    public LoginPanel getLoginPanel(){
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
}
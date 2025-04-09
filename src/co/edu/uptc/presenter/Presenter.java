package co.edu.uptc.presenter;

import co.edu.uptc.model.Admin;
import co.edu.uptc.model.ModelSystem;
import co.edu.uptc.view.JOptionMessages;
import co.edu.uptc.view.ParkingView;
import co.edu.uptc.view.panels.CreateRecepcionistPanel;
import co.edu.uptc.view.panels.LoginPanel;

public class Presenter {
    private static Presenter presenter;
    private ModelSystem modelSystem;
    private ParkingView parkingView;
    private LoginPanel loginPanel;
    private JOptionMessages jOptionMessages;
    private CreateRecepcionistPanel createRecepcionistPanel;
    private Admin adminModel;

    public Presenter(){
        modelSystem = new ModelSystem();
        parkingView = new ParkingView();
        adminModel = new Admin(modelSystem);
        loginPanel = parkingView.getLoginPanel();
        loginPanel.setPresenter(this);
        createRecepcionistPanel = parkingView.getCreateRecepcionistPanel();
        createRecepcionistPanel.setPresenter(this);
        jOptionMessages = new JOptionMessages(null);
    }

    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
        }
        return presenter;
    }

    public void login(){
        System.out.println("se está haciendo siiiiiiiiiiiiii");
         String userNameEntered = loginPanel.getTxtUsername();
        String passwordEntered = loginPanel.getTxtPassword();
        if (modelSystem.validateLogInAdmin(userNameEntered, passwordEntered)){
            parkingView.showPanel("Admin");
        } else if (modelSystem.validateLogIn(userNameEntered, passwordEntered)){
            //menurecpecionidta
        } else {
            jOptionMessages.errorMessage();
            loginPanel.clearFiles();
        }
    }

    public void openCreateReceptionist(){
        
    }

    public void backWindow(){
        createRecepcionistPanel.cleanFiles();
        parkingView.showPanel("Admin");
    }

    public void createRecepcionist(){
        /*adminModel.createNewReceptionist(createRecepcionistPanel.getDocField(), createRecepcionistPanel.getNameField(), createRecepcionistPanel.getLastNameField(), 
        createRecepcionistPanel.getPhoneField(), createRecepcionistPanel.getAddressField(), assignedParking); */
    }



    public void showParkingView(){
        parkingView.showPanel("LogIn");
    }
    
    public void init(){
        showParkingView();        
    }


}
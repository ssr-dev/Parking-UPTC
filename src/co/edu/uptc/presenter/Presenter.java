package co.edu.uptc.presenter;

import co.edu.uptc.model.*;
import co.edu.uptc.view.jOptionMessages;
import co.edu.uptc.view.ParkingView;

import java.util.List;
import java.time.format.DateTimeFormatter;

public final class Presenter {
    private static Presenter presenter;
    private ParkingView parkingView;
    private ModelSystem modelSystem;
    private jOptionMessages jOMessages;
    private Admin admin;
    private Parking parking;
    private Receptionist receptionist;

    private Presenter() {
        parkingView = new ParkingView();
        parkingView.setPresenters(this);
        modelSystem = new ModelSystem();
        jOMessages = new jOptionMessages(parkingView.getLoginPanel());
        admin = new Admin(modelSystem);
        parking = new Parking();
    }

    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
        }
        return presenter;
    }

    public void openLogin() {
        parkingView.showPanel("LoginPanel");
    }

    public void login() {
        String userNameEntered = parkingView.getLoginPanel().getTxtUsername();
        String passwordEntered = parkingView.getLoginPanel().getTxtPassword();
        if (modelSystem.validateLogInAdmin(userNameEntered, passwordEntered)) {
            parkingView.showPanel("adminMenuPanel");
        } else if (modelSystem.validateLogIn(userNameEntered, passwordEntered)) {
            parkingView.showPanel("recepcionistMenuPanel");
        } else {
            jOMessages.errorMessage();
            parkingView.getLoginPanel().cleanFiles();
        }
    }

    public void logOutToAdminMenu() {
        parkingView.showPanel("adminMenuPanel");
    }

    public void logOutToReceptionistMenu() {
        parkingView.showPanel("recepcionistMenuPanel");
    }

    public void openCreateRecepcionist() {
        String[] parkings = admin.getParkingNames();
        parkingView.getCreateRecepcionistPanel().setComboBox(parkings);
        parkingView.showPanel("createRecepcionistPanel");
    }

    public void createRecepcionist() {
        boolean result = admin.createNewReceptionist(parkingView.getCreateRecepcionistPanel().getDocField(), parkingView.getCreateRecepcionistPanel().getNameField(),
                parkingView.getCreateRecepcionistPanel().getLastNameField(), parkingView.getCreateRecepcionistPanel().getPhoneField(),
                parkingView.getCreateRecepcionistPanel().getAddressField(), parkingView.getCreateRecepcionistPanel().getEmailField(),
                parkingView.getCreateRecepcionistPanel().getSelectedParkingName());
        if (result) {
            String username = admin.getUserName();
            String password = admin.getPassword();
            jOMessages.showMessage("Ha creado un nuevo recepcionista, su usuario es:" + username + " y su contraseña " + password);
            parkingView.showPanel("adminMenuPanel");
        } else {
            jOMessages.errorMessage();
            parkingView.getCreateRecepcionistPanel().cleanFiles();
        }
    }

    public void openCreateParking() {
        parkingView.showPanel("registerParkingPanel");
    }

    public void createParking() {
        boolean result = admin.createNewParking(parkingView.getRegisterParkingPanel().getNameField(),
                parkingView.getRegisterParkingPanel().getAddressField(),
                parkingView.getRegisterParkingPanel().getSpacesSpinner(),
                parkingView.getRegisterParkingPanel().getPriceByHour(),
                parkingView.getRegisterParkingPanel().getSchedules());
        if (result) {
            jOMessages.successMessage();
            parkingView.getLoginPanel().cleanFiles();
            parkingView.showPanel("adminMenuPanel");
        } else {
            jOMessages.errorMessage();
            parkingView.getLoginPanel().cleanFiles();
        }
    }

    public void openChangeCredentials() {
        parkingView.showPanel("credentialsPanel");
    }

    public boolean changeCredentials() {
        return admin.validIdReceptionist(parkingView.getChangeCredentials().getDocumentField());
    }

    public void validateId() {
        jOMessages.showMessage("No se encontro el documento");
    }

    public void updatePassword(String pass, String confirm) {
        String id = parkingView.getChangeCredentials().getDocumentField();
        if (!pass.equals(confirm)) {
            jOMessages.showMessage("Las contraseñas no coinciden.");
        }
        if (admin.checkPassword(pass, modelSystem.searchUser(id, modelSystem.SEARCH_BY_ID).getPassword())) {
            admin.modifyReceptionistCredentials(id, pass);
            jOMessages.showMessage("Contraseña actualizada correctamente");
            parkingView.getChangeCredentials().cleanFields();
            parkingView.showPanel("LoginPanel");
        } else {
            jOMessages.showMessage("Contraseña inválida. Debe ser diferente a la anterior y tener máximo 8 caracteres alfanuméricos.");
        }
    }

    public void openGenerateReport() {
        parkingView.showPanel("generateReportPanel");
    }

    public void generateReport() {
        parkingView.showPanel("generateReport");
    }

    public Object[][] getReceptionistReportTable() {
        return modelSystem.getReceptionistReportTable();
    }

    public void openVehiceEntry() {
        parkingView.showPanel("vehicleEntryPanel");
    }

    public void vehiceEntry() {
        String plate = parkingView.getVehicleEntryPanel().getLicensePlate();

        if (plate.isEmpty()) {
            jOMessages.errorMessage();
            return;
        }

        receptionist.entryVehicle(plate);
        //  jOMessages.showMessage("Vehículo ingresado correctamente.");
        List<Ticket> tickets = modelSystem.getTickets();

        if (!tickets.isEmpty()) {
            Ticket ticket = tickets.get(tickets.size() - 1);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            String message = "Vehículo registrado correctamente\n\n" +
                    "Ticket generado:\n" +
                    "Placa: " + ticket.getPlate() + "\n" +
                    "Fecha: " + ticket.getEntryDate() + "\n" +
                    "Hora de ingreso: " + ticket.getEntryTime().format(formatter) + "\n" +
                    "Recepcionista: " + ticket.getReceptionist().getUsername();

            jOMessages.showMessage(message);
            parkingView.getVehicleEntryPanel().clearFields();
        }
    }
        public void openVehicleExit () {
            parkingView.showPanel("vehicleExitPanel");
        }

        public void loadVehicleExitData () {
            String plate = parkingView.getVehicleExitPanel().getLicensePlate();
            Vehicle vehicle = parking.searchVehicle(plate);
            if (vehicle != null) {
                Ticket ticket = vehicle.getAssignedTicket();
                int elapsedHours = ticket.calculateTime();
                String price = String.valueOf(ticket.calculatePrice(parking.getPriceByHour()));
                parkingView.getVehicleExitPanel().setTotalAmountMoney(price);
//            parkingView.getVehicleExitPanel().setDateVehicleExit(LocalDate.now().toString());
                parkingView.getVehicleExitPanel().getElapsedTimeField().setText(String.valueOf(elapsedHours));
            }
        }


        public boolean validatePlatee () {
            String plate = parkingView.getVehicleExitPanel().getLicensePlate();
            Vehicle vehicle = parking.searchVehicle(plate);
            if (vehicle == null) {
                jOMessages.errorMessage();
                parkingView.getVehicleExitPanel().cleanFields();
                return false;
            }
            return true;
        }

        public void generateChange () {
            String plate = parkingView.getVehicleExitPanel().getLicensePlate();
            Vehicle vehicle = parking.searchVehicle(plate);
            if (vehicle != null) {
                Ticket ticket = vehicle.getAssignedTicket();
                String received = parkingView.getVehicleExitPanel().getMoneyReceived();
                try {
                    Double cash = Double.parseDouble(received);
                    Double change = cash - ticket.getPrice();
                    parkingView.getVehicleExitPanel().setCashBack(String.format("%.2f", change));
                } catch (NumberFormatException ex) {
                    jOMessages.showMessage("Por favor ingrese un valor válido.");
                }
            }
        }
        public void confirmExit () {
            String plate = parkingView.getVehicleExitPanel().getLicensePlate();
            Vehicle vehicle = parking.searchVehicle(plate);
            if (vehicle != null) {
                parking.removeVehicle(plate);
                //jOMessages.showMessage("Salida registrada. Cambio: " + parkingView.getVehicleExitPanel().cashBack.getText();
                parkingView.getVehicleExitPanel().cleanFields();
                parkingView.showPanel("recepcionistMenuPanel");

            }
        }

        public void avalibleLots () {
            parkingView.setAvaliblesSpaces(parking.getAvailableLots());
        }

        public void isAvalible () {
            parkingView.setAvailable(parking.getAvailableLots() > 0);
        }

        public void openAvaliblesSpaces () {
            avalibleLots();
            isAvalible();
            parkingView.showPanel("parkingSpacesPanel");
        }


    }
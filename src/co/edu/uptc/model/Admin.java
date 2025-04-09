package co.edu.uptc.model;

import java.util.List;
import java.util.regex.Pattern;

public class Admin extends User{
    private String username;
    private String password;

    public Admin(ModelSystem objSystem){
        super(objSystem);
        username = "";
        password = "";
    }

    public boolean createNewParking(String name, String address, int totalLots, Double priceByHour, List<Schedule> schedules) {
        boolean result = false;
        if (name != null && name.matches("^[A-ZÁÉÍÓÚÑa-záéíóúñ0-9 ]{3,50}$")
                && address != null && address.matches("^[A-ZÁÉÍÓÚÑa-záéíóúñ0-9 #\\-]{5,100}$")
                && priceByHour != null && priceByHour > 0
                && totalLots > 0
                && schedules != null && !schedules.isEmpty()) {
            Parking parking = new Parking(objSystem, name, address, totalLots, priceByHour, schedules);
            objSystem.getParkings().add(parking);
            result = true;
        }
        return result;
    }

    public boolean createNewReceptionist(String id, String firstName, String lastName, String phoneNumber, String address, String email, String parking) {
        boolean result = false;

        if (id != null && firstName != null && lastName != null && phoneNumber != null && address != null && email != null && parking != null &&
                id.matches("\\d{5,10}") &&
                firstName.matches("[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+") &&
                lastName.matches("[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+") &&
                phoneNumber.matches("\\d{7,10}") &&
                address.matches(".{5,50}") &&
                email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {

            Receptionist receptionist = new Receptionist(this.objSystem, id, firstName, lastName, phoneNumber, address, parking);
            receptionist.setEmail(email);
            username = objSystem.createUsername(receptionist);
            receptionist.setUsername(username);
            password = objSystem.createPassword();
            receptionist.setPassword(password);
            objSystem.getUsers().add(receptionist);
            result = true;
        }
        return result;
    }


    public String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public String[] getParkingNames() {
        List<Parking> parkings = objSystem.getParkings();
        String[] names = new String[parkings.size()];

        for (int i = 0; i < parkings.size(); i++) {
            names[i] = parkings.get(i).getName();
        }

        return names;
    }


    public boolean validIdReceptionist(String id){
        return objSystem.searchUser(id, objSystem.SEARCH_BY_ID) != null;
    }
    
    public void modifyReceptionistCredentials(String id, String newPassword){
        if(checkPassword(newPassword, objSystem.searchUser(id, objSystem.SEARCH_BY_ID).getPassword())){
            objSystem.searchUser(id, objSystem.SEARCH_BY_ID).setPassword(newPassword);
        }
    }

   public boolean checkPassword(String newPassword, String previousPassword){
        
        if (newPassword.equals(previousPassword)){
            return false;
        }
        String pattern = "^[a-zA-Z0-9]{1,8}$";
        return Pattern.matches(pattern, newPassword);
    }

    @Override
    public String toString(){
        return super.toString();
    }

}

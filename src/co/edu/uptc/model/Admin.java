import java.util.List;
import java.util.regex.Pattern;

public class Admin extends User{
    private final ModelSystem objSystem;

    public Admin(ModelSystem objSystem){
        this.objSystem = objSystem;
    }

    public void createNewParking(String name, String address, int totalLots, Double priceByHour, List<Schedule> schedules){
        Parking parking = new Parking(name, address, totalLots, priceByHour, schedules);
        objSystem.addParking(parking);
    }

    public void createNewReceptionist(String id, String firstName, String lastName, String phoneNumber, String address,Parking assignedParking){
        Receptionist receptionist = new Receptionist(id, firstName, lastName, phoneNumber, address, assignedParking);
        receptionist.setUsername(objSystem.createUsername(receptionist));
        receptionist.setPassword(objSystem.createPassword());
        objSystem.addReceptionist(receptionist);
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


}

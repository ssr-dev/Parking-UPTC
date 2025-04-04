import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin extends User{
    private ModelSystem objSystem;

    public Admin(){
        objSystem = new ModelSystem();
    }

    public Parking createNewParking(String name, String address, int totalLots, Double priceByHour, List<Schedule> schedules){
        Parking parking =new Parking(name, address, totalLots, priceByHour, schedules);
        objSystem.addParking(parking);
        return parking;
     }

     public void createNewReceptionist(String id, String firstName, String lastName, String phoneNumber, String address,Parking assignedParking){
        Receptionist receptionist = new Receptionist(id, firstName, lastName, phoneNumber, address, assignedParking);
        objSystem.addReceptionist(receptionist);
        String username =objSystem.createUsername(receptionist);
        String password = objSystem.createPassword();
    }

    
    public void modifyReceptionistCridentials(String id, Receptionist receptionist){

        
        
    }

   public boolean checkPassword(String newPassword, String previousPassword){
        boolean compareToPassword = true;
        if (newPassword==previousPassword){
            compareToPassword = false;
        } else{
            String patron = "^[a-zA-Z0-9]{1,8}$";
		    Pattern pattern = Pattern.compile(patron);
            Matcher matcher = pattern.matcher(newPassword);
            compareToPassword = matcher.matches();
        }
        return compareToPassword;
    }


}

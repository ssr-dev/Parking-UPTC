public class Admin {

    public Admin(){

    }
   

     public Parking createNewParking(String address, int totalLots, double priceByHour, String[][] schedule){
        Parking parking = new Parking(address, totalLots, priceByHour, schedule);
        return parking;

     }

    public Receptionist createReceptionist(String id, String firstName, String lastName, String phoneNumber, String address, String nameParking){
        Receptionist receptionist = new Receptionist(id, firstName, lastName, phoneNumber, address, nameParking);
        return receptionist;
    }

    
    public void modifyReceptionistCridentials(String id, Receptionist receptionist){
        
        
    }
    public boolean checkPassword(String newPassword, String previousPassword){ 
        boolean compareToPassword = false;
        if (newPassword==previousPassword){
            compareToPassword = true;
        }
        return compareToPassword;
    }

}

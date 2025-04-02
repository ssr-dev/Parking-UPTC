public class Admin{

    public Admin(){
        
    }

     public Parking createNewParking(String name, String address, int totalLots, Double priceByHour, String[][] schedule){
        Parking parking = new Parking(name, address, totalLots, priceByHour, schedule);
        return parking;
     }

    public Receptionist createReceptionist(String id, String firstName, String lastName, String phoneNumber, String address,Parking assignedParking){
        Receptionist receptionist = new Receptionist(id, firstName, lastName, phoneNumber, address, assignedParking);
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

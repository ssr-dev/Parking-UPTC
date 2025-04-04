public class Receptionist extends User{
    public String id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String address;
    public Parking assignedParking;

    public Receptionist(String id, String firstName, String lastName, String phoneNumber, String address, Parking assignedParking){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.assignedParking = assignedParking;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void entryVehicle(String plate){
        //metodo de agregar vehiculo

    }

    public void exitVehicle(String plate){
        //remove vehicule, precio...
    }

}

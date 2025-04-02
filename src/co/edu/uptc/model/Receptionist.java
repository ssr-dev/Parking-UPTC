public class Receptionist {
    public String id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String address;
    public String nameParking; //cambiar

    public Receptionist(String id, String firstName, String lastName, String phoneNumber, String address, String nameParking){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.nameParking = nameParking;
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

    public String getNameParking() {
        return nameParking;
    }

    public void setNameParking(String nameParking) {
        this.nameParking = nameParking;
    }

    public void entryVehicle(String plate){

    }

    public void exitVehicle(String plate){

    }

}

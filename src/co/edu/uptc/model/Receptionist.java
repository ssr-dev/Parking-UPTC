public class Receptionist extends User{
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Parking assignedParking;

    public Receptionist(ModelSystem objSystem){
        super(objSystem);
    }

    public Receptionist(ModelSystem objSystem, String id, String firstName, String lastName, String phoneNumber, String address, Parking assignedParking){
        super(objSystem);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.assignedParking = assignedParking;
    }

    public void entryVehicle(String plate){
        Ticket ticket = new Ticket(plate, this);
        Vehicle vehicle = new Vehicle(plate, ticket);
        objSystem.getTickets().add(ticket);
        assignedParking.getVehicles().add(vehicle);
    }

    public void exitVehicle(String plate){
        assignedParking.searchVehicle(plate).getAssignedTicket().calculatePrice(assignedParking.getPriceByHour());
        assignedParking.removeVehicle(plate);
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

    public Parking getAssignedParking() {
        return assignedParking;
    }

    public void setAssignedParking(Parking assignedParking) {
        this.assignedParking = assignedParking;
    }

    @Override
    public String toString(){
        return super.toString() + ", " + this.id + ", " + this.firstName + ", " + this.lastName + ", " + this.phoneNumber + ", " + this.address + ", " + this.assignedParking.toString();
    }

}

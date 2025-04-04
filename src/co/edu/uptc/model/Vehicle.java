public class Vehicle {

    private String plate;
    private Ticket assignedTicket;

    public Vehicle(){

    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Ticket getAssignedTicket() {
        return assignedTicket;
    }

    public void setAssignedTicket(Ticket assignedTicket) {
        this.assignedTicket = assignedTicket;
    }

    public Vehicle(String plate, Ticket assignedTicket){
        this.plate = plate;
        this.assignedTicket = assignedTicket;
    }

}

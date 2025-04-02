public class Vehicle {

    private String plate;
    private Ticket assignedTicket;

    public Vehicle(){

    }

    public Vehicle(String plate, Ticket assignedTicket){
        this.plate = plate;
        this.assignedTicket = assignedTicket;
    }

}

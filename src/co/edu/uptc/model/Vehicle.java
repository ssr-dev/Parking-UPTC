public class Vehicle {

    private String plate;
    private Ticket assignedTicket;

    public Vehicle(){

    }

    public Vehicle(String plate, Ticket assignedTicket){
        this.plate = plate;
        this.assignedTicket = assignedTicket;
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

    @Override
    public String toString(){
        return this.plate + "";
    }

}

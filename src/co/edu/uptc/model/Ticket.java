import java.time.LocalDate;

public class Ticket {

    private Vehicle vehicle;
    private Receptionist receptionist;
    private LocalDate entryDate;
    private Double price;

    public Ticket(){

    }

    public Ticket(Vehicle vehicle, Receptionist receptionist){
        this.vehicle = vehicle;
        this.receptionist = receptionist;
        this.entryDate = LocalDate.now();
        this.price = null;
    }

    private int calculateTime(){
        String timeNow = LocalDate.now().toString();
        String entryTime = this.entryDate.toString();
        int time = String.valueOf(timeNow.substring(12, 13));
    }

    private Double calculatePrice(){

    }

    private Double calculateChange(){
        
    }


}

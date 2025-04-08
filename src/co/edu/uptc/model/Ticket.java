package co.edu.uptc.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    private String plate;
    private Receptionist receptionist;
    private LocalDate entryDate;
    private LocalTime entryTime;
    private Double price;

    public Ticket(){

    }

    public Ticket(String plate, Receptionist receptionist){
        this.plate = plate;
        this.receptionist = receptionist;
        this.entryDate = LocalDate.now();
        this.entryTime = LocalTime.now();
        this.price = null;
    }

    public int calculateTime(){
        String timeNow = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
        String entryTimeFormatted = entryTime.format(DateTimeFormatter.ISO_LOCAL_TIME);

        if (Integer.parseInt(timeNow.substring(3, 5)) < Integer.parseInt(entryTimeFormatted.substring(3, 5))) {
            return Integer.parseInt(timeNow.substring(0, 2)) - 1;
        }else if(Integer.parseInt(timeNow.substring(3, 5)) == Integer.parseInt(entryTimeFormatted.substring(3, 5))){
            return Integer.parseInt(timeNow.substring(0, 2));
        }else{
            return Integer.parseInt(timeNow.substring(0, 2)) + 1;
        }
    }

    public Double calculatePrice(Double price){
        Double totalPrice = price * calculateTime();
        this.price = totalPrice; 
        return totalPrice; 
    }

    // Este método tiene que ir en el controller, hay que pasarlo
    public Double calculateChange(Double cash){
        return cash - calculatePrice(price);
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString(){
        return this.plate + ", " + this.receptionist.getId() + ", " + this.entryDate + ", " + this.entryTime + ", " + this.price;
    }

}

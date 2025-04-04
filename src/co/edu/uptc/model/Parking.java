import java.util.ArrayList;
import java.util.List;

public class Parking {

    private String name;
    private String address;
    private int availableLots;
    private Double priceByHour;
    private List<Schedule> schedules;
    private List<Vehicle> vehicles;

    public Parking(){

    }

    public Parking(String name, String address, int availableLots, Double priceByHour, List<Schedule> schedules){
        this.name = name;
        this.address = address;
        this.availableLots = availableLots;
        this.priceByHour = priceByHour;
        this.vehicles = new ArrayList<>();
        this.schedules = schedules;
    }

    private void addVehicle(){

    }

    private void removeVehicle(String plate){

    }

    private Vehicle searchVehicle(String plate){

    }

    private void fillSchedules(){

    }

    private Schedule searchSchedule(String day){

    }

    private void modifySchedule(Schedule schedule, String openHour, String closeHour){
        
    }

}

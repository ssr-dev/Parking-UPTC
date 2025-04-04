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

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(String plate){
        if (searchVehicle(plate) != null) {
            this.vehicles.remove(searchVehicle(plate));
        }else{
            //La view debe mostrar "no se encontró el vehiculo"
        }
    }

    private Vehicle searchVehicle(String plate){
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlate().equals(plate)) { // Faltan getters de Vehicle
                return vehicle;
            }
        }

        return null;
    }

    private Schedule searchSchedule(String day){
        for (Schedule schedule : schedules) {
            if (schedule.getDay().equals(day)) { // Faltan getters de Schedule
                return schedule;
            }
        }

        return null;
    }

    private void modifySchedule(String day, String openHour, String closeHour){
        searchSchedule(day).setOpenHour(openHour); // faltan setters de Schedule
        searchSchedule(day).setCloseHour(closeHour); // faltan setters de Scehdule
    }

}

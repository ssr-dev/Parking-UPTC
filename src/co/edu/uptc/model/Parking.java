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
            if (vehicle.getPlate().equals(plate)) { 
                return vehicle;
            }
        }

        return null;
    }

    private Schedule searchSchedule(String day){
        for (Schedule schedule : schedules) {
            if (schedule.getDay().equals(day)) { 
                return schedule;
            }
        }

        return null;
    }

    public void modifySchedule(String day, String openHour, String closeHour){
        searchSchedule(day).setOpenTime(openHour); 
        searchSchedule(day).setCloseTime(closeHour); 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAvailableLots() {
        return availableLots;
    }

    public void setAvailableLots(int availableLots) {
        this.availableLots = availableLots;
    }

    public Double getPriceByHour() {
        return priceByHour;
    }

    public void setPriceByHour(Double priceByHour) {
        this.priceByHour = priceByHour;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}

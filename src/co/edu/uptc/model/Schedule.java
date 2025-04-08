package co.edu.uptc.model;

public class Schedule {

    private String day;
    private String openTime;
    private String closeTime;

    public Schedule(){

    }

    public Schedule(String day, String openTime, String closeTime){
        this.day = day;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString(){
        return "[" + this.day + ", " + this.openTime + ", " + this.closeTime + "]";
    }

}

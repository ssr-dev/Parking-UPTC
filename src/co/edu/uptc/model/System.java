import java.util.ArrayList;
import java.util.List;

public class System {

    private List<Parking> parkings;
    private List<Ticket> tickets;
    private List<User> users;
    private User activeUser;

    public System (){
        parkings = new ArrayList<>();
        tickets = new ArrayList<>();
        users = new ArrayList<>();
    }

    private void logIn(String username, String password){
        
    }

    private void validateLogIn(String username, String password){

    }

    private User searchUser(String key, int searchMethod){
        
    }

    private void addParking(Parking parking){

    }

    private void createUsername(User user){

    }

    private void createPassword(User user){

    }

    private void addReceptionist(Receptionist receptionist){

    }

    private Ticket[] getReport(Date date){

    }

    private Ticket[] getReport(Date date, Receptionist receptionist){

    }

    private int getTotalEntries(Ticket[] records){

    }

    private Double getTotalEarnings(Ticket[] records){

    }

}

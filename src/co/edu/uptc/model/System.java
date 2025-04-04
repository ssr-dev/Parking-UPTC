import java.util.ArrayList;
import java.util.List;

public class System {

    public final int SEARCH_BY_USERNAME = 0;
    public final int SEARCH_BY_ID = 1;

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
        if (validateLogIn(username, password)){
            this.activeUser = searchUser(username, SEARCH_BY_USERNAME);
        }else{
            // Llama al presenter para dar mensaje en vista "Credenciales no válidas"
        }
    }

    private boolean validateLogIn(String username, String password){
        return searchUser(username, SEARCH_BY_USERNAME).getPassword.equals(password); //falta agregar los get en User
    }

    private User searchUser(String key, int searchMethod){
        if(searchMethod == 0){
            for (User user : users) {
                if (user.getUsername.equals(key)) { //falta agregar los get en User
                    return user;
                }else{
                    return null;
                }
            }
        }else if (searchMethod == 1){
            for (User user : users) {
                if (user.getId.equals(key)) { //falta agregar los get en User
                    return user;
                }else{
                    return null;
                }
            }
        }
    }

    public void addParking(Parking parking){
        parkings.add(parking);
    }

    private void createUsername(User user){

    }

    private void createPassword(User user){

    }

    public void addReceptionist(Receptionist receptionist){
        users.add(receptionist);
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

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class ModelSystem {

    public final int SEARCH_BY_USERNAME = 0;
    public final int SEARCH_BY_ID = 1;
    private final int PASSWORD_LENGHT = 8;

    private List<Parking> parkings;
    private List<Ticket> tickets;
    private List<User> users;
    private User activeUser;

    public ModelSystem (){
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
        return searchUser(username, SEARCH_BY_USERNAME).getPassword().equals(password); //falta agregar los get en User
    }

    public User searchUser(String key, int searchMethod){
        if(searchMethod == 0){
            for (User user : users) {
                if (user.getUsername().equals(key)) { //falta agregar los get en User
                    return user;
                }
            }
        }else if (searchMethod == 1){
            for (User user : users) {
                if (user instanceof Receptionist) { //falta herencia de User
                    Receptionist r = (Receptionist) user;
                    if (r.getId().equals(key)) { //falta agregar los get en User
                        return r;
                    }
                }
            }
            
        }

        return null;
    }

    public void addParking(Parking parking){
        this.parkings.add(parking);
    }

    public String createUsername(Receptionist r){
        String username = r.getFirstName() + "_" + r.getLastName();
        boolean unique = false;
        int index = 2;

        while (unique == false) { 
            if (!checkExistingUsername(username)) {
                unique = true;
            }else{
                username = username + "index";
                index++;
            }
        }

        return username;
    }

    private boolean checkExistingUsername(String username){
        boolean existing = false;
        int index = 0;
        while (existing = false) { 
            if(this.users.get(index).getUsername().equals(username)){
                existing = true;
            }else{
                index++;
            }
        }
    }

    public String createPassword(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGHT);

        for (int i = 0; i < PASSWORD_LENGHT; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public void addReceptionist(Receptionist receptionist){
        this.users.add(receptionist); // falta herencia de User
    }

    public List<Ticket> getReport(Date date){
        List<Ticket> report = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (ticket.getDate().equals(date)) {
                report.add(ticket);
            }
        }

        return report;
    }

    public List<Ticket> getReport(Date date, Receptionist receptionist){
        List<Ticket> report = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (ticket.getDate().equals(date) && ticket.getReceptionist().equals(receptionist)) {
                report.add(ticket);
            }
        }

        return report;
    }

    public List<Receptionist> getReportReceptionists(List<Ticket> report){
        List<Receptionist> receptionists = new ArrayList<>();

        String receptionistUsername = report.get(0).getUsername(); // Falta getters de Receptionist

        for (Ticket ticket : report) {
            if (ticket.getReceptionist().getUsername().equals(receptionistUsername)) {
                receptionists.add(ticket.getReceptionist()); // Falta getters de Ticket
            }
        }

        return receptionists;
    }

    public int getTotalEntries(List<Ticket> records){
        return records.size();
    }

    public Double getTotalEarnings(List<Ticket> records){
        Double earnings = 0.0;

        for (Ticket ticket : records) {
            earnings = earnings + ticket.getPrice(); // Faltan getters de Ticket
        }

        return earnings;
    }
    
}

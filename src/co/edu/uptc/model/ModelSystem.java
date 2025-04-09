package co.edu.uptc.model;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelSystem {

    public final int SEARCH_BY_USERNAME = 0;
    public final int SEARCH_BY_ID = 1;
    private final int PASSWORD_LENGHT = 8;

    private final List<Parking> parkings;
    private final List<Ticket> tickets;
    private final List<User> users;
    private User activeUser;

    public ModelSystem() {
        parkings = new ArrayList<>();
        tickets = new ArrayList<>();
        users = new ArrayList<>();
    }

    public boolean validateLogIn(String username, String password) {

        if (searchUser(username, SEARCH_BY_USERNAME) != null) {
            return searchUser(username, SEARCH_BY_USERNAME).getPassword().equals(password);
        }
        return false;
    }

    public boolean validateLogInAdmin(String usernameU, String passwordU) {
        boolean validateAdmin = false;
        String username = "Faustino_Ramirez";
        String password = "dwe23";
        if (username.equals(usernameU) && password.equals(passwordU)) {
            validateAdmin = true;
        }
        return validateAdmin;
    }

    public User searchUser(String key, int searchMethod) {
        if (searchMethod == 0) {
            for (User user : users) {
                if (user.getUsername().equals(key)) {
                    return user;
                }
            }
        } else if (searchMethod == 1) {
            for (User user : users) {
                if (user instanceof Receptionist r) {
                    if (r.getId().equals(key)) {
                        return r;
                    }
                }
            }

        }

        return null;
    }

    public String createUsername(Receptionist r) {
        String username = r.getFirstName() + "_" + r.getLastName();
        boolean unique = false;
        int index = 2;

        while (unique == false) {
            if (!checkExistingUsername(username)) {
                unique = true;
            } else {
                username = username + index;
                index++;
            }
        }

        return username;
    }

    private boolean checkExistingUsername(String username) {
        int index = 0;
        while (index < this.users.size()) {
            if (this.users.get(index).getUsername().equals(username)) {
                return true;
            }

            index++;
        }

        return false;
    }

    public String createPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGHT);

        for (int i = 0; i < PASSWORD_LENGHT; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public List<Ticket> getReport(LocalDate date) {
        List<Ticket> report = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (ticket.getEntryDate().equals(date)) {
                report.add(ticket);
            }
        }

        return report;
    }

    public List<Ticket> getReport(LocalDate date, Receptionist receptionist) {
        List<Ticket> report = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (ticket.getEntryDate().equals(date) && ticket.getReceptionist().equals(receptionist)) {
                report.add(ticket);
            }
        }

        return report;
    }

    public Object[][] getReceptionistReportTable() {
        List<Ticket> report = this.getTickets(); // Ajusta si necesitas filtrar por fecha
        if (report.isEmpty()) {
            return new Object[0][4];
        }

        String targetUsername = report.get(0).getReceptionist().getUsername();
        Receptionist receptionist = report.get(0).getReceptionist();
        int vehicleCount = 0;
        double totalIncome = 0;

        for (Ticket ticket : report) {
            if (ticket.getReceptionist().getUsername().equals(targetUsername)) {
                vehicleCount++;
                totalIncome += ticket.getPrice(); // Asegúrate que ticket tenga getPrice()
            }
        }
        return new Object[][]{
                {
                        receptionist.getFirstName(),
                        receptionist.getLastName(),
                        "$" + totalIncome,
                        vehicleCount
                }
        };
    }


    public int getTotalEntries(List<Ticket> records) {
        return records.size();
    }

    public Double getTotalEarnings(List<Ticket> records) {
        Double earnings = 0.0;

        for (Ticket ticket : records) {
            earnings = earnings + ticket.getPrice();
        }

        return earnings;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public List<Parking> getParkings() {
        return parkings;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<User> getUsers() {
        return users;
    }

}

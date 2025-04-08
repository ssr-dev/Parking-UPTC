package co.edu.uptc.model;

public class User {
    protected String username;
    protected String password;
    protected String email;
    protected final ModelSystem objSystem;

    public User(ModelSystem objSystem){
        this.objSystem = objSystem;
    }

    public User(ModelSystem objSystem, String username, String password){
        this.objSystem = objSystem;
        this.username = username;
        this.password = password;
        this.email = null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return this.username + ", " + this.password + ", " + this.email;
    }

}

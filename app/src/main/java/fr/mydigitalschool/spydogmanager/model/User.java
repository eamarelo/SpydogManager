package fr.mydigitalschool.spydogmanager.model;

/**
 * Created by jp789 on 31/03/2018.
 */

public class User {
    String ID;
    String Name;
    String Email;
    String Password;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
}


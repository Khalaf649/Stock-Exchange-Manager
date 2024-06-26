package oop.stockexchangemanager.AccountPackage;

import javafx.scene.control.DatePicker;
import oop.stockexchangemanager.Database.Admins;
import oop.stockexchangemanager.Database.Users;

import java.util.Map;

public class Authentication {
    public static User SignUp(String UserName, String Password, String Email, DatePicker birthdate){
        User user = User.Generate(UserName,Password,Email,birthdate);
        return  Users.getInstance().create(user.getId(),user);
    }
    public static User signInAsUser(String email, String password) {
        // Iterate through the HashMap containing user data
        for (Map.Entry<Integer, User> entry : Users.getInstance().getData().entrySet()) {
            User user = entry.getValue();
            // Check if the email and password match
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user; // Return the user object if sign-in is successful
            }
        }
        throw new RuntimeException("Invalid email or password");

    }
    public static Admin signInAsAdmin(String email, String password) {
        // Iterate through the HashMap containing user data
        for (Map.Entry<Integer, Admin> entry : Admins.getInstance().getData().entrySet()) {
            Admin admin = entry.getValue();
            // Check if the email and password match
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                return admin; // Return the user object if sign-in is successful
            }
        }

        return null;// Throw exception if sign-in fails
    }


}
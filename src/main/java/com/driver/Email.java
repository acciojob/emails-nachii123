package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }
    ArrayList<Email> emails = new ArrayList<>();



    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(newPassword.length()>=8 && newPassword.equals(oldPassword) && newPassword.matches(".*[A-Z].*") && newPassword.matches(".*[a-z].*") && newPassword.matches(".*[^A-Za-z09].*") && newPassword.matches(".*\\d.*") && newPassword.matches(".*[^A-Za-z09].*")){
            this.password = newPassword;
        }
//        if(!newPassword.equals(oldPassword)){
//            System.out.println("Invalid old, Password not changed..");
//            return;
//        }
//
//        if (!newPassword.matches(".*[A-Z].*")){
//            System.out.println("Password should contain at least one uppercase letter.");
//            return;
//        }
//
//        if(!newPassword.matches(".*[a-z].*")){
//            System.out.println("Password should contain at least one lowercase letter.");
//            return;
//        }
//
//        if(!newPassword.matches(".*\\d.*")){
//            System.out.println("Password should contain at least one digit.");
//            return;
//        }
//
//        if(!newPassword.matches(".*[^A-Za-z09].*")){
//            System.out.println("Password should contain at least one special character.");
//            return;
//        }
//
//        this.password = newPassword;



    }
}

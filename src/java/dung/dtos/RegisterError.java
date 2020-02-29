/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.dtos;

import java.io.Serializable;

/**
 *
 * @author Pham Anh Dung
 */
public class RegisterError implements Serializable{
     String usernameErr, passwordErr,emailErr,fullnameErr,addressErr,passwordcomfirmErr,phonenoErr,usernameDuplicate;

    public String getPhonenoErr() {
        return phonenoErr;
    }

    public void setPhonenoErr(String phonenoErr) {
        this.phonenoErr = phonenoErr;
    }

    public String getPasswordcomfirmErr() {
        return passwordcomfirmErr;
    }

    public void setPasswordcomfirmErr(String passwordcomfirmErr) {
        this.passwordcomfirmErr = passwordcomfirmErr;
    }

    public String getUsernameErr() {
        return usernameErr;
    }

    public void setUsernameErr(String usernameErr) {
        this.usernameErr = usernameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    public String getFullnameErr() {
        return fullnameErr;
    }

    public void setFullnameErr(String fullnameErr) {
        this.fullnameErr = fullnameErr;
    }

    public String getAddressErr() {
        return addressErr;
    }

    public void setAddressErr(String addressErr) {
        this.addressErr = addressErr;
    }

    public String getUsernameDuplicate() {
        return usernameDuplicate;
    }

    public void setUsernameDuplicate(String usernameDuplicate) {
        this.usernameDuplicate = usernameDuplicate;
    }
     
}

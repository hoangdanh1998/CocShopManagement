/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import danh.user.UserDAO;
import danh.user.UserDTO;

/**
 *
 * @author Hoang Danh
 */
public class RegisterAction extends ActionSupport {

    private String username, password, confirm, address, phone, fullname;

    public RegisterAction() {
    }

    public String execute() throws Exception {

        System.out.println(username + "+" + password + "+" + confirm + "+" + address + "+" + phone);
        UserDAO dao = new UserDAO();

        if (dao.insertUser(new UserDTO(username, password, fullname, "user", address, phone))) {
            return SUCCESS;
        }
        return ERROR;
    }

    @Override
    public void validate() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @FieldExpressionValidator(expression = "confirm == password",
            message = "Confirm not match")
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getFullname() {
        return fullname;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static String getNONE() {
        return NONE;
    }

    public static String getERROR() {
        return ERROR;
    }

    public static String getINPUT() {
        return INPUT;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

}

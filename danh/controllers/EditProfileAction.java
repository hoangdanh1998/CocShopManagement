/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import danh.user.UserDAO;
import danh.user.UserDTO;

/**
 *
 * @author Hoang Danh
 */
public class EditProfileAction extends ActionSupport {
    private String address, phone, fullname;
    
    public EditProfileAction() {
    }
    
    public String execute() throws Exception {
        UserDAO  dao = new UserDAO();
        UserDTO dto = ((UserDTO)ActionContext.getContext().getSession().get("USER"));
         dto.setAddress(address);
         dto.setPhone(phone);
         dto.setFullname(fullname);
         dao.update(dto);
        return SUCCESS;
    }

      
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
}

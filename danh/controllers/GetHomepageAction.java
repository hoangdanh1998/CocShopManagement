/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import danh.user.UserDTO;
import java.util.Map;

/**
 *
 * @author Hoang Danh
 */
public class GetHomepageAction extends ActionSupport {
    private static final String USER = "user", ADMIN = "admin", GUEST = "guest";
    
    public GetHomepageAction() {
    }
    
    public String execute() throws Exception {
        Map<String,Object> session = ActionContext.getContext().getSession();
        String role = "";
        if (session.get("USER") != null) {
        role = ((UserDTO) session.get("USER")).getRole();
            
        }
        if (role.equalsIgnoreCase("user")) {
            return USER;
        } else if (role.equalsIgnoreCase("admin")) {
            return ADMIN;
        }
        return GUEST;
    }
    
}

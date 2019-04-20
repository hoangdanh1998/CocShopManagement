/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import danh.user.UserDAO;
import danh.user.UserDTO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Hoang Danh
 */
//@Action(value = "LoginAction", results = {
//    @Result(name = "admin", location = "admin/index.jsp"),
//    @Result(name = "user", location = "user/index.jsp"),
//    @Result(name = "error", location = "login.jsp"),
//    @Result(name = "input", location = "login.jsp")
//})
public class LoginAction extends ActionSupport {

    private String username, password;

    public LoginAction() {
    }

    @Override
    public String execute() throws Exception {
        String lable = ERROR;
        UserDAO dao = new UserDAO();
        UserDTO dto = dao.checkLogin(username, password);
        HttpServletRequest request = ServletActionContext.getRequest();
        if (dto.getRole().equals("failed")) {
            request.setAttribute("ERROR", "Invalid username or password");
        } else {
           Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("USER", dao.getUser(dto.getUsername()));
            if (dto.getRole().equals("admin")) {
                lable = "admin";
            } else if (dto.getRole().equals("user")) {
                lable = "user";
            } else {
                request.setAttribute("ERROR", "Your role not support");
            }
        }
        return lable;

    } 
   
    @RequiredStringValidator(
            type=ValidatorType.FIELD,
            message = "You can't leave this fields blank")
    @StringLengthFieldValidator(type = ValidatorType.FIELD,
            minLength = "3",maxLength ="20",
            message = "Username length must be 3 to 20 chars")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

}

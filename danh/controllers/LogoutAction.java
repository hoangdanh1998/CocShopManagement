/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.util.Map;

/**
 *
 * @author Hoang Danh
 */
public class LogoutAction extends ActionSupport {
      
    public LogoutAction() {
    }
    
    public String execute() throws Exception {
         Map<String, Object> session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }

  

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
}

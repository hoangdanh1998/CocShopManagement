/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import danh.order.OrderDAO;
import danh.order.OrderDTO;
import danh.user.UserDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hoang Danh
 */
public class ViewOrderAction extends ActionSupport {
    private List<OrderDTO> list;
    public ViewOrderAction() {
    }
    
    public String execute() throws Exception {
        System.out.println("here");
        Map<String, Object> session = ActionContext.getContext().getSession();
        String username = ((UserDTO)session.get("USER")).getUsername();
        
        list = new OrderDAO().getAllOrder(username);
        return SUCCESS;
    }

    public List<OrderDTO> getList() {
        return list;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
}

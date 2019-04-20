/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import danh.cart.CartDAO;
import danh.cart.CartProductDTO;
import danh.user.UserDTO;
import java.util.List;

/**
 *
 * @author Hoang Danh
 */
public class ViewCartAction extends ActionSupport {

    List<CartProductDTO> list;

    public ViewCartAction() {
    }

    public String execute() throws Exception {
        CartDAO dao = new CartDAO();
        String userid = ((UserDTO) ActionContext.getContext().getSession().get("USER")).getUsername();
        list =  dao.getCart(userid);
        
        
        return SUCCESS;
    }

    public List<CartProductDTO> getList() {
        return list;
    }

    

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
}

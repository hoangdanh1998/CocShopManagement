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
import danh.user.UserDTO;
import java.util.Map;

/**
 *
 * @author Hoang Danh
 */
public class DeleteCartAction extends ActionSupport {
    private String productID;
    public DeleteCartAction() {
    }
    
    public String execute() throws Exception {
        Map<String,Object> session = ActionContext.getContext().getSession();
        String username = ((UserDTO) session.get("USER")).getUsername();
        CartDAO dao = new CartDAO();
        dao.deleteProduct(username,productID);
        return SUCCESS;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
}

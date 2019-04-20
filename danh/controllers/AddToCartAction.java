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
public class AddToCartAction extends ActionSupport {

    private String productID;
    private int quantity = 1;

    public AddToCartAction() {
    }

    public String execute() throws Exception {
        CartDAO dao = new CartDAO();
        Map<String, Object> session = ActionContext.getContext().getSession();
        String username = ((UserDTO) session.get("USER")).getUsername();
        try {
            if (dao.addToDB(username, productID, quantity)) {
                return SUCCESS;
            }
        } catch (Exception e) {

            int quantityDB = dao.getQuantity(username, productID);
            if (quantityDB > -1) {
                dao.setQuantity(username, productID, quantity + quantityDB);
                return SUCCESS;
            }
        }
        return ERROR;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

}

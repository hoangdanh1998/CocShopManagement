/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import danh.cart.CartDAO;
import danh.product1.ProductDAO;
import danh.cart.CartProductDTO;
import danh.user.UserDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hoang Danh
 */
public class ConfirmOrderAction extends ActionSupport {
    
    public ConfirmOrderAction() {
    }
    
    public String execute() throws Exception {
        Map<String,Object> session = ActionContext.getContext().getSession();
        String username = ((UserDTO)session.get("USER")).getUsername();
             
        
        List<CartProductDTO> list = new CartDAO().getCart(username);
        ProductDAO dao = new ProductDAO();
        for (CartProductDTO productDTO : list) {
            if (productDTO.getQuantity() > dao.getProduct(productDTO.getId()).getQuantity()) {
                return ERROR;
            }
        }
        return SUCCESS;
    }
    
}

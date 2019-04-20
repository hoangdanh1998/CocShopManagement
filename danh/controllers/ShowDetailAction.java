/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import danh.cart.CartProductDTO;
import danh.order.OrderDAO;
import danh.product1.ProductDAO;
import danh.product1.ProductDTO;
import java.util.List;

/**
 *
 * @author Hoang Danh
 */
public class ShowDetailAction extends ActionSupport {
    private String orderID;
    List<CartProductDTO> list;
    public ShowDetailAction() {
    }
    
    public String execute() throws Exception {
        OrderDAO dao = new OrderDAO();
        list = dao.getListOrderDetail(orderID);
        ProductDAO productDAO = new ProductDAO();
        for (CartProductDTO dto : list) {
            ProductDTO myProduct = productDAO.getProduct(dto.getId());
            String type = myProduct.getType();
            String name = productDAO.getProduct(dto.getId()).getName();
            dto.setName(name);
            dto.setType(type);
        }
        return SUCCESS;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<CartProductDTO> getList() {
        return list;
    }
    
    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
    
}

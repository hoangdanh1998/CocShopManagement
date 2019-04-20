/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import danh.cart.CartDAO;
import danh.cart.CartProductDTO;
import danh.order.OrderDAO;
import danh.order.OrderDTO;
import danh.product1.ProductDAO;
import danh.user.UserDTO;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hoang Danh
 */
public class ConfirmInforAction extends ActionSupport {

    private String receiver, note, address, phone;

    public ConfirmInforAction() {
    }

    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String username = ((UserDTO) session.get("USER")).getUsername();

        List<CartProductDTO> list = new CartDAO().getCart(username);
        ProductDAO dao = new ProductDAO();
        for (CartProductDTO productDTO : list) {
            if (productDTO.getQuantity() > dao.getProduct(productDTO.getId()).getQuantity()) {
                return ERROR;
            }
        }

        OrderDTO orderDTO = new OrderDTO(username, address, note, receiver, phone, new java.sql.Date(new Date().getTime()));
        OrderDAO orderDAO = new OrderDAO();
        int orderID = orderDAO.createOrder(orderDTO);
        System.out.println("orderID " +orderID);
        if (orderID > 0) {

            if (orderDAO.createOrderDetail(list, orderID) && new CartDAO().remove(username)) {
                for (CartProductDTO productDTO : list) {
                    int old = dao.getProduct(productDTO.getId()).getQuantity();
                    int newQuantity = productDTO.getQuantity();
                    dao.setQuantity(productDTO.getId(), old - newQuantity);
                }
                return SUCCESS;
            }
        }

        return ERROR;
    }

    public String getReceiver() {
        return receiver;
    }

   

    public void setNote(String note) {
        this.note = note;
    }
    
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Can't be blank")
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Address can't be blank")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    @RegexFieldValidator(type = ValidatorType.FIELD,
            message = "Phone number invalid",
            regex = "\\d{10}")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

}

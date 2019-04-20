/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import danh.order.OrderDAO;

/**
 *
 * @author Hoang Danh
 */
public class CancelOrderAction extends ActionSupport {

    private int orderId;

    public CancelOrderAction() {
    }

    public String execute() throws Exception {
        System.out.println("orderId"+orderId);
        OrderDAO dao = new OrderDAO();
        dao.changeStatusOrder(orderId, "Cancel");
        return SUCCESS;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
}

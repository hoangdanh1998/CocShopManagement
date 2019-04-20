/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionSupport;
import danh.order.OrderDAO;

/**
 *
 * @author Hoang Danh
 */
public class FinishAction extends ActionSupport {

    private int orderId;

    public FinishAction() {
    }

    public String execute() throws Exception {
        System.out.println("ID "+orderId);
        if (new OrderDAO().changeStatusOrder(orderId,"Finish")) {
            return SUCCESS;
        }
        return ERROR;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
}

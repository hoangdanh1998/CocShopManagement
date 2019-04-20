/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.order;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Hoang Danh
 */
public class OrderDTO implements Serializable {

    private String orderBy, status, shippingAddress, note, receiver, phone;
    private int orderID;
    private Date orderDate;

    public OrderDTO() {
    }

    public OrderDTO(String status, String shippingAddress, String note, String receiver, String phone, int orderID, Date orderDate) {
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.note = note;
        this.receiver = receiver;
        this.phone = phone;
        this.orderID = orderID;
        this.orderDate = orderDate;
    }
    
    public OrderDTO(String orderBy, String shippingAddress, String note, String receiver, String phone, Date orderDate) {
        this.orderBy = orderBy;
        this.status = "NEW";
        this.shippingAddress = shippingAddress;
        this.note = note;
        this.receiver = receiver;
        this.phone = phone;
        this.orderDate = orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    
    
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.order;

import danh.cart.CartProductDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hoang Danh
 */
public class OrderObject implements Serializable{
    private int orderID;
    private  String fullname, status;
    
    private List<CartProductDTO> listProduct;

    public OrderObject(int orderID, String fullname,String status, List<CartProductDTO> list) {
        this.orderID = orderID;
        this.fullname = fullname;
        this.status = status;
        this.listProduct = list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String username) {
        this.fullname = username;
    }

    public List<CartProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<CartProductDTO> listProduct) {
        this.listProduct = listProduct;
    }

   
    
}

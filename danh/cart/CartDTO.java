/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.cart;

import danh.product1.ProductDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hoang Danh
 */
public class CartDTO implements Serializable{
    private String customerName;
    private List<ProductDTO> list;

    public CartDTO() {
    }

    public CartDTO(String customerName, List<ProductDTO> list) {
        this.customerName = customerName;
        this.list = list;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ProductDTO> getList() {
        return list;
    }

    public void setList(List<ProductDTO> list) {
        this.list = list;
    }
    
    
}

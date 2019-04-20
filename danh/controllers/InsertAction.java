/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import danh.product1.ProductDAO;
import danh.product1.ProductDTO;

/**
 *
 * @author Hoang Danh
 */
public class InsertAction extends ActionSupport {

    private String id, name, description, type;
    private float price;
    private int quantity;
    
    
    public InsertAction() {
    }
    
    public String execute() throws Exception {
        
        ProductDTO dto = new ProductDTO(id, name, description, quantity, price, type);
        System.out.println(dto);
        if (new ProductDAO().insert(dto)) {
            return SUCCESS;
        }         
        return ERROR;
    }
    
    public String getId() {
        return id;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "This feild can't be blank")

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "This feild can't be blank")
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "This feild can't be blank")
    public void setDescription(String des) {
        this.description = des;
    }

    public String getType() {
        return type;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "This feild can't be blank")
    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import danh.order.OrderDAO;
import danh.product1.ProductDAO;
import danh.product1.ProductDTO;
import danh.user.UserDAO;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Hoang Danh
 */
public class ShowIndexAction extends ActionSupport {

    private static final String PRODUCT = "product";
    private static final String USER = "user";
    private static final String ORDER = "order";
    private static final String INSERTPRODUCT = "insertProduct";
    ArrayList list;
    String typeInput;

    public ShowIndexAction() {
    }

    @Override
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();

        System.out.println(typeInput + ": typeInput");

        if (typeInput == null) {
            ProductDAO dao = new ProductDAO();
            list = dao.getAllProduct();
            return SUCCESS;
        }

       
        if (session.isEmpty()) {
            return LOGIN;
        }
        if (typeInput.equals("InsertProduct")) {
            return INSERTPRODUCT;
        }
        if (typeInput.equals("Product")) {
            ProductDAO dao = new ProductDAO();
            list = dao.getAllProduct();
            return PRODUCT;
        }
        if (typeInput.equals("Order")) {
            OrderDAO dao = new OrderDAO();
            list = dao.getAllOrder();            
            return ORDER;
        }
        if (typeInput.equals("User")) {
            UserDAO dao = new UserDAO();
            list = dao.getAllUser();
            return USER;
        }
        return "fail";
    }

    public ArrayList<ProductDTO> getList() {
        return list;
    }

    public void setList(ArrayList<ProductDTO> list) {
        this.list = list;
    }

    public String getTypeInput() {
        return typeInput;
    }

    public void setTypeInput(String typeInput) {
        this.typeInput = typeInput;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

}

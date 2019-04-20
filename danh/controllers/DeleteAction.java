/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import danh.product1.ProductDAO;
import danh.user.UserDAO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Hoang Danh
 */
public class DeleteAction extends ActionSupport {

    private static final String USER = "user";
    private static final String PRODUCT = "product";
    private String pk;
    private String typeInput;

    public DeleteAction() {
    }

    public String execute() throws Exception {
        System.out.println("TypeInput delete:" + typeInput);
        if (typeInput.equals("Product")) {
            ProductDAO dao = new ProductDAO();
            dao.delete(pk);
            return PRODUCT;

        } else if (typeInput.equals("User")) {
            UserDAO dao = new UserDAO();
            dao.delete(pk);
            return USER;
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Delete failed");
            return ERROR;
        }

    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
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

package danh.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import danh.product1.ProductDAO;
import danh.user.UserDAO;
import java.util.ArrayList;

/**
 *
 * @author Hoang Danh
 */
public class SearchAction extends ActionSupport {
    private static final String USER = "user";
    private static final String PRODUCT = "product";
    private String typeInput;
    private String searchValue;
    private ArrayList list;

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public SearchAction() {
    }

    @Override
    public String execute() throws Exception {
        System.out.println(typeInput + ": Type");
        if (typeInput.equals("Product")) {
            ProductDAO dao = new ProductDAO();
            list = dao.search(searchValue);
            return PRODUCT;
        } else if (typeInput.equals("User")) {
            list = new UserDAO().search(searchValue);
            return USER;
        }
        return ERROR;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public String getTypeInput() {
        return typeInput;
    }

    public void setTypeInput(String typeInput) {
        this.typeInput = typeInput;
    }
    
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "You can't leave this empty ")
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    
    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

}

package danh.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import danh.product1.ProductDAO;
import danh.user.UserDAO;

/**
 *
 * @author Hoang Danh
 */
public class EditAction extends ActionSupport {

    private final static String SUCCESSPRODUCT = "successProduct";
    private final static String SUCCESSUSER = "successUser";
    private String pk, typeInput;
    private Object dto;

    public String execute() throws Exception {
        System.out.println(typeInput);
        if (typeInput.equals("Product")) {
            ProductDAO dao = new ProductDAO();
            dto = dao.getProduct(pk);
            return SUCCESSPRODUCT;
        } else if (typeInput.equals("User")) {
            dto = new UserDAO().getUser(pk);
            return SUCCESSUSER;
        }
        return ERROR;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public Object getDto() {
        return dto;
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

    public EditAction() {
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.cart;

import danh.db.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang Danh
 */
public class CartDAO implements Serializable {

    public boolean deleteProduct(String userID, String productID) throws Exception {
        String sql = "Delete from tbl_Cart where userid = ? and productid = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, userID);
            stm.setString(2, productID);
            return stm.executeUpdate() > 0;
        }
    }

    public boolean addToDB(String userID, String productID, int quantity) throws Exception {
        String sql = "Insert into tbl_cart(productid, userid, quantity) values(?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, productID);
            stm.setString(2, userID);
            stm.setInt(3, quantity);
            return stm.executeUpdate() > 0;
        }
    }

    public boolean setQuantity(String userID, String productID, int quantity) throws Exception {
        String sql = "update tbl_cart set quantity = ? where productID = ? and userID = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(2, productID);
            stm.setString(3, userID);
            stm.setInt(1, quantity);
            return stm.executeUpdate() > 0;
        }
    }

    public int getQuantity(String userID, String productID) throws Exception {
        String sql = "select quantity from tbl_cart  where productID = ? and userID = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, productID);
            stm.setString(2, userID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Quantity");
                }
            }
        }
        return -1;
    }
    public boolean remove(String userId) throws Exception{
        String sql = "Delete tbl_Cart where userID = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, userId);
            return stm.executeUpdate() > 0;
        } 
    }
    public List<CartProductDTO> getCart(String userid) throws Exception {
        List<CartProductDTO> list = null;
        String sql = "select c.productid as productid, c.quantity as quantity,"
                + "p.quantity as maxquantity, p.type as type, p.description as description, "
                + "p.Name as name , p.Price as price\n"
                + "from tbl_cart as c\n"
                + "Join tbl_Product as p on c.productid = p.ProductID\n"
                + "	where userid = ? \n";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, userid);
            try (ResultSet rs = stm.executeQuery()) {
                list = new ArrayList();
                while (rs.next()) {
                    String productID = rs.getString("productid");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    String type = rs.getString("type");
                    int maxQuantity = rs.getInt("maxQuantity");

                    list.add(new CartProductDTO(productID, name, description, quantity, price, type, maxQuantity));
                }

            }
        }
        return list;
    }
}

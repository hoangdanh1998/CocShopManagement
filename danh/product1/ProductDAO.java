/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.product1;

import danh.db.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hoang Danh
 */
public class ProductDAO implements Serializable {

    

    public ProductDTO getProduct(String id) throws Exception {
        String sql = "Select name, description,quantity, type, price from tbl_product where productId = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    String type = rs.getString("type");
                    return new ProductDTO(id, name, description, quantity, price, type);
                }
            }
        }
        return null;
    }

    public ArrayList<ProductDTO> search(String value) throws Exception {
        ArrayList<ProductDTO> list = null;
        String id, name, description;
        String type;
        float price;
        String sql = "Select quantity, productID as id, name, description, type, price from tbl_product where name like ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, "%" + value + "%");
            try (ResultSet rs = stm.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    id = rs.getString("id");
                    name = rs.getString("name");
                    description = rs.getString("description");
                    price = rs.getFloat("price");
                    type = rs.getString("type");
                    int quantity = rs.getInt("quantity");
                    ProductDTO dto = new ProductDTO(id, name, description, price, type);
                    dto.setQuantity(quantity);
                    list.add(dto);
                }
            }
        }
        return list;
    }

    public ArrayList<ProductDTO> getAllProduct() throws Exception {
        ArrayList<ProductDTO> list = null;
        String id, name, description;
        String type;
        float price;
        String sql = "Select quantity, productID as id, name, description, type, price from tbl_product where quantity > -1";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    id = rs.getString("id").trim();
                    name = rs.getString("name");
                    description = rs.getString("description");
                    price = rs.getFloat("price");
                    type = rs.getString("type");
                    int quantity = rs.getInt("quantity");
                    ProductDTO dto = new ProductDTO(id, name, description, price, type);
                    dto.setQuantity(quantity);
                    list.add(dto);
                }
            }
        }
        return list;
    }

    public boolean delete(String id) throws Exception {
        String sql = "Update tbl_Product set quantity = -1 where ProductId = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, id);
            return stm.executeUpdate() > 0;
        }
    }

    public boolean insert(ProductDTO dto) throws Exception {
        String sql = "Insert into tbl_Product(productId, name, description, quantity, price, type)"
                + " values(?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, dto.getId());
            stm.setString(2, dto.getName());
            stm.setString(3, dto.getDescription());
            stm.setInt(4, dto.getQuantity());
            stm.setFloat(5, dto.getPrice());
            stm.setString(6, dto.getType());
            return stm.executeUpdate() > 0;
        }
    }

    public boolean update(ProductDTO dto) throws Exception {
        String sql = "Update tbl_Product set name = ?, description = ? , quantity =?, price=?, type = ? where productId = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(6, dto.getId());
            stm.setString(1, dto.getName());
            stm.setString(2, dto.getDescription());
            stm.setInt(3, dto.getQuantity());
            stm.setFloat(4, dto.getPrice());
            stm.setString(5, dto.getType());
            return stm.executeUpdate() > 0;
        }
    }
     public boolean setQuantity( String productID, int quantity) throws Exception {
        String sql = "update tbl_Product set quantity = ? where productID = ? ";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(2, productID);
            stm.setInt(1, quantity);
            return stm.executeUpdate() > 0;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.order;

import danh.cart.CartProductDTO;
import danh.db.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang Danh
 */
public class OrderDAO implements Serializable {

    public ArrayList<OrderObject> getAllOrder() throws Exception {
        ArrayList<OrderObject> listOrder = null;
        String sql = "Select o.Status as status, p.ProductID as productID, O.OrderID as orderid, u.Fullname as fullname,  p.Name as productName, od.Quantity as quantity, p.Price\n"
                + "from (((tbl_OrderDetail as od \n"
                + "INNER JOIN tbl_Product as p on od.ProductID = p.ProductID) \n"
                + "Inner JOIN tbl_Order as O on o.OrderID = od.OrderID)\n"
                + "INNER JOIN tbl_User as U on o.OrderBy = u.Username) ";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);) {
            try (ResultSet rs = stm.executeQuery()) {
                listOrder = new ArrayList<>();
                while (rs.next()) {
                    int orderId = rs.getInt("orderid");
                    String productId = rs.getString("productID");
                    String fullname = rs.getString("fullname");
                    String productName = rs.getString("productName");
                    String status = rs.getString("Status");
                    int quantity = rs.getInt("Quantity");
                    float price = rs.getFloat("Price");
                    CartProductDTO dto = new CartProductDTO(productId, productName, quantity, price);

                    boolean isExisted = false;
                    for (OrderObject orderObject : listOrder) {
                        if (orderObject.getOrderID() == orderId) {
                            isExisted = true;
                        }
                    }
                    if (!isExisted) {
                        ArrayList<CartProductDTO> listProduct = new ArrayList<>();
                        listProduct.add(dto);
                        listOrder.add(new OrderObject(orderId, fullname, status, listProduct));
                    } else {
                        for (OrderObject orderObject : listOrder) {
                            orderObject.getListProduct().add(dto);
                        }
                    }
                }
            }
        }
        return listOrder;
    }

    public int createOrder(OrderDTO dto) throws Exception {
        String sql = "INSERT INTO [dbo].[tbl_Order]\n"
                + "           ([OrderBy]\n"
                + "           ,[Status]\n"
                + "           ,[ShippingAddress]\n"
                + "           ,[OrderDate]\n"
                + "           ,[Note]\n"
                + "           ,[Receiver]\n"
                + "           ,[Phone])\n"
                + "     OUTPUT inserted.orderID "
                + "     VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, dto.getOrderBy());
            stm.setString(2, dto.getStatus());
            stm.setString(3, dto.getShippingAddress());
            stm.setDate(4, dto.getOrderDate());
            stm.setString(5, dto.getNote());
            stm.setString(6, dto.getReceiver());
            stm.setString(7, dto.getPhone());
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("orderID");
                }
            }
        }
        return 0;
    }

    public boolean createOrderDetail(List<CartProductDTO> listDTO, int orderID) throws Exception {
        boolean check = false;
        String sql = "insert into tbl_orderDetail(OrderID, productID, Quantity, Price) values(?,?,?,?)";
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stm = conn.prepareStatement(sql)) {
                for (CartProductDTO cartProductDTO : listDTO) {
                    stm.setInt(1, orderID);
                    stm.setString(2, cartProductDTO.getId());
                    stm.setInt(3, cartProductDTO.getQuantity());
                    stm.setFloat(4, cartProductDTO.getPrice());
                    stm.addBatch();
                }
                stm.executeBatch();
                conn.commit();
                check = true;
            }
        }
        return check;
    }

    public List<OrderDTO> getAllOrder(String username) throws Exception {
        List<OrderDTO> list = null;
        String sql = "Select orderID, status, shippingaddress, orderDate, note, receiver, phone from tbl_order where orderBy = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, username);
            try (ResultSet rs = stm.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    String status = rs.getString("status");
                    String shippingAddress = rs.getString("shippingaddress");
                    Date orderDate = rs.getDate("orderDate");
                    String note = rs.getString("note");
                    String receiver = rs.getString("receiver");
                    String phone = rs.getString("phone");
                    int orderID = rs.getInt("orderID");
                    OrderDTO dto = new OrderDTO(status, shippingAddress, note, receiver, phone, orderID, orderDate);
                    list.add(dto);

                }
            }
        }
        return list;
    }

    public List<CartProductDTO> getListOrderDetail(String orderID) throws Exception {
        ArrayList<CartProductDTO> list = null;
        String sql = "Select ProductID, Quantity, Price from tbl_orderDetail where orderID = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, orderID);
            try (ResultSet rs = stm.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    String productId = rs.getString("ProductID");
                    int quantity = rs.getInt("Quantity");
                    float price = rs.getFloat("price");
                    list.add(new CartProductDTO(productId, quantity, price));
                }
            }
        }
        return list;
    }
    public boolean changeStatusOrder(int orderId, String status)throws Exception {
        String sql = "update tbl_order set status = ? where orderid = ?";
        try(Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);){
            stm.setString(1,status);
            stm.setInt(2,orderId);
            return stm.executeUpdate() > 0;
        }
    }
    public String getStatusById(int orderId)throws Exception{
        String sql = "select status form tbl_Order where orderId = ?";
        try(Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1,orderId);
            try(ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("status");
                }
            }
        }
        return "";
    }
}

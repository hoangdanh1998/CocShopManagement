/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danh.user;

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
public class UserDAO implements Serializable {

    public boolean insertUser(UserDTO dto) throws Exception {
        String sql = "Insert into tbl_User(username,password,fullname, address,phone,role) values(?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, dto.getUsername());
            stm.setString(2, dto.getPassword());
            stm.setString(3, dto.getFullname());
            stm.setString(4, dto.getAddress());
            stm.setString(5,dto.getPhone());
            stm.setString(6,dto.getRole());
            return stm.executeUpdate() > 0;
        }
    }

    public UserDTO checkLogin(String username, String password) throws Exception {
        UserDTO dto = new UserDTO(null, null, null, "failed");
        String sql = "Select role, fullname from tbl_User where username = ? and password = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, username);
            stm.setString(2, password);
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {
                    String role = rs.getString("role");
                    String fullname = rs.getString("fullname");
                    dto = new UserDTO(username, password, fullname, role);
                }
            }
        }
        return dto;
    }

    public UserDTO getUser(String id) throws Exception {
        String username, addess, phone, role, fullname;
        String sql = "Select username, address, fullname, role, phone from tbl_User where username = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    username = rs.getString("username");
                    addess = rs.getString("address");
                    fullname = rs.getString("fullname");
                    role = rs.getString("role");
                    phone = rs.getString("phone");
                    return new UserDTO(username, fullname, role, addess, phone);
                }
            }
        }
        return null;
    }

    public ArrayList<UserDTO> getAllUser() throws Exception {
        ArrayList<UserDTO> list = null;
        String username, addess, phone, role, fullname;
        String sql = "Select username, address, fullname, role, phone from tbl_User where role = 'user' or role = 'admin' ";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    username = rs.getString("username");
                    addess = rs.getString("address");
                    fullname = rs.getString("fullname");
                    role = rs.getString("role");
                    phone = rs.getString("phone");
                    list.add(new UserDTO(username, fullname, role, addess, phone));
                }
            }
        }
        return list;
    }

    public boolean delete(String pk) throws Exception {
        String sql = "Update tbl_User set role = 'ban' where username = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, pk);
            return stm.executeUpdate() > 0;
        }
    }

    public boolean update(UserDTO dto) throws Exception {
        String sql = "Update tbl_User set role = ?, fullname = ?,address = ?, phone = ? where username = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, dto.getRole());
            stm.setString(2, dto.getFullname());
            stm.setString(3, dto.getAddress());
            stm.setString(4, dto.getPhone());
            stm.setString(5, dto.getUsername());
            return stm.executeUpdate() > 0;
        }
    }

    public ArrayList<UserDTO> search(String search) throws Exception {
        ArrayList<UserDTO> list = null;
        String sql = "Select username, address, fullname, role, phone from tbl_User where fullname like ? ";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, "%" + search + "%");
            try (ResultSet rs = stm.executeQuery()) {
                list = new ArrayList();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String address = rs.getString("address");
                    String fullname = rs.getString("fullname");
                    String role = rs.getString("role");
                    String phone = rs.getString("phone");
                    list.add(new UserDTO(username, fullname, role, address, phone));
                }
            }
        }
        return list;
    }
}

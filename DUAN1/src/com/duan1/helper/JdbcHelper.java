/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class JdbcHelper {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl = "jdbc:sqlserver://localhost;database=QLTV_Project1";
    static String user = "sa";
    static String pass = "karito";
    
    // Nạp driver !!
    static{
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**                 getStmt !!
     * Xây dựng PreparedStatement
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
     * @return PreparedStatement tạo được
     * @throws java.sql.SQLException lỗi sai cú pháp
    */
    public static PreparedStatement getStmt (String sql,Object...args)throws SQLException{
        Connection conn = DriverManager.getConnection(dburl,user,pass);
        PreparedStatement stmt = null;
        /*
          Nếu câu lệnh sql bắt đầu bằng "{" có nghĩa là lời gọi thủ tục
          Ngược lại là câu lênh sql
        */
        if(sql.trim().startsWith("{")){
            stmt = conn.prepareCall(sql); // thủ tục PROC
        }else{
            stmt = conn.prepareStatement(sql); // câu lệnh SQL
        }
        // Cho for duyệt, setObject có thể thay thế kiểu String, double, Boolean ,...
        for (int i = 0; i<args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }
    
    
    /**             UPDATE: int
     * Thực hiện câu lệnh SQL thao tác (INSERT, UPDATE, DELETE) hoặc thủ tục lưu thao tác dữ liệu
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql     * 
     * LƯU Ý: UPDATE và VALUE luôn phải close();
    */
    public static int update(String sql, Object...args){
        try {
            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
            try{
                return stmt.executeUpdate();
            }
            finally{
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
     /**               QUERY : ResultSet
     * Thực hiện câu lệnh SQL truy vấn (SELECT) hoặc thủ tục lưu truy vấn dữ liệu
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
     */    
    public static ResultSet query(String sql, Object...args) throws SQLException{
        PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
        return stmt.executeQuery();
    }
    
    /**               VALUE : Object
     * Thực hiện câu lệnh SQL truy vấn (SELECT) 1 giá trị (Gần giống như QUERY)
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
     */    
    public static Object value(String sql,Object...arsg){
        try {
            ResultSet rs = JdbcHelper.query(sql, arsg);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

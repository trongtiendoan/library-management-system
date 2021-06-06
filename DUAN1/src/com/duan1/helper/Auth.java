/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.helper;

import com.duan1.entity.NguoiDung;



/**
 *
 * @author Admin
 */
public class Auth {
    // Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
    public static NguoiDung user = null; 
    // Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
    public static void clear(){
        Auth.user = null;
    }
    // Kiểm tra xem đăng nhập hay chưa
    public static boolean isLogin(){
        return Auth.user != null;
    }
    // Kiểm tra xem có phải là trưởng phòng hay không
    public static boolean isManager(){
        return Auth.isLogin() && user.getVaiTro();
    }
    
    
}

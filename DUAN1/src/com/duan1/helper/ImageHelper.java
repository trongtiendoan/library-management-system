/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.helper;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class ImageHelper {
    // Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
    public static Image getAppIcon(){ // Viết hàm này để lấy icon của ứng dụng
        URL url = ImageHelper.class.getResource("/com/duan1/icon/fpt.png");
        return new ImageIcon(url).getImage();
    }
        
    /**
     * Sao chép file logo chuyên đề vào thư mục logo
     * @param src là đối tượng file ảnh
     */   
    public static void save(File src){
        File dst = new File("logos", src.getName());
        if(!dst.getParentFile().exists()){ // kiểm tra coi có tồn tại thư mục logos hay chưa
            dst.getParentFile().mkdirs();  // Nếu chưa sẽ tạo thư mục logos nếu chưa tồn tại
        }
        // Copy file vào thư mục (to)
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING); // Coppy vào thư mục logos, Nếu file đó tồn tại rồi thì thay thế lun
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Đọc hình ảnh logo chuyên đề
     * @param fileName  là tên file logo
     * @return ảnh đọc được
     */   
    public static ImageIcon read(String fileName){
        File path = new File("logos",fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    // getAbsolutePath(): Hàm này trả về tên đường dẫn tuyệt đối của đối tượng tệp đã cho
}

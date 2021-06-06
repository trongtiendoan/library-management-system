/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.entity;

/**
 *
 * @author Admin
 */
public class TacGia {

    private int MaTG;
    private String TenTG;
    private String ghiChu;
    private String Hinh;

    public int getMaTG() {
        return MaTG;
    }

    public void setMaTG(int MaTG) {
        this.MaTG = MaTG;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    @Override
    public String toString() {
        return this.TenTG;  // lấy tên để hiển thị trong combobox
    }
}

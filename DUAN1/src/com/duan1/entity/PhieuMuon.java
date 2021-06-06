/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.entity;

import com.duan1.helper.DateHelper;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class PhieuMuon {

    private int MaPM;
    private String MaSV;
    private Date NgayMuon;
    private Date NgayTra;
    private String MaND;
    private String TrangThai;
    private String GhiChu;

    public int getMaPM() {
        return MaPM;
    }

    public void setMaPM(int MaPM) {
        this.MaPM = MaPM;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public Date getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(Date NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

//    @Override
//    public String toString() {
//        return this.TrangThai;  // lấy tên để hiển thị trong combobox
//    }
}

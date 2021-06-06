/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import com.duan1.entity.SinhVien;
import com.duan1.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SinhVienDAO extends Library<SinhVien, String> {

    String INSERT_SQL = "INSERT SinhVien (MaSV,HoTen,GioiTinh,SDT,Email,DiaChi) VALUES (?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE SinhVien SET HoTen = ?, GioiTinh = ?, SDT = ?, Email = ?, DiaChi = ? WHERE MaSV = ?";
    String DELETE_SQL = "DELETE FROM SinhVien WHERE MaSV = ?";
    String SELECT_ALL_SQL = "SELECT * FROM SinhVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM SinhVien WHERE MaSV = ?";

    @Override
    public void insert(SinhVien entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getMaSV(),
                entity.getHoTen(),
                entity.isGioiTinh(),
                entity.getSDT(),
                entity.getEmail(),
                entity.getDiaChi()
        );
    }

    @Override
    public void update(SinhVien entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getHoTen(),
                entity.isGioiTinh(),
                entity.getSDT(),
                entity.getEmail(),
                entity.getDiaChi(),
                entity.getMaSV()
        );
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<SinhVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SinhVien selectByID(String key) {
        List<SinhVien> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<SinhVien> selectBySql(String sql, Object... args) {
        List<SinhVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                SinhVien entity = new SinhVien();
                entity.setMaSV(rs.getString("MaSV"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setSDT(rs.getString("SDT"));
                entity.setEmail(rs.getString("Email"));
                entity.setDiaChi(rs.getString("DiaChi"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

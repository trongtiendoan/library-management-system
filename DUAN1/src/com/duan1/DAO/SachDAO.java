/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import com.duan1.entity.Sach;
import com.duan1.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karit
 */
public class SachDAO extends Library<Sach, Integer> {

    String INSERT_SQL = "INSERT Sach (TenSach, MaLoai, MaNXB, MaTG, SoLuong, NoiDung, Hinh) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE Sach SET TenSach = ?, MaLoai = ?, MaNXB = ?, MaTG = ?, SoLuong = ?, NoiDung = ?, Hinh = ? WHERE MaSach = ?";
    String DELETE_SQL = "DELETE FROM Sach WHERE MaSach = ?";
    String SELECT_ALL_SQL = "SELECT * FROM Sach";
    String SELECT_BY_ID_SQL = "SELECT * FROM Sach WHERE MaSach = ?";

    @Override
    public void insert(Sach entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getTenSach(),
                entity.getMaLoai(),
                entity.getMaNXB(),
                entity.getMaTG(),
                entity.getSoLuong(),
                entity.getNoiDung(),
                entity.getHinh()
        );
    }

    @Override
    public void update(Sach entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getTenSach(),
                entity.getMaLoai(),
                entity.getMaNXB(),
                entity.getMaTG(),
                entity.getSoLuong(),
                entity.getNoiDung(),
                entity.getHinh(),
                entity.getMaSach()
        );
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Sach> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Sach selectByID(Integer key) {
        List<Sach> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Sach entity = new Sach();
                entity.setMaSach(rs.getInt("MaSach"));
                entity.setTenSach(rs.getString("TenSach"));
                entity.setMaLoai(rs.getInt("MaLoai"));
                entity.setMaNXB(rs.getInt("MaNXB"));
                entity.setMaTG(rs.getInt("MaTG"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setNoiDung(rs.getString("NoiDung"));
                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Sach> selectByKeyword(String keyword) {
        String sql = "select * from SACH where TenSach like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
}

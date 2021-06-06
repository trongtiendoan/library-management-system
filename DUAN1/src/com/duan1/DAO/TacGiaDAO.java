/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import com.duan1.entity.TacGia;
import com.duan1.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TacGiaDAO extends Library<TacGia, Integer> {

    String INSERT_SQL = "INSERT TacGia (TenTG, GhiChu, Hinh) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE TacGia SET TenTG = ?, GhiChu = ?, Hinh = ? WHERE MaTG = ?";
    String DELETE_SQL = "DELETE FROM TacGia WHERE MaTG = ?";
    String SELECT_ALL_SQL = "SELECT * FROM TacGia";
    String SELECT_BY_ID_SQL = "SELECT * FROM TacGia WHERE MaTG = ?";

    @Override
    public void insert(TacGia entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getTenTG(),
                entity.getGhiChu(),
                entity.getHinh());
    }

    @Override
    public void update(TacGia entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getTenTG(),
                entity.getGhiChu(),
                entity.getHinh(),
                entity.getMaTG()
        );
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<TacGia> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TacGia selectByID(Integer key) {
        List<TacGia> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<TacGia> selectBySql(String sql, Object... args) {
        List<TacGia> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                TacGia entity = new TacGia();
                entity.setMaTG(rs.getInt("MaTG"));
                entity.setTenTG(rs.getString("TenTG"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

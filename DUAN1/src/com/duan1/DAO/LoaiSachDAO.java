/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import com.duan1.entity.LoaiSach;
import com.duan1.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karit
 */
public class LoaiSachDAO extends Library<LoaiSach, Integer>{
    String INSERT_SQL = "INSERT LoaiSach (TenLoai, ViTri) VALUES (?, ?)";
    String UPDATE_SQL = "UPDATE LoaiSach SET TenLoai = ?, ViTri = ? WHERE MaLoai = ?";
    String DELETE_SQL = "DELETE FROM LoaiSach WHERE MaLoai = ?";
    String SELECT_ALL_SQL = "SELECT * FROM LoaiSach";
    String SELECT_BY_ID_SQL = "SELECT * FROM LoaiSach WHERE MaLoai = ?";
    
    @Override
    public void insert(LoaiSach entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getTenLoai(),
                entity.getViTri()
        );
    }

    @Override
    public void update(LoaiSach entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getTenLoai(),
                entity.getViTri(),
                entity.getMaLoai()
        );
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<LoaiSach> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public LoaiSach selectByID(Integer key) {
        List<LoaiSach> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<LoaiSach> selectBySql(String sql, Object... args) {
        List<LoaiSach> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                LoaiSach entity = new LoaiSach();
                entity.setMaLoai(rs.getInt("MaLoai"));
                entity.setTenLoai(rs.getString("TenLoai"));
                entity.setViTri(rs.getString("ViTri"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}

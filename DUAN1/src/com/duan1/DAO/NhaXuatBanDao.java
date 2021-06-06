/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import com.duan1.entity.NhaXuatBan;
import com.duan1.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MinhPhuc
 */
public class NhaXuatBanDao extends Library<NhaXuatBan, Integer>{
    
    String INSERT_SQL = "Insert NhaXuatBan(TenNXB,DiaChi,Email) values (?,?,?)";
    String UPDATE_SQL = "Update NhaXuatBan set TenNXB = ?,DiaChi = ?, Email = ? Where MaNXB = ?";
    String DELETE_SQL = "delete from NhaXuatBan where MaNXB = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NhaXuatBan";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhaXuatBan WHERE MaNXB = ?";
    
    

    @Override
    public void insert(NhaXuatBan entity) {
        JdbcHelper.update(INSERT_SQL,entity.getTenNXB(),entity.getDiaChi(),entity.getEmail());
    }

    @Override
    public void update(NhaXuatBan entity) {
          JdbcHelper.update(UPDATE_SQL,entity.getTenNXB(),entity.getDiaChi(),entity.getEmail(),entity.getMaNXB());
    }

    @Override
    public void delete(Integer key) {
         JdbcHelper.update(DELETE_SQL,key);
    }

    @Override
    public List<NhaXuatBan> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhaXuatBan selectByID(Integer key) {
         List<NhaXuatBan> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
        
    }

    @Override
    protected List<NhaXuatBan> selectBySql(String sql, Object... args) {
        List<NhaXuatBan> list = new ArrayList<NhaXuatBan>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhaXuatBan entity = new NhaXuatBan();
                entity.setMaNXB(rs.getInt("MaNXB"));
                entity.setTenNXB(rs.getString("TenNXB"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setEmail(rs.getString("Email"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import com.duan1.entity.NguoiDung;
import com.duan1.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NguoiDungDAO extends Library<NguoiDung, String> {

    String INSERT_SQL = "INSERT INTO NguoiDung (MaND, Password, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NguoiDung SET Password = ?, HoTen = ?, VaiTro = ? WHERE MaND = ?";
    String DELETE_SQL = "DELETE FROM NguoiDung WHERE MaND = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NguoiDung";
    String SELECT_BY_ID_SQL = "SELECT * FROM NguoiDung WHERE MaND = ?";

    @Override
    public void insert(NguoiDung entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getMaND(),
                entity.getPassword(),
                entity.getHoTen(),
                entity.getVaiTro());
    }

    @Override
    public void update(NguoiDung entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getPassword(),
                entity.getHoTen(),
                entity.getVaiTro(),
                entity.getMaND()
        );
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<NguoiDung> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NguoiDung selectByID(String key) {
        List<NguoiDung> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NguoiDung> selectBySql(String sql, Object... args) {
        List<NguoiDung> list = new ArrayList<NguoiDung>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NguoiDung entity = new NguoiDung();
                entity.setMaND(rs.getString("MaND"));
                entity.setPassword(rs.getString("Password"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

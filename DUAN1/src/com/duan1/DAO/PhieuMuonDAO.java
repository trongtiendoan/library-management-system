/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import com.duan1.entity.PhieuMuon;
import com.duan1.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuMuonDAO extends Library<PhieuMuon, Integer> {

    String INSERT_SQL = "INSERT PHIEUMUON (MaSV, NgayMuon, NgayTra, MaND, TrangThai, GhiChu) VALUES (?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE PHIEUMUON SET MaSV = ?, NgayMuon = ?, NgayTra = ?, MaND = ?, TrangThai = ?, GhiChu = ? WHERE MaPM = ?";
    String DELETE_SQL = "DELETE FROM PHIEUMUON WHERE MaPM = ?";
    String SELECT_ALL_SQL = "SELECT * FROM PHIEUMUON";
    String SELECT_BY_ID_SQL = "SELECT * FROM PHIEUMUON WHERE MaPM = ?";
    String SELECT_ALL_CT = "select * from PHIEUMUON where TrangThai = N'Chưa trả'";
    String SELECT_ALL_DT = "select * from PHIEUMUON where TrangThai = N'Đã trả'";

    @Override
    public void insert(PhieuMuon entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getMaSV(),
                entity.getNgayMuon(),
                entity.getNgayTra(),
                entity.getMaND(),
                entity.getTrangThai(),
                entity.getGhiChu()
        );
    }

    @Override
    public void update(PhieuMuon entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getMaSV(),
                entity.getNgayMuon(),
                entity.getNgayTra(),
                entity.getMaND(),
                entity.getTrangThai(),
                entity.getGhiChu(),
                entity.getMaPM()
        );
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<PhieuMuon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuMuon selectByID(Integer key) {
        List<PhieuMuon> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<PhieuMuon> selectBySql(String sql, Object... args) {
        List<PhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPM(rs.getInt("MaPM"));
                pm.setMaSV(rs.getString("MaSV"));
                pm.setNgayMuon(rs.getDate("NgayMuon"));
                pm.setNgayTra(rs.getDate("NgayTra"));
                pm.setMaND(rs.getString("MaND"));
                pm.setTrangThai(rs.getString("TrangThai"));
                pm.setGhiChu(rs.getString("GhiChu"));
                list.add(pm);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> selectPM() {
        String sql = "select DISTINCT TrangThai from PHIEUMUON";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);

        }
    }

    public List<Integer> selectTKCT1() {
        String sql = "select COUNT(*) from PHIEUMUON where TrangThai = N'Chưa trả";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);

        }
    }

    public List<PhieuMuon> selectCT() {
        return this.selectBySql(SELECT_ALL_CT);
    }

    public List<PhieuMuon> selectDT() {
        return this.selectBySql(SELECT_ALL_DT);
    }

    public List<PhieuMuon> selectByKeyword(String keyword) {
        String sql = "select * from PHIEUMUON where MaSV like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
}

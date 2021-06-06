/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import com.duan1.entity.ChiTietPM;
import com.duan1.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karit
 */
public class ChiTietPMDAO extends Library<ChiTietPM, Integer> {

    String INSERT_SQL = "INSERT ChiTietPM (MaPM, MaSach, TrangThai, SoLuong, GhiChu) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE ChiTietPM SET MaSach = ?, TrangThai = ?, SoLuong = ?, GhiChu = ? WHERE MaPM = ?";
    String DELETE_SQL = "DELETE FROM ChiTietPM WHERE MaPM = ?";
    String SELECT_ALL_SQL = "SELECT * FROM ChiTietPM";
    String SELECT_BY_ID_SQL = "SELECT * FROM ChiTietPM WHERE MaPM = ?";
    String SELECT_TK_TOPSACH = "select top 3 TenSach, Sum(ct.SoLuong) as SL from CHITIETPM ct inner join SACH s on ct.MaSach = s.MaSach group by TenSach order by Sum(ct.SoLuong) desc";
    String SELECT_TK_PM = "select count(MaSach) as MaSach,MONTH(NgayTra) as NM from CHITIETPM ct \n" +
                            "inner join  PHIEUMUON pm  on ct.MaPM = pm.MaPM \n" +
                            "where pm.GhiChu like N'%Quá hạn%' and Year(NgayTra) = 2020\n" +
                            "group by MONTH(NgayTra)";

    @Override
    public void insert(ChiTietPM entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getMaPM(),
                entity.getMaSach(),
                entity.getTrangThai(),
                entity.getSoLuong(),
                entity.getGhiChu()
        );
    }

    @Override
    public void update(ChiTietPM entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getMaSach(),
                entity.getTrangThai(),
                entity.getSoLuong(),
                entity.getGhiChu(),
                entity.getMaPM()
        );
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<ChiTietPM> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietPM selectByID(Integer key) {
        List<ChiTietPM> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ChiTietPM> selectBySql(String sql, Object... args) {
        List<ChiTietPM> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChiTietPM entity = new ChiTietPM();
                entity.setMaPM(rs.getInt("MaPM"));
                entity.setMaSach(rs.getInt("MaSach"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setGhiChu(rs.getString("GhiChu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//
//    public List<Integer> selectTKCT() {
//        
//        List<Integer> list = new ArrayList<>();
//        try {
//            ResultSet rs = JdbcHelper.query(SELECT_TK_TOPSACH);
//            while (rs.next()) {
//                list.add(rs.getInt(1));
//            }
//            rs.getStatement().getConnection().close();
//            return list;
//        } catch (Exception e) {
//            System.out.println(e);
//            throw new RuntimeException(e);
//
//        }
//    }

    public List<ChiTietPM> selectTOPS() {
        return this.selectByTK(SELECT_TK_TOPSACH);
    }

    protected List<ChiTietPM> selectByTK(String sql, Object... args) {
        List<ChiTietPM> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChiTietPM entity = new ChiTietPM();
//                entity.setMaPM(rs.getInt("MaPM"));
                entity.setTenSach(rs.getString("TenSach"));
                entity.setSoLuong(rs.getInt("SL"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
    public List<ChiTietPM> selectTKPMCT() {
        return this.selectByTKPM(SELECT_TK_PM);
    }
    protected List<ChiTietPM> selectByTKPM(String sql, Object... args) {
        List<ChiTietPM> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChiTietPM entity = new ChiTietPM();
//                entity.setMaPM(rs.getInt("MaPM"));
                entity.setMaPM(rs.getInt("MaSach"));
                entity.setNgayMuon(rs.getString("NM"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}

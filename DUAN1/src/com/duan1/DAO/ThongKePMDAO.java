/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.DAO;

import com.duan1.DAO.LoaiSachDAO;
import com.duan1.entity.ChiTietPM;
import com.duan1.entity.LoaiSach;
import com.duan1.entity.Sach;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Admin
 */
public class ThongKePMDAO {

    SachDAO sdao = new SachDAO();
    ChiTietPMDAO ctdao = new ChiTietPMDAO();

    public void setDataToChart1(JPanel jpnItem) {
        List<ChiTietPM> listItem = ctdao.selectTKPMCT();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
//            List<Sach> list = sdao.selectAll();
            for (ChiTietPM item : listItem) {

//                String ten = sdao.selectByID(item.getMaSach()).getTenSach();
                dataset.addValue(item.getMaPM(), "Học viên", item.getNgayMuon());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ tổng hợp số sách quá hạn 2020".toUpperCase(),
                "Tháng", "Số sách",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 400));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

}

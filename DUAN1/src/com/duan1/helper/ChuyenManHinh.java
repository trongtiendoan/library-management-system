/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.helper;

import com.duan1.ui.LoaiSachJPanel;
import com.duan1.ui.NXBJPanel;
import com.duan1.ui.NguoiDungJPanel;
import com.duan1.ui.PhieuMuonJPanel;
import com.duan1.ui.SachJPanel;
import com.duan1.ui.SinhVienJPanel;
import com.duan1.ui.TacGiaJPanel;
import com.duan1.ui.ThongKeJpanel;
import com.duan1.ui.TrangChuJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ChuyenManHinh {

    private JPanel root;
    private String kindSelected = "";
    private JMenuItem menu;
    private List<DanhMuc> listItem = null;

    public ChuyenManHinh(JPanel root) {
        this.root = root;
    }

//    public ChuyenManHinh(JMenuItem root) {
//        this.menu = root;
//    }
    public void setView(JPanel jpnItem, JLabel jblItem) {
        kindSelected = "TrangChu";
//        jpnItem.setBackground(new Color(96, 100, 191));
//        jblItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMuc> listItem) {
        this.listItem = listItem;
        for (DanhMuc item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    public void setNguoiDung(JPanel pnlNguoiDung) {
        kindSelected = "TrangChu";
//        pnlNguoiDung.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new NguoiDungJPanel());
        root.validate();
        root.repaint();
    }

    public void setSinhVien(JPanel pnlSinhVien) {
        kindSelected = "SinhVien";
//        pnlNguoiDung.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new SinhVienJPanel());
        root.validate();
        root.repaint();
    }

    public void setLoaiSach(JPanel pnlLoaiSach) {
        kindSelected = "LoaiSach";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new LoaiSachJPanel());
        root.validate();
        root.repaint();
    }

    public void setSach(JPanel pnlSach) {
        kindSelected = "Sach";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new SachJPanel());
        root.validate();
        root.repaint();
    }

    public void setPhieuMuon(JPanel pnlPhieuMuon) {
        kindSelected = "PhieuMuon";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new PhieuMuonJPanel());
        root.validate();
        root.repaint();
    }

    public void setThongKe(JPanel pnlThongKe) {
        kindSelected = "ThongKe";
//        pnlNguoiDung.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ThongKeJpanel());
        root.validate();
        root.repaint();
    }

    public void setNXB(JMenuItem mniNXB) {
        kindSelected = "NXB";
//        pnlNguoiDung.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new NXBJPanel());
        root.validate();
        root.repaint();
    }

    public void setTG(JMenuItem mniNXB) {
        kindSelected = "TacGia";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TacGiaJPanel());
        root.validate();
        root.repaint();
    }

    public void setLoaiSach(JMenuItem mniLS) {
        kindSelected = "LoaiSach";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new LoaiSachJPanel());
        root.validate();
        root.repaint();
    }

    public void setSach(JMenuItem mniSach) {
        kindSelected = "Sach";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new SachJPanel());
        root.validate();
        root.repaint();
    }

    public void setSinhVien(JMenuItem mniSV) {
        kindSelected = "SinhVien";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new SinhVienJPanel());
        root.validate();
        root.repaint();
    }

    public void setPhieuMuon(JMenuItem mniPM) {
        kindSelected = "PhieuMuon";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new PhieuMuonJPanel());
        root.validate();
        root.repaint();
    }

    public void setNguoiDung(JMenuItem mniND) {
        kindSelected = "NguoiDung";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new NguoiDungJPanel());
        root.validate();
        root.repaint();
    }

    public void setTK(JMenuItem mniTK) {
        kindSelected = "TK";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ThongKeJpanel());
        root.validate();
        root.repaint();
    }
//    public void setEvent1(List<DanhMuc> listItem) {
//        this.listItem = listItem;
//        for (DanhMuc item : listItem) {
//            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn()));
//        }
//    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jnlItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jnlItem;
            this.jlbItem = jlbItem;
        }

        public LabelEvent(String kind, JPanel jnlItem) {
            this.kind = kind;
            this.jpnItem = jnlItem;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if (Auth.isLogin()) {
                switch (kind) {
                    case "TrangChu":
                        node = new TrangChuJPanel();
                        break;
                    case "NguoiDung":
                        node = new NguoiDungJPanel();
                        break;
                    case "SinhVien":
                        node = new SinhVienJPanel();
                        break;
                    case "Sach":
                        node = new SachJPanel();
                        break;
                    case "PhieuMuon":
                        node = new PhieuMuonJPanel();
                        break;
                    default:
                        node = new TrangChuJPanel();
                        break;
                }
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(node);
                root.validate();
                root.repaint();
                setChangeBackground(kind);
            } else {
                JOptionPane.showMessageDialog(root, "Vui lòng đăng nhập");
//                MsgBox.alert(this, "Vui lòng đăng nhập");
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            kindSelected = kind;
//            jpnItem.setBackground(new Color(96, 100, 191));
//            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
//            jpnItem.setBackground(new Color(96, 100, 191));
//            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if (kindSelected.equalsIgnoreCase(kind)) {
//                jpnItem.setBackground(new Color(0, 153, 0));
//                jlbItem.setBackground(new Color(0, 153, 0));
            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMuc item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
//                item.getJpn().setBackground(new Color(96, 100, 191));
//                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
//                item.getJpn().setBackground(new Color(0, 153, 0));
//                item.getJlb().setBackground(new Color(0, 153, 0));
            }
        }
    }
}

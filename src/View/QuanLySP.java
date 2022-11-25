/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModel.ChatLieuDomainModel;
import DomainModel.KichCoDomainModel;
import DomainModel.LoaiHangDomainModel;
import DomainModel.MauSacDomainModel;
import Service.ChatLieuIplm;
import Service.Interface.ChatLieuServices;
import Service.Interface.IQlspService;
import Service.Interface.ISanPhamService;
import Service.Interface.KichCoServices;
import Service.Interface.LoaiHangServices;
import Service.Interface.MauSacServices;
import Service.KichCoIplm;
import Service.LoaiHangIplm;
import Service.MauSacIplm;
import Service.QlspImpl;
import Service.SanPhamImpl;
import ViewModel.Qlsp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLySP extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    DefaultComboBoxModel dcmMaSP;
    DefaultComboBoxModel dcmLoaiHang, dcmLoaiHangSerch;
    DefaultComboBoxModel dcmChatLieu, dcmChatLieuSerch;
    DefaultComboBoxModel dcmSize, dcmSizeSearch;
    DefaultComboBoxModel dcmMau, dcmMauSerch;

    IQlspService iQlspService;
    ISanPhamService iSanPhamService;
    LoaiHangServices loaiHangServices;
    MauSacServices mauSacServices;
    ChatLieuServices chatLieuServices;
    KichCoServices kichCoServices;
    ArrayList<Qlsp> listClone;

    public QuanLySP() {
        initComponents();

        iQlspService = new QlspImpl();
        iSanPhamService = new SanPhamImpl();
        loaiHangServices = new LoaiHangIplm();
        mauSacServices = new MauSacIplm();
        chatLieuServices = new ChatLieuIplm();
        kichCoServices = new KichCoIplm();

        dtm = (DefaultTableModel) tblQLSP.getModel();

        String[] hihi = {"Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Số lượng", "Đơn giá"};
        dtm.setColumnIdentifiers(hihi);

        loadCbbMaSp(iSanPhamService.getListMaSp());
        loadCbbLoaiHang(loaiHangServices.getListTenLoai());
        loadCbbChatLieu(chatLieuServices.getListTenCL());
        loadCbbSize(kichCoServices.getListTenKC());
        loadCbbMauSac(mauSacServices.getTenMS());
        loadData(iQlspService.getAll());
    }

    private void loadCbbMaSp(ArrayList<String> list) {
        dcmMaSP = (DefaultComboBoxModel) cbbMaSP.getModel();
        dcmMaSP.removeAllElements();
        for (String s : list) {
            dcmMaSP.addElement(s);
        }
    }

    void loadCbbLoaiHang(ArrayList<String> list) {
        dcmLoaiHang = (DefaultComboBoxModel) cbbLoai.getModel();
        dcmLoaiHangSerch = (DefaultComboBoxModel) cbbSearchLoaiSP.getModel();
        dcmLoaiHang.removeAllElements();
        dcmLoaiHangSerch.removeAllElements();
        for (String s : list) {
            dcmLoaiHang.addElement(s);
            dcmLoaiHangSerch.addElement(s);
        }
    }

    void loadCbbChatLieu(ArrayList<String> list) {
        dcmChatLieu = (DefaultComboBoxModel) cbbChatLieu.getModel();
        dcmChatLieuSerch = (DefaultComboBoxModel) cbbSearchChatLieu.getModel();
        dcmChatLieu.removeAllElements();
        dcmChatLieuSerch.removeAllElements();
        for (String s : list) {
            dcmChatLieu.addElement(s);
            dcmChatLieuSerch.addElement(s);
        }

    }

    void loadCbbSize(ArrayList<String> list) {
        dcmSize = (DefaultComboBoxModel) cbbSize.getModel();
        dcmSizeSearch = (DefaultComboBoxModel) cbbSearchSize.getModel();
        dcmSize.removeAllElements();
        dcmSizeSearch.removeAllElements();
        for (String s : list) {
            dcmSize.addElement(s);
            dcmSizeSearch.addElement(s);
        }

    }

    void loadCbbMauSac(ArrayList<String> list) {
        dcmMau = (DefaultComboBoxModel) cbbMauSac.getModel();
        dcmMauSerch = (DefaultComboBoxModel) cbbSearchMauSP.getModel();
        dcmMau.removeAllElements();
        dcmMauSerch.removeAllElements();
        for (String s : list) {
            dcmMau.addElement(s);
            dcmMauSerch.addElement(s);
        }

    }

    private void loadData(ArrayList<Qlsp> list) {
        dtm.setRowCount(0);
        listClone = list;
        for (Qlsp qlsp : list) {
            dtm.addRow(new Object[]{
                qlsp.getMaCtsp(),
                qlsp.getTenSp(),
                qlsp.getTenMs(),
                qlsp.getTenLoai(),
                qlsp.getTenCl(),
                qlsp.getTenKc(),
                qlsp.getSoLuong(),
                qlsp.getDonGia()
            });
        }
    }

    Qlsp getQlsp() {
        int mactsp = Integer.parseInt(txtChiTietSP.getText());
        int masp = Integer.parseInt(cbbMaSP.getSelectedItem().toString());
        String tensp = txtTenSP.getText();
        String size = cbbSize.getSelectedItem().toString();
        String ms = cbbMauSac.getSelectedItem().toString();
        String cl = cbbChatLieu.getSelectedItem().toString();
        String lh = cbbLoai.getSelectedItem().toString();
        int sl = Integer.parseInt(txtSoLuong.getText());
        float dg = Float.parseFloat(txtdDonGia.getText());
        String mota = txtMoTa.getText();
        Qlsp qlsp = new Qlsp(mactsp, masp, tensp, ms, cl, size, lh, sl, dg, mota);
        return qlsp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbbSearchMau = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtSearchMaSp = new javax.swing.JTextField();
        cbbSearchMauSP = new javax.swing.JComboBox<>();
        cbbSearchLoaiSP = new javax.swing.JComboBox<>();
        cbbSearchSize = new javax.swing.JComboBox<>();
        cbbSearchChatLieu = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        rdMau = new javax.swing.JRadioButton();
        rdSize = new javax.swing.JRadioButton();
        rdChatLieu = new javax.swing.JRadioButton();
        rdLoai = new javax.swing.JRadioButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtdDonGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLSP = new javax.swing.JTable();
        txtMoTa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbMaSP = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtChiTietSP = new javax.swing.JTextField();
        cbbLoai = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        btnLoadData = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnThemNhanhSize = new javax.swing.JButton();
        btnThemNhanhMau = new javax.swing.JButton();
        btnThemNhanhCl = new javax.swing.JButton();
        btnThemNhanhLh = new javax.swing.JButton();
        rdMaSp = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconresources (1)/Actions-document-edit-icon-16.png"))); // NOI18N
        jLabel1.setText("Quản Lý Sản Phẩm");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setText("Mã Sp");

        cbbSearchMau.setText("Màu SP");

        jLabel17.setText("Loại SP");

        jLabel18.setText("Size");

        jLabel19.setText("Chất liệu");

        txtSearchMaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchMaSpActionPerformed(evt);
            }
        });

        cbbSearchMauSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSearchMauSP.setEnabled(false);
        cbbSearchMauSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchMauSPActionPerformed(evt);
            }
        });

        cbbSearchLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSearchLoaiSP.setEnabled(false);

        cbbSearchSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSearchSize.setEnabled(false);
        cbbSearchSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchSizeActionPerformed(evt);
            }
        });

        cbbSearchChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSearchChatLieu.setEnabled(false);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Search.png"))); // NOI18N
        btnSearch.setText("search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        rdMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMauActionPerformed(evt);
            }
        });

        rdSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSizeActionPerformed(evt);
            }
        });

        rdChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChatLieuActionPerformed(evt);
            }
        });

        rdLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLoaiActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã SP");

        jLabel6.setText("Loại hàng");

        jLabel7.setText("Màu");

        jLabel8.setText("Size");

        jLabel9.setText("Số Lượng");

        jLabel10.setText("Đơn Giá");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Notes.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblQLSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblQLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLSP);

        jLabel11.setText("Mô tả");

        jLabel12.setText("Chất liệu");

        cbbMaSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Chi tiết SP");

        cbbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Tên SP");

        btnLoadData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Refresh.png"))); // NOI18N
        btnLoadData.setText("Load Data");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Task list.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnThemNhanhSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Add.png"))); // NOI18N
        btnThemNhanhSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanhSizeActionPerformed(evt);
            }
        });

        btnThemNhanhMau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Add.png"))); // NOI18N
        btnThemNhanhMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanhMauActionPerformed(evt);
            }
        });

        btnThemNhanhCl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Add.png"))); // NOI18N
        btnThemNhanhCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanhClActionPerformed(evt);
            }
        });

        btnThemNhanhLh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Add.png"))); // NOI18N
        btnThemNhanhLh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanhLhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbMaSP, 0, 151, Short.MAX_VALUE)
                                    .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnThemNhanhSize)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnThemNhanhMau)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel14))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnThemNhanhCl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnThemNhanhLh)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtdDonGia)
                                    .addComponent(txtChiTietSP)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(txtSoLuong)
                                    .addComponent(txtTenSP)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoadData)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear)
                                .addGap(29, 29, 29)
                                .addComponent(btnXoa)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(87, 87, 87))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9)
                                                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                            .addComponent(btnThemNhanhSize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtdDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel7)
                                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnThemNhanhMau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnThemNhanhCl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtChiTietSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnThemNhanhLh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLoadData)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản Lý SP", jPanel2);

        rdMaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMaSpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(rdLoai))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(rdMau)))
                    .addComponent(rdMaSp, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(cbbSearchLoaiSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbbSearchMau)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchMaSp)
                            .addComponent(cbbSearchMauSP, 0, 154, Short.MAX_VALUE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rdSize)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rdChatLieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbSearchSize, 0, 159, Short.MAX_VALUE)
                    .addComponent(cbbSearchChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnSearch))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdSize)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(rdMaSp)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel18)
                                            .addComponent(txtSearchMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbSearchSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbSearchMau)
                                .addComponent(jLabel19)
                                .addComponent(cbbSearchMauSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbSearchChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rdMau)))
                    .addComponent(rdChatLieu))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(cbbSearchLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdLoai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            Qlsp qlsp = getQlsp();
            if (iQlspService.check_ton_tai_ctsp(qlsp)) {
                JOptionPane.showMessageDialog(this, "sản phẩm đã tồn tại");
                return;
            } else {
                System.out.println("view  " + qlsp.toString());
                if (iQlspService.them(qlsp)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    loadData(iQlspService.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi thêm");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed


    private void cbbSearchSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSearchSizeActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        loadData(iQlspService.getAll());
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void txtSearchMaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchMaSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchMaSpActionPerformed

    private void btnThemNhanhSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanhSizeActionPerformed
        String kichCo = JOptionPane.showInputDialog("them size");
        if (kichCo == null) {
            kichCo = "";
        }
        KichCoDomainModel kc = new KichCoDomainModel();
        kc.setTenKC(kichCo);
        JOptionPane.showMessageDialog(this, kichCoServices.add(kc));
        loadCbbSize((kichCoServices.getListTenKC()));
    }//GEN-LAST:event_btnThemNhanhSizeActionPerformed

    private void rdMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMauActionPerformed
        if (rdMau.isSelected()) {
            cbbSearchMauSP.setEnabled(true);
        } else {
            cbbSearchMauSP.setEnabled(false);
        }
    }//GEN-LAST:event_rdMauActionPerformed

    private void btnThemNhanhMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanhMauActionPerformed
        String mau = JOptionPane.showInputDialog("Them mau sac moi:");
        if (mau == null) {
            mau = "";
        }
        MauSacDomainModel ms = new MauSacDomainModel();
        ms.setTenMau(mau);
        JOptionPane.showMessageDialog(this, mauSacServices.add(ms));
        loadCbbMauSac(mauSacServices.getTenMS());
    }//GEN-LAST:event_btnThemNhanhMauActionPerformed

    private void btnThemNhanhClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanhClActionPerformed
        // TODO add your handling code here:
        String Cl = JOptionPane.showInputDialog(this, "Them chat lieu moi(Fload) :");
        if (Cl == null) {
            Cl = "";
        }
        ChatLieuDomainModel ChatL = new ChatLieuDomainModel(Cl);
        JOptionPane.showMessageDialog(this, chatLieuServices.add(ChatL));
        loadCbbLoaiHang(chatLieuServices.getListTenCL());
    }//GEN-LAST:event_btnThemNhanhClActionPerformed

    private void btnThemNhanhLhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanhLhActionPerformed
        String loai = JOptionPane.showInputDialog(this, "Them loai hang moi:");
        if (loai == null) {
            loai = "";
        }
        LoaiHangDomainModel lh = new LoaiHangDomainModel(loai);
        JOptionPane.showMessageDialog(this, loaiHangServices.add(lh));
        loadCbbLoaiHang(loaiHangServices.getListTenLoai());
    }//GEN-LAST:event_btnThemNhanhLhActionPerformed

    private void rdSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSizeActionPerformed
        if (rdSize.isSelected()) {
            cbbSearchSize.setEnabled(true);
        } else {
            cbbSearchSize.setEnabled(false);
        }
    }//GEN-LAST:event_rdSizeActionPerformed

    private void rdChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChatLieuActionPerformed
        if (rdChatLieu.isSelected()) {
            cbbSearchChatLieu.setEnabled(true);
        } else {
            cbbSearchChatLieu.setEnabled(false);
        }
    }//GEN-LAST:event_rdChatLieuActionPerformed

    private void rdLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLoaiActionPerformed
        if (rdLoai.isSelected()) {
            cbbSearchLoaiSP.setEnabled(true);
        } else {
            cbbSearchLoaiSP.setEnabled(false);
        }
    }//GEN-LAST:event_rdLoaiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            Qlsp qlsp = getQlsp();
            if (iQlspService.xoa(qlsp)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadData(iQlspService.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi xóa");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cbbSearchMauSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchMauSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSearchMauSPActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtChiTietSP.setText("");
        txtMoTa.setText("");
        txtSoLuong.setText("");
        txtTenSP.setText("");
        txtdDonGia.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblQLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSPMouseClicked
        int i = tblQLSP.getSelectedRow();
//        String[] hihi = {"Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Số lượng", "Đơn giá"};
        txtTenSP.setText(tblQLSP.getValueAt(i, 1).toString());
        cbbSize.setSelectedItem(tblQLSP.getValueAt(i, 5).toString());
        cbbMauSac.setSelectedItem(tblQLSP.getValueAt(i, 2).toString());
        cbbChatLieu.setSelectedItem(tblQLSP.getValueAt(i, 4).toString());
        cbbLoai.setSelectedItem(tblQLSP.getValueAt(i, 3).toString());
        txtSoLuong.setText(tblQLSP.getValueAt(i, 6).toString());
        txtdDonGia.setText(tblQLSP.getValueAt(i, 7).toString());
        txtMoTa.setText(listClone.get(i).getMoTa());
        txtChiTietSP.setText(tblQLSP.getValueAt(i, 0).toString());
        dcmMaSP.setSelectedItem(listClone.get(i).getMaSp());
    }//GEN-LAST:event_tblQLSPMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        ArrayList<String> list = new ArrayList<>();
        if (!rdMaSp.isSelected() && !rdMau.isSelected()
                && !rdLoai.isSelected() && !rdSize.isSelected()
                && !rdChatLieu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Hãy chọn thông tin cần tìm");
            return;
        }

        if (rdMaSp.isSelected()) {
            list.add("sanpham.Masp=" + txtSearchMaSp.getText() + "");
        }
        if (rdMau.isSelected()) {
            list.add(" Tenms=N'" + cbbSearchMauSP.getSelectedItem().toString() + "' ");
        }
        if (rdLoai.isSelected()) {
            list.add(" tenloai=N'" + cbbSearchLoaiSP.getSelectedItem().toString() + "' ");
        }
        if (rdSize.isSelected()) {
            list.add(" tenkc=N'" + cbbSearchSize.getSelectedItem().toString() + "' ");
        }
        if (rdChatLieu.isSelected()) {
            list.add(" tencl=N'" + cbbSearchChatLieu.getSelectedItem().toString() + "' ");
        }

        if (iQlspService.boLoc(list).size() == 0) {
            JOptionPane.showMessageDialog(this, "Thông tin cần tìm không có");
            return;
        } else {
            loadData(iQlspService.boLoc(list));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void rdMaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMaSpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemNhanhCl;
    private javax.swing.JButton btnThemNhanhLh;
    private javax.swing.JButton btnThemNhanhMau;
    private javax.swing.JButton btnThemNhanhSize;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JComboBox<String> cbbMaSP;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbSearchChatLieu;
    private javax.swing.JComboBox<String> cbbSearchLoaiSP;
    private javax.swing.JLabel cbbSearchMau;
    private javax.swing.JComboBox<String> cbbSearchMauSP;
    private javax.swing.JComboBox<String> cbbSearchSize;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton rdChatLieu;
    private javax.swing.JRadioButton rdLoai;
    private javax.swing.JRadioButton rdMaSp;
    private javax.swing.JRadioButton rdMau;
    private javax.swing.JRadioButton rdSize;
    private javax.swing.JTable tblQLSP;
    private javax.swing.JTextField txtChiTietSP;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSearchMaSp;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtdDonGia;
    // End of variables declaration//GEN-END:variables
}

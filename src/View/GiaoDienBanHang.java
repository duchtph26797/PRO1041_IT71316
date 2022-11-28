/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModel.HoaDonModel2;
import DomainModel.KhachHangDomainModel;
import DomainModel.NhanVienModel;
import Service.HDlmp;
import Service.Interface.HDSer;
import Service.Interface.IKhuyenMaiService;
import Service.Interface.IQlspService;
import Service.Interface.KhachHangService;
import Service.KhachHangIplm;
import Service.KhuyenMaiImpl;
import Service.QlspImpl;
import ViewModel.Qlsp;
import ViewModel.hdview;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL 5570
 */
public class GiaoDienBanHang extends javax.swing.JPanel {

    private DefaultTableModel dtmSp = new DefaultTableModel();
    private DefaultTableModel dtmGh = new DefaultTableModel();
    private DefaultTableModel dtmHd = new DefaultTableModel();
    DefaultComboBoxModel dcmMucKm;
    
    private IQlspService iQlspService = new QlspImpl();
    private HDSer HD = new HDlmp();
    KhachHangService serviceKH=new KhachHangIplm();
    NhanVienModel nvGdbh=new NhanVienModel();
    IKhuyenMaiService iKhuyenMaiService=new KhuyenMaiImpl();
    
    
    public GiaoDienBanHang() {
        initComponents();
        
        dcmMucKm=(DefaultComboBoxModel) cbMucKm.getModel();
        loadMucKm(iKhuyenMaiService.getListMucKm());
        tbSanPham.setModel(dtmSp);
        String[] header = {"STT", "Mã SP", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Số lượng", "Đơn giá", "Mô Tả"};
        dtmSp.setColumnIdentifiers(header);
        tblGh.setModel(dtmGh);
        String[] header1 = {"STT", "Mã SP", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Số lượng", "Đơn giá"};
        dtmGh.setColumnIdentifiers(header1);
        tblHd.setModel(dtmHd);
        String[] header2 = {"STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Khách hàng", "Mức Km", "Tình trạng"};
        dtmHd.setColumnIdentifiers(header2);

        loadTBSanPham(iQlspService.getAllSpGdbh());
        loadTBHoadon(HD.getAllHdGdbh());
    }

    
    public GiaoDienBanHang(NhanVienModel nvHome) {
        initComponents();
        tbSanPham.setModel(dtmSp);
        String[] header = {"STT", "Mã SP", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Số lượng", "Đơn giá", "Mô Tả"};
        dtmSp.setColumnIdentifiers(header);
        tblGh.setModel(dtmGh);
        String[] header1 = {"STT", "Mã SP", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Số lượng", "Đơn giá"};
        dtmGh.setColumnIdentifiers(header1);
        tblHd.setModel(dtmHd);
        String[] header2 = {"STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Khách hàng", "Mức Km", "Tình trạng"};
        dtmHd.setColumnIdentifiers(header2);

        nvGdbh=nvHome;
        loadTBSanPham(iQlspService.getAllSpGdbh());
        loadTBHoadon(HD.getAllHdGdbh());
    }
    
    private void loadTBSanPham(ArrayList<Qlsp> list) {
        dtmSp.setRowCount(0);
        int i = 1;
        for (Qlsp qlsp : list) {
            dtmSp.addRow(new Object[]{
                i,
                qlsp.getMaSp(),
                qlsp.getMaCtsp(),
                qlsp.getTenSp(),
                qlsp.getTenMs(),
                qlsp.getTenLoai(),
                qlsp.getTenCl(),
                qlsp.getTenKc(),
                qlsp.getSoLuong(),
                qlsp.getDonGia(),
                qlsp.getMoTa()
            });
            i++;
        }
    }

    private void loadTBHoadon(ArrayList<hdview> list) {
        dtmHd.setRowCount(0);
        int i = 1;
        for (hdview hdv : list) {
            dtmHd.addRow(new Object[]{
                i++,
                hdv.getMaHD(),
                hdv.getNgayTao(),
                hdv.getTenNv(),
                hdv.getTenKh(),
                hdv.getMucKm() + "%",
                hdv.hienTt()
            });
        }
//        {"STT", "Mã HĐ", "Ngày tạo", "Tên NV","Khách hàng","Mã Km", "Tình trạng"};
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSerachSp = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGh = new javax.swing.JTable();
        buttonCapNhat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHd = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaHd = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTenNv = new javax.swing.JTextField();
        txtTenKh = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        txtTongTien = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtSearchKh = new javax.swing.JTextField();
        btnSerachKh = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtMaKh2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTenKh2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDiaChi2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtSdt2 = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtNgaySinh2 = new javax.swing.JTextField();
        buttonTaoHD = new javax.swing.JButton();
        buttonThanhToan = new javax.swing.JButton();
        buttonHuyDon = new javax.swing.JButton();
        cbMucKm = new javax.swing.JComboBox<>();
        txtMaKhThemHd = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbSanPham);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("Tìm Kiếm");

        txtSerachSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerachSpActionPerformed(evt);
            }
        });
        txtSerachSp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerachSpKeyPressed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(txtSerachSp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnLamMoi)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerachSp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );

        jLabel3.setText("SẢN PHẨM");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblGh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblGh);

        buttonCapNhat.setText("Cập nhật số lượng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCapNhat)
                .addGap(97, 97, 97))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCapNhat)
                .addGap(20, 20, 20))
        );

        jLabel5.setText("GIỎ HÀNG");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblHd.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblHd);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 436, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel6.setText("HÓA ĐƠN");

        jLabel4.setText("Mã HD");

        jLabel7.setText("Ngày tạo");

        jLabel8.setText("Tên NV");

        jLabel9.setText("Tên KH");

        jLabel10.setText("SDT");

        jLabel11.setText("Địa chỉ");

        jLabel12.setText("Tổng tiền");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane4.setViewportView(txtDiaChi);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenKh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtTenNv, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa đơn", jPanel5);

        jLabel13.setText("Tìm KH");

        btnSerachKh.setText("Search");
        btnSerachKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerachKhActionPerformed(evt);
            }
        });

        jLabel14.setText("Mã KH");

        txtMaKh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKh2ActionPerformed(evt);
            }
        });

        jLabel15.setText("Tên KH");

        txtTenKh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKh2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Địa chỉ");

        txtDiaChi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChi2ActionPerformed(evt);
            }
        });

        jLabel17.setText("Sdt");

        txtSdt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdt2ActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel18.setText("Ngày sinh");

        txtNgaySinh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinh2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel13)
                        .addGap(43, 43, 43)
                        .addComponent(txtSearchKh, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTenKh2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMaKh2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSdt2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(btnSerachKh))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtSearchKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSerachKh))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaKh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTenKh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtSdt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khách hàng", jPanel6);

        buttonTaoHD.setText("Tạo hóa đơn");
        buttonTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTaoHDActionPerformed(evt);
            }
        });

        buttonThanhToan.setText("Thanh toán");

        buttonHuyDon.setText("Hủy đơn");

        cbMucKm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMaKhThemHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhThemHdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonThanhToan)
                            .addComponent(buttonHuyDon)
                            .addComponent(buttonTaoHD))
                        .addGap(29, 29, 29)
                        .addComponent(txtMaKhThemHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbMucKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaKhThemHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonTaoHD)
                                    .addComponent(cbMucKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(buttonHuyDon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonThanhToan)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerachSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerachSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerachSpActionPerformed

    private void txtSerachSpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerachSpKeyPressed
        if (txtSerachSp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập mã sp cần tìm");
            return;
        }
       
        ArrayList<String> list=new ArrayList<>();
        list.add("sanpham.Masp=" + txtSerachSp.getText() + " ");
        if(iQlspService.boLoc(list).size()==0){
            JOptionPane.showMessageDialog(this, "Không có sản phẩm cần tìm");
            return;
        }
        else{
            loadTBSanPham(iQlspService.boLoc(list));
        }
    }//GEN-LAST:event_txtSerachSpKeyPressed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadTBSanPham(iQlspService.getAllSpGdbh());
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtMaKh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKh2ActionPerformed

    private void txtTenKh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKh2ActionPerformed

    private void txtDiaChi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChi2ActionPerformed

    private void txtSdt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdt2ActionPerformed

    private void buttonTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTaoHDActionPerformed
        try {
            HoaDonModel2 hd=new HoaDonModel2();
            hd.setNgayTao(new Date());
            hd.setTrangThai(0);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_buttonTaoHDActionPerformed

    public void loadMucKm(ArrayList<String> list){
        dcmMucKm=(DefaultComboBoxModel) cbMucKm.getModel();
        dcmMucKm.removeAllElements();
        for (String s : list) {
            dcmMucKm.addElement(s);
        }
    }
    
    private void btnSerachKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerachKhActionPerformed
        List<KhachHangDomainModel> listKH=new ArrayList<>();
        String sdt = txtSearchKh.getText().trim();
        listKH = serviceKH.Search(sdt);
        if(listKH.size()==0){
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại");
            return;
        }
        KhachHangDomainModel kh=listKH.get(0);
        txtMaKh2.setText(String.valueOf(kh.getMaKH()));
        txtTenKh2.setText(kh.getTenKH());
        txtDiaChi2.setText(kh.getDiaChi());
        txtSdt2.setText(kh.getSdt());
        txtNgaySinh2.setText(kh.getNgaySinh());
    }//GEN-LAST:event_btnSerachKhActionPerformed

    private void txtNgaySinh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh2ActionPerformed

    private void txtMaKhThemHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhThemHdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhThemHdActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String tenKH = txtTenKh2.getText();
        String diaChi = txtDiaChi2.getText();
        String sdt = txtSdt2.getText();
        String ngaySinh = txtNgaySinh2.getText();
        KhachHangDomainModel kh = new KhachHangDomainModel(tenKH, diaChi, sdt, ngaySinh);
        JOptionPane.showMessageDialog(this, serviceKH.add(tenKH, sdt, sdt, ngaySinh));
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSerachKh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton buttonCapNhat;
    private javax.swing.JButton buttonHuyDon;
    private javax.swing.JButton buttonTaoHD;
    private javax.swing.JButton buttonThanhToan;
    private javax.swing.JComboBox<String> cbMucKm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTable tblGh;
    private javax.swing.JTable tblHd;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtDiaChi2;
    private javax.swing.JTextField txtMaHd;
    private javax.swing.JTextField txtMaKh2;
    private javax.swing.JTextField txtMaKhThemHd;
    private javax.swing.JTextField txtNgaySinh2;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSdt2;
    private javax.swing.JTextField txtSearchKh;
    private javax.swing.JTextField txtSerachSp;
    private javax.swing.JTextField txtTenKh;
    private javax.swing.JTextField txtTenKh2;
    private javax.swing.JTextField txtTenNv;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}

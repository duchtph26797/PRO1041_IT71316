/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModel.HDCTDomainModel;
import DomainModel.HoaDonModel2;
import DomainModel.KhachHangDomainModel;
import DomainModel.KhuyenMai;
import DomainModel.NhanVienModel;
import Service.HDCTIplm;
import Service.HDlmp;
import Service.Interface.HDCTService;
import Service.Interface.HDSer;
import Service.Interface.IKhuyenMaiService;
import Service.Interface.IQlspService;
import Service.Interface.KhachHangService;
import Service.KhachHangIplm;
import Service.KhuyenMaiImpl;
import Service.QlspImpl;
import ViewModel.HdctView;
import ViewModel.Qlsp;
import ViewModel.hdview;
import java.text.SimpleDateFormat;
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
    DefaultComboBoxModel dcmMucKm = new DefaultComboBoxModel();

    private IQlspService iQlspService = new QlspImpl();
    private HDSer HD = new HDlmp();
    KhachHangService serviceKH = new KhachHangIplm();
    IKhuyenMaiService iKhuyenMaiService = new KhuyenMaiImpl();
    HDCTService hDCTService = new HDCTIplm();

    NhanVienModel nvGdbh = new NhanVienModel();

    public GiaoDienBanHang() {
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

        loadTBSanPham(iQlspService.getAllSpGdbh());
        loadTBHoadon(HD.getAllHdGdbh());

    }

    public GiaoDienBanHang(NhanVienModel nvHome) {
        initComponents();
        txtChao.setText("^_^XIN CHÀO " + nvHome.getTenNV());
        tbSanPham.setModel(dtmSp);
        String[] header = {"STT", "Mã SP", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Sl", "Giá", "Mô Tả"};
        dtmSp.setColumnIdentifiers(header);
        tblGh.setModel(dtmGh);
        String[] header1 = {"STT", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Sl", "Giá"};
        dtmGh.setColumnIdentifiers(header1);
        tblHd.setModel(dtmHd);
        String[] header2 = {"STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Khách hàng", "Mức Km", "Tình trạng"};
        dtmHd.setColumnIdentifiers(header2);

        dcmMucKm = (DefaultComboBoxModel) cbMucKm.getModel();
        loadMucKm(iKhuyenMaiService.getListMucKm());

        nvGdbh = nvHome;

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

    private void loadTBGioHang(ArrayList<HdctView> list) {
        dtmGh.setRowCount(0);
        int i = 1;
        for (HdctView hd : list) {
            dtmGh.addRow(new Object[]{
                i++,
                hd.getMactsp(),
                hd.getTenSp(),
                hd.getTenMs(),
                hd.getTenLoai(),
                hd.getTenCl(),
                hd.getTenKc(),
                hd.getSoLuong(),
                hd.getDonGia(),});
            //{"STT", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Sl", "Giá"};
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
        btnSearchSp = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHd = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGh = new javax.swing.JTable();
        buttonCapNhat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnXoaSp = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaHd = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTenNv = new javax.swing.JTextField();
        txtTenKh = new javax.swing.JTextField();
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
        txtChao = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

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
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerachSpKeyReleased(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSearchSp.setText("Search");
        btnSearchSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(txtSerachSp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSearchSp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLamMoi)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerachSp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnSearchSp))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setText("HÓA ĐƠN");

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
        tblHd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHdMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHd);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(436, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
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
        tblGh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGh);

        buttonCapNhat.setText("Cập nhật số lượng");
        buttonCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCapNhatActionPerformed(evt);
            }
        });

        jLabel5.setText("GIỎ HÀNG");

        btnXoaSp.setText("Xóa sản phẩm");
        btnXoaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btnXoaSp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCapNhat)
                .addGap(97, 97, 97))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCapNhat)
                    .addComponent(btnXoaSp))
                .addGap(20, 20, 20))
        );

        jLabel4.setText("Mã HD");

        jLabel7.setText("Ngày tạo");

        jLabel8.setText("Tên NV");

        jLabel9.setText("Tên KH");

        jLabel12.setText("Tổng tiền");

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
                    .addComponent(jLabel12))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenKh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtTenNv, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(125, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
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
        buttonThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThanhToanActionPerformed(evt);
            }
        });

        buttonHuyDon.setText("Hủy đơn");
        buttonHuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHuyDonActionPerformed(evt);
            }
        });

        cbMucKm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMaKhThemHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhThemHdActionPerformed(evt);
            }
        });

        txtChao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtChao.setText(".");

        jLabel19.setText("Nhập mã KH");

        jLabel20.setText("Mức Km");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtChao, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTaoHD)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel19)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel20))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(txtMaKhThemHd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(cbMucKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonHuyDon)
                            .addComponent(buttonThanhToan))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtChao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonTaoHD)
                            .addComponent(txtMaKhThemHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMucKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonHuyDon)
                        .addGap(18, 18, 18)
                        .addComponent(buttonThanhToan)))
                .addGap(29, 29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerachSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerachSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerachSpActionPerformed

    private void txtSerachSpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerachSpKeyPressed

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
            if (txtMaKhThemHd.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nhập mã khách hàng mua");
                return;
            }
            HoaDonModel2 hd = new HoaDonModel2();
            hd.setNgayTao(new Date());
            hd.setTrangThai(0);
            //
            KhachHangDomainModel kh = new KhachHangDomainModel();
            kh.setMaKH(Integer.parseInt(txtMaKhThemHd.getText()));
            hd.setKh(kh);
            //
            hd.setNv(nvGdbh);
            //
            KhuyenMai km = new KhuyenMai();
//            km.setMaKm(cbMucKm.getSelectedIndex());
            km.setMaKm(1);//tạm thời fix cứng
            System.out.println(cbMucKm.getSelectedIndex());
            hd.setKm(km);
            //
            if (HD.addByGdbh(hd)) {
                JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
                loadTBHoadon(HD.getAllHdGdbh());
            } else {
                JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_buttonTaoHDActionPerformed

    public void loadMucKm(ArrayList<String> list) {
        dcmMucKm.removeAllElements();
        for (String s : list) {
            dcmMucKm.addElement(s);
        }
    }

    private void btnSerachKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerachKhActionPerformed
        List<KhachHangDomainModel> listKH = new ArrayList<>();
        String sdt = txtSearchKh.getText().trim();
        listKH = serviceKH.Search(sdt);
        if (listKH.size() == 0) {
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại");
            return;
        }
        KhachHangDomainModel kh = listKH.get(0);
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

    private void buttonHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHuyDonActionPerformed
        try {
            if (tblHd.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Chọn hóa đơn cần hủy");
                return;
            }
            if (HD.xoa(txtMaHd.getText())) {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công");
                loadTBHoadon(HD.getAllHdGdbh());
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn thất bại");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
    }//GEN-LAST:event_buttonHuyDonActionPerformed

    private void tblHdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHdMouseClicked
        //{"STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Khách hàng", "Mức Km", "Tình trạng"};
        int rowHd = tblHd.getSelectedRow();
        txtMaHd.setText(tblHd.getValueAt(rowHd, 1).toString());
        txtNgayTao.setText(tblHd.getValueAt(rowHd, 2).toString());
        txtTenNv.setText(tblHd.getValueAt(rowHd, 3).toString());
        txtTenKh.setText(tblHd.getValueAt(rowHd, 4).toString());

        loadTBGioHang(hDCTService.getAllHdctByMaHd(tblHd.getValueAt(rowHd, 1).toString()));
        txtTongTien.setText(String.valueOf(hDCTService.tongTienHd(tblHd.getValueAt(rowHd, 1).toString())));
    }//GEN-LAST:event_tblHdMouseClicked

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int rowHd = tblHd.getSelectedRow();
        int rowSp = tbSanPham.getSelectedRow();
        if (rowHd == -1) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn cần thêm sản phẩm");
            return;
        }
        int sl;
        try {
            sl = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập số lượng mua"));
            if (sl <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng nguyên dương");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng nguyên dương");
            return;
        }
        HDCTDomainModel hd = new HDCTDomainModel(
                Integer.parseInt(tblHd.getValueAt(rowHd, 1).toString()),
                Integer.parseInt(tbSanPham.getValueAt(rowSp, 2).toString()),
                //                new SimpleDateFormat("yyyy-mm-dd").parse(tblHd.getValueAt(2, rowHd).toString()),
                null,
                sl,
                tbSanPham.getValueAt(rowSp, 9).toString()
        );

        if (hDCTService.checkTonTaiHdct(String.valueOf(hd.getMaHD()), String.valueOf(hd.getMaCTSP()))) {
            JOptionPane.showMessageDialog(this, "Đã có sản phẩm trong giỏ hàng");
            return;
        }
        try {
            JOptionPane.showMessageDialog(this, hDCTService.Add(hd));
            iQlspService.sua_so_luong(-sl, tbSanPham.getValueAt(rowSp, 2).toString());
        } catch (Exception e) {
        }
        loadTBGioHang(hDCTService.getAllHdctByMaHd(tblHd.getValueAt(rowHd, 1).toString()));
        loadTBSanPham(iQlspService.getAllSpGdbh());
        txtTongTien.setText(String.valueOf(hDCTService.tongTienHd(tblHd.getValueAt(rowHd, 1).toString())));
    }//GEN-LAST:event_tbSanPhamMouseClicked

    void clearForm() {
        txtMaHd.setText("");
        txtNgayTao.setText("");
        txtTenNv.setText("");
        txtTenKh.setText("");
        txtTongTien.setText("");
    }

    private void buttonThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThanhToanActionPerformed
        int rowHd = tblHd.getSelectedRow();
        if (rowHd == -1) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn cần thanh toán");
            return;
        }
        try {
            if (HD.sua_tt_hd(tblHd.getValueAt(rowHd, 1).toString())) {
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                loadTBHoadon(HD.getAllHdGdbh());
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thanh toán thất bại");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi thanh toán");
        }
    }//GEN-LAST:event_buttonThanhToanActionPerformed

    private void btnXoaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSpActionPerformed
        int rowGh = tblGh.getSelectedRow();
        int rowHd = tblHd.getSelectedRow();
        if (rowGh == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa");
            return;
        }
        String maHd = tblHd.getValueAt(rowHd, 1).toString();
        String maHdct = tblGh.getValueAt(rowGh, 1).toString();

        int sl = Integer.parseInt(tblGh.getValueAt(rowGh, 7).toString());
        try {
            iQlspService.sua_so_luong(sl, tblGh.getValueAt(rowGh, 1).toString());
            hDCTService.delete(maHd, maHdct);
            loadTBGioHang(hDCTService.getAllHdctByMaHd(maHd));
            loadTBSanPham(iQlspService.getAllSpGdbh());
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
        } catch (Exception e) {
        }
        txtTongTien.setText(String.valueOf(hDCTService.tongTienHd(tblHd.getValueAt(rowHd, 1).toString())));
    }//GEN-LAST:event_btnXoaSpActionPerformed

    private void buttonCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCapNhatActionPerformed
        int rowGh = tblGh.getSelectedRow();
        int rowHd = tblHd.getSelectedRow();
        if (rowGh == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cập nhật số lượng");
            return;
        }
        String maHd = tblHd.getValueAt(rowHd, 1).toString();
        String maHdct = tblGh.getValueAt(rowGh, 1).toString();

        int slMoi;
        try {
            slMoi = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập số lượng"));
            if (slMoi <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng nguyên dương");
                return;
            }
//            if(slMoi>){
//                
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng nguyên dương");
            return;
        }
        int slCu = Integer.parseInt(tblGh.getValueAt(rowGh, 7).toString());
        try {
            hDCTService.update_so_luong(String.valueOf(slMoi), maHd, maHdct);
            iQlspService.sua_so_luong(slCu - slMoi, tblGh.getValueAt(rowGh, 1).toString());
            txtTongTien.setText(String.valueOf(hDCTService.tongTienHd(tblHd.getValueAt(rowHd, 1).toString())));
            loadTBGioHang(hDCTService.getAllHdctByMaHd(maHd));
            loadTBSanPham(iQlspService.getAllSpGdbh());
            JOptionPane.showMessageDialog(this, "Sửa số lượng thành công");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_buttonCapNhatActionPerformed

    private void txtSerachSpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerachSpKeyReleased

    }//GEN-LAST:event_txtSerachSpKeyReleased

    private void btnSearchSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSpActionPerformed
        if (txtSerachSp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập mã sp cần tìm");
            return;
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("sanpham.Masp=" + txtSerachSp.getText() + " ");
        if (iQlspService.boLoc(list).size() == 0) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm cần tìm");
            return;
        } else {
            loadTBSanPham(iQlspService.boLoc(list));      
        }    }//GEN-LAST:event_btnSearchSpActionPerformed

    private void tblGhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSearchSp;
    private javax.swing.JButton btnSerachKh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoaSp;
    private javax.swing.JButton buttonCapNhat;
    private javax.swing.JButton buttonHuyDon;
    private javax.swing.JButton buttonTaoHD;
    private javax.swing.JButton buttonThanhToan;
    private javax.swing.JComboBox<String> cbMucKm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTable tblGh;
    private javax.swing.JTable tblHd;
    private javax.swing.JLabel txtChao;
    private javax.swing.JTextField txtDiaChi2;
    private javax.swing.JTextField txtMaHd;
    private javax.swing.JTextField txtMaKh2;
    private javax.swing.JTextField txtMaKhThemHd;
    private javax.swing.JTextField txtNgaySinh2;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSdt2;
    private javax.swing.JTextField txtSearchKh;
    private javax.swing.JTextField txtSerachSp;
    private javax.swing.JTextField txtTenKh;
    private javax.swing.JTextField txtTenKh2;
    private javax.swing.JTextField txtTenNv;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}

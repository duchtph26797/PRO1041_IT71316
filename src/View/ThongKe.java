/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModel.HoaDonModel;
import DomainModel.HoaDonModel2;
import DomainModel.SanPham;
import Service.HDlmp;
import Service.Interface.HDSer;
import Service.Interface.IQlspService;
import Service.Interface.ThongKeService;
import Service.QlspImpl;
import Service.ThongKeIplm;
import ViewModel.DoanhThuView;
import ViewModel.Qlsp;
import ViewModel.hdview;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TRUNG DUC
 */
public class ThongKe extends javax.swing.JPanel {
    
    private DefaultTableModel dtmHD = new DefaultTableModel();
    private DefaultTableModel dtmSP = new DefaultTableModel();
    private DefaultComboBoxModel dcbmSortTK = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmSortHD = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmSortSP = new DefaultComboBoxModel();
    private HDSer hds = new HDlmp();
    private ThongKeService tks = new ThongKeIplm();

    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        
        loadCbbSortTK();
        txtFirstDate.setVisible(false);
        lbTo.setVisible(false);
        txtLastDate.setVisible(false);
        btnTK.setVisible(false);
        loadCbbSortHD();
        loadCbbSortSP();
        
        loadDT(tks.getThongKe(""));
        loadTBHD("All");
        loadTBSP("order by [Tong doanh thu] desc");
    }
    
    private void loadTBHD(String conditions) {
        String[] headers = {"Mã HD", "Ngày tạo", "Tên NV", "Tên KH", "Mức khuyến mãi", "Trạng thái"};
        tbHD.setModel(dtmHD);
        dtmHD.setColumnIdentifiers(headers);
        dtmHD.setRowCount(0);
        if (conditions.equals("All")) {
            for (hdview x : hds.getAllHdGdbh()) {
                dtmHD.addRow(new Object[]{
                    x.getMaHD(),
                    x.getNgayTao(),
                    x.getTenNv(),
                    x.getTenKh(),
                    x.getMucKm() + "%",
                    x.hienTt()});
            }
        }
        if (conditions.equals("Đang chờ")) {
            for (hdview x : hds.getAllHdGdbh()) {
                if (x.getTrangThai() == 0) {
                    dtmHD.addRow(new Object[]{
                        x.getMaHD(),
                        x.getNgayTao(),
                        x.getTenNv(),
                        x.getTenKh(),
                        x.getMucKm() + "%",
                        x.hienTt()});
                }
            }
        }
        if (conditions.equals("Đã thanh toán")) {
            for (hdview x : hds.getAllHdGdbh()) {
                if (x.getTrangThai() == 1) {
                    dtmHD.addRow(new Object[]{
                        x.getMaHD(),
                        x.getNgayTao(),
                        x.getTenNv(),
                        x.getTenKh(),
                        x.getMucKm() + "%",
                        x.hienTt()});
                }
            }
        }
    }
    
    private void loadTBSP(String conditions) {
        String[] headers = {"Mã SP", "Tên SP", "Loại hàng", "Màu sắc", "Kích cỡ", "Chất liệu", "Đơn giá", "Đã bán", "Còn tồn", "Tổng doanh thu"};
        tbSP.setModel(dtmSP);
        dtmSP.setColumnIdentifiers(headers);
        dtmSP.setRowCount(0);
        for (SanPham x : tks.getSanPham(conditions)) {
            dtmSP.addRow(x.toRowData());
        }
    }
    
    private void loadCbbSortTK() {
        cbbSortTK.setModel(dcbmSortTK);
        dcbmSortTK.addElement("Mọi thời điểm");
        dcbmSortTK.addElement("Trong ngày");
        dcbmSortTK.addElement("Trong tuần");
        dcbmSortTK.addElement("Tuần vừa qua");
        dcbmSortTK.addElement("Trong tháng");
        dcbmSortTK.addElement("Tháng vừa qua");
        dcbmSortTK.addElement("Cả năm");
        dcbmSortTK.addElement("Khoảng thời gian cụ thể");
    }
    
    private void loadDT(DoanhThuView dt) {
        txtDT.setText(String.valueOf(dt.getTongDoanhThu()));
        txtSP.setText(String.valueOf(dt.getTongSanPham()));
        txtHD.setText(String.valueOf(dt.getSoHoaDon()));
    }
    
    private void loadCbbSortHD() {
        cbbSortHD.setModel(dcbmSortHD);
        dcbmSortHD.addElement("All");
        dcbmSortHD.addElement("Đã thanh toán");
        dcbmSortHD.addElement("Đang chờ");
    }
    
    private void loadCbbSortSP() {
        cbbSortSP.setModel(dcbmSortSP);
        dcbmSortSP.addElement("Doanh thu cao nhất");
        dcbmSortSP.addElement("Doanh thu thấp nhất");
        dcbmSortSP.addElement("Được mua nhiều nhất");
        dcbmSortSP.addElement("Được mua ít nhất");
        dcbmSortSP.addElement("Còn tồn nhiều nhất");
        dcbmSortSP.addElement("Còn tồn ít nhất");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbSortTK = new javax.swing.JComboBox<>();
        txtDT = new javax.swing.JLabel();
        txtSP = new javax.swing.JLabel();
        txtHD = new javax.swing.JLabel();
        txtFirstDate = new javax.swing.JTextField();
        txtLastDate = new javax.swing.JTextField();
        lbTo = new javax.swing.JLabel();
        btnTK = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSP = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cbbSortHD = new javax.swing.JComboBox<>();
        cbbSortSP = new javax.swing.JComboBox<>();

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbHD);

        jLabel1.setText("Danh sách hóa đơn được lưu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Price list.png"))); // NOI18N
        jLabel5.setText("Thống kê doanh thu");

        jLabel2.setText("Tổng doanh thu");

        jLabel3.setText("Số sản phẩm đã bán");
        jLabel3.setToolTipText("");

        jLabel4.setText("Số hóa đơn đã thanh toán");

        cbbSortTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSortTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSortTKActionPerformed(evt);
            }
        });

        txtDT.setText("-.---.---");

        txtSP.setText("----");

        txtHD.setText("----");

        lbTo.setText("to");

        btnTK.setText("Thống kê");
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });

        tbSP.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbSP);

        jLabel6.setText("Danh sach sản phẩm đã được bán");

        cbbSortHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSortHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSortHDActionPerformed(evt);
            }
        });

        cbbSortSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSortSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSortSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(88, 88, 88)
                                .addComponent(txtDT))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHD)
                                    .addComponent(txtSP)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbbSortTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lbTo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLastDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65)
                        .addComponent(btnTK)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbSortSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbSortHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(434, 434, 434))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSortTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTo)
                    .addComponent(btnTK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHD))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbSortHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbSortSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbSortTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSortTKActionPerformed
        if (cbbSortTK.getSelectedItem().equals("Khoảng thời gian cụ thể")) {
            txtFirstDate.setVisible(true);
            lbTo.setVisible(true);
            txtLastDate.setVisible(true);
            btnTK.setVisible(true);
        } else {
            txtFirstDate.setText("");
            txtLastDate.setText("");
            txtFirstDate.setVisible(false);
            lbTo.setVisible(false);
            txtLastDate.setVisible(false);
            btnTK.setVisible(false);
        }
        if (cbbSortTK.getSelectedItem().equals("Mọi thời điểm")) {
            loadDT(tks.getThongKe(""));
        }
        if (cbbSortTK.getSelectedItem().equals("Trong ngày")) {
            loadDT(tks.getThongKe(" and hd.NgayTao = GETDATE()"));
        }
        if (cbbSortTK.getSelectedItem().equals("Trong tuần")) {
            loadDT(tks.getThongKe(" and DATEPART(WEEK, hd.NgayTao) = DATEPART(WEEK, GETDATE())"));
        }
        if (cbbSortTK.getSelectedItem().equals("Tuần vừa qua")) {
            loadDT(tks.getThongKe(" and (hd.NgayTao > DATEADD(DAY, -8, GETDATE()) and hd.NgayTao <= GETDATE())"));
        }
        if (cbbSortTK.getSelectedItem().equals("Trong tháng")) {
            loadDT(tks.getThongKe(" and MONTH(hd.NgayTao) = (MONTH(GETDATE()))"));
        }
        if (cbbSortTK.getSelectedItem().equals("Tháng vừa qua")) {
            loadDT(tks.getThongKe(" and (hd.NgayTao > DATEADD(DAY, -31, GETDATE()) and hd.NgayTao <= GETDATE())"));
        }
        if (cbbSortTK.getSelectedItem().equals("Cả năm")) {
            loadDT(tks.getThongKe(" and YEAR(hd.NgayTao) = (YEAR(GETDATE()))"));
        }
        if (cbbSortTK.getSelectedItem().equals("Khoảng thời gian cụ thể")) {
            txtFirstDate.setVisible(true);
            txtLastDate.setVisible(true);
        } else {
            txtFirstDate.setVisible(false);
            txtLastDate.setVisible(false);
            txtFirstDate.setText("");
            txtLastDate.setText("");
        }
    }//GEN-LAST:event_cbbSortTKActionPerformed

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        String first = "'" + txtFirstDate.getText() + "'";
        String last = "'" + txtLastDate.getText() + "'";
        loadDT(tks.getThongKe(" and (hd.NgayTao >= " + first + " and hd.NgayTao <= " + last));
    }//GEN-LAST:event_btnTKActionPerformed

    private void cbbSortSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSortSPActionPerformed
        if (cbbSortSP.getSelectedItem().equals("Doanh thu cao nhất")) {
            loadTBSP("order by [Tong doanh thu] desc");
        }
        if (cbbSortSP.getSelectedItem().equals("Doanh thu thấp nhất")) {
            loadTBSP("order by [Tong doanh thu] asc");
        }
        if (cbbSortSP.getSelectedItem().equals("Được mua nhiều nhất")) {
            loadTBSP("order by SUM(hdct.SoLuong) desc");
        }
        if (cbbSortSP.getSelectedItem().equals("Được mua ít nhất")) {
            loadTBSP("order by SUM(hdct.SoLuong) asc");
        }
        if (cbbSortSP.getSelectedItem().equals("Còn tồn nhiều nhất")) {
            loadTBSP("order by ctsp.SoLuong desc");
        }
        if (cbbSortSP.getSelectedItem().equals("Còn tồn ít nhất")) {
            loadTBSP("order by ctsp.SoLuong asc");
        }
    }//GEN-LAST:event_cbbSortSPActionPerformed

    private void cbbSortHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSortHDActionPerformed
        loadTBHD(cbbSortHD.getSelectedItem().toString());
    }//GEN-LAST:event_cbbSortHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTK;
    private javax.swing.JComboBox<String> cbbSortHD;
    private javax.swing.JComboBox<String> cbbSortSP;
    private javax.swing.JComboBox<String> cbbSortTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTo;
    private javax.swing.JTable tbHD;
    private javax.swing.JTable tbSP;
    private javax.swing.JLabel txtDT;
    private javax.swing.JTextField txtFirstDate;
    private javax.swing.JLabel txtHD;
    private javax.swing.JTextField txtLastDate;
    private javax.swing.JLabel txtSP;
    // End of variables declaration//GEN-END:variables
}

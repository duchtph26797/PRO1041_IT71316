/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModel.NhanVienModel;
import Service.Interface.NhanVienSer;
import Service.NhanVienImp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class FormQLNhanVien extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private NhanVienSer NVSer = new NhanVienImp();
    private List<NhanVienModel> ListNV = new ArrayList<>();

    /**
     * Creates new form FormQLNhanVien
     */
    public FormQLNhanVien() {
        initComponents();
        initComponents();
        TBbang.setModel(dtm);
        String[] headers = {"Mã NV", "Tên NV", "SĐT", "Use Name", "Ngày Sinh"};
        dtm.setColumnIdentifiers(headers);
        ListNV = NVSer.getAll();
        LoadData(ListNV);
    }

    private void LoadData(List<NhanVienModel> ListNVS) {
        dtm.setRowCount(0);
        for (NhanVienModel nv : ListNVS) {
            dtm.addRow(nv.toDataRow());
        }
    }

    private void showData(NhanVienModel Nv) {
        txtTenNV.setText(Nv.getTenNV());
        txtSDT.setText(Nv.getSdt());
        TxtUseName.setText(Nv.getUseName());
        txtNgaySinh.setText(Nv.getNgaySinh());
    }

    public void resetForm() {
        txtTenNV.setText("");
        txtSDT.setText("");
        txtNgaySinh.setText("");
        TxtUseName.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        BtHuy = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        BtSua = new javax.swing.JButton();
        TxtUseName = new javax.swing.JTextField();
        BtXoa = new javax.swing.JButton();
        BtLuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBbang = new javax.swing.JTable();
        BtSapXep = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconset4/Person-Male-Light-icon-24.png"))); // NOI18N
        jLabel1.setText("NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel2.setText("Thông tin nhân viên");

        jLabel4.setText("Tên NV :");

        txtTenNV.setBackground(new java.awt.Color(205, 218, 218));
        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        jLabel5.setText("SĐT :");

        jLabel6.setText("Ngày Sinh :");

        txtSDT.setBackground(new java.awt.Color(204, 224, 226));

        txtNgaySinh.setBackground(new java.awt.Color(198, 216, 224));

        BtHuy.setBackground(new java.awt.Color(204, 255, 255));
        BtHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconset4/Actions-edit-delete-icon-16.png"))); // NOI18N
        BtHuy.setText("Hủy");
        BtHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtHuyActionPerformed(evt);
            }
        });

        jLabel9.setText("Use Name :");

        BtSua.setBackground(new java.awt.Color(204, 255, 255));
        BtSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Task list.png"))); // NOI18N
        BtSua.setText("Sửa");
        BtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSuaActionPerformed(evt);
            }
        });

        TxtUseName.setBackground(new java.awt.Color(204, 204, 255));

        BtXoa.setBackground(new java.awt.Color(204, 255, 255));
        BtXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconset4/Button-Close-icon-16.png"))); // NOI18N
        BtXoa.setText("Xóa");
        BtXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtXoaActionPerformed(evt);
            }
        });

        BtLuu.setBackground(new java.awt.Color(204, 255, 255));
        BtLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Accept.png"))); // NOI18N
        BtLuu.setText("Lưu NV");
        BtLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLuuActionPerformed(evt);
            }
        });

        TBbang.setBackground(new java.awt.Color(245, 220, 183));
        TBbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "SĐT", "Use Name", "Ngày Sinh"
            }
        ));
        TBbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBbangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBbang);

        BtSapXep.setBackground(new java.awt.Color(204, 255, 255));
        BtSapXep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Refresh.png"))); // NOI18N
        BtSapXep.setText("Sắp Xếp");
        BtSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSapXepActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconset4/Login-icon-16.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("----------------Danh Sách Nhân Viên----------------");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconresources (1)/new-icon-16.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtUseName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSDT)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(BtHuy)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BtLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BtSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(101, 101, 101))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(BtSapXep)
                                        .addGap(160, 160, 160))))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtUseName)
                    .addComponent(BtHuy))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtSua))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(BtSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtHuyActionPerformed
        // TODO add your handling code here:
        resetForm();
        JOptionPane.showMessageDialog(this, "Hủy Thêm NV ❌");
    }//GEN-LAST:event_BtHuyActionPerformed

    private void BtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSuaActionPerformed
        // TODO add your handling code here:
        NhanVienModel NvU = ListNV.get(TBbang.getSelectedRow());
        String tenNV = txtTenNV.getText();
        String Sdt = txtSDT.getText();
        String use = TxtUseName.getText();
        String ngaySinh = txtNgaySinh.getText();
        NhanVienModel Nv = new NhanVienModel(tenNV, Sdt, use, ngaySinh);
        JOptionPane.showMessageDialog(this, NVSer.Update(Nv, NvU.getTenNV()));
        ListNV = NVSer.getAll();
        LoadData(ListNV);
    }//GEN-LAST:event_BtSuaActionPerformed

    private void BtXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtXoaActionPerformed
        String TenNV = txtTenNV.getText();
        JOptionPane.showMessageDialog(this, NVSer.delete(TenNV));
        ListNV = NVSer.getAll();
        LoadData(ListNV);
    }//GEN-LAST:event_BtXoaActionPerformed

    private void BtLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLuuActionPerformed
        // TODO add your handling code here:
        String tenNV = txtTenNV.getText();
        String SDT = txtSDT.getText();
        String Use = TxtUseName.getText();
        String NgaySinh = txtNgaySinh.getText();
        NhanVienModel Nv = new NhanVienModel(tenNV, SDT, Use, NgaySinh);
        JOptionPane.showMessageDialog(this, NVSer.add(Nv));
        ListNV = NVSer.getAll();
        LoadData(ListNV);
    }//GEN-LAST:event_BtLuuActionPerformed

    private void TBbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBbangMouseClicked
        // TODO add your handling code here:
        NhanVienModel Nv = ListNV.get(TBbang.getSelectedRow());
        showData(Nv);
    }//GEN-LAST:event_TBbangMouseClicked

    private void BtSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSapXepActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Sắp Xếp Theo Tên NV 🔁 !");
        //Sắp xếp theo Mã NV
        ListNV.sort((o1, o2) -> {
            return o1.getTenNV().compareTo(o2.getTenNV());
        });
        LoadData(ListNV);
    }//GEN-LAST:event_BtSapXepActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Exit... 🙋‍♂️");
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtHuy;
    private javax.swing.JButton BtLuu;
    private javax.swing.JButton BtSapXep;
    private javax.swing.JButton BtSua;
    private javax.swing.JButton BtXoa;
    private javax.swing.JTable TBbang;
    private javax.swing.JTextField TxtUseName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}

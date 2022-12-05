/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author TRUNG DUC
 */
public class SanPham {
    int maSp;
    String tenSp;
    LoaiHangDomainModel loaiHang;

    public SanPham() {
    }

    public SanPham(int maSp, String tenSp, LoaiHangDomainModel loaiHang) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.loaiHang = loaiHang;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public LoaiHangDomainModel getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(LoaiHangDomainModel loaiHang) {
        this.loaiHang = loaiHang;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSp=" + maSp + ", tenSp=" + tenSp + ", loaiHang=" + loaiHang + '}';
    }
    public Object[] showdata(){
        return new Object[]{maSp,tenSp,loaiHang.getMaLoai()};
    }
}

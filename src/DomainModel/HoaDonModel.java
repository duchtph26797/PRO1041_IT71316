/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;
import javax.xml.datatype.DatatypeFactory;

/**
 *
 * @author admin
 */
public class HoaDonModel {
    private int MaHD;
    private Date NgayTao;
    private int TrangThai;
    private NhanVienModel nv;
//    private ;
    private KhuyenMai km;
    


    public HoaDonModel() {
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "MaHD=" + MaHD + ", NgayTao=" + NgayTao + ", TrangThai=" + TrangThai + ", nv=" + nv + ", km=" + km + '}';
    }

    public HoaDonModel(int MaHD, Date NgayTao, int TrangThai, NhanVienModel nv, KhuyenMai km) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
        this.nv = nv;
        this.km = km;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public NhanVienModel getNv() {
        return nv;
    }

    public void setNv(NhanVienModel nv) {
        this.nv = nv;
    }

    public KhuyenMai getKm() {
        return km;
    }

    public void setKm(KhuyenMai km) {
        this.km = km;
    }
    
}

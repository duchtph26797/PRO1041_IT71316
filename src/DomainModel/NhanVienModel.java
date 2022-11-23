/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author admin
 */
public class NhanVienModel {
    private String MaNV;
    private String TenNV;
    private int Sdt;
    private String NgaySinh;
    private String MaLuong;
    private String MaTk;
    //Contructor

    public NhanVienModel() {
    }

    public NhanVienModel(String MaNV, String TenNV, int Sdt, String NgaySinh, String MaLuong, String MaTk) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.Sdt = Sdt;
        this.NgaySinh = NgaySinh;
        this.MaLuong = MaLuong;
        this.MaTk = MaTk;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int Sdt) {
        this.Sdt = Sdt;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getMaLuong() {
        return MaLuong;
    }

    public void setMaLuong(String MaLuong) {
        this.MaLuong = MaLuong;
    }

    public String getMaTk() {
        return MaTk;
    }

    public void setMaTk(String MaTk) {
        this.MaTk = MaTk;
    }
    
    
    public Object[] toDataRow()
    {return new Object[]{MaNV,TenNV,Sdt,NgaySinh,MaLuong, MaTk};}
    //To String

    @Override
    public String toString() {
        return "NhanVienModel{" + "MaNV=" + MaNV + ", TenNV=" + TenNV + ", Sdt=" + Sdt + ", NgaySinh=" + NgaySinh + ", MaLuong=" + MaLuong + ", MaTk=" + MaTk + '}';
    }  
}

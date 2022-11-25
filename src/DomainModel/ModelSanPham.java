/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;


public class ModelSanPham {
    private int chiTietSP;
    private int maSP;
    private int mauSP;
    private int MaLSP;
    private int MaCL;
    private int MaKC;
    private int soLuong;
    private String donGia;
    private String moTa;

    public ModelSanPham() {
    }

    public ModelSanPham(int chiTietSP, int maSP, int mauSP, int MaLSP, int MaCL, int MaKC, int soLuong, String donGia, String moTa) {
        this.chiTietSP = chiTietSP;
        this.maSP = maSP;
        this.mauSP = mauSP;
        this.MaLSP = MaLSP;
        this.MaCL = MaCL;
        this.MaKC = MaKC;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
    }

    public int getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(int chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getMauSP() {
        return mauSP;
    }

    public void setMauSP(int mauSP) {
        this.mauSP = mauSP;
    }

    public int getMaLSP() {
        return MaLSP;
    }

    public void setMaLSP(int MaLSP) {
        this.MaLSP = MaLSP;
    }

    public int getMaCL() {
        return MaCL;
    }

    public void setMaCL(int MaCL) {
        this.MaCL = MaCL;
    }

    public int getMaKC() {
        return MaKC;
    }

    public void setMaKC(int MaKC) {
        this.MaKC = MaKC;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "ModelSanPham{" + "chiTietSP=" + chiTietSP + ", maSP=" + maSP + ", mauSP=" + mauSP + ", MaLSP=" + MaLSP + ", MaCL=" + MaCL + ", MaKC=" + MaKC + ", soLuong=" + soLuong + ", donGia=" + donGia + ", moTa=" + moTa + '}';
    }


    public Object[] showdata(){
        return new Object[]{chiTietSP,maSP,mauSP,MaLSP,MaCL,MaKC,soLuong,donGia,moTa};
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;


public class ModelSanPham {
    private String chiTietSP;
    private String maSP;
    private String mauSP;
    private String loaiSP;
    private String chatLieu;
    private String size;
    private int soLuong;
    private int donGia;
    private String moTa;

    public ModelSanPham() {
    }

    public ModelSanPham(String chiTietSP, String maSP, String mauSP, String loaiSP, String chatLieu, String size, int soLuong, int donGia, String moTa) {
        this.chiTietSP = chiTietSP;
        this.maSP = maSP;
        this.mauSP = mauSP;
        this.loaiSP = loaiSP;
        this.chatLieu = chatLieu;
        this.size = size;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
    }

    public String getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(String chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMauSP() {
        return mauSP;
    }

    public void setMauSP(String mauSP) {
        this.mauSP = mauSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
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
        return "ModelSanPham{" + "chiTietSP=" + chiTietSP + ", maSP=" + maSP + ", mauSP=" + mauSP + ", loaiSP=" + loaiSP + ", chatLieu=" + chatLieu + ", size=" + size + ", soLuong=" + soLuong + ", donGia=" + donGia + ", moTa=" + moTa + '}';
    }

    public Object[] showdata(){
        return new Object[]{chiTietSP,maSP,mauSP,chatLieu,loaiSP,size,soLuong,donGia,moTa};
    }
}

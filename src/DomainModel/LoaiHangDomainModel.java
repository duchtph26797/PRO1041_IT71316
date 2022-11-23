/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author nhatc
 */
public class LoaiHangDomainModel {

    private String maLoai;
    private String tenLoai;

    public LoaiHangDomainModel() {
    }

    public LoaiHangDomainModel(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public Object[] toRowDataLoaiHang() {
        return new Object[]{maLoai, tenLoai};
    }

    @Override
    public String toString() {
        return "LoaiHangDomainModel{" + "maLoai=" + maLoai + ", tenLoai=" + tenLoai + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author DELL 5570
 */
public class KichCoDomainModel {
    private String maKC;
    private String tenKC;

    public KichCoDomainModel() {
    }

    public KichCoDomainModel(String maKC, String tenKC) {
        this.maKC = maKC;
        this.tenKC = tenKC;
    }

    public String getMaKC() {
        return maKC;
    }

    public void setMaKC(String maKC) {
        this.maKC = maKC;
    }

    public String getTenKC() {
        return tenKC;
    }

    public void setTenKC(String tenKC) {
        this.tenKC = tenKC;
    }

    @Override
    public String toString() {
        return "KichCoDomainModel{" + "maKC=" + maKC + ", tenKC=" + tenKC + '}';
    }
    public Object[] toRowDataKC(){
        return new Object[]{maKC, tenKC};
    }
    
}

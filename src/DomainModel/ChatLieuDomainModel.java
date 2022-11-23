/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author DELL 5570
 */
public class ChatLieuDomainModel {
    private String maCL;
    private String tenCL;

    public ChatLieuDomainModel() {
    }

    public ChatLieuDomainModel(String maCL, String tenCL) {
        this.maCL = maCL;
        this.tenCL = tenCL;
    }

    public String getMaCL() {
        return maCL;
    }

    public void setMaCL(String maCL) {
        this.maCL = maCL;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    @Override
    public String toString() {
        return "ChatLieuDomainModel{" + "maCL=" + maCL + ", tenCL=" + tenCL + '}';
    }
    public Object[] toRowDataCL(){
        return new Object[]{maCL, tenCL};
    }
    
}

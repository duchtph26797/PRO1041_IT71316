/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.KhachHangDomainModel;
import java.util.List;

/**
 *
 * @author nhatc
 */
public interface KhachHangService {
    
    List<KhachHangDomainModel> getAll();
    
    String add(String ten, String dc, String sdt, String ngay);
}

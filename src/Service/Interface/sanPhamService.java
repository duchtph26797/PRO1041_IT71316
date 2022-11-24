/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.ModelSanPham;
import java.util.List;


public interface sanPhamService {
    List<ModelSanPham> getAll();
     String add(ModelSanPham sanp);
    String update(ModelSanPham sanp, String MaSP);
    String delete(String MaSP);
}

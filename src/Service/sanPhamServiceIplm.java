/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.ModelSanPham;
import Repository.repositorySP;
import Service.Interface.sanPhamService;
import java.util.List;


public class sanPhamServiceIplm implements sanPhamService{
        private Repository.repositorySP rsp = new repositorySP();
    @Override
    public List<ModelSanPham> getAll() {
        return rsp.getAll();
    }

    @Override
    public String add(ModelSanPham sanp) {
       boolean add = rsp.Add(sanp);
       if(add){
           return "add thành công";
       }
       else{
           return "add thất bại";
       }
    }

    @Override
    public String update(ModelSanPham sanp, String MaSP) {
        boolean update = rsp.Update(sanp, MaSP);
       if(update){
           return "update thành công";
       }
       else{
           return "updata thất bại";
       }
    }

    @Override
    public String delete(String MaSP) {
        boolean delete = rsp.delete(MaSP);
       if(delete){
           return "xóa thành công";
       }
       else{
           return "xóa thất bại";
       }
    }
    
}

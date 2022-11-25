/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author DELL 5570
 */
import DomainModel.KichCoDomainModel;
import Repository.KichCoRepository;
import Repository.SanPhamRepository;
import Service.Interface.KichCoServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public class KichCoIplm implements KichCoServices{
    private KichCoRepository res = new KichCoRepository();
    @Override
    public List<KichCoDomainModel> getAll() {
        return res.getAll();
    }

    @Override
    public String add(KichCoDomainModel kc) {
        boolean add = res.Add(kc);
        if(add){
            return "Add thành công";
        }else{
            return "add thất bại";
        }
    }

    @Override
    public String update(KichCoDomainModel kc, String ma) {
        boolean update = res.update(kc, ma);
        if(update){
            return "update thành công";
        }else{
            return "update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = res.delete(ma);
        if(delete){
            return "delete thành công";
        }else{
            return "delete thất bại";
        }
    }

    @Override
    public ArrayList<String> getListTenKC() {
        return res.getListTenKC();
        
    }
    public static void main(String[] args) {
         KichCoServices kcsv = new KichCoIplm();
         System.out.println(kcsv.getListTenKC());
     }
}
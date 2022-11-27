/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.HDCTDomainModel;
import Repository.HDCTRepository;
import Service.Interface.HDCTService;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public class HDCTIplm implements HDCTService{
    HDCTRepository res ;

    public HDCTIplm() {
        res= new HDCTRepository();
    }

    @Override
    public List<HDCTDomainModel> getAll() {
        return res.getAll();
    }

    @Override
    public String Add(HDCTDomainModel hdct) {
        boolean add = res.Add(hdct);
        if(add){
            return "add thành công";
        }else{
            return "add thất bại";
        }
    }

    @Override
    public String update(HDCTDomainModel hdct, String maHd,String maCtsp) {
        boolean update = res.update(hdct, maHd,maCtsp);
        if(update){
            return "update thành công";
        }else{
            return "update thất bại";
        }
    }

    @Override
    public String delete(String maHD, String maCTSP) {
        boolean delete = res.delete(maHD, maCTSP);
        if(delete){
            return "delete thành công";
        }else{
            return "delete thất bại";
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.MauSacDomainModel;
import Repository.MauSacRepository;
import Service.Interface.MauSacServices;

import java.util.List;

/**
 *
 * @author DELL 5570
 */
public class MauSacIplm implements MauSacServices{
    private MauSacRepository res = new MauSacRepository();
    @Override
    public List<MauSacDomainModel> getAll() {
        return res.getAll();
    }

    @Override
    public String add(MauSacDomainModel ms) {
        boolean add = res.Add(ms);
        if(add){
            return "add thành công";
        }else{
            return "add thất bại";
        }
    }

    @Override
    public String update(MauSacDomainModel ms, String ma) {
        boolean update = res.Update(ms, ma);
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
    public List<MauSacDomainModel> timkiem(String ten) {
        return res.timKiem(ten);
    }

   
    
}

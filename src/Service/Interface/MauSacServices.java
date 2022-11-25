/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.MauSacDomainModel;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public interface MauSacServices {
    List<MauSacDomainModel> getAll();
    String add(MauSacDomainModel ms);
    String update(MauSacDomainModel ms, String ma);
    String delete(String ma);
    List<MauSacDomainModel> timkiem(String ten);
}

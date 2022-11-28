/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Service.Interface;

import DomainModel.HoaDonModel;
import java.util.List;

/**
 *
 * @author admin
 */
public interface HDSer {
        List<HoaDonModel> getAll();
        String suaHD(HoaDonModel Hd, String ma);
        String add(HoaDonModel Hd);
}

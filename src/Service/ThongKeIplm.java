/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.ThongKeRepository;
import Service.Interface.ThongKeService;
import ViewModel.DoanhThuView;
import java.util.List;

/**
 *
 * @author nhatc
 */
public class ThongKeIplm implements ThongKeService{
    private ThongKeRepository rp = new ThongKeRepository();

    @Override
    public DoanhThuView getThongKe(String conditions) {
        return rp.getThongKe(conditions);
    }
    
}

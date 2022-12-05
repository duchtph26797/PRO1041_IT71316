/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.SanPhamRepository;
import Service.Interface.ISanPhamService;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUC
 */
public class SanPhamImpl implements ISanPhamService {

    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public ArrayList<String> getListMaSp() {
        return sanPhamRepository.getListMaSp();
    }

    public static void main(String[] args) {
        ISanPhamService sv=new SanPhamImpl();
        System.out.println(sv.getListMaSp());
    }
}

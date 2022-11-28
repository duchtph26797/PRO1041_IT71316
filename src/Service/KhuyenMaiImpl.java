/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.KhuyenMai;
import Repository.KhuyenMaiRepository;
import Service.Interface.IKhuyenMaiService;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUC
 */
public class KhuyenMaiImpl implements IKhuyenMaiService {

    KhuyenMaiRepository khuyenMaiRepository;

    public KhuyenMaiImpl() {
        khuyenMaiRepository = new KhuyenMaiRepository();
    }

    @Override
    public ArrayList<KhuyenMai> getAll() {
        return khuyenMaiRepository.getAll();
    }

    @Override
    public Boolean them(KhuyenMai km) {
        return khuyenMaiRepository.them(km);
    }

    @Override
    public Boolean sua(KhuyenMai km, String ma) {
        return khuyenMaiRepository.sua(km, ma);
    }

    @Override
    public Boolean xoa(String ma) {
        return khuyenMaiRepository.xoa(ma);
    }

    @Override
    public ArrayList<String> getListMucKm() {
        return khuyenMaiRepository.getListMucKm();
    }

}

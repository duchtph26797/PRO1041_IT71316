/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Interface;

import DomainModel.NhanVienModel;
import Repository.NhanVienRepo;
import Service.NhanVienSer;
import java.util.List;

/**
 *
 * @author admin
 */
public class NhanVienImp implements NhanVienSer {

    private NhanVienRepo NvRepo = new NhanVienRepo();

    @Override
    public List<NhanVienModel> getAll() {
        return NvRepo.getAll();
    }

    @Override

    public String delete(String ma) {
        boolean delete = NvRepo.delete(ma);
        if (delete) {
            return "Delete thành công";
        } else {
            return"Delete Thất bại" ;
        }
    
}

    @Override
    public String add(NhanVienModel Nvv) {
        if (Nvv.getMaNV().isEmpty() || Nvv.getTenNV().isEmpty() || Nvv.getNgaySinh().isEmpty()) {
            return "Đang có trường để trống không thể thêm NV !";
        }
        boolean add = NvRepo.add(Nvv);
        if (add) {
            return "Thêm NV thành công !";
        }else{
        return "Thêm NV thất bại Hoặc NV đã tồn tại !";
        }
    }

    @Override
    public String Update(NhanVienModel Nv, String Ma) {
        boolean update = NvRepo.Update(Nv, Ma);
        if (update) {
            return "Update Nv ✔️";
        } else {
            return "Update NV False !";
        }
    }
    }

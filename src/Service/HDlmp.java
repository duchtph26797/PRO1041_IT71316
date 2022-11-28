/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.HoaDonModel;
import Repository.HDRepos;
import Service.Interface.HDSer;
import java.util.List;

/**
 *
 * @author admin
 */
public class HDlmp implements HDSer {

    private HDRepos HDr = new HDRepos();

    @Override
    public List<HoaDonModel> getAll() {
        return HDr.getAll();
    }

    @Override
    public String suaHD(HoaDonModel Hd, String ma) {
        boolean update = HDr.suaHD(Hd, ma);
        if (update) {
         return "Update Nv ✔️";
        } else {
            return "Update NV False !";
        }
    }

    @Override
    public String add(HoaDonModel Hd) {
        if (Hd.getNgayTao().isEmpty()) {
            return "Đang có trường để trống";
        }
        boolean add = HDr.add(Hd);
        if (add) {
            return "Thêm HD thành công !";
        } else {
            return "Thêm HD thất bại Hoặc mã HD đã tồn tại !";
        }
    }

}

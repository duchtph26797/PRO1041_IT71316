/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.LoaiHangDomainModel;
import Ulities.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nhatc
 */
public class LoaiHangRepository {

    final String select_all = "select * from LOAIHANG";

    public ArrayList<LoaiHangDomainModel> getAll() {
        ArrayList<LoaiHangDomainModel> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(select_all);
            while (rs.next()) {
                list.add(new LoaiHangDomainModel(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    final String add = "insert LOAIHANG values(?,?)";

    public Boolean add(LoaiHangDomainModel lh) {
        try {
            if (DBConnection.ExcuteQuery(
                    add,
                    lh.getMaLoai(),
                    lh.getTenLoai()) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String update = "update LOAIHANG set TenLoai=? where MaLoai=?";

    public Boolean update(LoaiHangDomainModel lh, String ma) {
        try {
            if (DBConnection.ExcuteQuery(
                    update,
                    lh.getTenLoai(),
                    ma) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String delete = "delete LOAIHANG where MaLoai=?";

    public Boolean delete(String ma) {
        try {
            if (DBConnection.ExcuteQuery(
                    delete,
                    ma) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        new LoaiHangRepository().getAll().forEach(s -> System.out.println(s.toString()));
    }
}

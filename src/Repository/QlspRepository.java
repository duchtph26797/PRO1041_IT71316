/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChatLieuDomainModel;
import DomainModel.Ctsp;
import DomainModel.KichCoDomainModel;
import DomainModel.LoaiHangDomainModel;
import DomainModel.MauSacDomainModel;
import DomainModel.SanPham;
import Ulities.DBConnection;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author TRUNG DUC
 */
public class QlspRepository {
    
    final String get_all = "select mactsp,chitietsp.masp,SANPHAM.TenSP,mausac.TenMS,CHATLIEU.TenCL,KICHCO.TenKC,LOAIHANG.TenLoai,soluong,dongia,mota from CHITIETSP \n"
            + "	join SANPHAM on SANPHAM.MAsp = CHITIETSP.MaSP\n"
            + "	join MAUSAC on MAUSAC.MaMS = CHITIETSP.MaMS\n"
            + "	join CHATLIEU on CHATLIEU.macl = CHITIETSP.Macl\n"
            + "	join KICHCO on KICHCO.MaKC = CHITIETSP.MaKC\n"
            + "	join LOAIHANG on LOAIHANG.MaLoai = CHITIETSP.MaLoai";
    
    public ArrayList<Ctsp> getAll() {
        ArrayList<Ctsp> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(get_all);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getInt(2));
                sp.setTenSp(rs.getString(3));
                MauSacDomainModel ms = new MauSacDomainModel(0, rs.getString(4));
                ChatLieuDomainModel cl = new ChatLieuDomainModel(0, rs.getString(5));
                KichCoDomainModel kc = new KichCoDomainModel(0, rs.getString(6));
                LoaiHangDomainModel lh = new LoaiHangDomainModel(0, rs.getString(7));
                list.add(new Ctsp(
                        rs.getInt(1),
                        sp,
                        ms,
                        lh,
                        cl,
                        kc,
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

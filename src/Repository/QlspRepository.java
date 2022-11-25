package Repository;

import DomainModel.ModelSanPham;
import Ulities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QlspRepository {

    public List<ModelSanPham> getAll() {
        String sql = "SELECT [MaCTSP]\n"
                + "      ,[MaSP]\n"
                + "      ,[MaMS]\n"
                + "      ,[MaLoai]\n"
                + "      ,[MaCL]\n"
                + "      ,[MaKC]\n"
                + "      ,[SoLuong]\n"
                + "      ,[DonGia]\n"
                + "      ,[MoTa]\n"
                + "  FROM [dbo].[CHITIETSP]";
        try ( Connection con = new DBConnection().openDbConnection();  PreparedStatement ps = con.prepareCall(sql)) {

            ResultSet rs = ps.executeQuery();
            List<ModelSanPham> list = new ArrayList<>();
            while (rs.next()) {
                ModelSanPham sp = new ModelSanPham(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }

    public boolean Add(ModelSanPham sanp) {
        int check = 0;
        String sqp = "INSERT INTO [dbo].[CHITIETSP]\n"
                + "           ([MaSP]\n"
                + "           ,[MaMS]\n"
                + "           ,[MaLoai]\n"
                + "           ,[MaCL]\n"
                + "           ,[MaKC]\n"
                + "           ,[SoLuong]\n"
                + "           ,[DonGia]\n"
                + "           ,[MoTa])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sqp)) {
            ps.setObject(1, sanp.getChiTietSP());
            ps.setObject(2, sanp.getMaSP());
            ps.setObject(3, sanp.getMauSP());
            ps.setObject(4, sanp.getMaLSP());
            ps.setObject(5, sanp.getMaCL());
            ps.setObject(6, sanp.getMaKC());
            ps.setObject(7, sanp.getSoLuong());
            ps.setObject(8, sanp.getDonGia());
            ps.setObject(9, sanp.getMoTa());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean Update(ModelSanPham sanp, String MaSP) {
        int check = 0;
        String query = "UPDATE [dbo].[CHITIETSP]\n"
                + "   SET [MaSP] = ?\n"
                + "      ,[MaMS] = ?\n"
                + "      ,[MaLoai] = ?\n"
                + "      ,[MaCL] = ?\n"
                + "      ,[MaKC] = ?\n"
                + "      ,[SoLuong] = ?\n"
                + "      ,[DonGia] = ?\n"
                + "      ,[MoTa] = ?\n"
                + " WHERE MaCTSP = ?\n";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sanp.getMaSP());
            ps.setObject(2, sanp.getMauSP());
            ps.setObject(3, sanp.getMaLSP());
            ps.setObject(4, sanp.getMaCL());
            ps.setObject(5, sanp.getMaKC());
            ps.setObject(6, sanp.getSoLuong());
            ps.setObject(7, sanp.getDonGia());
            ps.setObject(8, sanp.getMoTa());
            ps.setObject(9, sanp.getChiTietSP());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String MaCT) {
        int check = 0;
        String query = "DELETE FROM [dbo].[CHITIETSP]\n"
                + "      WHERE MaCTSP = ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, MaCT);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
         new QlspRepository().getAll().forEach(s -> System.out.println(s.toString()));
    }
}

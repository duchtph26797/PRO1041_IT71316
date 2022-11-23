/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChatLieuDomainModel;
import DomainModel.KichCoDomainModel;
import Ulities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public class ChatLieuRepository {

    public List<ChatLieuDomainModel> getAll() {
        List<ChatLieuDomainModel> listCL = new ArrayList<>();
        String query = "SELECT [MaCL]\n"
                + "      ,[TenCL]\n"
                + "  FROM [dbo].[CHATLIEU]";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCL.add(new ChatLieuDomainModel(rs.getString(1), rs.getString(2)));
            }
            return listCL;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(ChatLieuDomainModel cl) {
        int check = 0;
        String query = "INSERT INTO [dbo].[CHATLIEU]\n"
                + "           ([MaCL]\n"
                + "           ,[TenCL])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cl.getMaCL());
            ps.setObject(2, cl.getTenCL());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ChatLieuDomainModel cl, String ma) {
        int check = 0;
        String query = "UPDATE [dbo].[CHATLIEU]\n"
                + "   SET [TenCL] = ?\n"
                + " WHERE MaCL = ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cl.getTenCL());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = "DELETE FROM [dbo].[CHATLIEU]\n"
                + "      WHERE MaCL like ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}

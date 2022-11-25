/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.ChatLieuDomainModel;
import Repository.ChatLieuRepository;
import Service.Interface.ChatLieuServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public class ChatLieuIplm implements ChatLieuServices {

    private ChatLieuRepository res = new ChatLieuRepository();

    @Override
    public List<ChatLieuDomainModel> getAll() {
        return res.getAll();
    }

    @Override
    public String add(ChatLieuDomainModel cl) {
        boolean add = res.Add(cl);
        if (add) {
            return "Add thành công";
        } else {
            return "add thất bại";
        }
    }

    @Override
    public String update(ChatLieuDomainModel cl, String ma) {
        boolean update = res.update(cl, ma);
        if (update) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = res.delete(ma);
        if (delete) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

    @Override
    public ArrayList<String> getListTenCL() {
        return res.getListTenCL();
    }
     public static void main(String[] args){
        ChatLieuServices sv = new ChatLieuIplm();
        System.out.println(sv.getListTenCL());
     }
}

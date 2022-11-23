/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.ChatLieuDomainModel;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public interface ChatLieuServices {
    List<ChatLieuDomainModel> getAll();
    String add(ChatLieuDomainModel cl);
    String update(ChatLieuDomainModel cl, String ma);
    String delete(String ma);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.KichCoDomainModel;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public interface KichCoServices {
    List<KichCoDomainModel> getAll();
    String add(KichCoDomainModel kc);
    String update(KichCoDomainModel kc, String ma);
    String delete(String ma);
}

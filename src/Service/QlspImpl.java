/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.Ctsp;
import Repository.QlspRepository;
import Service.Interface.IQlspService;
import ViewModel.Qlsp;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUC
 */
public class QlspImpl implements IQlspService{

    QlspRepository qlspRepository;

    public QlspImpl() {
        qlspRepository=new QlspRepository();
    }
    
    
    
    @Override
    public ArrayList<Qlsp> getAll() {
        ArrayList<Qlsp> listView=new ArrayList<>();
        ArrayList<Ctsp> list=qlspRepository.getAll();
        for (Ctsp ctsp : list) {
            listView.add(new Qlsp(
                    ctsp.getMaCtsp(),
                    ctsp.getSp().getMaSp(),
                    ctsp.getSp().getTenSp(),
                    ctsp.getMs().getTenMau(),
                    ctsp.getCl().getTenCL(),
                    ctsp.getKc().getTenKC(),
                    ctsp.getLoai().getTenLoai(),
                    ctsp.getSoLuong(),
                    ctsp.getDonGia(),
                    ctsp.getMoTa()
            ));
        }
        return listView;
    }
    
}

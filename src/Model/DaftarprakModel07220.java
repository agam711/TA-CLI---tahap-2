/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
import Entity.PraktikumEntity07220;
import Entity.DaftarprakEntity07220;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * @author Agam
 */
public class DaftarprakModel07220 implements ModelInterfaces07220{
    private ArrayList<DaftarprakEntity07220> daftarprakArryList;
    
    public DaftarprakModel07220(){
        daftarprakArryList = new ArrayList<DaftarprakEntity07220>();
    }
    
    public void insertDataDaftarprak(DaftarprakEntity07220 daftarprak){
        daftarprakArryList.add(daftarprak);
    }
    
    public ArrayList<DaftarprakEntity07220> getDaftarprakArrayList(){
        return daftarprakArryList;
    }
    
    @Override
    public void view(){
        for(DaftarprakEntity07220 daftarprak : daftarprakArryList){
            System.out.print("==============================================");
            System.out.print("NPM : "+daftarprak.getPraktikan().getNpm()+
                    "\n Nama : "+daftarprak.getPraktikan().getNama()+
                    "\n Password : "+daftarprak.getPraktikan().getPassword()+
                    "\n No. Telp : "+daftarprak.getPraktikan().getNo_telp()+
                    "\n Tanggal Lahir : "+new SimpleDateFormat ("dd-MM-yyyy").format(daftarprak.getPraktikan().getTglLahir())+
                    "\n Praktikum : "+PraktikumEntity07220.nama[daftarprak.getIndexPrak()]+
                    "\n IsVerified : ");
                    if (daftarprak.isIsVerified()==false){
                        System.out.println("Belum Di Verifikasi Admin");
                    }
                    else {
                        System.out.println("Telas Di Verifikasi");
                    }
            System.out.print("==============================================");
        }
    }
    public int cekData(String npm, String password){
        int loop=0;
        if (daftarprakArryList.size() == 0){
            loop=-1;//data kosong
        }
        else {
            for (int i=0; i<daftarprakArryList.size();i++){
                if (daftarprakArryList.get(i).getPraktikan().getNpm().equals(npm)){
                    loop=i;
                    break;
                }
                else{
                    loop=-2;
                }
            }
        }return loop;
    }
    
    public DaftarprakEntity07220 showDaftarprak(int index){
        return daftarprakArryList.get(index);
    }
    
    public void updateIsVerified(int index, DaftarprakEntity07220 daftarprakEntity){
        daftarprakArryList.set(index, daftarprakEntity);
    }
}

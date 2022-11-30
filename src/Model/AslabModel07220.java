/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.AslabEntity07220;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class AslabModel07220 implements ModelInterfaces07220{
    private ArrayList<AslabEntity07220> aslabEntityArrayList;
    
    public AslabModel07220() {
        aslabEntityArrayList = new ArrayList<AslabEntity07220>();
    }
    
    public void insertAslab(AslabEntity07220 aslab) {
        aslabEntityArrayList.add(aslab);
    }

    @Override
    public void view() {
        for (AslabEntity07220 aslabEntity07220 : aslabEntityArrayList) {
            System.out.println(aslabEntity07220.getNpm());
            System.out.println(aslabEntity07220.getNama());
            System.out.println(aslabEntity07220.getPassword());
            System.out.println(aslabEntity07220.getNo_telp());
            System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(aslabEntity07220.getTglLahir()));
        }
    }

    @Override
    public int cekData(String npm, String password) {
        int loop = 0;
        for (AslabEntity07220 aslabEntity07220 : aslabEntityArrayList) {
            if (aslabEntity07220.getNpm().equals(npm) && aslabEntity07220.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    
    public AslabEntity07220 showDataAslab(int index) {
        return aslabEntityArrayList.get(index);
    }
}

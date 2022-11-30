/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Agam
 */
public class AslabEntity07220 extends MahasiswaAbstractEntity07220{
    private String laboratorium;

    public AslabEntity07220(String npm, String password, String nama, String no_telp, Date tglLahir, String lab) {
        super(npm, password, nama, no_telp, tglLahir);
        this.laboratorium = lab;
    }

   @Override
   public String getNpm(){
       return npm;
   }
    
   public String getLaboratorium(){
       return laboratorium;
   }

   public void setLaboratorium(String laboratorium) {
       this.laboratorium = laboratorium;
    }
   
   
}

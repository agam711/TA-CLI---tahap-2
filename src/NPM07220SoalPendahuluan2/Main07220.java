/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NPM07220SoalPendahuluan2;
import Entity.*;
import Model.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main07220 {
private static AslabModel07220 aslabmodel = new AslabModel07220();
private static Scanner input = new Scanner(System.in);
private static PraktikanModel07220 praktikanModel = new PraktikanModel07220();
private static DaftarprakModel07220 daftarprakModel = new DaftarprakModel07220();
private static int pilPrak;
static int cekpraktikan;
static int cekAslab;
    public static void main(String[] args) {
        int loop=0;
        dataAslab();
        
        do{
            int pilih = 0;
            System.out.println("Selamat Datang di Laboratorium ITATS"+
                    "\n 1. Login"+
                    "\n 2. Daftar Praktikan"+
                    "\n 0. Stop"+
                    "\n Masukkan Pilihan Anda : ");
            pilih = input.nextInt();
            if (pilih==1){
                int pilLogin=0;
                System.out.println("1. Login Aslab"+
                    "\n 2. Login Praktikan"+
                    "\n Masukkan Pilihan Anda : ");
                pilLogin = input.nextInt();
                if (pilLogin==1){
                    loginAdmin();
                }
                else{
                    login();
                }
            }
            else if (pilih == 2){
                register();
            }
            else if (pilih == 3){
                aslabmodel.view();
            }
            else if (pilih == 4){
            }
            else {
                break;
            }
        }while (loop!=1);
    }
    
    static void dataAslab(){
        String npmAslab [] = {"01","02","03","04","05","06","07"};
        String passwordAslab [] = {"01","02","03","04","05","06","07"};
        String namaAslab [] = {"Michael","Alan","Odil","Fitria","Sita","Eric","Fernanda"};
        String notelpAslab [] = {"01","02","03","04","05","06","07"};
        String tglLahirAslab [] = {"04/05/2000","01/12/2000","03/03/2000","23/06/2000","11/07/2000","13/09/2000","22/12/2000"};
        String laboratorium  [] = {"RPL","SO","BASPROG","BASPROG","SO","RPL","RPL"};
        
       for (int i = 0; i < npmAslab.length; i++) {
            aslabmodel.insertAslab(new AslabEntity07220(npmAslab[i],passwordAslab[i],namaAslab[i],notelpAslab[i], new Date(tglLahirAslab[i]), laboratorium[i]));
        }
    }

    static void register() {
        System.out.println("Input NPM : ");
        String npm = input.next();
        System.out.println("Input Nama : ");
        String nama = input.next();
        System.out.println("Input Password : ");
        String pass = input.next();
        System.out.println("Input No. Telp : ");
        String notelp = input.next();
        System.out.println("Input Tgl Lahir dd/mm/yyyy : ");
        Date tanggal = new Date(input.next());
        System.out.println("Kelas : ");
        String kelas = input.next();
        praktikanModel.insert(new PraktikanEntity07220(npm, pass, nama, notelp, tanggal, kelas));
    }

    static void login() {
        System.out.println("NPM : ");
        String npm = input.next();
        System.out.println("Password : ");
        String password = input.next();
        cekpraktikan = praktikanModel.cekData(npm, password);
        System.out.println("Selamat Datang " + praktikanModel.getPraktikanEntity07220ArrayList(cekpraktikan).getNama());
        int cekpraktikum = daftarprakModel.cekData(npm, password);
        if (cekpraktikum == -1) {
            System.out.println("Anda Belum daftar Praktikum");
            daftarprak();
        } else if (cekpraktikum == -2) {
            System.out.println("Anda Belum daftar Praktikum");
            daftarprak();
        } else {
            System.out.println("Nama : " + daftarprakModel.showDaftarprak(cekpraktikan).getPraktikan().getNama());
            System.out.println("NPM : " + daftarprakModel.showDaftarprak(cekpraktikan).getPraktikan().getNpm());
            System.out.println("No. Telp : " + daftarprakModel.showDaftarprak(cekpraktikan).getPraktikan().getNo_telp());
            System.out.println("Praktikum : " + PraktikumEntity07220.nama[daftarprakModel.showDaftarprak(cekpraktikum).getIndexPrak()]);
            System.out.println("isVerified : " + daftarprakModel.showDaftarprak(cekpraktikan).isIsVerified());
        }
    }

    static void daftarprak() {
        System.out.println("Praktikum : ");
        for (int i = 0; i < PraktikumEntity07220.nama.length; i++) {
            System.out.println(i + ". " + PraktikumEntity07220.nama[i]);
        }
        System.out.println("Pilih Praktikum : ");
        pilPrak = input.nextInt();
        daftarprakModel.insertDataDaftarprak(new DaftarprakEntity07220(praktikanModel.getPraktikanEntity07220ArrayList(cekpraktikan),false, pilPrak));
    }

    static void loginAdmin() {
        System.out.println("NPM : ");
        String npm = input.next();
        System.out.println("Passwrod : ");
        String password = input.next();
        cekAslab = aslabmodel.cekData(npm, password);
        System.out.println("Selamat Datang " + aslabmodel.showDataAslab(cekAslab).getNama());
        praktikanModel.view();
        updateIsVerified();
    }

    static void updateIsVerified() {
        System.out.println("NPM Praktikum : ");
        String npm = input.next();
        int index = daftarprakModel.cekData(npm, null);
        daftarprakModel.updateIsVerified(index, new DaftarprakEntity07220(praktikanModel.getPraktikanEntity07220ArrayList(index),
                true, pilPrak));
    }
}

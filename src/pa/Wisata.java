/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa;

/**
 *
 * @author Hp
 */

public abstract class Wisata {
    protected String Nama,Tempat;
    protected int harga;
    protected int id;
    protected double rating;
    protected final String Negara = "Indonesia";
    
    public Wisata(int id,String Nama, String Tempat, int harga, double rating) {
        this.id=id;
        this.Nama = Nama;
        this.Tempat = Tempat;
        this.harga = harga;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }    

    public String getNama() {
        return Nama;
    }

    public int getHarga() {
        return harga;
    }

    public double getRating() {
        return rating;
    }

    public String getTempat() {
        return Tempat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setTempat(String Tempat) {
        this.Tempat = Tempat;
    }
    
    public abstract void display();
    
    public final static void tambah(){
        System.out.println("Data Berhasil Ditambah");
    }
    
    public final static void hapus(){
        System.out.println("Data Berhasil Dihapus");
    }
    
    public final static void update(){
        System.out.println("Data Berhasil Diubah");
    }
}



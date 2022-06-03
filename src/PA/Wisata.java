package PA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public abstract class Wisata {
    protected String Nama,Tempat;
    protected int harga;
    protected double rating;
    protected final String Negara = "Indonesia";
    
    public Wisata(String Nama, String Tempat, int harga, double rating) {
        this.Nama = Nama;
        this.Tempat = Tempat;
        this.harga = harga;
        this.rating = rating;
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



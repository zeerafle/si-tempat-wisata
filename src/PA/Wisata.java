package PA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public abstract class Wisata {
    protected final String Negara = "Indonesia";
    protected String Nama, Tempat;
    protected int harga;
    protected double rating;
    protected String desk;

    public Wisata(String Nama, String Tempat, int harga, double rating, String desk) {
        this.Nama = Nama;
        this.Tempat = Tempat;
        this.harga = harga;
        this.rating = rating;
        this.desk = desk;
    }

    public static void tambah() {
        System.out.println("Data Berhasil Ditambah");
    }

    public static void hapus() {
        System.out.println("Data Berhasil Dihapus");
    }

    public static void update() {
        System.out.println("Data Berhasil Diubah");
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTempat() {
        return Tempat;
    }

    public void setTempat(String Tempat) {
        this.Tempat = Tempat;
    }

    public abstract void display();
}



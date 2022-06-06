package PA;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author raymo
 */
public final class Hutan extends Wisata {
    private String flora;

    public Hutan(String desk, String Nama, String Tempat, int harga, double rating, String flora) {
        super(Nama, Tempat, harga, rating, desk);
        this.flora = flora;
    }

    public String getFlora() {
        return flora;
    }

    public void setFlora(String flora) {
        this.flora = flora;
    }

    @Override
    public void display() {
        System.out.println("Nama : " + this.Nama);
        System.out.println("Tempat : " + this.Tempat);
        System.out.println("Harga : " + this.harga);
        System.out.println("Rating : " + this.rating);
        System.out.println("Deskripsi : " + this.desk);
        System.out.println("Flora : " + this.flora);
        System.out.println("Negara : " + Negara);
    }
}

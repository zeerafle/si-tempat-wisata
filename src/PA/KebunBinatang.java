package PA;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author raymo
 */
public final class KebunBinatang extends Wisata {

    private String fauna;

    public KebunBinatang(int id, String Nama, String Tempat, int harga, double rating, String desk, String fauna) {
        super(id, Nama, Tempat, harga, rating, desk);
        this.fauna = fauna;
    }

    public String getFauna() {
        return fauna;
    }

    public void setFauna(String fauna) {
        this.fauna = fauna;
    }

    @Override
    public void display() {
        System.out.println("Nama : " + this.Nama);
        System.out.println("Tempat : " + this.Tempat);
        System.out.println("Harga : " + this.harga);
        System.out.println("Rating : " + this.rating);
        System.out.println("Deskripsi : " + this.desk);
        System.out.println("Fauna : " + this.fauna);
        System.out.println("Negara : " + Negara);
    }
}

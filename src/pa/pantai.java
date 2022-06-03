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
public final class pantai extends Wisata{
    private String wahana;

    public pantai(int id,String wahana, String Nama, String Tempat, int harga, double rating) {
        super(id,Nama, Tempat, harga, rating);
        this.wahana = wahana;
    }
  
    public String getWahana() {
        return wahana;
    }

    public void setWahana(String wahana) {
        this.wahana = wahana;
    }
    
    @Override
    public void display(){
        System.out.println("Nama : " + this.Nama);
        System.out.println("Tempat : " + this.Tempat);
        System.out.println("Harga : " + this.harga);
        System.out.println("Rating : " + this.rating);
        System.out.println("Wahana : " + this.wahana);
        System.out.println("Negara : " + Negara);
    }
}

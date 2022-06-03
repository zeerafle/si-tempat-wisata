package PA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public final class Pantai extends Wisata{
    private String desk;

    public Pantai(String desk, String Nama, String Tempat, int harga, double rating) {
        super(Nama, Tempat, harga, rating);
        this.desk = desk;
    }
  
    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }
    
    @Override
    public void display(){
        System.out.println("Nama : " + this.Nama);
        System.out.println("Tempat : " + this.Tempat);
        System.out.println("Harga : " + this.harga);
        System.out.println("Rating : " + this.rating);
        System.out.println("Deskripsi : " + this.desk);
        System.out.println("Negara : " + Negara);
    }
}

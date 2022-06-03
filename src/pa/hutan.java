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
public final class hutan extends Wisata{
    private String flora,fauna;
    

    public hutan(int id,String flora, String fauna, String Nama, String Tempat, int harga, double rating) {
        super(id,Nama, Tempat, harga, rating);
        this.flora = flora;
        this.fauna = fauna;
    }

    public String getFlora() {
        return flora;
    }

    public String getFauna() {
        return fauna;
    }

    public void setFlora(String flora) {
        this.flora = flora;
    }

    public void setFauna(String fauna) {
        this.fauna = fauna;
    }
    
    
    @Override
    public void display(){
        System.out.println("Id : " + this.id);
        System.out.println("Nama : " + this.Nama);
        System.out.println("Tempat : " + this.Tempat);
        System.out.println("Harga : " + this.harga);
        System.out.println("Rating : " + this.rating);
        System.out.println("Flora : " + this.flora);
        System.out.println("Fauna : " + this.fauna);
        System.out.println("Negara : " + Negara);
    }
}


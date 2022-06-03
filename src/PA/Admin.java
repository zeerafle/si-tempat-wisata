package PA;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static PA.Main.Menu;



public class Admin implements Login{
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public void masuk()throws IOException{
        InputStreamReader prepare = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(prepare);
        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| |    :     PUSAT INFORMASI    | |");
            System.out.println("| | No :      WISATA KALTIM     | |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("| | USERNAME : ");
            String username = input.readLine();
            System.out.print("| | PASSWORD : ");
            String password = input.readLine();
            if (username.equals(this.getUsername()) && password.equals(this.getPassword())){
                Menu();
            } else{
                System.out.println("USERNAME / PASSWORD ANDA SALAH");
            }
            
        }
    }

    @Override
    public void keluar() {
        System.out.println("TERIMA KASIH TELAH MEMAKAI SISTEM INI");
        System.exit(0);
    }
    
    
    
}

package PA;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;

public class User {
    private Login login;
    
    public User(Login login){
     this.login = login;
    }
    
    void log_in() throws IOException{
        this.login.masuk();
    }
    
    void log_out() throws IOException{
        this.login.keluar();
    }
}

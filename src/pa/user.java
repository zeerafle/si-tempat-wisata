package pa;

public class user {
    int Id;
    String Nama,Username,password;

 
 
    public user(int Id, String Username, String password, String Nama){
        this.Id = Id;
        this.Username = Username;
        this.password = password;
        this.Nama = Nama;

    }
    public int getId() {
        return Id;
    }
    public String getNama() {
        return Nama;
    }
    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return password;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public void setNama(String Nama) {
        this.Nama = Nama;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

 
 }
   
 
    
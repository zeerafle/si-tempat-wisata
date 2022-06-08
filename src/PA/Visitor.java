package PA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Visitor implements Login {
    private int ID;
    private String username;
    private String password;
    private String nama;

    public Visitor(int ID, String username, String password, String nama) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.nama = nama;
    }

    public static void menu() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Database database = new Database();

        while (true) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|------------   LIHAT DATA TEMPAT WISATA   -------------|");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("                1. Lihat Data Seluruh Tempat Wisata     |");
            System.out.println("                2. Lihat Tempat Wisata Per Kategori     |");
            System.out.println("                3. Keluar                               |");
            System.out.println("--------------------------------------------------------|");
            System.out.println("Pilih :");
            int pi = Integer.parseInt(input.readLine());
            if (pi == 1) {
                System.out.println("========================================================================================================================================");
                System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                System.out.println("========================================================================================================================================");
                database.dataWisata();
            } else if (pi == 2) {
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|-----------   LIHAT DATA TEMPAT WISATA    --------------|");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("                1. Lihat Data Pantai                     |");
                System.out.println("                2. Lihat Data Kebun Binatang             |");
                System.out.println("                3. Lihat Data Hutan                      |");
                System.out.println("---------------------------------------------------------|");
                System.out.println("Pilih :");
                int pil = Integer.parseInt(input.readLine());

                if (pil == 1) {
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH PANTAI                                                                |");
                    System.out.println("========================================================================================================================================");
                    database.readPantai();
                } else if (pil == 2) {
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH KEBUN BINATANG                                                        |");
                    System.out.println("========================================================================================================================================");
                    database.readKebun();
                } else if (pil == 3) {
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH HUTAN                                                                 |");
                    System.out.println("========================================================================================================================================");
                    database.readHutan();
                }

            } else if (pi == 3) {
                return;
            }
        }

        // beri rating
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public void masuk() {
        System.out.println("Anjay Masuk");
    }

    public void keluar() {
        System.out.println("Anjay Keluar");
    }
}

package PA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Visitor implements Login {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static Database database = new Database();
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

    public static void menuLihat() throws IOException {
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|-----------   BERI RATING TEMPAT WISATA    -------------|");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("                1. Beri Rating Wisata                    |");
        System.out.println("                0. Kembali                               |");
        System.out.println("+--------------------------------------------------------+");
        System.out.print("Masukkan pilihan : ");
        String pilihan = input.readLine();
        switch (pilihan) {
            case "1":
                beriRating();
                break;
            case "0":
                break;
        }
    }

    public static void beriRating() {
        boolean inputSalah = true;
        System.out.println("========================================================================================================================================");
        System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
        System.out.println("========================================================================================================================================");
        database.dataWisata();
        System.out.print("Masukkan id : ");
        int id = 0;
        while (inputSalah) {
            try {
                id = Integer.parseInt(input.readLine());
                inputSalah = false;
            } catch (Exception e) {
                System.out.println("Id salah");
            }
        }
        System.out.println();
        double rating = Main.cekInputRentang("Nilai tempat wisata rentang 1.0 - 5.0 : ", input);
        double ratingSaatIni = database.getWisataRatingById(id);
        double ratingBaru = (ratingSaatIni + rating) / 2;
        database.setWisataRatingById(id, ratingBaru);
    }

    public static int cekInputAngka(String perintah, BufferedReader input, String pesan) {
        int penampung;

        while (true) {
            try {
                System.out.print(perintah);
                penampung = Integer.parseInt(input.readLine());
                return penampung;
            } catch (Exception e) {
                // System.out.println(pesan);
            }
        }
    }

    public void menu() throws IOException {
        while (true) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|------------   LIHAT DATA TEMPAT WISATA   -------------|");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("                1. Lihat Data Seluruh Tempat Wisata     |");
            System.out.println("                2. Lihat Tempat Wisata Per Kategori     |");
            System.out.println("                3. beri rating                          |");
            System.out.println("                4. Wisata Favorite                      |");
            System.out.println("                5. Keluar                               |");
            System.out.println("--------------------------------------------------------|");
            System.out.print("Pilih :");
            String pi = input.readLine();
            switch (pi) {
                case "1" -> {
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.dataWisata();
                }
                case "2" -> {
                    System.out.println("+--------------------------------------------------------+");
                    System.out.println("|-----------   LIHAT DATA TEMPAT WISATA    --------------|");
                    System.out.println("+--------------------------------------------------------+");
                    System.out.println("                1. Lihat Data Pantai                     |");
                    System.out.println("                2. Lihat Data Kebun Binatang             |");
                    System.out.println("                3. Lihat Data Hutan                      |");
                    System.out.println("                4. Kembali                               |");
                    System.out.println("---------------------------------------------------------|");
                    System.out.print("Pilih :");
                    String pil = input.readLine();
                    switch (pil) {
                        case "1" -> {
                            System.out.println("========================================================================================================================================");
                            System.out.println("|                                                    LIST SELURUH PANTAI                                                                |");
                            System.out.println("========================================================================================================================================");
                            database.readPantai();
                        }
                        case "2" -> {
                            System.out.println("========================================================================================================================================");
                            System.out.println("|                                                    LIST SELURUH KEBUN BINATANG                                                        |");
                            System.out.println("========================================================================================================================================");
                            database.readKebun();
                        }
                        case "3" -> {
                            System.out.println("========================================================================================================================================");
                            System.out.println("|                                                    LIST SELURUH HUTAN                                                                 |");
                            System.out.println("========================================================================================================================================");
                            database.readHutan();
                        }
                        case "4" -> {
                            menu();
                            System.out.println("Menu Visitor!!");
                        }
                    }
                }
                case "3" -> menuLihat();
                case "4" -> MenuFavorite();
            }

        }
    }

    public void MenuFavorite() throws IOException {
        System.out.println("+--------------------------------------------+");
        System.out.println("|-----------   Menu Favorite    -------------|");
        System.out.println("+--------------------------------------------+");
        System.out.println("                1. Tambah                    |");
        System.out.println("                2. Lihat                     |");
        System.out.println("                3. hapus                     |");
        System.out.println("                0. Kembali                   |");
        System.out.println("+--------------------------------------------+");
        System.out.print("Masukkan pilihan : ");
        String pilihan = input.readLine();
        switch (pilihan) {
            case "1":
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("|-------------     TAMBAH WISATA FAVORITE        -----------|");
                System.out.println("+-----------------------------------------------------------+");
                System.out.print("Masukkan id User         : ");
                int id_user = Integer.parseInt(input.readLine());
                System.out.println("========================================================================================================================================");
                System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                System.out.println("========================================================================================================================================");
                database.dataWisata();
                System.out.print("Masukkan id Wisata         : ");
                int id_wisata = Integer.parseInt(input.readLine());
                database.CreateFavorite(id_user, id_wisata);

                break;
            case "2":
                database.readUserFavorite(this.ID);


                break;
            case "3":
                System.out.println("\n");
                System.out.println("+----------------------------------------------+");
                System.out.println("|-----------     HAPUS DATA FAVORITE    --------|");
                System.out.println("+-----------------------------------------------+");
                int id_Hapus = cekInputAngka("Masukkan ID yang Ingin Di Hapus  : ", input, "ID Harus Angka");
                database.deleteFavorite(id_Hapus);
                break;
            case "0":
                break;
        }
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

package PA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Visitor implements User {
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
        int id = 0;
        while (inputSalah) {
            try {
                System.out.print("Masukkan id : ");
                id = Integer.parseInt(input.readLine());

                // cek id ada apa nggak
                if (database.isWisataTidakAdaById(id)) {
                    System.out.println("Data wisata tidak ada");
                    continue;
                }

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

    @Override
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
            if (pi.equals("1")) {
                System.out.println("========================================================================================================================================");
                System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                System.out.println("========================================================================================================================================");
                database.dataWisata();
            } else if (pi.equals("2")) {
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

                if (pil.equals("1")) {
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH PANTAI                                                                |");
                    System.out.println("========================================================================================================================================");
                    database.readPantai();
                } else if (pil.equals("2")) {
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH KEBUN BINATANG                                                        |");
                    System.out.println("========================================================================================================================================");
                    database.readKebun();
                } else if (pil.equals("3")) {
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH HUTAN                                                                 |");
                    System.out.println("========================================================================================================================================");
                    database.readHutan();
                } else if (pil.equals("4")) {
                    menu();
                    System.out.println("Menu Visitor!!");
                }

            } else if (pi.equals("3")) {
                menuLihat();
            } else if (pi.equals("4")) {
                MenuFavorite();
            } else if (pi.equals("5")) {
                return;
            } else {
                System.out.println();
                System.out.println("Menu Tidak Ada");
                System.out.println();
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
                database.deleteFavorite(this.ID);
                System.out.println("Favorit dihapus");
                break;
            case "0":
                break;
            default:
                System.out.println("Menu Tidak Ada");
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
}

package PA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Visitor implements User {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static Database database = new Database();
    private final int ID;
    private String username;
    private String password;
    private String nama;

    public Visitor(int ID, String username, String password, String nama) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.nama = nama;
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
                System.out.println();
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
                    break;
                }
                System.out.println();

            } else if (pi.equals("3")) {
                System.out.print("Masukkan id : ");
                int id = Integer.parseInt(input.readLine());
                if (database.isWisataAdaById(id)) {
                    double rating = Main.cekInputRentang("Nilai tempat wisata rentang 1.0 - 5.0 : ", input);
                    double ratingSaatIni = database.getWisataRatingById(id);
                    double ratingBaru = (ratingSaatIni + rating) / 2;
                    database.setWisataRatingById(id, ratingBaru);
                }
            } else if (pi.equals("4")) {
                menuFavorite();
            } else if (pi.equals("5")) {
                return;
            } else {
                System.out.println();
                System.out.println("Menu Tidak Ada");
                System.out.println();
            }
        }
    }

    public void menuFavorite() throws IOException {
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
                System.out.println("========================================================================================================================================");
                System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                System.out.println("========================================================================================================================================");
                database.dataWisata();
                int idWisata = Main.cekInputAngka("Pilih id Wisata yang di favoritkan : ", input);
                if (database.isWisataAdaById(idWisata)) {
                    if (!database.isWisataSudahAdaDiFavoritUser(this.ID, idWisata)) {
                        database.addFavorite(this.ID, idWisata);
                        System.out.println();
                        System.out.println("Berhasil di Tambahkan !");
                    } else {
                        System.out.println("Wisata sudah dalam favorit");
                    }
                } else {
                    System.out.println("Id tidak ada");
                }

                break;
            case "2":
                database.readUserFavorite(this.ID);
                break;
            case "3":
                database.readUserFavorite(this.ID);
                int idWisataHapus = Main.cekInputAngka("Pilih id Wisata yang ingin dihapus : ", input);
                if (database.isWisataAdaById(idWisataHapus)) {
                    database.deleteFavorite(this.ID, idWisataHapus);
                    System.out.println("Favorit dihapus");
                } else {
                    System.out.println("Id tidak ada dalam favorit");
                }
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

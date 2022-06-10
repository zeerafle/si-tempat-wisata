package PA;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader prepare = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(prepare);
        Login admin = new Admin("Kitsu", "Anjay123");
        Database database = new Database();
        ArrayList<Visitor> dataVisitor = database.getDataAkun();

        while (true) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| |    :     PUSAT INFORMASI    | |");
            System.out.println("| | No :      WISATA KALTIM     | |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| | 1. : Admin                  | |");
            System.out.println("| | 2. : Visitor                | |");
            System.out.println("| | 3. : Keluar Program         | |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("| | Masuk Sebagai : ");
            String login = input.readLine();
            switch (login) {
                case "1":
                    admin.masuk();
                case "2":
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("| | 1. : Login                  | |");
                    System.out.println("| | 2. : Register               | |");
                    System.out.println("| | 0. : Kembali                | |");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.print("| | Masukkan pilihan : ");
                    String userSignMenu = input.readLine();
                    switch (userSignMenu) {
                        case "1":
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.print("| | USERNAME : ");
                            String username = input.readLine();
                            System.out.print("| | PASSWORD : ");
                            String password = input.readLine();
                            for (Visitor visitor : dataVisitor) {
                                if (visitor.getUsername().equals(username) && visitor.getPassword().equals(password)) {
                                    visitor.menu();
                                }
                            }
                            System.out.println("Username atau password salah");
                            break;
                        case "2":
                            System.out.println("+-----------------------------------------------------------+");
                            System.out.println("|-------------     REGISTRASI USER         -----------------|");
                            System.out.println("+-----------------------------------------------------------+");
                            System.out.print("Masukkan Nama            : ");
                            String nama = input.readLine();
                            System.out.print("Masukkan Username        : ");
                            String username1 = input.readLine();
                            System.out.print("Masukkan Password        : ");
                            String password1 = input.readLine();

                            database.createDataakun(nama, username1, password1);
                            dataVisitor = database.getDataAkun();
                            break;
                    }
                    break;
                case "3":
                    System.out.println("Menutup program");
                    System.exit(0);
            }
        }
    }

    public static void Menu() throws IOException {
        InputStreamReader prepare = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(prepare);
        Database database = new Database();
        ArrayList<Wisata> wisata = database.getDataWisata();

        while (true) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| |    :     PUSAT INFORMASI    | |");
            System.out.println("| | No :      WISATA KALTIM     | |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| | 1. : Tambah Tempat Wisata   | |");
            System.out.println("| | 2. : Lihat Tempat Wisata    | |");
            System.out.println("| | 3. : Ubah Tempat Wisata     | |");
            System.out.println("| | 4. : Hapus Tempat Wisata    | |");
            System.out.println("| | 5. : Keluar Program         | |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print(" || Pilih Menu : ");
            String menu = input.readLine();
            switch (menu) {
                case "1":
                    System.out.println();

                    System.out.println("+-------------------------------------------------------+");
                    System.out.println("|-----------   TAMBAH DATA TEMPAT WISATA   -------------|");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println("                1. Tambah Data Hutan                    |");
                    System.out.println("                2. Tambah Data Taman                    |");
                    System.out.println("                3. Tambah Data Pantai                   |");
                    System.out.println("--------------------------------------------------------|");
                    System.out.print("Pilih Menu : ");
                    String pilih = input.readLine();
                    switch (pilih) {
                        case "1" -> {
                            System.out.println("+-----------------------------------------------------------+");
                            System.out.println("|-------------     TAMBAH DATA PANTAI      -----------------|");
                            System.out.println("+-----------------------------------------------------------+");
                            String jenisWisata = "pantai";
                            System.out.print("Masukkan Nama Pantai           : ");
                            String nama = input.readLine();
                            System.out.print("Masukkan Lokasi Pantai         : ");
                            String tempat = input.readLine();
                            int harga = cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                            double rating = 0;
                            System.out.print("Masukkan Deskripsi Pantai      : ");
                            String deskripsi = input.readLine();
                            System.out.print("Masukkan Wahana Pantai         : ");
                            String spesial = input.readLine();
                            database.createWisata(jenisWisata, nama, tempat, harga, rating, deskripsi, spesial);

                            break;
                        }
                        case "2" -> {
                            System.out.println("+------------------------------------------------------------------+");
                            System.out.println("|---------------    TAMBAH DATA KEBUN BINATANG      ---------------|");
                            System.out.println("+------------------------------------------------------------------+");
                            String jenisWisata = "kebun_binatang";
                            System.out.print("Masukkan Nama Kebun Binatang   : ");
                            String nama = input.readLine();
                            System.out.print("Masukkan Lokasi                : ");
                            String tempat = input.readLine();
                            int harga = cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                            double rating = 0;
                            System.out.print("Masukkan Deskripsi Tempat      : ");
                            String deskripsi = input.readLine();
                            System.out.print("Masukkan Fauna Kebun Binatang  : ");
                            String spesial = input.readLine();

                            database.createWisata(jenisWisata, nama, tempat, harga, rating, deskripsi, spesial);
                            break;
                        }
                        case "3" -> {
                            System.out.println("+-----------------------------------------------------------+");
                            System.out.println("|-------------     TAMBAH DATA HUTAN      ------------------|");
                            System.out.println("+-----------------------------------------------------------+");

                            String jenisWisata = "hutan";
                            System.out.print("Masukkan Nama Hutan            : ");
                            String nama = input.readLine();
                            System.out.print("Masukkan Lokasi Hutan          : ");
                            String tempat = input.readLine();
                            int harga = cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                            double rating = 0;
                            System.out.print("Masukkan Deskripsi Hutan       : ");
                            String deskripsi = input.readLine();
                            System.out.print("Masukkan Fauna                 : ");
                            String spesial = input.readLine();
                            database.createWisata(jenisWisata, nama, tempat, harga, rating, deskripsi, spesial);
                            break;
                        }
                        default -> System.out.println("Menu Tidak Ada");
                    }
                    break;

                case "2":
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|-----------           LIHAT DATA          --------------|");
                    System.out.println("+--------------------------------------------------------+");
                    System.out.println("                1. Lihat Data User                       |");
                    System.out.println("                2. Lihat Data Wisata                     |");
                    System.out.println("                3. Kembali                               |");
                    System.out.println("---------------------------------------------------------|");
                    System.out.print("Pilih :");
                    String pil = input.readLine();

                    if (pil.equals("1")) {
                        System.out.println("========================================================================================================================================");
                        System.out.println("|                                                    LIST SELURUH USER                                                                |");
                        System.out.println("========================================================================================================================================");
                        database.DataUser();
                    } else if (pil.equals("2")) {
                        System.out.println("========================================================================================================================================");
                        System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                        System.out.println("========================================================================================================================================");
                        database.dataWisata();
                    }
                    break;
                // Menu ubah
                case "3":
                    // TODO dapatkan jenis wisata apa yang mau diubah
                    // ganti "masukkan nama ..." sesuai jenis wisata
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.dataWisata();
                    int id = cekInputAngka("Masukan Id yang ingin di ubah  : ", input, "Harga harus angka");
                    System.out.print("Masukkan Nama Hutan            : ");
                    String nama = input.readLine();
                    System.out.print("Masukkan Lokasi Hutan          : ");
                    String tempat = input.readLine();
                    int harga = cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                    double rating = cekInputRentang("Masukkan Rating : ", input);
                    System.out.print("Masukkan Deskripsi Hutan       : ");
                    String deskripsi = input.readLine();
                    System.out.print("Masukkan Fauna                 : ");
                    String spesial = input.readLine();
                    database.updateWisata(id, nama, tempat, harga, rating, deskripsi, spesial);
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.dataWisata();

                    break;

                case "4":
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.dataWisata();
                    System.out.println("\n");
                    System.out.println("+---------------------------------------+");
                    System.out.println("|-----------     HAPUS DATA     --------|");
                    System.out.println("+---------------------------------------+");
                    int idHapus = cekInputAngka("Masukkan ID yang Ingin Di Hapus  : ", input, "ID Harus Angka");
                    database.deleteKelas(idHapus);
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.dataWisata();
                    break;

                case "5":
                    System.exit(0);
            }
        }
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

    public static double cekInputRentang(String perintah, BufferedReader input) {
        double penampung;

        while (true) {
            try {
                System.out.print(perintah);
                penampung = Double.parseDouble(input.readLine());

                if (penampung <= 5.0 && penampung >= 1.0) {
                    return penampung;
                } else {
                    System.out.println("Rating berkisar 1 sampai 5");
                }
            } catch (Exception e) {
                // System.out.println();
            }
        }
    }
}

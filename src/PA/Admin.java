package PA;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin implements User {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
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

    public void masuk() throws IOException {
        InputStreamReader prepare = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(prepare);
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| |    :     PUSAT INFORMASI    | |");
            System.out.println("| | No :      WISATA KALTIM     | |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("| | USERNAME : ");
            String username = input.readLine();
            System.out.print("| | PASSWORD : ");
            String password = input.readLine();
            if (username.equals(this.getUsername()) && password.equals(this.getPassword())) {
                menu();
                break;
            } else {
                System.out.println("USERNAME / PASSWORD ANDA SALAH");
            }

        }
    }

    public void menu() throws IOException {
        InputStreamReader prepare = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(prepare);
        Database database = new Database();

        while (true) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| |    :     PUSAT INFORMASI    | |");
            System.out.println("| | No :      WISATA KALTIM     | |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| | 1. : Tambah Tempat Wisata   | |");
            System.out.println("| | 2. : Lihat Data             | |");
            System.out.println("| | 3. : Ubah Tempat Wisata     | |");
            System.out.println("| | 4. : Hapus Tempat Wisata    | |");
            System.out.println("| | 5. : Kembali Program         | |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print(" || Pilih Menu : ");
            String menu = input.readLine();
            switch (menu) {
                case "1":
                    while (true) {
                        System.out.println();

                        System.out.println("+-------------------------------------------------------+");
                        System.out.println("|-----------   TAMBAH DATA TEMPAT WISATA   -------------|");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println("                1. Tambah Data Pantai                   |");
                        System.out.println("                2. Tambah Data Kebun Binatang           |");
                        System.out.println("                3. Tambah Data Hutan                    |");
                        System.out.println("                4. Kembali Ke Menu                      |");
                        System.out.println("--------------------------------------------------------|");
                        System.out.print("Pilih Menu : ");
                        String pilih = input.readLine();
                        if (pilih.equals("1")) {
                            System.out.println("+-----------------------------------------------------------+");
                            System.out.println("|-------------     TAMBAH DATA PANTAI      -----------------|");
                            System.out.println("+-----------------------------------------------------------+");
                            String jenisWisata = "pantai";
                            System.out.print("Masukkan Nama Pantai           : ");
                            String nama = input.readLine();
                            System.out.print("Masukkan Lokasi Pantai         : ");
                            String tempat = input.readLine();
                            int harga = Main.cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                            double rating = 0;
                            System.out.print("Masukkan Deskripsi Pantai      : ");
                            String deskripsi = input.readLine();
                            System.out.print("Masukkan Wahana Pantai         : ");
                            String spesial = input.readLine();
                            database.createWisata(jenisWisata, nama, tempat, harga, rating, deskripsi, spesial);

                        } else if (pilih.equals("2")) {
                            System.out.println("+------------------------------------------------------------------+");
                            System.out.println("|---------------    TAMBAH DATA KEBUN BINATANG      ---------------|");
                            System.out.println("+------------------------------------------------------------------+");
                            String jenisWisata = "kebun_binatang";
                            System.out.print("Masukkan Nama Kebun Binatang   : ");
                            String nama = input.readLine();
                            System.out.print("Masukkan Lokasi                : ");
                            String tempat = input.readLine();
                            int harga = Main.cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                            double rating = 0;
                            System.out.print("Masukkan Deskripsi Tempat      : ");
                            String deskripsi = input.readLine();
                            System.out.print("Masukkan Fauna Kebun Binatang  : ");
                            String spesial = input.readLine();

                            database.createWisata(jenisWisata, nama, tempat, harga, rating, deskripsi, spesial);
                        } else if (pilih.equals("3")) {
                            System.out.println("+-----------------------------------------------------------+");
                            System.out.println("|-------------     TAMBAH DATA HUTAN      ------------------|");
                            System.out.println("+-----------------------------------------------------------+");

                            String jenisWisata = "hutan";
                            System.out.print("Masukkan Nama Hutan            : ");
                            String nama = input.readLine();
                            System.out.print("Masukkan Lokasi Hutan          : ");
                            String tempat = input.readLine();
                            int harga = Main.cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                            double rating = 0;
                            System.out.print("Masukkan Deskripsi Hutan       : ");
                            String deskripsi = input.readLine();
                            System.out.print("Masukkan Fauna                 : ");
                            String spesial = input.readLine();
                            database.createWisata(jenisWisata, nama, tempat, harga, rating, deskripsi, spesial);
                        } else if (pilih.equals("4")) {
                            break;
                        } else {
                            System.out.println();
                            System.out.println("Menu Tidak Ada");
                        }
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
                    } else if (pil.equals("3")) {
                        break;
                    } else {
                        System.out.println("Menu tidak ada");
                    }
                    break;
                // Menu ubah
                case "3":
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.dataWisata();
                    int id;
                    while (true) {
                        id = Main.cekInputAngka("Masukan Id yang ingin di ubah  : ", input, "Harga harus angka");
                        // cek id ada apa nggak
                        if (database.isWisataTidakAdaById(id)) {
                            System.out.println("Data wisata tidak ada");
                        } else {
                            break;
                        }
                    }
                    System.out.print("Masukkan Nama Hutan            : ");
                    String nama = input.readLine();
                    System.out.print("Masukkan Lokasi Hutan          : ");
                    String tempat = input.readLine();
                    int harga = Main.cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                    double rating = Main.cekInputRentang("Masukkan Rating : ", input);
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
                    int idHapus = Main.cekInputAngka("Masukkan ID yang Ingin Di Hapus  : ", input, "ID Harus Angka");
                    database.deleteKelas(idHapus);
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.dataWisata();
                    break;

                case "5":
                    return;
                default:
                    System.out.println("Menu Tidak Ada");
            }
        }
    }

}

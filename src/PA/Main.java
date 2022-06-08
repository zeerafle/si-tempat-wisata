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
        User Alex = new User(admin);

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
            int login = Integer.parseInt(input.readLine());
            switch (login) {
                case 1:
                    admin.masuk();
                case 2:
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("| | 1. : Login                  | |");
                    System.out.println("| | 2. : Register               | |");
                    System.out.println("| | 0. : Kembali                | |");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.print("| | Masukkan pilihan : ");
                    String userSignMenu = input.readLine();
                    break;
                case 3:
                    Alex.log_out();
            }
        }
    }

    public static void Menu() throws IOException {
        InputStreamReader prepare = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(prepare);
        DatabaseWisata database = new DatabaseWisata();
        ArrayList<Wisata> wisata = database.getDataWisata();
        /*
         * dataWisata.add(new Pantai(2, "Pantai Manggar", "Balikpapan", 25000, 4.6,
         * "banana but", "Pantai yang banyak ubur uburnya"));
         * dataWisata.add(new KebunBinatang(
         * 3"Salah satu taman kota yang menarik di Kota Balikpapan yang memiliki ukuran yang sangat luas"
         * , "Taman 5 Generasi", "Balikpapan", 0, 4.6, ""));
         * dataWisata.add(new Hutan("Hutan yang banyak akarnya", "Hutan Mangrove",
         * "Balikpapan", 30001, 4.6, "banyak"));
         */
        //

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
            int menu = Integer.parseInt(input.readLine());
            switch (menu) {

                case 1:
                    System.out.println();

                    System.out.println("+-------------------------------------------------------+");
                    System.out.println("|-----------   TAMBAH DATA TEMPAT WISATA   -------------|");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println("                1. Tambah Data Hutan                    |");
                    System.out.println("                2. Tambah Data Taman                    |");
                    System.out.println("                3. Tambah Data Pantai                   |");
                    System.out.println("--------------------------------------------------------|");
                    System.out.print("Pilih Menu : ");
                    int pilih = Integer.parseInt(input.readLine());
                    if (pilih == 1) {
                        System.out.println("+-----------------------------------------------------------+");
                        System.out.println("|-------------     TAMBAH DATA PANTAI      -----------------|");
                        System.out.println("+-----------------------------------------------------------+");
                        System.out.print("Masukkan Jenis Wisata          : ");
                        String jenisWisata = input.readLine();
                        System.out.print("Masukkan Nama Pantai           : ");
                        String nama = input.readLine();
                        System.out.print("Masukkan Lokasi Pantai         : ");
                        String tempat = input.readLine();
                        int harga = cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                        double rating = cekInputRentang("Masukkan Rating : ", input);
                        System.out.print("Masukkan Deskripsi Pantai      : ");
                        String deskripsi = input.readLine();
                        System.out.print("Masukkan Wahana Pantai         : ");
                        String spesial = input.readLine();
                        database.createWisata(jenisWisata, nama, tempat, harga, rating, deskripsi, spesial);

                    } else if (pilih == 2) {
                        System.out.println("+------------------------------------------------------------------+");
                        System.out.println("|---------------    TAMBAH DATA KEBUN BINATANG      ---------------|");
                        System.out.println("+------------------------------------------------------------------+");
                        System.out.print("Masukkan Jenis Wisata          : ");
                        String jenisWisata = input.readLine();
                        System.out.print("Masukkan Nama Kebun Binatang   : ");
                        String nama = input.readLine();
                        System.out.print("Masukkan Lokasi                : ");
                        String tempat = input.readLine();
                        int harga = cekInputAngka("Masukkan Harga Tiket  : ", input, "Harga harus angka");
                        double rating = cekInputRentang("Masukkan Rating : ", input);
                        System.out.print("Masukkan Deskripsi Tempat      : ");
                        String deskripsi = input.readLine();
                        System.out.print("Masukkan Fauna Kebun Binatang  : ");
                        String spesial = input.readLine();

                        database.createWisata(jenisWisata, nama, tempat, harga, rating, deskripsi, spesial);
                    } else if (pilih == 3) {
                        System.out.println("+-----------------------------------------------------------+");
                        System.out.println("|-------------     TAMBAH DATA HUTAN      ------------------|");
                        System.out.println("+-----------------------------------------------------------+");
                        System.out.print("Masukkan Jenis Wisata          : ");
                        String jenisWisata = input.readLine();
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
                        database.createWisata(jenisWisata, nama, tempat, harga, rating, deskripsi, spesial);
                    } else {
                        System.out.println("Menu Tidak Ada");
                    }
                    break;

                case 2:
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.DataWisata();
                    // System.out.println("\n");
                    // System.out.println("+---------------------------------------------------------+");
                    // System.out.println("|-----------   LIHAT DATA MASING MASING WISATA    --------|");
                    // System.out.println("+---------------------------------------------------------+");
                    // System.out.println("                1. Lihat Data Hutan                       |");
                    // System.out.println("                2. Lihat Data Taman                       |");
                    // System.out.println("                3. Lihat Data Pantai                      |");
                    // System.out.println("                4. Lihat Data user                        |");
                    // System.out.println("----------------------------------------------------------|");
                    // System.out.print("Pilih Menu : ");
                    // int pilih2 = Integer.parseInt(input.readLine());
                    // if(pilih2 == 1){
                    //     System.out.println("+-----------------------------------------------------------+");
                    //     System.out.println("|---------------    LIHAT DATA PANTAI      -----------------|");
                    //     System.out.println("+-----------------------------------------------------------+");
                    //     database.DataWisata();
                    // } else if(pilih2 == 2){
                    //     System.out.println("+------------------------------------------------------------------+");
                    //     System.out.println("|---------------    LIHAT DATA KEBUN BINATANG      ---------------|");
                    //     System.out.println("+------------------------------------------------------------------+");
                    //     database.DataWisata();
                    // } else if(pilih2 == 3){
                    //     System.out.println("+-----------------------------------------------------------+");
                    //     System.out.println("|---------------    LIHAT DATA HUTAN      ------------------|");
                    //     System.out.println("+-----------------------------------------------------------+");
                    //     database.DataWisata();
                    // } else if(pilih2 == 4){
                    //     System.out.println("+-----------------------------------------------------------+");
                    //     System.out.println("|---------------    LIHAT DATA USER      ------------------|");
                    //     System.out.println("+-----------------------------------------------------------+");

                    // } else {
                    //     System.out.println("Menu Tidak Ada");
                    // }
                    break;
                // Menu ubah
                case 3:
                    // TODO dapatkan jenis wisata apa yang mau diubah
                    // ganti "masukkan nama ..." sesuai jenis wisata

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

                    break;

                case 4:
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.DataWisata();
                    System.out.println("\n");
                    System.out.println("+---------------------------------------+");
                    System.out.println("|-----------     HAPUS DATA     --------|");
                    System.out.println("+---------------------------------------+");
                    int idHapus = cekInputAngka("Masukkan ID yang Ingin Di Hapus  : ", input, "ID Harus Angka");
                    database.deleteKelas(idHapus);
                    System.out.println("========================================================================================================================================");
                    System.out.println("|                                                    LIST SELURUH TEMPAT WISATA                                                         |");
                    System.out.println("========================================================================================================================================");
                    database.DataWisata();
                    break;

                case 5:
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
// public static void tambahData(ArrayList<Wisata> listData, String jenisWisata,
// BufferedReader input) throws IOException {
// System.out.print("Masukkan Nama Wisata : ");
// String Nama = input.readLine();
// System.out.print("Masukkan Tempat Wisata : ");
// String Tempat = input.readLine();
// int Harga = cekInputAngka("Masukkan harga wisata : ", input, "Mohon masukkan
// angka");
// double Rating = cekInputRentang("Masukkan Rating Wisata : ", input);
// System.out.print("Masukkan Deskripsi Wisata : ");
// String Desk = input.readLine();
// switch (jenisWisata) {
// case "hutan" :
// System.out.print("Masukkan Flora pada Hutan: ");
// String flora = input.readLine();
// // listData.add(new Hutan(id, Desk, Nama, Tempat, Harga, Rating, flora));

// case "pantai" :
// System.out.print("Masukkan Wahana pada Pantai : ");
// String wahana = input.readLine();
// // listData.add(new Pantai(Desk, Nama, Tempat, Harga, Rating, wahana));

// case "kebun binatang" :
// System.out.print("Masukkan fauna pada kebun binatang : ");
// String fauna = input.readLine();
// // listData.add(new KebunBinatang(Desk, Nama, Tempat, Harga, Rating, fauna));

// }
// System.out.println();
// Wisata.tambah();
// System.out.println();
// }
// }

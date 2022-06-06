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
                    Alex.log_in();
                case 2:
                    System.out.println();
                    System.out.println("Menu Ini Masih Dalamm Maintenance");
                    System.out.println();
                    break;
                case 3:
                    Alex.log_out();
            }
        }
    }

    public static void Menu() throws IOException {
        InputStreamReader prepare = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(prepare);
        ArrayList<Wisata> dataWisata = new ArrayList<>();
        dataWisata.add(new Pantai("Pantai yang banyak ubur uburnya", "Pantai Manggar", "Balikpapan", 25000, 4.6, "banana but"));
        dataWisata.add(new KebunBinatang("Salah satu taman kota yang menarik di Kota Balikpapan yang memiliki ukuran yang sangat luas", "Taman 5 Generasi", "Balikpapan", 0, 4.6, ""));
        dataWisata.add(new Hutan("Hutan yang banyak akarnya", "Hutan Mangrove", "Balikpapan", 30000, 4.6, "banyak"));
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
                case 1 -> {
                    System.out.println();
                    System.out.println("1. Pantai ");
                    System.out.println("2. Kebun Binatang");
                    System.out.println("3. Hutan");
                    System.out.println();
                    System.out.print("Pilih Menu : ");
                    int pilih = Integer.parseInt(input.readLine());
                    if (pilih == 1) {
                        tambahData(dataWisata, "pantai", input);
                    } else if (pilih == 2) {
                        tambahData(dataWisata, "kebun binatang", input);
                    } else if (pilih == 3) {
                        tambahData(dataWisata, "hutan", input);
                    } else {
                        System.out.println("Menu Tidak Ada");
                    }
                }
                case 2 -> {
                    System.out.println();
                    for (int i = 0; i < dataWisata.size(); i++) {
                        System.out.println();
                        System.out.println("Wisata Ke - " + (i + 1));
                        dataWisata.get(i).display();
                    }
                }
                // Menu ubah
                case 3 -> {
                    System.out.println();
                    System.out.print("Masukkan Nama Wisata : ");
                    String nama = input.readLine();
                    boolean isKetemu = false;
                    for (Wisata i : dataWisata) {
                        if (i.getNama().equals(nama)) {
                            System.out.print("Masukkan Nama Wisata Baru : ");
                            i.setNama(input.readLine());
                            System.out.print("Masukkan Nama Tempat Baru : ");
                            i.setTempat(input.readLine());
                            System.out.print("Masukkan Nama Harga Baru  : ");
                            i.setHarga(Integer.parseInt(input.readLine()));
                            System.out.print("Masukkan Nama Rating Baru : ");
                            i.setRating(Double.parseDouble(input.readLine()));
                            System.out.print("Masukkan Nama Wahana Baru : ");
                            i.setDesk(input.readLine());
                            isKetemu = true;
                            break;
                        }
                    }
                    if (!isKetemu) {
                        System.out.println("Data tidak ditemukan");
                    } else {
                        System.out.println();
                        Wisata.update();
                        System.out.println();
                    }

                }
                case 4 -> {
                    System.out.println();
                    System.out.print("Masukkan Nama Wisata : ");
                    String Nama = input.readLine();
                    for (int i = 0; i < dataWisata.size(); i++) {
                        if (dataWisata.get(i).getNama().equals(Nama)) {
                            dataWisata.remove(i);
                        }
                    }
                    System.out.println();
                    Wisata.hapus();
                    System.out.println();
                }
                case 5 -> System.exit(0);
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
//                System.out.println();
            }
        }
    }

    public static void tambahData(ArrayList<Wisata> listData, String jenisWisata, BufferedReader input) throws IOException {
        System.out.print("Masukkan Nama Wisata   : ");
        String Nama = input.readLine();
        System.out.print("Masukkan Tempat Wisata : ");
        String Tempat = input.readLine();
        int Harga = cekInputAngka("Masukkan harga wisata : ", input, "Mohon masukkan angka");
        double Rating = cekInputRentang("Masukkan Rating Wisata : ", input);
        System.out.print("Masukkan Deskripsi Wisata : ");
        String Desk = input.readLine();
        switch (jenisWisata) {
            case "hutan" -> {
                System.out.print("Masukkan Flora pada Hutan: ");
                String flora = input.readLine();
                listData.add(new Hutan(Desk, Nama, Tempat, Harga, Rating, flora));
            }
            case "pantai" -> {
                System.out.print("Masukkan Wahana pada Pantai : ");
                String wahana = input.readLine();
                listData.add(new Pantai(Desk, Nama, Tempat, Harga, Rating, wahana));
            }
            case "kebun binatang" -> {
                System.out.print("Masukkan fauna pada kebun binatang : ");
                String fauna = input.readLine();
                listData.add(new KebunBinatang(Desk, Nama, Tempat, Harga, Rating, fauna));
            }
        }
        System.out.println();
        Wisata.tambah();
        System.out.println();
    }
}

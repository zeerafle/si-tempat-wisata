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
        Admin admin = new Admin("Kitsu", "Anjay123");
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
                    break;
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


    public static int cekInputAngka(String perintah, BufferedReader input, String pesan) {
        int penampung;

        while (true) {
            try {
                System.out.print(perintah);
                penampung = Integer.parseInt(input.readLine());
                if (penampung >= 0) {
                    return penampung;
                } else {
                    System.out.println("Harga Tidak Boleh Minus");
                }
            } catch (Exception e) {
                System.out.println("Harga Harus Angka");
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

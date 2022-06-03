package pa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {
    static String fileName;
    static String fileNam;
    static String fileNama;
    static String fileUser;
    static ArrayList<String> todoLists;
    static boolean isEditing = false;
    static Scanner s = new Scanner(System.in);
    static Scanner s1 = new Scanner(System.in);
    static Scanner s2 = new Scanner(System.in);

    public static void main(String[] args) {
        List<hutan> htn = new ArrayList<hutan>();
        List<Taman> tmn = new ArrayList<Taman>();
        List<pantai> pnt = new ArrayList<pantai>();
        List<user> usr = new ArrayList<user>();
        todoLists = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String Hutan = System.console() == null ? "/src/Hutan.txt" : "/Hutan.txt";
        String taman = System.console() == null ? "/src/Taman.txt" : "/Taman.txt";
        String Pantai = System.console() == null ? "/src/Pantai.txt" : "/Pantai.txt";
        String User = System.console() == null ? "/src/User.txt" : "/User.txt";

        fileName = System.getProperty("user.dir") + Hutan;
        System.out.println("FILE: " + fileName);
        fileNam = System.getProperty("user.dir") + taman;
        System.out.println("FILE: " + fileNam);
        fileNama = System.getProperty("user.dir") + Pantai;
        System.out.println("FILE: " + fileNama);
        fileUser = System.getProperty("user.dir") + User;
        System.out.println("FILE: " + fileUser);
    
        int pilih;
        do {
            System.out.println("+---------------------------+");
            System.out.println("|-------- Masuk Sebagai-----|");
            System.out.println("+---------------------------+");
            System.out.println("|      1. Admin             |");
            System.out.println("|      2. Pengujung         |");
            System.out.println("|      3. Keluar            |");
            System.out.println("+---------------------------+");
            System.out.print("Pilihan Menu : ");
            pilih = s.nextInt();
            System.out.print("\n");
            switch (pilih) {
                case 1:
                    System.out.println("+---------------------------+");
                    System.out.println("|-------- Admin Menu---------|");
                    System.out.println("+---------------------------+");
                    System.out.println("|      1. Tambah Data        |");
                    System.out.println("|      2. Lihat Data         |");
                    System.out.println("|      3. Hapus Data         |");
                    System.out.println("|      4. Edit Data          |");
                    System.out.println("|      5. Kembali            |");
                    System.out.println("+---------------------------+");
                    System.out.print("Pilihan Menu : ");
                    int p = s.nextInt();
                    System.out.print("\n");
                    switch (p) {
                        case 1:
                                System.out.println("+-------------------------------------------------------+");
                                System.out.println("|-----------   TAMBAH DATA TEMPAT WISATA   -------------|");
                                System.out.println("+-------------------------------------------------------+");
                                System.out.println("                1. Tambah Data Hutan                    |");
                                System.out.println("                2. Tambah Data Taman                    |");
                                System.out.println("                3. Tambah Data Pantai                   |");
                                System.out.println("--------------------------------------------------------|");
                                System.out.println("Pilih :");
                                p = s.nextInt();
                                if (p == 1) {
                                    System.out.println("+-----------------------------------------------------------+");
                                    System.out.println("|-----------     TAMBAH DATA HUTAN       ------------|");
                                    System.out.println("+-----------------------------------------------------------+");
                                    System.out.print("Masukan ID           :");
                                    int id = s.nextInt();
                                    System.out.print("Masukkan Nama        : ");
                                    String Nama = s1.nextLine();
                                    System.out.print("Masukkan Tempat      : ");
                                    String Tempat = s1.nextLine();
                                    System.out.print("Masukkan Rating      : ");
                                    Double rating = s2.nextDouble();
                                    System.out.print("Masukkan flora       : ");
                                    String flora = s1.nextLine();
                                    System.out.print("Masukkan fauna       : ");
                                    String fauna = s1.nextLine();
                                    System.out.print("Masukkan harga       : ");
                                    int harga = s.nextInt();
                                    System.out.println("-----------------------------------------------------------");
                                    htn.add(new hutan(id, flora, fauna, Nama, Tempat, harga, rating));
                                    try {
                                        // tulis file
                                        FileWriter fileWriter = new FileWriter(fileName, true);
                                        fileWriter.append(String.format("%s%n",
                                                "Id : " + id + " Nama : " + Nama + " Tempat : " + Tempat + " Rating : " + rating
                                                        + " Flora : " + flora + " Fauna : " + fauna + " Harga :" + harga));
                                        fileWriter.close();
                                        System.out.println("Berhasil ditambahkan!");
                                    } catch (IOException e) {
                                        System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                    }
                                }
                                if (p == 2) {
                                    System.out.println("+-----------------------------------------------------------+");
                                    System.out.println("|-----------     TAMBAH DATA TAMAN       -------------------|");
                                    System.out.println("+-----------------------------------------------------------+");
                                    System.out.println("Masukan ID           :");
                                    int id = s.nextInt();
                                    System.out.println("Masukkan Nama        : ");
                                    String Nama = s1.nextLine();
                                    System.out.println("Masukkan Tempat      : ");
                                    String Tempat = s1.nextLine();
                                    System.out.println("Masukkan Rating      : ");
                                    Double rating = s2.nextDouble();
                                    System.out.println("Masukkan flora       : ");
                                    String flora = s1.nextLine();
                                    System.out.println("Masukkan fauna       : ");
                                    String fauna = s1.nextLine();
                                    System.out.println("Masukkan harga       : ");
                                    int harga = s.nextInt();
                                    System.out.println("-----------------------------------------------------------");
                                    tmn.add(new Taman(id, flora, fauna, Nama, Tempat, harga, rating));
                                    try {
                                        // tulis file
                                        FileWriter fileWriter = new FileWriter(fileNam, true);
                                        fileWriter.append(String.format("%s%n",
                                                "Id :" + id + " Nama :" + Nama + " Tempat :" + Tempat + " Rating :" + rating
                                                        + " Flora :" + flora + " Fauna :" + fauna + " Harga :" + harga));
                                        fileWriter.close();
                                        System.out.println("Berhasil ditambahkan!");
                                    } catch (IOException e) {
                                        System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                    }
                                }
                                if (p == 3) {
        
                                    System.out.println("+-----------------------------------------------------------+");
                                    System.out.println("|-----------     TAMBAH DATA PANTAI       ------------|");
                                    System.out.println("+-----------------------------------------------------------+");
                                    System.out.println("Masukan ID         :");
                                    int id = s.nextInt();
                                    System.out.println("Masukkan Nama      : ");
                                    String Nama = s1.nextLine();
                                    System.out.println("Masukkan Tempat    : ");
                                    String Tempat = s1.nextLine();
                                    System.out.println("Masukkan Rating    : ");
                                    Double rating = s2.nextDouble();
                                    System.out.println("Masukkan wahana    : ");
                                    String wahana = s1.nextLine();
                                    System.out.println("Masukkan harga     : ");
                                    int harga = s.nextInt();
                                    System.out.println("-----------------------------------------------------------");
                                    pnt.add(new pantai(id, wahana, Nama, Tempat, harga, rating));
                                    try {
                                        // tulis file
                                        FileWriter fileWriter = new FileWriter(fileNama, true);
                                        fileWriter.append(String.format("%s%n", "Id :" + id + "Nama :" + Nama + " Tempat :"
                                                + Tempat + " Rating :" + rating + " Wahana :" + wahana + " Harga :" + harga));
                                        fileWriter.close();
                                        System.out.println("Berhasil ditambahkan!");
                                    } catch (IOException e) {
                                        System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                    }
                                }
                                break;
                                case 2:
                                System.out.println("+------------------------------------+");
                                System.out.println("|-----------   LIHAT DATA    --------|");
                                System.out.println("+------------------------------------+");
                                System.out.println("         1. Lihat Data Hutan         |");
                                System.out.println("         2. Lihat Data Taman         |");
                                System.out.println("         3. Lihat Data Pantai        |");
                                System.out.println("         4. Lihat Data user          |");
                                System.out.println("-------------------------------------|");
                                System.out.println("Pilih :");
                                p = s.nextInt();
        
                                if (p == 1) {
                                    try {
                                        File file = new File(fileName);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Tempat Wisata Hutan Tersedia :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                    } else {
                                        System.out.println("Tidak ada data!");
        
                                    }
                                }
                                if (p == 2) {
                                    try {
                                        File file = new File(fileNam);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Tempat Wisata Taman Tersedia :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                    } else {
                                        System.out.println("Tidak ada data!");
        
                                    }
                                }
                                if (p == 3) {
                                    try {
                                        File file = new File(fileNama);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Tempat Wisata Pantai Tersedia :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                    } else {
                                        System.out.println("Tidak ada data!");
        
                                    }
                                }
                                if (p == 4) {
                                    try {
                                        File file = new File(fileUser);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Data Pengunjung :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                    } else {
                                        System.out.println("Tidak ada data!");
        
                                    }
                                }
                                                          
                                break;
                                case 3:
                                System.out.println("+-------------------------------------+");
                                System.out.println("|-----------   HAPUS DATA     --------|");
                                System.out.println("+-------------------------------------+");
                                System.out.println("          1. Hapus Data Hutan         |");
                                System.out.println("          2. Hapus Data Taman         |");
                                System.out.println("          3. Hapus Data Pantai        |");
                                System.out.println("          4. Hapus Data user          |");
                                System.out.println("--------------------------------------|");
                                System.out.println("Pilih :");
                                p = s.nextInt();
                                if (p == 1) {
                                    try {
                                        File file = new File(fileName);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Tempat Wisata Hutan Tersedia :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                        System.out.println("+----------------------------------------------+");
                                    }
        
                                    System.out.println("----------------------------------------------");
                                    System.out.println("------ Masukkan ID data ingin dihapus ------- :");
                                    System.out.println("----------------------------------------------");
                                    int index = Integer.parseInt(s1.nextLine());
                                    try {
                                        if (index > todoLists.size()) {
                                            throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
                                        } else {
        
                                            System.out.println("Kamu akan menghapus:");
                                            System.out.println(String.format("[%d] %s", index, todoLists.get(index)));
                                            System.out.println("Apa kamu yakin?");
                                            System.out.print("Jawab (y/t): ");
                                            String jawab = s1.nextLine();
        
                                            if (jawab.equalsIgnoreCase("y")) {
                                                // hapus data
                                                todoLists.remove(index);
        
                                                // tulis ulang file
                                                try {
                                                    FileWriter fileWriter = new FileWriter(fileName, false);
        
                                                    // write new data
                                                    for (String data : todoLists) {
                                                        fileWriter.append(String.format("%s%n", data));
                                                    }
                                                    fileWriter.close();
        
                                                    System.out.println("Berhasil dihapus!");
                                                } catch (IOException e) {
                                                    System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
        
                                }
                                if (p == 2) {
                                    try {
                                        File file = new File(fileNam);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Tempat Wisata Taman Tersedia :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                        System.out.println("+----------------------------------------------+");
                                    }
        
                                    System.out.println("----------------------------------------------");
                                    System.out.println("------ Masukkan ID data ingin dihapus ------- :");
                                    System.out.println("----------------------------------------------");
                                    int index = Integer.parseInt(s1.nextLine());
                                    try {
                                        if (index > todoLists.size()) {
                                            throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
                                        } else {
        
                                            System.out.println("Kamu akan menghapus:");
                                            System.out.println(String.format("[%d] %s", index, todoLists.get(index)));
                                            System.out.println("Apa kamu yakin?");
                                            System.out.print("Jawab (y/t): ");
                                            String jawab = s1.nextLine();
        
                                            if (jawab.equalsIgnoreCase("y")) {
                                                // hapus data
                                                todoLists.remove(index);
        
                                                // tulis ulang file
                                                try {
                                                    FileWriter fileWriter = new FileWriter(fileNam, false);
        
                                                    // write new data
                                                    for (String data : todoLists) {
                                                        fileWriter.append(String.format("%s%n", data));
                                                    }
                                                    fileWriter.close();
        
                                                    System.out.println("Berhasil dihapus!");
                                                } catch (IOException e) {
                                                    System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                if (p == 3) {
                                    try {
                                        File file = new File(fileNama);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Tempat Wisata Pantai Tersedia :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                        System.out.println("+----------------------------------------------+");
                                    }
        
                                    System.out.println("----------------------------------------------");
                                    System.out.println("------ Masukkan ID data ingin dihapus ------- :");
                                    System.out.println("----------------------------------------------");
                                    int index = Integer.parseInt(s1.nextLine());
                                    try {
                                        if (index > todoLists.size()) {
                                            throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
                                        } else {
        
                                            System.out.println("Kamu akan menghapus:");
                                            System.out.println(String.format("[%d] %s", index, todoLists.get(index)));
                                            System.out.println("Apa kamu yakin?");
                                            System.out.print("Jawab (y/t): ");
                                            String jawab = s1.nextLine();
        
                                            if (jawab.equalsIgnoreCase("y")) {
                                                // hapus data
                                                todoLists.remove(index);
        
                                                // tulis ulang file
                                                try {
                                                    FileWriter fileWriter = new FileWriter(fileNama, false);
        
                                                    // write new data
                                                    for (String data : todoLists) {
                                                        fileWriter.append(String.format("%s%n", data));
                                                    }
                                                    fileWriter.close();
        
                                                    System.out.println("Berhasil dihapus!");
                                                } catch (IOException e) {
                                                    System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                if (p == 1) {
                                    try {
                                        File file = new File(fileUser);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List data Pengunjung :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                        System.out.println("+----------------------------------------------+");
                                    }
        
                                    System.out.println("----------------------------------------------");
                                    System.out.println("------ Masukkan ID data ingin dihapus ------- :");
                                    System.out.println("----------------------------------------------");
                                    int index = Integer.parseInt(s1.nextLine());
                                    try {
                                        if (index > todoLists.size()) {
                                            throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
                                        } else {
        
                                            System.out.println("Kamu akan menghapus:");
                                            System.out.println(String.format("[%d] %s", index, todoLists.get(index)));
                                            System.out.println("Apa kamu yakin?");
                                            System.out.print("Jawab (y/t): ");
                                            String jawab = s1.nextLine();
        
                                            if (jawab.equalsIgnoreCase("y")) {
                                                // hapus data
                                                todoLists.remove(index);
        
                                                // tulis ulang file
                                                try {
                                                    FileWriter fileWriter = new FileWriter(fileUser, false);
        
                                                    // write new data
                                                    for (String data : todoLists) {
                                                        fileWriter.append(String.format("%s%n", data));
                                                    }
                                                    fileWriter.close();
        
                                                    System.out.println("Berhasil dihapus!");
                                                } catch (IOException e) {
                                                    System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
        
                                }                                
                                break;
                                case 4:
                                System.out.println("+-------------------------------------------------------+");
                                System.out.println("|-----------   UBAH DATA TEMPAT WISATA    --------|");
                                System.out.println("+-------------------------------------------------------+");
                                System.out.println("                1. Ubah Data Hutan                    |");
                                System.out.println("                2. Ubah Data Taman                     |");
                                System.out.println("                3. Ubah Data Pantai                     |");
                                System.out.println("--------------------------------------------------------|");
                                System.out.println("Pilih :");
                                p = s.nextInt();
                                if (p == 1) {
                                    try {
                                        File file = new File(fileName);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Tempat Wisata Hutan Tersedia :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                        System.out.println("+----------------------------------------------+");
                                    }
        
                                    System.out.println("+--------------------------------------------------------+");
                                    System.out.println("|          Masukkan Index data yang ingin di Update :       |");
                                    System.out.println("+--------------------------------------------------------+");
                                    int index = Integer.parseInt(s1.nextLine());
                                    if (index > todoLists.size()) {
                                        throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
                                    } else {
        
                                        System.out.println("+-----------------------------------------------------------+");
                                        System.out.println("|-----------     TAMBAH DATA HUTAN       ------------|");
                                        System.out.println("+-----------------------------------------------------------+");
                                        System.out.println("Masukan ID       :");
                                        int id = s.nextInt();
                                        System.out.println("Masukkan Nama    : ");
                                        String Nama = s1.nextLine();
                                        System.out.println("Masukkan Tempat  : ");
                                        String Tempat = s1.nextLine();
                                        System.out.println("Masukkan Rating  : ");
                                        Double rating = s2.nextDouble();
                                        System.out.println("Masukkan flora   : ");
                                        String flora = s1.nextLine();
                                        System.out.println("Masukkan fauna   : ");
                                        String fauna = s1.nextLine();
                                        System.out.println("Masukkan harga   : ");
                                        int harga = s.nextInt();
                                        System.out.println("-----------------------------------------------------------");
        
                                        // update data
                                        todoLists.set(index, "Id :" + id + "Nama :" + Nama + " Tempat :" + Tempat + " Rating :"
                                                + rating + " flora : " + flora + "Fauna : " + fauna + " Harga :" + harga);
        
                                        System.out.println(todoLists.toString());
        
                                        try {
                                            FileWriter fileWriter = new FileWriter(fileName, false);
        
                                            // write new data
                                            for (String data : todoLists) {
                                                fileWriter.append(String.format("%s%n", data));
                                            }
                                            fileWriter.close();
        
                                            System.out.println("Data Berhasil diubah!\n");
                                        } catch (IOException e) {
                                            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                        }
                                    }
                                } else if (p == 2) {
                                    try {
                                        File file = new File(fileNam);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Tempat Wisata Taman Tersedia :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                        System.out.println("+----------------------------------------------+");
                                    }
        
                                    System.out.println("+--------------------------------------------------------+");
                                    System.out.println("|          Masukkan Index data yang ingin di Update :       |");
                                    System.out.println("+--------------------------------------------------------+");
                                    int index = Integer.parseInt(s1.nextLine());
                                    if (index > todoLists.size()) {
                                        throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
                                    } else {
        
                                        System.out.println("+-----------------------------------------------------------+");
                                        System.out.println("|-----------     TAMBAH DATA TAMAN       ------------|");
                                        System.out.println("+-----------------------------------------------------------+");
                                        System.out.println("Masukan ID       :");
                                        int id = s.nextInt();
                                        System.out.println("Masukkan Nama    : ");
                                        String Nama = s1.nextLine();
                                        System.out.println("Masukkan Tempat  : ");
                                        String Tempat = s1.nextLine();
                                        System.out.println("Masukkan Rating  : ");
                                        Double rating = s2.nextDouble();
                                        System.out.println("Masukkan flora   : ");
                                        String flora = s1.nextLine();
                                        System.out.println("Masukkan fauna   : ");
                                        String fauna = s1.nextLine();
                                        System.out.println("Masukkan harga   : ");
                                        int harga = s.nextInt();
                                        System.out.println("-----------------------------------------------------------");
        
                                        // update data
                                        todoLists.set(index, "Id :" + id + "Nama :" + Nama + " Tempat :" + Tempat + " Rating :"
                                                + rating + " flora : " + flora + "Fauna : " + fauna + " Harga :" + harga);
        
                                        System.out.println(todoLists.toString());
        
                                        try {
                                            FileWriter fileWriter = new FileWriter(fileNam, false);
        
                                            // write new data
                                            for (String data : todoLists) {
                                                fileWriter.append(String.format("%s%n", data));
                                            }
                                            fileWriter.close();
        
                                            System.out.println("Data Berhasil diubah!\n");
                                        } catch (IOException e) {
                                            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                        }
                                    }
                                } else if (p == 3) {
                                    try {
                                        File file = new File(fileNama);
                                        Scanner fileReader = new Scanner(file);
        
                                        // load isi file ke dalam array todoLists
                                        todoLists.clear();
                                        while (fileReader.hasNextLine()) {
                                            String newTodoList = fileReader.nextLine();
                                            todoLists.add(newTodoList);
                                        }
        
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error karena: " + e.getMessage());
        
                                    }
                                    if (todoLists.size() > 0) {
                                        System.out.println("List Tempat Wisata Pantai Tersedia :");
                                        int index = 0;
                                        for (String data : todoLists) {
                                            System.out.println(String.format("[%d] %s", index, data));
                                            index++;
                                        }
                                        System.out.println("+----------------------------------------------+");
                                    }
        
                                    System.out.println("+--------------------------------------------------------+");
                                    System.out.println("|          Masukkan Index data yang ingin di Update :       |");
                                    System.out.println("+--------------------------------------------------------+");
                                    int index = Integer.parseInt(s1.nextLine());
                                    if (index > todoLists.size()) {
                                        throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
                                    } else {
        
                                        System.out.println("+-----------------------------------------------------------+");
                                        System.out.println("|-----------     TAMBAH DATA PANTAI       ------------|");
                                        System.out.println("+-----------------------------------------------------------+");
                                        System.out.println("Masukan ID       :");
                                        int id = s.nextInt();
                                        System.out.println("Masukkan Nama    : ");
                                        String Nama = s1.nextLine();
                                        System.out.println("Masukkan Tempat  : ");
                                        String Tempat = s1.nextLine();
                                        System.out.println("Masukkan Rating  : ");
                                        Double rating = s2.nextDouble();
                                        System.out.println("Masukkan Wahana   : ");
                                        String wahana = s1.nextLine();
                                        System.out.println("Masukkan harga   : ");
                                        int harga = s.nextInt();
                                        System.out.println("-----------------------------------------------------------");
        
                                        // update data
                                        todoLists.set(index, "Id :" + id + "Nama :" + Nama + " Tempat :" + Tempat + " Rating :"
                                                + rating + " Wahana : " + wahana + " Harga :" + harga);
        
                                        System.out.println(todoLists.toString());
        
                                        try {
                                            FileWriter fileWriter = new FileWriter(fileNama, false);
        
                                            // write new data
                                            for (String data : todoLists) {
                                                fileWriter.append(String.format("%s%n", data));
                                            }
                                            fileWriter.close();
        
                                            System.out.println("Data Berhasil diubah!\n");
                                        } catch (IOException e) {
                                            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                                        }
                                    }
        
                                }
                                break;
                                default:
                                    System.out.println("Masuk Ke Menu utama");
                                    break;
                            }

                break;
                case 2:
                System.out.println("+-----------------------------+");
                System.out.println("|-----   MENU PENGUNJUNG  ----|");
                System.out.println("+-----------------------------+");
                System.out.println("|           1. Login          |");
                System.out.println("|           2. Daftar         |");
                System.out.println("|           3. Kembali        |");
                System.out.println("|-----------------------------|");
                System.out.println("Pilih :");
                p = s.nextInt();
                if (p == 1) {
                    System.out.println("Anda Berhasil Login");
                    System.out.print("\n");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println("|-----------   TAMBAH DATA TEMPAT WISATA   -------------|");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println("                1. Lihat Data Tempat Wisata             |");
                    System.out.println("                2. Cari Data Tempat Wisata              |");
                    System.out.println("--------------------------------------------------------|");
                    System.out.println("Pilih :");
                    p = s.nextInt();
                    if (p == 1) {
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println("|-----------   LIHAT DATA TEMPAT WISATA    --------|");
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println("                1. Lihat Data Hutan                    |");
                        System.out.println("                2. Lihat Data Taman                    |");
                        System.out.println("                3. Lihat Data Pantai                    |");
                        System.out.println("--------------------------------------------------------|");
                        System.out.println("Pilih :");
                        p = s.nextInt();

                        if (p == 1) {
                            try {
                                File file = new File(fileName);
                                Scanner fileReader = new Scanner(file);

                                // load isi file ke dalam array todoLists
                                todoLists.clear();
                                while (fileReader.hasNextLine()) {
                                    String newTodoList = fileReader.nextLine();
                                    todoLists.add(newTodoList);
                                }

                            } catch (FileNotFoundException e) {
                                System.out.println("Error karena: " + e.getMessage());

                            }
                            if (todoLists.size() > 0) {
                                System.out.println("List Tempat Wisata Hutan Tersedia :");
                                int index = 0;
                                for (String data : todoLists) {
                                    System.out.println(String.format("[%d] %s", index, data));
                                    index++;
                                }
                            } else {
                                System.out.println("Tidak ada data!");

                            }
                        }
                        if (p == 2) {
                            try {
                                File file = new File(fileNam);
                                Scanner fileReader = new Scanner(file);

                                // load isi file ke dalam array todoLists
                                todoLists.clear();
                                while (fileReader.hasNextLine()) {
                                    String newTodoList = fileReader.nextLine();
                                    todoLists.add(newTodoList);
                                }

                            } catch (FileNotFoundException e) {
                                System.out.println("Error karena: " + e.getMessage());

                            }
                            if (todoLists.size() > 0) {
                                System.out.println("List Tempat Wisata Taman Tersedia :");
                                int index = 0;
                                for (String data : todoLists) {
                                    System.out.println(String.format("[%d] %s", index, data));
                                    index++;
                                }
                            } else {
                                System.out.println("Tidak ada data!");

                            }
                        }
                        if (p == 3) {
                            try {
                                File file = new File(fileNama);
                                Scanner fileReader = new Scanner(file);

                                // load isi file ke dalam array todoLists
                                todoLists.clear();
                                while (fileReader.hasNextLine()) {
                                    String newTodoList = fileReader.nextLine();
                                    todoLists.add(newTodoList);
                                }

                            } catch (FileNotFoundException e) {
                                System.out.println("Error karena: " + e.getMessage());

                            }
                            if (todoLists.size() > 0) {
                                System.out.println("List Tempat Wisata Pantai Tersedia :");
                                int index = 0;
                                for (String data : todoLists) {
                                    System.out.println(String.format("[%d] %s", index, data));
                                    index++;
                                }
                            } else {
                                System.out.println("Tidak ada data!");

                            }
                        }
                    }
                    if (p == 2) {
                        System.out.println("data yang anda Cari");
                    }

                   
                }if (p == 2) {
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("|-----------     DATA REGISTRASI       ------------|");
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("Masukan ID           :");
                    int Id = s.nextInt();
                    System.out.println("Masukkan Nama        : ");
                    String Nama = s1.nextLine();
                    System.out.println("Masukkan Username      : ");
                    String Username = s1.nextLine();
                    System.out.println("Masukkan Password      : ");
                    String password = s1.nextLine();
                    System.out.println("-----------------------------------------------------------");
                    usr.add(new user(Id, Username, password, Nama));
                    try {
                        // tulis file
                        FileWriter fileWriter = new FileWriter(fileName, true);
                        fileWriter.append(String.format("%s%n","Id : " + Id + " Nama : " + Nama + " Username : " + Username + " Password : " + password));
                        fileWriter.close();
                        System.out.println("Anda berhasil Registrasi !");
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                    }
                
                }                
                break;
                
                default:
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("                  Program Selesai Terima Kasih!!!              |");
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("+---------------------------------------------------------------+");
                System.out.println("|-------          Data Tempat Wisata Indonesia     ----------|");
                System.out.println("+---------------------------------------------------------------+");
                break;
            } 
        }while (pilih != 3);

    }   
}

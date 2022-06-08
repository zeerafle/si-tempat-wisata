package PA;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseWisata {
    private final String url = "jdbc:sqlite:wisata.db";
    private PreparedStatement pst;
    private Connection c;
    private ResultSet rs;
    private Statement stm;
    private String sql;

    public boolean isDatabaseExists(String dbFilePath) {
        File database = new File(dbFilePath);
        return database.exists();
    }

    // menghubungkan ke database
    public Connection getKoneksi() {
        String dapatkanJalurFile = new File("").getAbsolutePath();
        String jalurAbsolutFile = dapatkanJalurFile.concat("/wisata.db");
        if (isDatabaseExists(jalurAbsolutFile)) {
            try {
                c = DriverManager.getConnection(url);
                //System.out.println("Yey");
            } catch (SQLException e) {
                System.out.println("Error " + e);
            }
        } else {
            System.out.println("Tidak ketemu");
        }
        return c;
    }

    // manajemen tempat wisata
    public void createWisata(String jenisWisata, String nama, String tempat, int harga, double rating, String deskripsi, String special) {
        try {
            sql = "INSERT INTO wisata (nama, tempat, harga, rating, deskripsi, jenis, spesial) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, tempat);
            pst.setInt(3, harga);
            pst.setDouble(4, rating);
            pst.setString(5, deskripsi);
            pst.setString(6, jenisWisata);
            pst.setString(7, special);
            pst.execute();

        } catch (SQLException e) {
            System.out.println("Oops " + e);
        }
    }

    // TODO bikin satu method aja untuk dapatkan data. Kasi parameter jenis di fungsinya
    //  if (result.getInt(7) == "hutan") {
    //                    akun.add(new Hutan())
    public ArrayList<Wisata> getDataWisata() {
        ArrayList<Wisata> wisata = new ArrayList<>();
        try {
            sql = "SELECT * FROM wisata ";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString(7) == "Pantai") {
                    wisata.add(new Pantai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
                } else if (rs.getInt(7) == 2) {
                    wisata.add(new KebunBinatang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
                } else if (rs.getInt(7) == 3) {
                    wisata.add(new Hutan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
                }

            }
        } catch (SQLException e) {
            System.out.println("Yoo error cok");
        }

        return wisata;
    }

    public ArrayList<Wisata> DataWisata() {
        ArrayList<Wisata> wisata = new ArrayList<>();
        try {
            sql = "SELECT * FROM wisata ";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            String tabl = "| %-2s | %-25s | %-13s | %-14s | %-7s | %-23s | %-13s | %-14s |%n";


            System.out.format("+----+---------------------------+---------------+----------------+---------+-------------------------+--------------+-----------------+%n");
            System.out.format("| ID | Nama                      | Tempat        | Harga          | Rating  | Deskripsi               | Jenis        |  Special        |%n");
            System.out.format("+----+---------------------------+---------------+----------------+---------+-------------------------+--------------+-----------------+%n");
            while (rs.next()) {

                System.out.format(tabl, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8));

            }
        } catch (SQLException e) {
            System.out.println("Yoo error cok");
        }

        return wisata;
    }
    // TODO bikin method untuk hutan dan kebun
    // public ArrayList<Pantai> getDataPantai() {
    //     ArrayList<Pantai> wisata = new ArrayList<>();
    //     try {
    //         sql = "SELECT * FROM wisata WHERE jenis = pantai";
    //         Connection cn = getKoneksi();
    //         pst = cn.prepareStatement(sql);
    //         rs = pst.executeQuery();
    //         while (rs.next()) {
    //             wisata.add(new Pantai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
    //         }
    //     } catch (SQLException e) {
    //         System.out.println("Yoo error cok");
    //     }

    //     return wisata;
    // }

    // public ArrayList<Hutan> getDataHutan() {
    //     ArrayList<Hutan> wisata = new ArrayList<>();
    //     try {
    //         sql = "SELECT * FROM wisata WHERE jenis = hutan";
    //         Connection cn = getKoneksi();
    //         pst = cn.prepareStatement(sql);
    //         rs = pst.executeQuery();
    //         while (rs.next()) {
    //             wisata.add(new Hutan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
    //         }
    //     } catch (SQLException e) {
    //         System.out.println("Yoo error cok");
    //     }

    //     return wisata;
    // }

    // public ArrayList<KebunBinatang> getDataKebunBinatang() {
    //     ArrayList<KebunBinatang> wisata = new ArrayList<>();
    //     try {
    //         sql = "SELECT * FROM wisata WHERE jenis = 'kebun_binatang'";
    //         Connection cn = getKoneksi();
    //         pst = cn.prepareStatement(sql);
    //         rs = pst.executeQuery();
    //         while (rs.next()) {
    //             wisata.add(new KebunBinatang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
    //         }
    //     } catch (SQLException e) {
    //         System.out.println("Yoo error cok");
    //     }

    //     return wisata;
    // }
    public void updateWisata(int id, String nama, String tempat, int harga, double rating,
                             String deskripsi, String spesial) {
        try {
            sql = "UPDATE wisata SET nama=?, tempat=?, harga=?, deskripsi=?,spesial=? WHERE id=?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, tempat);
            pst.setInt(3, harga);
            pst.setString(4, deskripsi);
            pst.setString(5, spesial);
            pst.setInt(6, id);
            pst.execute();
        } catch (SQLException e) {
            System.out.println("Mantap Error");
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void deleteKelas(int id) {
        try {
            sql = "DELETE FROM wisata WHERE id=?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            System.out.println("erorrrrrrrr" + ex);
        }
    }


}

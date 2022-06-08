package PA;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    protected final String url = "jdbc:sqlite:wisata.db";
    protected PreparedStatement pst;
    protected Connection c;
    protected ResultSet rs;
    protected Statement stm;
    protected String sql;

    public boolean isDatabaseExists(String dbFilePath) {
        File database = new File(dbFilePath);
        return database.exists();
    }

    // menghubungkan ke database
    public Connection getKoneksi() {
        String dapatkanJalurFile = new File("").getAbsolutePath();
//        String jalurAbsolutFile = dapatkanJalurFile.concat("\\wisata.db");
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
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
    }

    public ArrayList<Wisata> getDataWisata() {
        ArrayList<Wisata> wisata = new ArrayList<>();
        try {
            sql = "SELECT * FROM wisata ";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString(7).equals("pantai")) {
                    wisata.add(new Pantai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
                } else if (rs.getString(7).equals("kebun_binatang")) {
                    wisata.add(new KebunBinatang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
                } else if (rs.getString(7).equals("hutan")) {
                    wisata.add(new Hutan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
                }

            }
        } catch (SQLException e) {
            System.out.println("Yoo error cok");
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }

        return wisata;
    }

    public void dataWisata() {
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
            System.out.println("Yoo error cok" + e);
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }

    }

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
            System.out.println("Mantap Error" + e);
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
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
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
    }

    public void readPantai() {
        try {
            sql = "SELECT * FROM wisata WHERE jenis='pantai'";
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
        } catch (SQLException ex) {
            System.out.println("erorrrrrrrr" + ex);

        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
    }

    public void readKebun() {
        try {
            sql = "SELECT * FROM wisata WHERE jenis='kebun_binatang'";
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
        } catch (SQLException ex) {
            System.out.println("erorrrrrrrr" + ex);

        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
    }

    public void readHutan() {
        try {
            sql = "SELECT * FROM wisata WHERE jenis='hutan'";
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
        } catch (SQLException ex) {
            System.out.println("erorrrrrrrr" + ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
    }

    public void DataUser() {
        try {
            sql = "SELECT * FROM User ";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            String tabl = "| %-2s | %-25s | %-13s | %-14s |%n";
            System.out.format("+----+---------------------------+---------------+----------------+%n");
            System.out.format("| ID | Nama                      | Username       | Password      |%n");
            System.out.format("+----+---------------------------+---------------+----------------+%n");
            while (rs.next()) {

                System.out.format(tabl, rs.getInt(1), rs.getString(4), rs.getString(2), rs.getInt(3));

            }
        } catch (SQLException e) {
            System.out.println("Yoo error cok");
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }

    }

    public ArrayList<Visitor> getDataAkun() {
        ArrayList<Visitor> visitor = new ArrayList<>();
        try {
            Connection cn = getKoneksi();
            stm = cn.createStatement();
            rs = stm.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                visitor.add(new Visitor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            try {
                rs.close();
                stm.close();
            } catch (SQLException ex) {
                System.out.println("Error set data : " + ex);
            }
        }
        return visitor;
    }

    public void createDataakun(String nama, String username, String password) {
        try {
            sql = "INSERT INTO user (nama, username,password) VALUES (?, ?, ?)";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.execute();

        } catch (SQLException e) {
            System.out.println("Oops " + e);
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
    }

    public double getWisataRatingById(int id) {
        double rating = 0;
        try {
            sql = "SELECT rating FROM wisata WHERE id = ?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rating = rs.getDouble(1);
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
        return rating;
    }

    public void setWisataRatingById(int id, double rating) {
        try {
            sql = "UPDATE wisata SET rating=? WHERE id=?";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setDouble(1, rating);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException e) {
            System.out.println("Mantap Error" + e);
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
    }
}

package PA;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseWisata {
    private final String url = "jdbc:sqlite:/home/zeerafle/Projects/si-tempat-wisata/wisata.db";
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
                System.out.println("Yey");
            } catch (SQLException e) {
                System.out.println("Error " + e);
            }
        } else {
            System.out.println("Tidak ketemu");
        }
        return c;
    }

    // manajemen tempat wisata
    public void createPantai(String jenisWisata, String nama, String tempat, int harga, double rating, String deskripsi, String atributKhusus, String nilaiAtributKhusus) {
        // INSERT INTO wisata (nama, tempat, harga, rating, deskripsi) VALUES ('Manggar', 'Balikpapan', 15000, 1.6, 'bagus');
        // INSERT INTO pantai (id, wahana) VALUES ((SELECT MAX(id) FROM wisata), 'banana boat');
        try {
            sql = "INSERT INTO wisata (nama, tempat, harga, rating, deskripsi) VALUES (?, ?, ?, ?, ?)";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, tempat);
            pst.setInt(3, harga);
            pst.setDouble(4, rating);
            pst.setString(5, deskripsi);
            pst.execute();

            // query kedua
            sql = "INSERT INTO " + jenisWisata + " (id, " + atributKhusus + ") VALUES ((SELECT MAX(id) FROM wisata), ?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, nilaiAtributKhusus);
        } catch (SQLException e) {
            System.out.println("Oops " + e);
        }
    }

    public ArrayList<Wisata> getDataWisata() {
        ArrayList<Wisata> dataWisata = new ArrayList<>();
        dataWisata.addAll(getDataJenisWisata("pantai", "wahana"));
        dataWisata.addAll(getDataJenisWisata("hutan", "flora"));
        dataWisata.addAll(getDataJenisWisata("kebun_binatang", "fauna"));

        return dataWisata;
    }

    // fungsi untuk ngambil semua data dengan jenis spesifik
    // mengembalikan arraylist bentuk Wisata
    public ArrayList<Wisata> getDataJenisWisata(String jenisWisata, String atributKhusus) {
        ArrayList<Wisata> wisata = new ArrayList<>();
        try {
            sql = "SELECT wisata.id, nama, tempat, harga, rating, deskripsi, " + atributKhusus + " FROM wisata INNER JOIN " + jenisWisata + " ON wisata.id = " + jenisWisata + ".id";
            Connection cn = getKoneksi();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                wisata.add(new Pantai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("Yoo error cok");
        }

        return wisata;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas.pbo.jdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author zahidahhanumalzahra
 */
public class KomunitasDatabase {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/pbo_tm4"; 
    String user = "postgres"; // Username PostgreSQL
    String password = "197300"; // Password PostgreSQL
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    // Menambah data member
    public void tambah() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);

            String sql = "INSERT INTO komunitas_gengsee (id_member, nama_member, nickname) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            boolean selesai = false;
            while (!selesai) {
                System.out.println("MASUKKAN DATA MEMBER GENGSEE");
                System.out.print("ID Member: ");
                String id_member = input.readLine().trim();
                System.out.print("Nama Member: ");
                String nama_member = input.readLine().trim();
                System.out.print("Nickname Persona: ");
                String nickname = input.readLine().trim();

                pstmt.setLong(1, Long.parseLong(id_member));
                pstmt.setString(2, nama_member);
                pstmt.setString(3, nickname);
                pstmt.executeUpdate();

                System.out.print("Apakah Anda ingin memasukkan data member lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true;
                }
            }

            conn.commit();
            pstmt.close();
            conn.close();
            System.out.println("Sukses dalam satu transaksi.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi insert.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback.");
                e.printStackTrace();
            }
        }
    }

    // Menampilkan data member
    public void tampil() {
        try {
            Class.forName(driver);
            String sql = "SELECT * FROM komunitas_gengsee";
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("id_member") + ": " + rs.getString("nama_member") + " - " + rs.getString("nickname"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(KomunitasDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Menghapus data member
    public void hapus() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);

            System.out.print("Masukkan ID Member yang akan dihapus: ");
            String idMemberToDelete = input.readLine().trim();

            String deleteSql = "DELETE FROM komunitas_gengsee WHERE id_member = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, idMemberToDelete);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("ID Member " + idMemberToDelete + " berhasil dihapus!");
            } else {
                System.out.println("ID Member " + idMemberToDelete + " tidak ditemukan.");
            }

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(KomunitasDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public void update() {
        try {
            Class.forName(driver);
            String sql = "UPDATE komunitas_gengsee SET nama_member = ?, nickname = ? WHERE id_member = ?";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);
                    

            System.out.print("Masukkan ID Member yang akan diupdate: ");
            String idMember = input.readLine().trim();
            System.out.print("Nama Member baru: ");
            String namaMemberBaru = input.readLine().trim();
            System.out.print("Nickname baru: ");
            String nicknameBaru = input.readLine().trim();

            pstmt.setString(1, namaMemberBaru);
            pstmt.setString(2, nicknameBaru);
            pstmt.setLong(3, Long.parseLong(idMember));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diupdate.");
            } else {
                System.out.println("ID Member tidak ditemukan.");
            }

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(KomunitasDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Menu utama
    public void menu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Input Data");
        System.out.println("2. Tampil Data");
        System.out.println("3. Hapus Data");
        System.out.println("4. Update Data");
        System.out.println("0. Keluar");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    tambah();
                    break;
                case 2:
                    tampil();
                    break;
                case 3:
                    hapus();
                    break;
                case 4:
                    update();
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } catch (IOException ex) {
            Logger.getLogger(KomunitasDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new KomunitasDatabase().menu();
    }
}

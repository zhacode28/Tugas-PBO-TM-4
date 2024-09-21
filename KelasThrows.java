/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.pbo.jdk;


import java.util.Scanner;

public class KelasThrows {    
    public void prosesInput() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama (Throws) : ");
        
        String inputNama = scanner.nextLine(); // Membaca input dari pengguna
        if (inputNama.trim().isEmpty()) { // Memeriksa apakah nama kosong
            throw new IllegalArgumentException("Nama tidak boleh kosong!");
        }
        System.out.println("Nama yang Anda masukkan: " + inputNama);
    }

    public static void main(String[] args) {
        KelasThrows instance = new KelasThrows();
        
        try {
            instance.prosesInput(); // Memanggil metode yang melempar pengecualian
        } catch (IllegalArgumentException e) {
            // Menangani pengecualian dari metode dengan throws
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}

        
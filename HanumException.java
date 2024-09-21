/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.pbo.jdk;

/**
 *
 * @author zahidahhanumalzahra
 */
public class HanumException extends Exception {
    
    // Konstruktor custom exception
    public HanumException(String message) {
        super(message);
    }

    // Metode untuk memvalidasi nama member
    public static void validasiNamaMember(String namaMember) throws HanumException {
        if (namaMember == null || namaMember.trim().isEmpty()) {
            // Jika nama member kosong atau null, lemparkan custom exception
            throw new HanumException("Nama member tidak boleh kosong!");
        }
        System.out.println("Nama member valid: " + namaMember);
    }

    public static void main(String[] args) {
        String namaMember = ""; // Nama member kosong

        try {
            // Mencoba memvalidasi nama member
            validasiNamaMember(namaMember);
        } catch (HanumException e) {
            // Menangani custom exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}

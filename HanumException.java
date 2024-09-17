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
    public HanumException(String message) {
        super(message);
    }

  
    public static void main(String[] args) {
        try {
            // Menggunakan Exception kustom
            throw new HanumException("Ini salah");
        } catch (HanumException e) {
            // Menangkap Exception kustom
            System.err.println("Exception berhasil:");
            System.out.println(e.getMessage());
        }
    }
    
}
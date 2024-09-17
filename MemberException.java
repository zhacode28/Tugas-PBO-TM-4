/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.pbo.jdk;
// Custom Exception: MemberNotFoundException
class MemberNotFoundException extends Exception {
    public MemberNotFoundException(String message) {
        super(message);
    }
}

public class MemberException {
    private final String[] idMemberList = {"01", "02", "03", "04", "05", "06"};
    
    public void cariMember(String id_member) throws MemberNotFoundException {
        boolean ditemukan = false;
        for (String id : idMemberList) {
            if (id.equals(id_member)) {
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            throw new MemberNotFoundException("Member dengan ID " + id_member + " tidak ditemukan!");
        } else {
            System.out.println("Member dengan ID " + id_member + " ditemukan.");
        }
    }

    public static void main(String[] args) {
        MemberException komunitas = new MemberException();

        try {
            komunitas.cariMember("03");
            komunitas.cariMember("10");
        } catch (MemberNotFoundException e) {
            System.err.println("Kesalahan: " + e.getMessage());
        }
    }
}

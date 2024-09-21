## Database Member Gengsee 

Aplikasi ini adalah program sederhana yang menggunakan JDBC untuk mengelola (Menambah, mengupdate, melihat dan menghapus) data member dari komunitas Gengsee yang disimpan dalam sebuah tabel dalam database PostgreSQL.

### Menu Utama

1. Input Data: Untuk menambahkan data member baru ke dalam database saya.
2. Tampil Data: Menampilkan seluruh data member yang sudah dimasukkan.
3. Hapus Data: Menghapus data berdasarkan ID member.
4. Update Data: Memperbarui nama dan nickname member berdasarkan ID.
0. Keluar: Untuk mengakhiri program.

## Throws
Metode throws dalam kode ini memberi tahu bahwa metode prosesInput akan menyebabkan error tertentu, yaitu IllegalArgumentException. jika pengguna tidak memasukkan nama (nama dibiarkan kosong)—metode ini akan "melempar" (Throws) pengecualian tersebut.

## Try Catch
Kelas KelasTryCatch ini berfungsi untuk meminta pengguna memasukkan nama. Di dalamnya, ada metode prosesInput yang akan mengecek apakah nama yang dimasukkan kosong atau tidak. Jika kosong, metode ini akan melempar kesalahan dengan pesan bahwa nama tidak boleh kosong. Dalam metode main, program mencoba menjalankan prosesInput. Jika ada kesalahan, program akan menangkapnya dan menunjukkan pesan kesalahan kepada pengguna. Jadi, meskipun terjadi kesalahan, program tetap berjalan tanpa langsung berhenti.

## Custom Exception
Class ini mendefinisikan kelas HanumException, yang merupakan pengecualian kustom untuk memvalidasi nama anggota. Disini, Metode validasiNamaMember memeriksa apakah nama yang diberikan kosong atau null; jika iya, maka akan melempar HanumException. Dalam metode main ini, program mencoba memvalidasi nama yang kosong, dan jika terjadi kesalahan, maka pesan error akan otomatis ditampilkan. ]

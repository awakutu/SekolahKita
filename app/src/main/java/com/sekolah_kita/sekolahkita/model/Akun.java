package com.sekolah_kita.sekolahkita.model;

public class Akun {
    private String Nama, JenisKelamin, Alamat, Jurusan, Kelas;

    public Akun(String Nama,String JenisKelamin, String Alamat, String Jurusan, String Kelas){
        this.Nama = Nama;
        this.JenisKelamin = JenisKelamin;
        this.Alamat = Alamat;
        this.Jurusan = Jurusan;
        this.Kelas = Kelas;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getJenisKelamin() {
        return JenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        JenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getJurusan() {
        return Jurusan;
    }

    public void setJurusan(String jurusan) {
        Jurusan = jurusan;
    }

    public String getKelas() {
        return Kelas;
    }

    public void setKelas(String kelas) {
        Kelas = kelas;
    }
}

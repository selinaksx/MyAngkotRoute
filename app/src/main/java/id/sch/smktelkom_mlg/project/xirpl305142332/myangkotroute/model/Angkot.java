package id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.model;

import java.io.Serializable;

/**
 * Created by ASUS TP 450 LDV on 11/20/2016.
 */
public class Angkot implements Serializable{
    public String judul;
    public String deskripsi;
    public String detail;
    public String lokasi;
    public String foto;


    public Angkot(String judul, String deskripsi, String foto, String detail)
    {
        this.judul = judul;
        this.deskripsi= deskripsi;
        this.foto = foto;
        this.detail = detail;
        //this.lokasi = lokasi;

    }
}

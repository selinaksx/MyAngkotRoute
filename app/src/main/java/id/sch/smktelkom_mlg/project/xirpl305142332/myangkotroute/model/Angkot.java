package id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.model;

import android.graphics.drawable.Drawable;

/**
 * Created by ASUS TP 450 LDV on 11/20/2016.
 */
public class Angkot {
    public String judul;
    public String deskripsi;
    public Drawable foto;

    public Angkot(String judul, String deskripsi, Drawable foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}

package id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute;

import java.io.Serializable;

/**
 * Created by Nabila Basharahil on 11/22/2016.
 */
public class Angkot implements Serializable
{
    public String judul;
    public String deskripsi;

    public Angkot(String judul, String deskripsi)
    {
        this.judul = judul;
        this.deskripsi = deskripsi;
    }
}

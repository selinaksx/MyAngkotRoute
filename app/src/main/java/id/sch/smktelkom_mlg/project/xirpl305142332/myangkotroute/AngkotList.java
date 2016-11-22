package id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.Adapter.AngkotAdapter;
import id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.model.Angkot;

public class AngkotList extends AppCompatActivity implements AngkotAdapter.IAngkotAdapter{

    public static final String ANGKOT = "angkot";

    ArrayList<Angkot> mList = new ArrayList<>();
    AngkotAdapter mAdapter;
    int ItemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angkot);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AngkotAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        filldata();
    }

    private void filldata() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.places);
        String[] arDeskripsi = resources.getStringArray(R.array.place_desc);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        Drawable[] arFoto = new Drawable[a.length()];
        for (int i = 0; i < arFoto.length; i++)
        {
            arFoto[i] = a.getDrawable(i);

        }
        a.recycle();
        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Angkot(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void doClick(int pos)
    {
        Intent intent = new Intent(this, coba.class);
        intent.putExtra(ANGKOT,mList.get(pos).judul.toString());
        startActivity(intent);
    }
}

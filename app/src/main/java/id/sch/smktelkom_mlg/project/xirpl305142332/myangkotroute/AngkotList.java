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
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    ArrayList<Angkot> mListAll = new ArrayList<>();
    String mQuery;
    AngkotAdapter mAdapter;
    int ItemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angkot);
        setTitle("Angkot List");
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
        Intent intent = new Intent(this, AngkotDetails.class);
        intent.putExtra(ANGKOT,mList.get(pos).judul.toString());
        startActivity(intent);
    }


    private void doFilter(String query)
    {
        if(!isFiltered)
        {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered = true;
        }

        mList.clear();
        if (query == null||query.isEmpty())
        {
            mList.addAll(mListAll);
            isFiltered = false;
        }
        else
        {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++)
            {
                Angkot angkot = mListAll.get(i);
                if (angkot.judul.toLowerCase().contains(query)||angkot.deskripsi.toLowerCase().contains(query))
                {
                    mList.add(angkot);
                    mListMapFilter.add(i);
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }




}

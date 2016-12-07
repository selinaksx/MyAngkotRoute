package id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
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
        String[] arDetail = resources.getStringArray(R.array.place_details);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++)
        {
            int id = a.getResourceId(i,0);
                arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE+"://"
                        +resources.getResourcePackageName(id)+'/'
                        +resources.getResourceTypeName(id)+'/'
                        +resources.getResourceEntryName(id);
        }
        a.recycle();
        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Angkot(arJudul[i], arDeskripsi[i], arFoto[i],arDetail[i]));
        }
        mAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){


        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener()
                {
                    @Override
                    public boolean onQueryTextSubmit(String query)
                    {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText)
                    {
                        mQuery = newText.toLowerCase();
                        doFilter(mQuery);
                        return true;
                    }
                }
        );
        return true;
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
        intent.putExtra("judul",mList.get(pos).judul.toString());
        intent.putExtra("deskripsi",mList.get(pos).deskripsi.toString());
        intent.putExtra("foto",mList.get(pos).foto.toString());
        Log.d("APP",mList.get(pos).foto.toString());
        intent.putExtra("detail",mList.get(pos).detail.toString());
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

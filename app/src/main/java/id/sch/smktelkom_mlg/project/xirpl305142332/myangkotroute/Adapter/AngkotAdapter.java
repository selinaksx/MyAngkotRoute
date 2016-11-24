package id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.R;
import id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.model.Angkot;

/**
 * Created by ASUS TP 450 LDV on 11/20/2016.
 */
public class AngkotAdapter extends RecyclerView.Adapter<AngkotAdapter.ViewHolder> {
    ArrayList<Angkot> angkotList;
    IAngkotAdapter mIAngkotAdapter;

    public AngkotAdapter(Context context, ArrayList<Angkot> angkotList) {
        this.angkotList = angkotList;
        mIAngkotAdapter = (IAngkotAdapter) context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_angkot_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Angkot angkot = angkotList.get(position);
        holder.tvJudul.setText(angkot.judul);
        holder.tvDeskripsi.setText(angkot.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(angkot.foto));
    }


    @Override
    public int getItemCount() {
        if (angkotList != null)
            return angkotList.size();
        return 0;
    }

    public interface IAngkotAdapter
    {
        void doClick(int pos);
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);

        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
                    public void onClick(View v)
            {
                mIAngkotAdapter.doClick(getAdapterPosition());
            }
        });
    }
    }
}

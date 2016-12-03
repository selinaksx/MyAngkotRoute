package id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.AngkotList;
import id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.R;
import id.sch.smktelkom_mlg.project.xirpl305142332.myangkotroute.model.Angkot;

/**
 * Created by ASUS TP 450 LDV on 11/24/2016.
 */
public class AngkotAdapter extends RecyclerView.Adapter<AngkotAdapter.ViewHolder> {
    ArrayList<Angkot> angkotList;

    public AngkotAdapter(AngkotList list, ArrayList<Angkot> angkotList) {
        this.angkotList = angkotList;
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
        holder.ivFoto.setImageDrawable(angkot.foto);
    }

    @Override
    public int getItemCount() {
        if (angkotList != null)
            return angkotList.size();
        return 0;
    }

    public interface IAngkotAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}

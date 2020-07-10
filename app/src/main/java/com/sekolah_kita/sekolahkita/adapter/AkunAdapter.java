package com.sekolah_kita.sekolahkita.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sekolah_kita.sekolahkita.R;
import com.sekolah_kita.sekolahkita.model.Akun;

import java.util.ArrayList;

public class AkunAdapter extends RecyclerView.Adapter<AkunAdapter.AkunViewHolder> {
    private ArrayList<Akun> dataList;

    public AkunAdapter(ArrayList<Akun> dataList) {

        this.dataList = dataList;

    }

    @Override

    public AkunViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.baris_akun, parent, false);
        return new AkunViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AkunViewHolder holder, int position) {

        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtJenisKelamin.setText(dataList.get(position).getJenisKelamin());
        holder.txtAlamat.setText(dataList.get(position).getAlamat());
        holder.txtJurusan.setText(dataList.get(position).getJurusan());
        holder.txtKelas.setText(dataList.get(position).getKelas());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class AkunViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtJenisKelamin, txtAlamat, txtJurusan, txtKelas;
        public AkunViewHolder(View itemView) {
            super(itemView);
            txtNama =  itemView.findViewById(R.id.textViewNama);
            txtJenisKelamin = itemView.findViewById(R.id.textViewJenisKelamin);
            txtAlamat = itemView.findViewById(R.id.textViewAlamat);
            txtJurusan = itemView.findViewById(R.id.textViewJurusan);
            txtKelas = itemView.findViewById(R.id.textViewKelas);
        }
    }
}

package com.sekolah_kita.sekolahkita.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.sekolah_kita.sekolahkita.R;
import com.sekolah_kita.sekolahkita.adapter.AkunAdapter;
import com.sekolah_kita.sekolahkita.model.Akun;

import java.util.ArrayList;

public class fragment_akun extends Fragment {


    private RecyclerView recyclerView;
    private AkunAdapter adapter;
    private ArrayList<Akun> AkunArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_akun, container, false);
        AkunArrayList = new ArrayList<>();
        AkunArrayList.add(new Akun("Nama : Andre Diofanu", "Jenis Kelamin : Pria", "Alamat : Jalan Bondowoso", "Jurusan : RPL", "Kelas B"));
        AkunArrayList.add(new Akun("Nama : Iwan Majid", "Jenis Kelamin : Pria", "ALamat : Jalan Wlingi", "Jurusan : TKJ", "Kelas C"));
        AkunArrayList.add(new Akun("Nama : Rizky Tri Sulistyo", "Jenis Kelamin : Pria", "Alamat : Jalan Muara Teweh", "Jurusan : RPL", "Kelas D"));
        AkunArrayList.add(new Akun("Nama : Ismaiwati", "Jenis Kelamin : Peyempuan", "Alamat : Jalan Mojokerto", "Jurusan : TKJ", "Kelas E"));
        recyclerView =  view.findViewById(R.id.recycler_view);
        adapter = new AkunAdapter(AkunArrayList);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
       return  view;
    }

}

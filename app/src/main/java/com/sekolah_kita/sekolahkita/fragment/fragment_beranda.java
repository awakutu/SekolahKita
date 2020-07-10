package com.sekolah_kita.sekolahkita.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sekolah_kita.sekolahkita.PrakerinMapActivity;
import com.sekolah_kita.sekolahkita.R;

public class fragment_beranda extends Fragment {
    private ImageView prakerin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_beranda, container, false);
        prakerin = view.findViewById(R.id.imageViewLokasiPrakerin);
        prakerin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), PrakerinMapActivity.class);
                startActivity(intent);
            }

        });
        return  view;
    }



}

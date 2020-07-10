package com.sekolah_kita.sekolahkita.activity;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.sekolah_kita.sekolahkita.R;
import com.sekolah_kita.sekolahkita.fragment.fragment_akun;
import com.sekolah_kita.sekolahkita.fragment.fragment_beranda;
import com.sekolah_kita.sekolahkita.fragment.fragment_lainnya;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Default tampilan awal
        loadFragment(new fragment_lainnya());

        //inisialisasi
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);

        // listener pada item/menu bottomNavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    // Untuk load fragment
    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.FrameLayout_Kontainer, fragment)
                    .commit();
            return true;
        }
        return  false;
    }
    // untuk listener logika pemilihan
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.beranda:
                fragment = new fragment_beranda();
                break;
            case R.id.akun:
                fragment = new fragment_akun();
                break;
            case R.id.lainnya:
                fragment = new fragment_lainnya();
                break;
        }
        return loadFragment(fragment);
    }
}

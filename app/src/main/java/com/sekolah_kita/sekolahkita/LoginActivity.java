package com.sekolah_kita.sekolahkita;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sekolah_kita.sekolahkita.activity.MainActivity;

public class LoginActivity extends AppCompatActivity {

    // Deklarasi Variabel dari Objek
    private EditText ET_Email, ET_KataSandi;
    private Button Button_Daftar, Button_Masuk, Button_LupaSandi ;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Mendapatkan Firebase auth instance
        auth = FirebaseAuth.getInstance();

        //Views
        ET_Email = findViewById(R.id.editText_Email);
        ET_KataSandi       = findViewById(R.id.editTextKataSandi);
        Button_Masuk       = findViewById(R.id.button_Masuk);
        Button_Daftar      = findViewById(R.id.button_Daftar);
        Button_LupaSandi   = findViewById(R.id.button_LupaSandi);

        Button_Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = ET_Email.getText().toString().trim();
                final String KataSandi = ET_KataSandi.getText().toString().trim();
                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplicationContext(), "Mohon Isi Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(KataSandi)){
                    Toast.makeText(getApplicationContext(), "Mohon Isi Kata Sandi", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (KataSandi.length()  < 6){
                    Toast.makeText(getApplicationContext(), "Kata Sandi harus lebih dari 6", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(Email, KataSandi)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Email sudah terdaftar / periksa jaringan Anda." /*+ task.getException()*/,
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Email Berhasil Terdaftar!" /*+ task.isSuccessful()*/, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        Button_Masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = ET_Email.getText().toString().trim();
                final String KataSandi = ET_KataSandi.getText().toString().trim();
                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplicationContext(), "Mohon Isi Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(KataSandi)){
                    Toast.makeText(getApplicationContext(), "Mohon Isi Kata Sandi", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (KataSandi.length()  < 6){
                    Toast.makeText(getApplicationContext(), "Kata Sandi harus lebih dari 6", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(Email, KataSandi)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Authentikasi Gagal, Periksa Jaringan Anda." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });

        Button_LupaSandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = ET_Email.getText().toString().trim();
                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplicationContext(), "Mohon Isi Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.sendPasswordResetEmail(Email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Instruksi sandi baru telah terkirim ke Email Anda", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Gagal mengirim sandi ke Email Anda", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        }

        /*Untuk menyimpan / mengembalikan state ketika di rotate*/
    private static final String SELECTED_ITEM_POSITION = "ItemPosition";
    private int mPosition;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Read the state of item position
        mPosition = savedInstanceState.getInt(SELECTED_ITEM_POSITION);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of item position
        outState.putInt(SELECTED_ITEM_POSITION, mPosition);

    }
}




package com.wesleyaldrich.animedxd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenAnimeList = findViewById(R.id.btnOpenAnimeList);

        btnOpenAnimeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Buat Intent untuk memulai AnimeListActivity
                Intent intent = new Intent(MainActivity.this, AnimeListActivity.class);
                startActivity(intent); // Mulai Activity baru
            }
        });
    }
}
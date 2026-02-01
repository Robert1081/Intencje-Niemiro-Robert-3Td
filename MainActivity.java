package com.example.intencje1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnImieNazwisko, btnAdres, btnGeo;
    TextView tvURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImieNazwisko = findViewById(R.id.btnImieNazwisko);
        btnAdres = findViewById(R.id.btnAdres);
        btnGeo = findViewById(R.id.btnGeo);
        tvURL = findViewById(R.id.tvURL);

        // 1. Aktywność z imieniem i nazwiskiem
        btnImieNazwisko.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // 2. Otwieranie przeglądarki z URL
        btnAdres.setOnClickListener(v -> {
            String url = tvURL.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        // 3. Aktywność GPS
        btnGeo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        });
    }
}

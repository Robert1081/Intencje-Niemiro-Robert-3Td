package com.example.intencje1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    TextView tvSzer, tvDlug;
    LocationManager locManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        tvSzer = findViewById(R.id.tvSzer);
        tvDlug = findViewById(R.id.tvDlug);

        btnStop.setEnabled(false);

        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                tvSzer.setText(String.valueOf(location.getLatitude()));
                tvDlug.setText(String.valueOf(location.getLongitude()));
            }
        };

        btnStart.setOnClickListener(v -> {
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);

            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                return;
            }

            locManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    2000,
                    0,
                    listener
            );
        });

        btnStop.setOnClickListener(v -> {
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
            locManager.removeUpdates(listener);
        });
    }
}

package com.example.intencje1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = findViewById(R.id.tvSecond);
        tv.setText("Twoje Robert Niemiro\nKliknij przycisk back by wrócić do poprzedniego ekranu");
    }
}

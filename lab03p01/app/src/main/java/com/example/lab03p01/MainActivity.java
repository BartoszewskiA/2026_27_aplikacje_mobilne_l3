package com.example.lab03p01;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int licznik = 0;

    TextView textView_licznik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView_licznik = findViewById(R.id.textView_licznik);
        textView_licznik.setText(String.valueOf(licznik));

    }

    public void dodaj(View view) {
        licznik++;
        textView_licznik.setText(String.valueOf(licznik));
    }

    public void odejmij(View view) {
        licznik--;
        textView_licznik.setText(String.valueOf(licznik));
    }

    public void zeruj(View view) {
        licznik=0;
        textView_licznik.setText(String.valueOf(licznik));
    }
}
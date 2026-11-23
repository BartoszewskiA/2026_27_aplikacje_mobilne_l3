package com.example.lab07p01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    ImageView powiekszenie;
    Random random = new Random();
    int[] obrazki = {
            R.drawable.grafika_01,
            R.drawable.grafika_02,
            R.drawable.grafika_03,
            R.drawable.grafika_04};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        powiekszenie = findViewById(R.id.a2_imageView_powiekszenie);
        Intent intencja = getIntent();
        Bundle paczka = intencja.getExtras();
        int id = paczka.getInt("id");
        powiekszenie.setImageResource(id);
        powiekszenie.setOnClickListener(v -> losuj());
    }

    private void losuj() {
        int nr = random.nextInt(obrazki.length);
        powiekszenie.setImageResource(obrazki[nr]);
    }
}
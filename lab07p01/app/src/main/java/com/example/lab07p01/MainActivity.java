package com.example.lab07p01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView[] ramki = new ImageView[4];
    int[] ids = {
            R.id.imageView_01,
            R.id.imageView_02,
            R.id.imageView_03,
            R.id.imageView_04
    };
    int[] obrazki = {
            R.drawable.grafika_01,
            R.drawable.grafika_02,
            R.drawable.grafika_03,
            R.drawable.grafika_04};
    int[] miniatury = {
            R.drawable.mini_01,
            R.drawable.mini_02,
            R.drawable.mini_03,
            R.drawable.mini_04};
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
//      ramki[0]=findViewById(R.id.imageView_01);
//      ramki[1]=findViewById(R.id.imageView_02);
//      ramki[2]=findViewById(R.id.imageView_03);
//      ramki[3]=findViewById(R.id.imageView_04);

//      for (int i =0; i<ramki.length; i++)
//          ramki[i] = findViewById(ids[i]);
//
//      for (int i =0; i<ramki.length; i++)
//          ramki[i].setImageResource(miniatury[i]);
//      for (int i =0; i<ramki.length; i++)
//      {
//          final int nr = i;
//          ramki[i].setOnClickListener(v -> powiekszenie(nr));
//      }

        for (int i =0; i<ramki.length; i++)
        {
            ramki[i] = findViewById(ids[i]);
            ramki[i].setImageResource(miniatury[i]);
            final int nr = i;
            ramki[i].setOnClickListener(v -> powiekszenie(nr));
        }

    }

    private void powiekszenie(int nr)
    {
        Intent intencja = new Intent(MainActivity.this, MainActivity2.class);
        intencja.putExtra("id", obrazki[nr]);
        startActivity(intencja);
    }
}
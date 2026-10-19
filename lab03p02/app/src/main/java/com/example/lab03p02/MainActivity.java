package com.example.lab03p02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int losowa =0;
    Random random = new Random();
    EditText editText_liczba;
    TextView textView_wynik;
    Button btn_sprawdz;
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
        editText_liczba = findViewById(R.id.editText_liczba);
        textView_wynik = findViewById(R.id.textView_wynik);
        btn_sprawdz = findViewById(R.id.btn_sprawdz);
        losowa = random.nextInt(99)+1;
    }

    public void sprawdz(View view) {
       String licza_str = editText_liczba.getText().toString();
       if (licza_str.isEmpty())
       {
           return;
       }
       int liczba = Integer.parseInt(licza_str);
       if(liczba>losowa)
       {
           textView_wynik.setText("Za\ndużo");
       } else if(liczba<losowa)
       {
           textView_wynik.setText("Za\nmało");
       } else {
           textView_wynik.setText(String.valueOf(losowa));
           btn_sprawdz.setEnabled(false);
       }
    }

    public void nowa_gra(View view) {
        losowa = random.nextInt(99)+1;
        textView_wynik.setText("?");
        editText_liczba.setText("");
        btn_sprawdz.setEnabled(true);

    }
}
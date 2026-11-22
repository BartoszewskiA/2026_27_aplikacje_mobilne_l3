package com.example.lab05_atlas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String[] nazwy;
    String[] opisy;
    int[] zdjecia = {R.drawable.prawdziwek, R.drawable.podgrzybek, R.drawable.muchomor, R.drawable.kania};
    int pozycja =0;
    ImageView imageView_zdjecie;
    Button btn_wst;
    Button btn_np;
    TextView textView_tytul;
    TextView textView_opis;

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
        znajdz_uchwyty();
        imageView_zdjecie.setImageResource(zdjecia[pozycja]);
        textView_tytul.setText(nazwy[pozycja]);
        textView_opis.setText(opisy[pozycja]);

        btn_wst.setOnClickListener(v -> wstecz());
        btn_np.setOnClickListener(v -> naprzod());

    }

    private void naprzod() {
        pozycja++;
        if (pozycja >= nazwy.length) {
            pozycja = 0;
        }
        imageView_zdjecie.setImageResource(zdjecia[pozycja]);
        textView_tytul.setText(nazwy[pozycja]);
        textView_opis.setText(opisy[pozycja]);
    }

    private void wstecz() {
        pozycja--;
        if (pozycja < 0) {
            pozycja = nazwy.length - 1;
        }
        imageView_zdjecie.setImageResource(zdjecia[pozycja]);
        textView_tytul.setText(nazwy[pozycja]);
        textView_opis.setText(opisy[pozycja]);
    }

    private void znajdz_uchwyty() {
        imageView_zdjecie = findViewById(R.id.imageView_zdjecie);
        btn_wst = findViewById(R.id.btn_wst);
        btn_np = findViewById(R.id.btn_np);
        textView_tytul = findViewById(R.id.textView_tytul);
        textView_opis = findViewById(R.id.textView_opis);
        nazwy = getResources().getStringArray(R.array.nazwy);
        opisy = getResources().getStringArray(R.array.opisy);
    }
}
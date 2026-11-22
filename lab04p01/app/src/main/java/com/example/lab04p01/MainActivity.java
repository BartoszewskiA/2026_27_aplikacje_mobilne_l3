package com.example.lab04p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    
    EditText editText_dane, editText_wynik;
    Button btn_mile_angielskie, btn_mile_morskie, btn_mile_amerykanskie;
    
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
        uchwyty_kontrolek();
        sluchacze();
    }

    private void sluchacze() {
        btn_mile_angielskie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dane = editText_dane.getText().toString();
                if(dane.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Pole dane nie może byc puste", Toast.LENGTH_SHORT).show();
                    return;
                }
                double km = Double.parseDouble(dane);
                double mile = km / 1.609344;
                mile *=1000;
                mile = Math.round(mile);
                mile /=1000;
                editText_wynik.setText(String.valueOf(mile));
            }
        });
        btn_mile_morskie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dane = editText_dane.getText().toString();
                if(dane.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Pole dane nie może byc puste", Toast.LENGTH_SHORT).show();
                    return;
                }
                double km = Double.parseDouble(dane);
                double mile = km / 1.825;
                mile *=1000;
                mile = Math.round(mile);
                mile /=1000;
                editText_wynik.setText(String.valueOf(mile));
            }
        });
btn_mile_amerykanskie.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String dane = editText_dane.getText().toString();
        if(dane.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Pole dane nie może byc puste", Toast.LENGTH_SHORT).show();
            return;
        }
        double km = Double.parseDouble(dane);
        double mile = km / 1.609347;
        mile *=1000;
        mile = Math.round(mile);
        mile /=1000;
        editText_wynik.setText(String.valueOf(mile));
    }
});
    }

    private void uchwyty_kontrolek() {
        editText_dane = findViewById(R.id.editText_dane);
        editText_wynik = findViewById(R.id.editText_wynik);
        btn_mile_angielskie = findViewById(R.id.btn_mile_angielskie);
        btn_mile_morskie = findViewById(R.id.btn_mile_morskie);
        btn_mile_amerykanskie = findViewById(R.id.btn_mile_amerykanskie);
    }
}
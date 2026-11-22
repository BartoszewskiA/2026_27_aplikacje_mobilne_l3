package com.example.lab06p01;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView_info;
    Button btn_login;
    EditText editText_login;
    Button btn_unlog;

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
        uchwyty();
        sprawdz_uzytkownika();
        btn_login.setOnClickListener(v -> zaloguj());
        btn_unlog.setOnClickListener(v -> wyloguj());
    }

    private void wyloguj() {
        SharedPreferences sharedPreferences = getSharedPreferences("uzytkownicy", MODE_PRIVATE);
        SharedPreferences.Editor edytor = sharedPreferences.edit();
        edytor.putBoolean("zalogowany", false);
        edytor.putString("login", "");
        edytor.apply();
        sprawdz_uzytkownika();
    }

    private void zaloguj() {
        String name = editText_login.getText().toString();
        if (name.isEmpty()) name = "gość";
        SharedPreferences sharedPreferences = getSharedPreferences("uzytkownicy", MODE_PRIVATE);
        SharedPreferences.Editor edytor = sharedPreferences.edit();
        edytor.putBoolean("zalogowany", true);
        edytor.putString("login", name);
        edytor.apply();
        sprawdz_uzytkownika();
    }

    private void sprawdz_uzytkownika() {
        SharedPreferences sharedPreferences = getSharedPreferences("uzytkownicy", MODE_PRIVATE);
        boolean zalogowany = sharedPreferences.getBoolean("zalogowany", false);
        String login = sharedPreferences.getString("login", "gość");
        if(zalogowany){
            textView_info.setVisibility(VISIBLE);
            btn_login.setVisibility(GONE);
            btn_unlog.setVisibility(VISIBLE);
            editText_login.setVisibility(GONE);
            textView_info.setText("Zalogowano jako: " + login);
        } else
        {
            textView_info.setVisibility(GONE);
            btn_login.setVisibility(VISIBLE);
            btn_unlog.setVisibility(GONE);
            editText_login.setVisibility(VISIBLE);
        }
    }

    private void uchwyty() {
        textView_info = findViewById(R.id.textView_info);
        btn_login = findViewById(R.id.btn_login);
        btn_unlog = findViewById(R.id.btn_unlog);
        editText_login = findViewById(R.id.editText_login);

    }
}
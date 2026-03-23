package com.example.sensortempluzumb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTemperatura = findViewById(R.id.btnTemperatura);
        Button btnLuz         = findViewById(R.id.btnLuz);
        Button btnSalir       = findViewById(R.id.btnSalir);

        btnTemperatura.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,
                    TemperaturaActivity.class);
            startActivity(intent);
        });

        btnLuz.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,
                    LuzActivity.class);
            startActivity(intent);
        });

        // finish() cierra el menú y por tanto toda la app
        btnSalir.setOnClickListener(v -> finish());
    }
}

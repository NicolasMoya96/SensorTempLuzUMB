package com.example.sensortempluzumb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LuzActivity extends AppCompatActivity
        implements SensorEventListener {

    private TextView    tvLux;
    private TextView    tvNivel;
    private ProgressBar progressLuz;
    private View        ventana;

    private SensorManager sensorManager;
    private Sensor        sensorLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz);

        ventana     = this.getWindow().getDecorView();
        tvLux       = findViewById(R.id.tvLux);
        tvNivel     = findViewById(R.id.tvNivel);
        progressLuz = findViewById(R.id.progressLuz);

        sensorManager = (SensorManager)
                this.getSystemService(Context.SENSOR_SERVICE);
        sensorLuz = sensorManager
                .getDefaultSensor(Sensor.TYPE_LIGHT);

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> finish());

        Button btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(v -> finishAffinity());
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float lux = sensorEvent.values[0];
        tvLux.setText("Luz: " + lux + " lux");

        progressLuz.setMax(40000);
        progressLuz.setProgress((int) Math.min(lux, 40000));

        if (lux < 10) {
            ventana.setBackgroundResource(R.color.negro);
            tvNivel.setText("Muy Oscuro");
        } else if (lux < 50) {
            ventana.setBackgroundResource(R.color.gris_oscuro);
            tvNivel.setText("Oscuro");
        } else if (lux < 200) {
            ventana.setBackgroundResource(R.color.gris_medio);
            tvNivel.setText("Normal");
        } else if (lux < 1000) {
            ventana.setBackgroundResource(R.color.amarillo_claro);
            tvNivel.setText("Luminoso");
        } else if (lux < 10000) {
            ventana.setBackgroundResource(R.color.amarillo_sol);
            tvNivel.setText("Muy Luminoso");
        } else {
            ventana.setBackgroundResource(R.color.blanco_sol);
            tvNivel.setText("Luz Solar");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorLuz,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) { }
}
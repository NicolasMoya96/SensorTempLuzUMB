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
import android.widget.TextView;

public class TemperaturaActivity extends AppCompatActivity
        implements SensorEventListener {

    private TextView textTemp;
    private TextView tvEstado;
    private View     ventana;

    private SensorManager sensorManager;
    private Sensor        sensorTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        ventana   = this.getWindow().getDecorView();
        ventana.setBackgroundResource(R.color.azul_claro);

        textTemp  = findViewById(R.id.textTemp);
        tvEstado  = findViewById(R.id.tvEstado);

        sensorManager = (SensorManager)
                this.getSystemService(Context.SENSOR_SERVICE);
        sensorTemp = sensorManager
                .getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> finish());

        Button btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(v -> finishAffinity());
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float value = sensorEvent.values[0];
        textTemp.setText("Temp: " + value + " oC");

        if (value < 0) {
            ventana.setBackgroundResource(R.color.azul_claro);
            tvEstado.setText("Muy Frio");
        } else if (value <= 10) {
            ventana.setBackgroundResource(R.color.azul);
            tvEstado.setText("Frio");
        } else if (value <= 20) {
            ventana.setBackgroundResource(R.color.gris);
            tvEstado.setText("Fresco");
        } else if (value <= 30) {
            ventana.setBackgroundResource(R.color.amarillo);
            tvEstado.setText("Templado");
        } else if (value <= 40) {
            ventana.setBackgroundResource(R.color.naranja);
            tvEstado.setText("Caliente");
        } else {
            ventana.setBackgroundResource(R.color.rojo);
            tvEstado.setText("Muy Caliente");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorTemp,
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
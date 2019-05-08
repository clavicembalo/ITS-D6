package com.example.its_d6;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager =
                (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sensorEventListener =
                new SensorEventListener() {
                    @Override
                    public void onSensorChanged(SensorEvent event) {
                         Log.i("ACC: " ,"X: "+ event.values[0] +
                                "Y: " + event.values[1] +
                                "Z: " + event.values[2]);
                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int accuracy) {

                    }
                };

        sensorManager.registerListener(
                SensorEventListener,
                sensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
}

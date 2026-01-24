package com.albarq.ai;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AlBarqEngine alBarqEngine;
    private Switch alBarqSwitch;
    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alBarqEngine = new AlBarqEngine();
        alBarqSwitch = findViewById(R.id.switch_albarq);
        statusText = findViewById(R.id.status_text);

        alBarqSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    alBarqEngine.startEngine();
                    statusText.setText("الحالة: محرك البرق يعمل على المنفذ 8888");
                    statusText.setTextColor(android.graphics.Color.GREEN);
                } else {
                    alBarqEngine.stopEngine();
                    statusText.setText("الحالة: متوقف");
                    statusText.setTextColor(android.graphics.Color.GRAY);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (alBarqEngine != null) {
            alBarqEngine.stopEngine();
        }
    }
}

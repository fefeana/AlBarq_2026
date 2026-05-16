package com.shigi.albarq;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AlBarqEngine alBarqEngine;
    private TextView aiErrorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        alBarqEngine = new AlBarqEngine();
        aiErrorMsg = findViewById(R.id.aiErrorMsg);

        findViewById(R.id.mirageBtn).setOnClickListener(v -> safeCall("connect", "mirage"));
        findViewById(R.id.cloudBtn).setOnClickListener(v -> safeCall("connect", "cloud"));
        findViewById(R.id.reconnectBtn).setOnClickListener(v -> safeCall("reconnect", null));
        findViewById(R.id.disconnectBtn).setOnClickListener(v -> safeCall("disconnect", null));
    }

    private void safeCall(String method, String param) {
        if (alBarqEngine == null) {
            aiErrorMsg.setVisibility(View.VISIBLE);
            aiErrorMsg.setText("❌ محرك البرق غير معرف! تأكد من تحميله بشكل صحيح.");
            Toast.makeText(this, "⚡ خطأ في تشغيل المحرك", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (method) {
            case "connect":
                alBarqEngine.startEngine(param);
                Toast.makeText(this, "✅ تم الاتصال بـ " + param, Toast.LENGTH_SHORT).show();
                break;
            case "reconnect":
                alBarqEngine.reconnect();
                Toast.makeText(this, "🔄 إعادة الاتصال...", Toast.LENGTH_SHORT).show();
                break;
            case "disconnect":
                alBarqEngine.stopEngine();
                Toast.makeText(this, "⏹️ تم فصل الاتصال", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

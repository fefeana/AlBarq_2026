package com.shigi.albarq; // اسم الباكيج الخاص بمشروعك

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AlBarqEngine alBarqEngine;
    private TextView aiErrorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // إخفاء الشريط الأصفر (ActionBar)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // تعريف المحرك
        alBarqEngine = new AlBarqEngine();
        aiErrorMsg = findViewById(R.id.aiErrorMsg);

        // ربط الأزرار بالدوال
        findViewById(R.id.mirageBtn).setOnClickListener(v -> safeCall("connect", "mirage"));
        findViewById(R.id.cloudBtn).setOnClickListener(v -> safeCall("connect", "cloud"));
        findViewById(R.id.reconnectBtn).setOnClickListener(v -> safeCall("reconnect", null));
        findViewById(R.id.disconnectBtn).setOnClickListener(v -> safeCall("disconnect", null));
    }

    // دالة الحماية: تمنع انهيار التطبيق لو المحرك غير معرف
    private void safeCall(String method, String param) {
        if (alBarqEngine == null) {
            aiErrorMsg.setVisibility(View.VISIBLE);
            aiErrorMsg.setText("❌ محرك البرق غير معرف! تأكد من تحميله بشكل صحيح.");
            return;
        }
        switch (method) {
            case "connect":
                alBarqEngine.startEngine(param);
                break;
            case "reconnect":
                alBarqEngine.reconnect();
                break;
            case "disconnect":
                alBarqEngine.stopEngine();
                break;
        }
    }
}

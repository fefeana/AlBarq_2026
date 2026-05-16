package com.shigi.albarq;

public class AlBarqEngine {

    private boolean isRunning = false;
    private String currentMode = null;

    public void startEngine(String mode) {
        if (mode == null || mode.isEmpty()) {
            System.out.println("⚡ لا يمكن تشغيل المحرك بدون وضع محدد!");
            return;
        }
        isRunning = true;
        currentMode = mode;
        System.out.println("✅ محرك البرق بدأ في وضع: " + mode);
    }

    public void reconnect() {
        if (!isRunning) {
            System.out.println("⚡ المحرك غير نشط، سيتم تشغيله من جديد...");
            startEngine(currentMode != null ? currentMode : "default");
        } else {
            System.out.println("🔄 إعادة الاتصال بالمحرك في وضع: " + currentMode);
        }
    }

    public void stopEngine() {
        if (!isRunning) {
            System.out.println("⏹️ المحرك متوقف بالفعل.");
            return;
        }
        isRunning = false;
        System.out.println("⏹️ تم إيقاف محرك البرق.");
    }

    public boolean isRunning() {
        return isRunning;
    }

    public String getCurrentMode() {
        return currentMode;
    }
}

import java.io.*;
import java.net.*;

public class AlBarqEngine {
    private ServerSocket serverSocket;
    private boolean isRunning = false;
    private final int PORT = 8888;

    public void startEngine() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(PORT);
                isRunning = true;
                // رسالة تأكيد تشغيل المحرك والذكاء معاً
                System.out.println("AlBarq AI: Engine & AI Brain Link Active");

                while (isRunning) {
                    Socket clientSocket = serverSocket.accept();
                    
                    // تقوية المحرك: استدعاء الذكاء الاصطناعي لتحليل الاتصال
                    runAIBrain();
                    
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void runAIBrain() {
        try {
            // هذا هو الجسر البرمجي الذي يستدعي ملف الذكاء الخاص بك
            ProcessBuilder pb = new ProcessBuilder("python", "brain_protected.py");
            pb.start();
        } catch (Exception e) {
            System.out.println("AI Bridge Error: " + e.getMessage());
        }
    }

    public void stopEngine() {
        try {
            isRunning = false;
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

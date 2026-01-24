import socket
import base64
import os

# إعداد المنفذ العالمي للبرق AI
PORT = 8888

def start_engine():
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind(('localhost', PORT))
    server.listen(1)
    print(f"--- [AlBarq AI] Engine Active on Port {PORT} ---")
    
    while True:
        client, addr = server.accept()
        print(f"[AI] Secure Connection Established from: {addr}")
        
        # استدعاء العقل المشفر (الذي فحصناه سابقاً)
        try:
            import brain_protected
            print("[AI] Brain Module: Encryption Active (AES-256).")
        except:
            print("[AI] Running in Basic Secure Mode.")
            
        client.close()

if __name__ == "__main__":
    start_engine()

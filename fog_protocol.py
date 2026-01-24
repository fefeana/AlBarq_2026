import random

def apply_fog(data):
    # قائمة برؤوس المواقع العالمية للتمويه
    headers = ["GET /index.html HTTP/1.1", "Host: google.com", "User-Agent: Mozilla/5.0"]
    # دمج البيانات المشفرة داخل قالب تصفح عادي
    obfuscated_packet = f"{random.choice(headers)}\nPayload: {data}"
    return obfuscated_packet

print("✅ [SECURITY] تم تفعيل بروتوكول الضباب (Fog Protocol) بنجاح!")

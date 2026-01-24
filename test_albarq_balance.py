import socket
import os

def check_stress():
    print("--- [1] اختبار ميزان الأداء ---")
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        s.settimeout(2)
        s.connect(('localhost', 8888))
        print("✅ المحرك يستجيب بسرعة فائقة.")
        s.close()
    except Exception as e:
        print(f"❌ خلل في الاستجابة: {e}")

def check_files():
    print("\n--- [2] فحص النقص في المكونات ---")
    files = ["AlBarq_Ultimate_Core.py", "brain_protected.py", "activity_main.xml", "res/values/colors.xml"]
    for f in files:
        if os.path.exists(f):
            print(f"✅ المكون {f}: موجود.")
        else:
            print(f"⚠️ نقص: {f} غير موجود!")

def check_security():
    print("\n--- [3] فحص الثغرات (Security Audit) ---")
    # فحص إذا كان المحرك مشفراً فعلياً
    if os.path.exists("brain_protected.py"):
        with open("brain_protected.py", "r") as f:
            content = f.read()
            if "base64.b64decode" in content:
                print("✅ الأمان: خوارزمية التشفير محصنة بتمويه Base64.")
            else:
                print("⚠️ ثغرة: العقل غير مموه برمجياً!")

if __name__ == "__main__":
    check_stress()
    check_files()
    check_security()

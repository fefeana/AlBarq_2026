import base64

def protect_albarq_brain():
    try:
        with open("brain.py", "r") as f:
            source_code = f.read()
        
        # تحويل الكود إلى طبقة مشفرة (Obfuscation)
        protected_layer = base64.b64encode(source_code.encode()).decode()
        
        with open("brain_protected.py", "w") as f:
            f.write(f"import base64\n# AlBarq AI Protected Module\nexec(base64.b64decode('{protected_layer}').decode())")
        
        print("\n✅ [SECURITY] تم تشفير 'عقل البرق' بنجاح!")
        print("✅ [SECURITY] الملف المحمي الجديد: brain_protected.py")
    except Exception as e:
        print(f"❌ خطأ في التشفير: {e}")

if __name__ == "__main__":
    protect_albarq_brain()

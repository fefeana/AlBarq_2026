#!/bin/bash
echo "--- [AlBarq AI] بدء عملية التجميع النهائي (النسخة المصححة) ---"
# إنشاء هيكلية المجلدات
mkdir -p build/assets
# نسخ المكونات الأساسية بالأسماء الصحيحة
cp brain_protected.py build/assets/
cp AlBarq_Ultimate_Core.py build/
cp -r res build/
echo "✅ تم تجميع كافة المكونات بنجاح في مجلد: build/"
echo "🛡️ 'البرق AI' الآن في كامل جاهزيته داخل مجلد التجميع."

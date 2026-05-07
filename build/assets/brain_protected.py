python
from Crypto.Cipher import AES
from Crypto.Random import getrandombytes
from Crypto.Protocol.KDF import PBKDF2
import base64

class AlBarqSecureTunnel:
    def init(self, password: str, salt: bytes = None):
        # توليد Salt عشوائي إذا ما أعطيت واحد
        self.salt = salt or getrandombytes(16)
        # اشتقاق مفتاح AES‑256 من كلمة المرور باستخدام PBKDF2
        self.key = PBKDF2(password, self.salt, dkLen=32, count=200000)

    def encrypt(self, data: str) -> str:
        iv = getrandombytes(12)  # GCM يحتاج IV بطول 12 بايت
        cipher = AES.new(self.key, AES.MODE_GCM, nonce=iv)
        encrypted, tag = cipher.encryptanddigest(data.encode())
        payload = self.salt + iv + tag + encrypted
        return base64.b64encode(payload).decode()

    def decrypt(self, encoded_payload: str, password: str) -> str:
        payload = base64.b64decode(encoded_payload)
        salt, iv, tag, encrypted = payload[:16], payload[16:28], payload[28:44], payload[44:]
        # إعادة توليد المفتاح بنفس كلمة المرور و Salt
        key = PBKDF2(password, salt, dkLen=32, count=200000)
        cipher = AES.new(key, AES.MODE_GCM, nonce=iv)
        decrypted = cipher.decryptandverify(encrypted, tag)
        return decrypted.decode()

if name == "main":
    print("--- AlBarq AI Global Protection Active ---")
    tunnel = AlBarqSecureTunnel(password="كوالبرق")  # كلمة مرور شعائرية
    testpacket = "PsiphonRequestPort8888"

    encrypted = tunnel.encrypt(test_packet)
    print(f"[AI] Secure Payload: {encrypted}")

    decrypted = tunnel.decrypt(encrypted, password="كوالبرق")
    print(f"[AI] Status: Original='{test_packet}', Decrypted='{decrypted}'")
`

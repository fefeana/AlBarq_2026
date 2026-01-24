// ملف الـ UI الرئيسي لتطبيق ارعد وابرق
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AlBarqMainScreen() {
    // حالة الاتصال (True = متصل / False = غير متصل)
    var isConnected by remember { mutableStateOf(false) }

    // تغيير الثيم بناءً على "الاستشعار بالوقت"
    val backgroundColor = if (isDayTime()) Color(0xFFF5F5F5) else Color(0xFF080808)

    Surface(modifier = Modifier.fillMaxSize(), color = backgroundColor) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            // 1. الأيقونة المضيئة (Status Icon)
            AtomicLightningIcon(isConnected)

            // 2. العداد الرقمي الثابت (Fixed Speed Counter)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = if (isConnected) "450.5" else "0.0",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isConnected) Color(0xFFFFD700) else Color.Gray
                )
                Text(text = "Mbps", fontSize = 18.sp, color = Color.Gray)
            }

            // 3. زر الاتصال الفيزيائي
            Button(
                onClick = { isConnected = !isConnected },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isConnected) Color.Red else Color(0xFFFFD700)
                ),
                modifier = Modifier.height(60.dp).width(200.dp)
            ) {
                Text(
                    text = if (isConnected) "قطع الاتصال" else "ارعد وابرق الآن",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            
            // 4. مؤشر درع الحماية (Security Badge)
            SecurityBadge(isConnected)
        }
    }
}
ه


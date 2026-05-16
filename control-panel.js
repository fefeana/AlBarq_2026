import { loadUserData, loadProjects, loadLogs } from "./database";

export function renderControlPanel(userId) {
  const panel = document.createElement("div");
  panel.id = "control-panel";
  panel.style.padding = "20px";
  panel.style.border = "2px solid gold";
  panel.style.borderRadius = "10px";
  panel.style.backgroundColor = "#f9f9f9";
  panel.style.display = "grid";
  panel.style.gridGap = "10px";

  // زر تحديث البيانات (مباشر)
  const refreshBtn = document.createElement("button");
  refreshBtn.innerText = "🔄 تحديث البيانات";
  refreshBtn.onclick = () => {
    loadUserData(userId);   // يقرأ بيانات المستخدم
    loadProjects();         // يقرأ المشاريع
    loadLogs();             // يقرأ اللوغز (Admins فقط)
  };

  // زر إرسال تقرير بالبريد
  const emailBtn = document.createElement("button");
  emailBtn.innerText = "📧 إرسال تقرير بالبريد";
  emailBtn.onclick = () => {
    console.log("Sending report via email...");
  };

  panel.appendChild(refreshBtn);
  panel.appendChild(emailBtn);

  document.body.appendChild(panel);
}

package com.adoptly.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String index() {
        return "<html><head><title>Adoptly API Dashboard</title>" +
               "<style>" +
               "body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f0f2f5; padding: 40px; color: #333; }" +
               ".container { max-width: 1000px; margin: auto; background: white; padding: 30px; border-radius: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.1); }" +
               "h1 { color: #2c3e50; text-align: center; border-bottom: 3px solid #3498db; padding-bottom: 15px; }" +
               "table { width: 100%; border-collapse: collapse; margin-top: 20px; }" +
               "th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }" +
               "th { background-color: #f8f9fa; }" +
               ".btn { padding: 6px 12px; border: none; border-radius: 5px; cursor: pointer; color: white; font-weight: bold; text-decoration: none; display: inline-block; }" +
               ".get { background-color: #61affe; }" +
               ".post { background-color: #49cc90; }" +
               ".put { background-color: #fca130; }" +
               ".delete { background-color: #f93e3e; }" +
               "#result-box { margin-top: 30px; padding: 20px; background: #272822; color: #f8f8f2; border-radius: 10px; min-height: 50px; white-space: pre-wrap; font-family: monospace; }" +
               "</style>" +
               "<script>" +
               "function callApi(method, url, body = null) {" +
               "  const resultBox = document.getElementById('result-box');" +
               "  resultBox.innerText = 'İstek gönderiliyor...';" +
               "  fetch(url, { method: method, headers: { 'Content-Type': 'application/json' }, body: body ? JSON.stringify(body) : null })" +
               "    .then(res => res.ok ? res.json() : res.text())" +
               "    .then(data => { resultBox.innerText = JSON.stringify(data, null, 2); })" +
               "    .catch(err => { resultBox.innerText = 'Hata: ' + err; });" +
               "}" +
               "</script>" +
               "</head><body>" +
               "<div class='container'>" +
               "<h1>🐾 Adoptly API İnteraktif Test Paneli</h1>" +
               "<p style='text-align:center;'>Aşağıdaki butonlara tıklayarak API uç noktalarını anlık test edebilirsiniz.</p>" +
               
               "<table>" +
               "<tr><th>İşlem</th><th>Metot</th><th>Endpoint</th><th>Test Et</th></tr>" +
               
               "" +
               "<tr><td>Tüm İlanlar</td><td><span class='btn get'>GET</span></td><td>/api/animals</td><td><button onclick=\"callApi('GET', '/api/animals')\">Çalıştır</button></td></tr>" +
               "<tr><td>Hayvan Detay (ID:1)</td><td><span class='btn get'>GET</span></td><td>/api/animals/1</td><td><button onclick=\"callApi('GET', '/api/animals/1')\">Çalıştır</button></td></tr>" +
               "<tr><td>Kedi Filtrele</td><td><span class='btn get'>GET</span></td><td>/api/animals/search</td><td><button onclick=\"callApi('GET', '/api/animals/search?species=Cat')\">Çalıştır</button></td></tr>" +
               
               "" +
               "<tr><td>Yeni İlan Ekle</td><td><span class='btn post'>POST</span></td><td>/api/animals</td><td><button onclick=\"callApi('POST', '/api/animals', {name:'Pamuk', species:'Cat', age:2, status:'AVAILABLE'})\">Ekle</button></td></tr>" +
               "<tr><td>Kullanıcı Kayıt</td><td><span class='btn post'>POST</span></td><td>/api/auth/register</td><td><button onclick=\"callApi('POST', '/api/auth/register', {firstName:'Victus', email:'v@test.com', password:'123'})\">Kaydet</button></td></tr>" +
               "<tr><td>İlan Sil (ID:1)</td><td><span class='btn delete'>DELETE</span></td><td>/api/animals/1</td><td><button onclick=\"callApi('DELETE', '/api/animals/1')\">Sil</button></td></tr>" +
               "<tr><td>Başvurularım</td><td><span class='btn get'>GET</span></td><td>/api/applications/my</td><td><button onclick=\"callApi('GET', '/api/applications/my?userId=1')\">Listele</button></td></tr>" +

               "</table>" +
               
               "<h3>🖥️ API Yanıtı (JSON Output)</h3>" +
               "<div id='result-box'>Burada henüz bir veri yok. Yukarıdaki butonlardan birine basın!</div>" +

               "<br><hr>" +
               "<p style='text-align: center;'>Geliştiren: <b>Victus (syzeybek)</b> | Adoptly Projesi 2026</p>" +
               "</div></body></html>";
    }
}
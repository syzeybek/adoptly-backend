package com.adoptly.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String index() {
        return "<html><head><title>Adoptly API Interactive Dashboard</title>" +
               "<style>" +
               "body { font-family: 'Segoe UI', sans-serif; background-color: #f8f9fa; padding: 40px; color: #333; }" +
               ".container { max-width: 1100px; margin: auto; background: white; padding: 40px; border-radius: 20px; box-shadow: 0 15px 35px rgba(0,0,0,0.1); }" +
               "h1 { color: #2c3e50; text-align: center; border-bottom: 4px solid #3498db; padding-bottom: 15px; margin-bottom: 30px; }" +
               "table { width: 100%; border-collapse: collapse; margin-top: 20px; }" +
               "th, td { padding: 15px; text-align: left; border-bottom: 1px solid #eee; }" +
               "th { background-color: #fcfcfc; color: #7f8c8d; text-transform: uppercase; font-size: 12px; }" +
               ".btn-tag { padding: 4px 8px; border-radius: 4px; color: white; font-weight: bold; font-size: 11px; display: inline-block; width: 60px; text-align: center; }" +
               ".get { background-color: #61affe; } .post { background-color: #49cc90; } .put { background-color: #fca130; } .delete { background-color: #f93e3e; }" +
               "button { padding: 8px 16px; border: none; border-radius: 6px; cursor: pointer; background-color: #34495e; color: white; transition: 0.3s; }" +
               "button:hover { background-color: #2c3e50; transform: translateY(-2px); }" +
               "#result-box { margin-top: 30px; padding: 25px; background: #1e1e1e; color: #d4d4d4; border-radius: 12px; min-height: 100px; white-space: pre-wrap; font-family: 'Consolas', monospace; font-size: 14px; border-left: 5px solid #3498db; }" +
               "</style>" +
               "<script>" +
               "function callApi(method, url, body = null) {" +
               "  const resultBox = document.getElementById('result-box');" +
               "  resultBox.innerText = 'İstek gönderiliyor...';" +
               "  const options = { method: method, headers: { 'Content-Type': 'application/json' } };" +
               "  if (body) options.body = typeof body === 'string' ? body : JSON.stringify(body);" +
               "  fetch(url, options)" +
               "    .then(res => res.status === 204 ? {message: 'Başarıyla Silindi'} : (res.ok ? res.json() : res.text()))" +
               "    .then(data => { resultBox.innerText = JSON.stringify(data, null, 2); })" +
               "    .catch(err => { resultBox.innerText = 'Hata: ' + err; });" +
               "}" +
               "</script>" +
               "</head><body>" +
               "<div class='container'>" +
               "<h1>🐾 Adoptly Proje Test Paneli</h1>" +
               "<p style='text-align:center; color: #666;'>Victus, tüm Postman senaryoların burada! Sırasıyla test edebilirsin.</p>" +
               
               "<table>" +
               "<tr><th>Sıra</th><th>İşlem Adı</th><th>Metot</th><th>Endpoint</th><th>Aksiyon</th></tr>" +
               
               "" +
               "<tr><td>1</td><td>Kullanıcı Kaydı</td><td><span class='btn-tag post'>POST</span></td><td>/api/auth/register</td><td><button onclick=\"callApi('POST', '/api/auth/register', {firstName:'Victus', lastName:'Zeybek', email:'victus@adoptly.com', password:'Sifre123', role:'USER'})\">Kaydet</button></td></tr>" +
               "<tr><td>2</td><td>Giriş Yap</td><td><span class='btn-tag post'>POST</span></td><td>/api/auth/login</td><td><button onclick=\"callApi('POST', '/api/auth/login', {email:'victus@adoptly.com', password:'Sifre123'})\">Giriş Yap</button></td></tr>" +
               
               "" +
               "<tr><td>3</td><td>Yeni İlan Oluştur</td><td><span class='btn-tag post'>POST</span></td><td>/api/animals</td><td><button onclick=\"callApi('POST', '/api/animals', {name:'Pamuk', species:'Cat', age:2, gender:'Female', status:'AVAILABLE', description:'Çok tatlı bir kedi', imageUrl:'https://images.com/pamuk.jpg'})\">Ekle</button></td></tr>" +
               "<tr><td>4</td><td>Tüm İlanları Listele</td><td><span class='btn-tag get'>GET</span></td><td>/api/animals</td><td><button onclick=\"callApi('GET', '/api/animals')\">Listele</button></td></tr>" +
               "<tr><td>5</td><td>İlan Detayı (ID:1)</td><td><span class='btn-tag get'>GET</span></td><td>/api/animals/1</td><td><button onclick=\"callApi('GET', '/api/animals/1')\">Detay Getir</button></td></tr>" +
               
               "" +
               "<tr><td>6</td><td>İlan Güncelle (ID:1)</td><td><span class='btn-tag put'>PUT</span></td><td>/api/animals/1</td><td><button onclick=\"callApi('PUT', '/api/animals/1', {name:'Pamuk Prenses', species:'Cat', age:3, gender:'Female', status:'AVAILABLE'})\">Güncelle</button></td></tr>" +
               "<tr><td>7</td><td>Hayvan Filtrele (Cat)</td><td><span class='btn-tag get'>GET</span></td><td>/api/animals/search</td><td><button onclick=\"callApi('GET', '/api/animals/search?species=Cat')\">Filtrele</button></td></tr>" +
               
               "" +
               "<tr><td>8</td><td>Sahiplenme Başvurusu</td><td><span class='btn-tag post'>POST</span></td><td>/api/applications</td><td><button onclick=\"callApi('POST', '/api/applications?userId=1&animalId=1', 'Onu sahiplenmek istiyorum, çok heyecanlıyım!')\">Başvur</button></td></tr>" +
               "<tr><td>9</td><td>Başvurularımı Listele</td><td><span class='btn-tag get'>GET</span></td><td>/api/applications/my</td><td><button onclick=\"callApi('GET', '/api/applications/my?userId=1')\">Başvurularım</button></td></tr>" +
               
               "" +
               "<tr><td>10</td><td>İlan Kaldırma (ID:1)</td><td><span class='btn-tag delete'>DELETE</span></td><td>/api/animals/1</td><td><button onclick=\"callApi('DELETE', '/api/animals/1')\">İlanı Sil</button></td></tr>" +

               "</table>" +
               
               "<h3>🖥️ Canlı Sunucu Yanıtı (JSON)</h3>" +
               "<div id='result-box'>Postman testlerini başlatmak için yukarıdaki butonlara tıkla!</div>" +

               "<br><hr>" +
               "<p style='text-align: center; color: #95a5a6;'><b>Geliştiren:</b> Victus (syzeybek) | Yazılım Mühendisliği 2026</p>" +
               "</div></body></html>";
    }

    @GetMapping("/api/ping")
    public String ping() {
        return "Backend Ayakta!";
    }
}
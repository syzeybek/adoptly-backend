package com.adoptly.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String index() {
        return "<html><head><title>Adoptly API Documentation</title>" +
               "<style>" +
               "body { font-family: 'Segoe UI', Tahoma, sans-serif; background-color: #f4f7f6; padding: 40px; color: #333; }" +
               ".container { max-width: 1100px; margin: auto; background: white; padding: 40px; border-radius: 15px; box-shadow: 0 5px 25px rgba(0,0,0,0.1); }" +
               "h1 { color: #2c3e50; border-bottom: 4px solid #3498db; padding-bottom: 15px; text-align: center; }" +
               "h2 { color: #2980b9; margin-top: 40px; border-left: 5px solid #3498db; padding-left: 10px; }" +
               ".request-box { background: #eef2f3; padding: 15px; border-radius: 8px; margin: 10px 0; border-left: 4px solid #61affe; }" +
               ".response-box { background: #272822; color: #f8f8f2; padding: 15px; border-radius: 8px; font-family: monospace; overflow-x: auto; white-space: pre-wrap; }" +
               ".tag { padding: 4px 8px; border-radius: 4px; color: white; font-weight: bold; font-size: 12px; }" +
               ".post { background: #49cc90; } .get { background: #61affe; } .put { background: #fca130; } .delete { background: #f93e3e; }" +
               "</style></head><body>" +
               "<div class='container'>" +
               "<h1>🐾 Adoptly Backend API Teknik Dökümantasyonu</h1>" +
               "<p style='text-align:center;'>Aşağıda Postman üzerinde gerçekleştirilen 10 temel senaryonun giriş (Request) ve çıkış (Response) verileri yer almaktadır.</p>" +

               "<h2>1. Kullanıcı Kaydı (Register)</h2>" +
               "<div class='request-box'><span class='tag post'>POST</span> <code>/api/auth/register</code></div>" +
               "<b>Request Body:</b><pre>{ \"firstName\": \"HP\", \"lastName\": \"Vıctus\", \"email\": \"victus@adoptly.com\", \"password\": \"Sifre123\", \"role\": \"USER\" }</pre>" +
               "<b>Postman Output:</b><div class='response-box'>{ \"id\": 1, \"firstName\": \"HP\", \"lastName\": \"Vıctus\", \"email\": \"victus@adoptly.com\", \"role\": \"USER\" }</div>" +

               "<h2>2. Kullanıcı Girişi (Login)</h2>" +
               "<div class='request-box'><span class='tag post'>POST</span> <code>/api/auth/login</code></div>" +
               "<b>Request Body:</b><pre>{ \"email\": \"victus@adoptly.com\", \"password\": \"Sifre123\" }</pre>" +
               "<b>Postman Output:</b><div class='response-box'>\"SUCCESSFUL_LOGIN: Welcome HP Vıctus\"</div>" +

               "<h2>3. Yeni İlan Oluşturma</h2>" +
               "<div class='request-box'><span class='tag post'>POST</span> <code>/api/animals</code></div>" +
               "<b>Request Body:</b><pre>{ \"name\": \"Pamuk\", \"species\": \"Cat\", \"age\": 2, \"gender\": \"Female\", \"status\": \"AVAILABLE\", \"description\": \"Çok tatlı bir kedi\", \"imageUrl\": \"https://images.com/pamuk.jpg\" }</pre>" +
               "<b>Postman Output:</b><div class='response-box'>{ \"id\": 1, \"name\": \"Pamuk\", \"species\": \"Cat\", \"age\": 2, \"gender\": \"Female\", \"status\": \"AVAILABLE\" ... }</div>" +

               "<h2>4. Tüm İlanları Listeleme</h2>" +
               "<div class='request-box'><span class='tag get'>GET</span> <code>/api/animals</code></div>" +
               "<b>Postman Output:</b><div class='response-box'>[ { \"id\": 1, \"name\": \"Pamuk\", \"species\": \"Cat\", \"status\": \"AVAILABLE\" } ]</div>" +

               "<h2>5. İlan Detayı Görüntüleme</h2>" +
               "<div class='request-box'><span class='tag get'>GET</span> <code>/api/animals/1</code></div>" +
               "<b>Postman Output:</b><div class='response-box'>{ \"id\": 1, \"name\": \"Pamuk\", \"species\": \"Cat\", \"age\": 2, \"description\": \"Çok tatlı bir kedi\" }</div>" +

               "<h2>6. İlan Güncelleme</h2>" +
               "<div class='request-box'><span class='tag put'>PUT</span> <code>/api/animals/1</code></div>" +
               "<b>Request Body:</b><pre>{ \"name\": \"Pamuk Prenses\", \"species\": \"Cat\", \"age\": 3, \"status\": \"AVAILABLE\" }</pre>" +
               "<b>Postman Output:</b><div class='response-box'>{ \"id\": 1, \"name\": \"Pamuk Prenses\", \"age\": 3, \"status\": \"AVAILABLE\" }</div>" +

               "<h2>7. Hayvan Filtreleme (Arama)</h2>" +
               "<div class='request-box'><span class='tag get'>GET</span> <code>/api/animals/search?species=Cat</code></div>" +
               "<b>Postman Output:</b><div class='response-box'>[ { \"id\": 1, \"name\": \"Pamuk Prenses\", \"species\": \"Cat\" } ]</div>" +

               "<h2>8. Sahiplenme Başvurusu Yapma</h2>" +
               "<div class='request-box'><span class='tag post'>POST</span> <code>/api/applications?userId=1&animalId=1</code></div>" +
               "<b>Request Body (Text):</b><pre>\"Onu sahiplenmek istiyorum, çok heyecanlıyım!\"</pre>" +
               "<b>Postman Output:</b><div class='response-box'>{ \"id\": 1, \"user\": { \"id\": 1, \"firstName\": \"Victus\" }, \"animal\": { \"id\": 1, \"name\": \"Pamuk Prenses\" }, \"message\": \"Onu sahiplenmek istiyorum...\" }</div>" +

               "<h2>9. Başvurularımı Listeleme</h2>" +
               "<div class='request-box'><span class='tag get'>GET</span> <code>/api/applications/my?userId=1</code></div>" +
               "<b>Postman Output:</b><div class='response-box'>[ { \"id\": 1, \"animalName\": \"Pamuk Prenses\", \"status\": \"PENDING\" } ]</div>" +

               "<h2>10. İlan Kaldırma (Delete)</h2>" +
               "<div class='request-box'><span class='tag delete'>DELETE</span> <code>/api/animals/1</code></div>" +
               "<b>Postman Output:</b><div class='response-box'>HTTP 200 OK (No Content)</div>" +

               "<br><hr>" +
               "<p style='text-align: center;'>Geliştiren: <b>Victus (syzeybek)</b> | Adoptly Project 2026</p>" +
               "</div></body></html>";
    }

    @GetMapping("/api/ping")
    public String ping() {
        return "Backend Ayakta!";
    }
}
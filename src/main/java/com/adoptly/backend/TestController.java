package com.adoptly.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String index() {
        return "<html><body style='font-family: Arial, sans-serif; line-height: 1.4; padding: 30px; max-width: 900px; margin: auto; background-color: #f4f7f6;'>" +
               "<div style='background: white; padding: 30px; border-radius: 15px; box-shadow: 0 4px 15px rgba(0,0,0,0.1);'>" +
               "<h1 style='color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px;'>🐾 Adoptly API Rehberi</h1>" +
               "<p>Proje şu an <b>canlıdadır.</b> Postman testleri için aşağıdaki uç noktaları kullanabilirsiniz:</p>" +
               
               "<h3>1. Hayvan İlan Yönetimi (Animals)</h3>" +
               "<table border='1' cellpadding='10' style='border-collapse: collapse; width: 100%;'>" +
               "<tr style='background: #3498db; color: white;'><th>İşlem</th><th>Metot</th><th>Endpoint / Link</th></tr>" +
               "<tr><td>Yeni İlan Oluştur</td><td><b>POST</b></td><td><code>/api/animals</code></td></tr>" +
               "<tr><td>Tüm İlanları Listele</td><td><b>GET</b></td><td><a href='/api/animals' target='_blank'>/api/animals</a></td></tr>" +
               "<tr><td>İlan Detayı (ID:1)</td><td><b>GET</b></td><td><a href='/api/animals/1' target='_blank'>/api/animals/1</a></td></tr>" +
               "<tr><td>İlan Güncelle (ID:1)</td><td><b>PUT</b></td><td><code>/api/animals/1</code></td></tr>" +
               "<tr><td>İlan Kaldır (ID:1)</td><td><b>DELETE</b></td><td><code>/api/animals/1</code></td></tr>" +
               "<tr><td>Arama & Filtreleme</td><td><b>GET</b></td><td><a href='/api/animals/search?species=Cat' target='_blank'>/api/animals/search?species=Cat</a></td></tr>" +
               "</table>" +

               "<h3>2. Kullanıcı & Güvenlik (Auth)</h3>" +
               "<table border='1' cellpadding='10' style='border-collapse: collapse; width: 100%;'>" +
               "<tr style='background: #2ecc71; color: white;'><th>İşlem</th><th>Metot</th><th>Endpoint</th></tr>" +
               "<tr><td>Kullanıcı Kaydı</td><td><b>POST</b></td><td><code>/api/auth/register</code></td></tr>" +
               "<tr><td>Giriş Yap</td><td><b>POST</b></td><td><code>/api/auth/login</code></td></tr>" +
               "</table>" +

               "<h3>3. Sahiplenme Başvuruları (Applications)</h3>" +
               "<table border='1' cellpadding='10' style='border-collapse: collapse; width: 100%;'>" +
               "<tr style='background: #e67e22; color: white;'><th>İşlem</th><th>Metot</th><th>Endpoint / Link</th></tr>" +
               "<tr><td>Başvuru Yap</td><td><b>POST</b></td><td><code>/api/applications?userId=1&animalId=1</code></td></tr>" +
               "<tr><td>Başvurularımı Listele</td><td><b>GET</b></td><td><a href='/api/applications/my?userId=1' target='_blank'>/api/applications/my?userId=1</a></td></tr>" +
               "</table>" +

               "<br><hr>" +
               "<p style='text-align: center; color: #7f8c8d;'><b>Geliştiren:</b> Victus (syzeybek) | Adoptly Project 2026</p>" +
               "</div></body></html>";
    }

    @GetMapping("/api/ping")
    public String ping() {
        return "Backend Ayakta!";
    }
}
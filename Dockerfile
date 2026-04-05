# 1. Aşama: Build (İnşa) - Maven ile projeyi derliyoruz
FROM maven:3.8.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Aşama: Run (Çalıştırma) - Sadece JRE kullanarak hafif bir imaj oluşturuyoruz
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Build aşamasından çıkan .jar dosyasını kopyalıyoruz
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
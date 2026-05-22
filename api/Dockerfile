# Usar una imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR del proyecto al contenedor
# Nota: Asegúrate de haber ejecutado 'mvn clean install' antes de construir la imagen
COPY presentacion/target/presentacion-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

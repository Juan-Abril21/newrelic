# Usa una imagen base adecuada (ajusta según tu versión de Java)
FROM openjdk:17-jdk-slim

# Crear la carpeta donde irá el agente de New Relic
RUN mkdir -p /usr/local/newrelic

# Copiar el agente y su configuración al contenedor
ADD ./newrelic/newrelic.jar /usr/local/newrelic/newrelic.jar
ADD ./newrelic/newrelic.yml /usr/local/newrelic/newrelic.yml

# Copiar tu aplicación .jar al contenedor (ajusta la ruta si es necesario)
ADD ./build/libs/NewRelicPatrones-0.0.1-SNAPSHOT.jar /usr/local/app/app.jar

# Exponer el puerto si tu app lo necesita
EXPOSE 8080

# Iniciar la app con el agente de New Relic activado
ENTRYPOINT ["java", "-javaagent:/usr/local/newrelic/newrelic.jar", "-jar", "/usr/local/app/app.jar"]

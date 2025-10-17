FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app/notas
COPY . .
RUN mvn -B -DskipTests=false clean package

FROM eclipse7-temurin:21-jre
WORKDIR /app/notas
# garantizar que exista la carpeta dentro de la imagen
RUN mkdir -p /app/notas/data
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# usar la variable $PORT que Render proporciona en tiempo de ejecución
CMD ["sh", "-c", "mkdir -p /app/data && java -Dserver.port=${PORT:-8080} -jar /app/app.jar"]

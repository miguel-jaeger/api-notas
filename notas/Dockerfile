# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app/notas
COPY . .
RUN mvn -B -DskipTests=false clean package

# Etapa runtime
FROM eclipse-temurin:21-jre
WORKDIR /app/notas
RUN mkdir -p /app/notas/data
COPY --from=build /app/notas/target/*.jar app.jar
EXPOSE 8080
CMD ["sh", "-c", "mkdir -p /app/notas/data && java -Dserver.port=${PORT:-8080} -jar /app/notas/app.jar"]

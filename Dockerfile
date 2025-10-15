# Use imagem do Maven com JDK 17
FROM maven:3.9.2-eclipse-temurin-17-alpine

WORKDIR /app

# Copia pom.xml e código
COPY pom.xml .
COPY src ./src

# Build da aplicação
RUN mvn package -DskipTests

# Comando de dev (hot reload)
CMD ["mvn", "spring-boot:run"]

# Estágio 1: Build do projeto com Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copia apenas o pom.xml primeiro (para aproveitar o cache de dependências)
COPY pom.xml .

# Baixa as dependências (essa camada será armazenada em cache se o pom.xml não mudar)
RUN mvn dependency:go-offline -B

# Copia o código-fonte
COPY src ./src

# Compila o projeto
RUN mvn package -DskipTests

# Estágio 2: Cria a imagem final
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o JAR gerado no estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
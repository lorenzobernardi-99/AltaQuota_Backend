# Fase 1: Build (Costruire l'applicazione)
# Usiamo un'immagine con il JDK (Java Development Kit) per compilare il codice
FROM eclipse-temurin:17-jdk-jammy AS build

# Imposta la directory di lavoro
WORKDIR /build

# Copia i file del progetto
# Copiamo prima pom.xml per sfruttare la cache di Docker
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY src src

# Aggiungi i permessi di esecuzione!
RUN chmod +x mvnw

# Esegui il build con Maven (questo risolve anche il problema dei permessi!)
RUN ./mvnw clean package -DskipTests

# Fase 2: Run (Eseguire l'applicazione)
# Usiamo un'immagine più leggera solo con il JRE (Java Runtime Environment)
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copia solo il file .jar compilato dalla fase di build
COPY --from=build /build/target/gestionale-0.0.1-SNAPSHOT.jar app.jar

# Esponi la porta 8080 (anche se Render la gestisce in automatico)
EXPOSE 8080

# Comando per avviare l'applicazione

ENTRYPOINT ["java", "-jar", "app.jar"]

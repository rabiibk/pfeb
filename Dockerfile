# Utiliser une image de base Java
FROM openjdk:11

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le jar généré dans le répertoire de travail
COPY target/springboot-crud-api-0.0.1-SNAPSHOT.jar /app/springboot-crud-api-0.0.1-SNAPSHOT.jar

# Exposer le port sur lequel l'application Java s'exécute (ajuster si nécessaire)
EXPOSE 8090

# Commande pour démarrer l'application au lancement du conteneur
CMD ["java", "-jar", "springboot-crud-api-0.0.1-SNAPSHOT.jar"]

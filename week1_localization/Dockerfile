# Use a known-good OpenJDK base image
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy project files
COPY . .

RUN mvn clean package

CMD ["java", "-jar", "target/week1_localization-1.jar"]
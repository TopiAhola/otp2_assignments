# Use a known-good OpenJDK base image
FROM eclipse-temurin:21-jdk



# Install dependencies for GUI + Maven build
RUN apt-get update && \
    apt-get install -y maven wget unzip libgtk-3-0 libgbm1 libx11-6 && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copy project files
COPY . .

# Build the shaded JAR
RUN mvn clean package -DskipTests

# List target folder to check JAR
RUN ls -l target


CMD ["java", "-jar", "target/week1_localization.jar"]
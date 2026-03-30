# Use a known-good OpenJDK base image
FROM eclipse-temurin:21-jdk


WORKDIR .

# Copy project files including local javafx libraray
COPY . .

# display for Xming   // ENV DISPLAY=host.docker.internal:0.0
ENV DISPLAY=host.docker.internal:0

#try installing japanese fonts
RUN apt-get update && \
apt-get install -y \
fonts-liberation \
fonts-dejavu-core \
fonts-noto-core \
fonts-noto-cjk \
fontconfig \
libfreetype6 \
locales \
&& locale-gen ja_JP.UTF-8 \
&& rm -rf /var/lib/apt/lists/*

#rebuild font cache
RUN fc-cache -fv


#Install dependencies for GUI + Maven build
RUN apt-get update && \
    apt-get install -y maven wget unzip libgtk-3-0 libgbm1 libx11-6 && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Download JavaFX SDK 21
RUN wget https://download2.gluonhq.com/openjfx/21/openjfx-21_linux-x64_bin-sdk.zip -O /tmp/openjfx.zip && \
    unzip /tmp/openjfx.zip -d /opt && \
    rm /tmp/openjfx.zip

#copy JavaFX SDK 21 from local source
#COPY ./JavaFX_SDK_21/javafx-sdk-21.0.10 ./opt/javafx-sdk-21.0.10


RUN mvn dependency:resolve

RUN mvn clean package -DskipTests

#javafx lib:  javaFX_SDK/javafx-sdk-21/lib
# Run the **shaded JAR** with JavaFX modules  (locla javafxsdk : "/javaFX_SDK/javafx-sdk-21/lib")
##CMD ["java", "--module-path", "./javaFX_SDK/javafx-sdk-21/lib", "--add-modules", "javafx.base,javafx.controls,javafx.fxml,javafx.graphics", "-jar", "./target/week2_localization.jar"]
# java --module-path "./javaFX_SDK/javafx-sdk-21/lib" "--add-modules" "javafx.fxml,javafx.graphics,javafx.controls,javafx.base" "-jar" ./target/week2_localization.jar

CMD ["java", "--module-path", "/opt/javafx-sdk-21/lib", "--add-modules", "javafx.fxml,javafx.graphics,javafx.controls,javafx.base", "-jar", "target/week2_localization.jar"]
FROM bellsoft/liberica-runtime-container:jdk-21-glibc
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]
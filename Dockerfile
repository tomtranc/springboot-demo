FROM amazoncorretto:latest

RUN mkdir -p /deployment

COPY target/${project.build.finalName}.war /deployment/ROOT.war

ENTRYPOINT ["java", "-jar", "/deployment/ROOT.war"]
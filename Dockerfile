#docker build -t product-service:latest .
FROM registry.access.redhat.com/ubi8/openjdk-11-runtime

COPY ./build/resources/main/entrypoint.sh /home/jboss/entrypoint.sh
COPY ./build/libs/*.jar /home/jboss/service.jar

USER root
RUN chmod 755 /home/jboss/entrypoint.sh
USER jboss

ENTRYPOINT ["/home/jboss/entrypoint.sh"]
EXPOSE 8001

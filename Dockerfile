FROM java:alpine
ADD target/dropwizard-dockerized.jar /data/dropwizard-dockerized.jar
ADD conf /data/conf
CMD java -jar /data/dropwizard-dockerized.jar server /data/conf/$ENV_NAME/config.yml
EXPOSE 8080
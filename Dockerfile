FROM registry.saas.hand-china.com/tools/mysql:8.0

COPY docker/mysql/sakila-data.sql sakila-data.sql  
COPY docker/mysql/sakila-schema.sql sakila-schema.sql


FROM registry.saas.hand-china.com/hap-cloud/base:latest

# mvn clean package


ADD target/app.jar app.jar
RUN java-jar app.jar





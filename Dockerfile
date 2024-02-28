FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/coffee-order-0.0.1-SNAPSHOT.jar coffee-order.jar
ENTRYPOINT [ "jar", "-java", "coffee-order.jar" ]
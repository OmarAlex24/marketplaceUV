./mvnw clean package -DskipTests && docker rm java_db java_app && docker image rm postgres:latest mercadito-uv && docker-compose up
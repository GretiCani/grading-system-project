
cd ./auth-server
mvn clean package -DskipTests

cd ..
cd ./discovery-server 
mvn clean package -DskipTests

cd ..
cd ./gateway-service
mvn clean package -DskipTests

cd ..
cd ./professor-service
mvn clean package -DskipTests

cd ..
cd ./student-service
mvn clean package -DskipTests

cd ..
cd ./evaluation-service
mvn clean package -DskipTests

cd ..
cd ./notification-service
mvn clean package -DskipTests


cd ..

cd ./docker

docker-compose build
docker-compose up 





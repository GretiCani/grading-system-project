docker-compose -f ./docker/docker-compose-mongo.yml up -d
docker-compose -f ./docker/docker-compose-kafka.yml up -d
docker-compose -f ./docker/docker-compose-elastic-kibana.yml up -d 
docker-compose -f ./docker/docker-compose-pro-grafana.yml up  -d
docker-compose -f ./docker/docker-compose.yml up --build
docker-compose -f ./docker/docker-compose-external-services.yml up --build -d

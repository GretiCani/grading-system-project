docker-compose -f ./docker/docker-compose-kafka.yml up -d 
docker-compose -f ./docker/docker-compose-elastic-kibana.yml up -d 
docker-compose -f ./docker/docker-compose-external-services.yml up  -d
docker-compose -f ./docker/docker-compose-external-services.yml up --build -d
docker-compose -f ./docker/docker-compose.yml up --build

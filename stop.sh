docker-compose -f ./docker/docker-compose-mongo.yml down
docker-compose -f ./docker/docker-compose-kafka.yml down
docker-compose -f ./docker/docker-compose-elastic-kibana.yml down
docker-compose -f ./docker/docker-compose-pro-grafana.yml down
docker-compose -f ./docker/docker-compose-external-services.yml down
docker-compose -f ./docker/docker-compose.yml down

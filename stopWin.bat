@echo off

docker-compose "-f" "%CD%\docker\docker-compose-kafka.yml" "down"
docker-compose "-f" "%CD%\docker\docker-compose-elastic-kibana.yml" "down"
docker-compose "-f" "%CD%\docker\docker-compose-pro-grafana.yml" "down"
docker-compose "-f" "%CD%\docker\docker-compose-external-services.yml" "down"
docker-compose "-f" "%CD%\docker\docker-compose.yml" "down"

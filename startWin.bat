@echo off

docker-compose "-f" "%CD%\docker\docker-compose-kafka.yml" "up" "-d"
docker-compose "-f" "%CD%\docker\docker-compose-external-services.yml" "up" "--build" "-d"
docker-compose "-f" "%CD%\docker\docker-compose.yml" "up" "--build"

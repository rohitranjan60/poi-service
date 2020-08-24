### poi-service
This service can be used to get nearby places such as Restuarants, Parking and Charging areas. 

## Configuration
application port 8080
redis port 6379

### Installation with Docker
run the docker-build.sh to build the docker image

create a redis container with 6379 port( if redis is already running on a different port then change it on application.properties)

`docker run --name redis -p 6379:6379 -d redis:latest`


run the docker image to start up the application

`docker container run -it -p 8080:8080 -d poi-service:0.0.1`

## Test
http://localhost:8080/nearby-places/52.5159,13.3777
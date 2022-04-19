# Swagger generated server

build image 
mvn clean package -pl shop-service -am jib:dockerBuild -Dimage=tructxn/shop-service -DskipTests=true
mvn clean package -pl order-service -am jib:dockerBuild -Dimage=tructxn/order-service -DskipTests=true

build image to push to docker hub 
docker push new-repo:tagname

running database 
 docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
 
 running app locally
 docker run -p 8082:8082 --env  db.host='207.148.71.168' tructxn/order-service
 
 running app in vm. 
 docker run -p 8082:8082 --env  db.host='127.0.0.1' tructxn/order-service
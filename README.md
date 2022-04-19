# Swagger generated server

build image 
mvn clean package -pl shop-service -am jib:dockerBuild -Dimage=tructxn/shop-service -DskipTests=true
mvn clean package -pl order-service -am jib:dockerBuild -Dimage=tructxn/order-service -DskipTests=true

build image to push to docker hub 
docker push new-repo:tagname

running database 
 docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
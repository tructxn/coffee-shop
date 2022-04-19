# Swagger generated server

build image 
mvn clean package -pl shop-service -am jib:dockerBuild -Dimage=tructxn/shop-service -DskipTests=true
mvn clean package -pl order-service -am jib:dockerBuild -Dimage=tructxn/order-service -DskipTests=true

build image to push to docker hub 
docker push new-repo:tagname

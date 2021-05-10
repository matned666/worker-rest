FROM adoptopenjdk/openjdk11:ubi
ADD target/workerrest-GREEN_TREE.jar .
CMD java -jar workerrest-GREEN_TREE.jar
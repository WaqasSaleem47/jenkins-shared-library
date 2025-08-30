#!/usr/bin/env groovy
def call(String imageName) {
    echo "building the docker image..."
    sh "docker build -t $imageName ."
    sh "docker tag $imageName localhost:90/java-maven-app:4.0"
}
#!/usr/bin/env groovy
def call() {
    echo "building the docker image..."
    sh 'docker build -t waqassaleem/java-maven-app:4.0 .'
    sh 'docker tag waqassaleem/java-maven-app:4.0 localhost:90/java-maven-app:4.0'
}
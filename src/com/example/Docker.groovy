#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }
    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName ."
        script.sh "docker tag $imageName localhost:90/java-maven-app:4.0"
    }
}
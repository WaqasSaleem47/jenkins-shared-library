#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }
    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.sh "docker build -t waqassaleem/$imageName ."
        script.sh "docker tag waqassaleem/$imageName localhost:90/$imageName"
    }
    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerHub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }
    def dockerPush(String imageName){
        script.sh "docker push waqassaleem/$imageName"
        script.sh "docker push localhost:90/$imageName"
    }
}
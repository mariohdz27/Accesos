pipeline {
    agent any
    tools {
        jdk "java 17"
         'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }	
  environment {
    MAVEN_ARGS=" -e clean install"

  }
  triggers {
    pollSCM('* * * * *')
  }
  stages {  	  
  
    stage('Docker  build') {
      steps {
            echo '----------------- This is a docker-compose phase ----------'
            sh 'docker build -t backend .'
        }
    }
    stage('Docker compose ') {
      steps {
            echo '----------------- This is a docker-compose phase ----------'
            sh 'docker-compose up -d'
        }
    }
  }
}
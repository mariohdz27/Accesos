pipeline {
    agent any
    tools {
        jdk "java 17"
        'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }	
  environment {
    MAVEN_ARGS=" -e clean install"
    registry = ""
    dockerContainerName = 'access-api'
    dockerImageName = 'access'
  }
  stages {
     
 	stage('clean container') {
      steps {
      script {
          docker.withRegistry('https://docker.mycorp.com/') {     	  	
    	  	bat 'docker build -t backend .'
    	  	bat 'docker-compose up -d'
          }
      }
      
      }
    }
  }
}
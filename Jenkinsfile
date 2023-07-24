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
    	  	sh 'java -version'
    	  	sh 'docker build -t backend .'
    	  	sh 'docker-compose up -d'
          }
      }
      
      }
    }
  }
}
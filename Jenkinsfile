pipeline {
    agent any
    tools {
        jdk "java 17"
    }	
  environment {
    MAVEN_ARGS=" -e clean install"

  }
  triggers {
    pollSCM('* * * * *')
  }
  stages {  	  
    stage('Add docker') {
      steps {
            echo '-----------------Imagen de jenkins ----------'
            sh 'docker build -t root/jenkins .'
        }
    }
    stage('Prueba'){
        
        steps {
            echo '----------------- This is a docker-compose phase ----------'
            sh 'docker run -d -p8080:8080 -v /var/run/docker.sock:/var/run/docker.sock su nombre de root/jenkins .'
        }
    }

   
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
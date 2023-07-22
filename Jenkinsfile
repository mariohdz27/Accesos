pipeline {
    agent any
    tools {
        jdk "java 17"
    }	
  environment {
    MAVEN_ARGS=" -e clean install"
    registry = ""
    dockerContainerName = 'myapp-main'
    dockerImageName = 'backend'
  }
  triggers {
    pollSCM('* * * * *')
  }
  stages {
    stage('Docker  build') {
      steps {
            echo '----------------- This is a docker build phase ----------'
            sh 'docker build -t backend .'
        }
    }
    stage('Docker compose build') {
      steps {
            echo '----------------- This is a docker-compose phase ----------'
            sh 'docker-compose up -d'
        }
    }
  }
}
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
  	  
    stage('Docker compose build') {
      steps {
            echo '----------------- This is a docker-compose phase ----------'
            sh 'docker-compose up -d --force-recreate --remove-orphans --build myapp-main'
        }
    }
  }
}
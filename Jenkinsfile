pipeline {
    agent any
    tools {
        jdk "java 17"
        'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }	
  environment {
    DOCKER_IMAGE = 'ms_access'
    DOCKER_CONTAINER = 'ms_accesos'
  }
  stages {
   
 
    stage('limpiando contenedor') {
      steps {
      script {
          docker.withRegistry('https://docker.mycorp.com/') {   
    	  	sh ' docker stop  $(DOCKER_CONTAINER) || (echo "Contenedor $(DOCKER_CONTAINER) no puede ser detenido"; exit 0)'
    	  	sh ' docker rm  $(DOCKER_CONTAINER) || (echo "Contenedor $(DOCKER_CONTAINER) no puede ser removido"; exit 0)'
          }
      	}
      }
    }
    stage('limpiando image') {
      steps {
      script {
          docker.withRegistry('https://docker.mycorp.com/') {   
    	  	sh 'docker image rm $(DOCKER_IMAGE) || (echo "Imagen $(DOCKER_IMAGE) no puedes ser removida"; exit 0)'
          }
      	}
      }
    }
    stage('Creando imagen') {
      steps {
      script {
          docker.withRegistry('https://docker.mycorp.com/') {   
    	  	sh 'docker build -t ${DOCKER_IMAGE} .'
          }
      	}
      }
    }
    stage('Ejecutando docker-compose') {
      steps {
      script {
          docker.withRegistry('https://docker.mycorp.com/') {   
    	  	sh 'docker-compose up -d'
          }
      	}
      }
    }
  }
}
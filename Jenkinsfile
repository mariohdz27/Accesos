pipeline {
    agent any
    tools {
            'org.jenkinsci.plugins.docker.commons.tools.DockerTool' '18.09'
    }	
  environment {
    DOCKER_CERT_PATH = credentials('id-for-a-docker-cred')
  }
  stages {
    stage('foo') {
      steps {
        sh "docker version" // DOCKER_CERT_PATH is automatically picked up by the Docker client
      }
    }
  }
}
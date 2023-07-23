pipeline {
	agent any
	tools {
	    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
	}
    stages {
        stage('Test') {
            steps {
    docker.withRegistry('repo','credentials') { 
         	sh 'node --version'    
		    
		}
            }
        }
    }
}
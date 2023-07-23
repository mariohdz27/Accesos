pipeline {
	tools {
	    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
	}
    stages {
        stage('Test') {
            steps {
                docker.withTool('docker'){
   			 docker.withRegistry { 
         	sh 'docker -v'    
		    }
		}
            }
        }
    }
}
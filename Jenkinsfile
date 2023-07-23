pipeline {
	tools {
	    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
	}
    stages {
        stage('Test') {
            steps {
                docker.withTool('docker'){
         	sh 'docker -v'    	    
		}
            }
        }
    }
}
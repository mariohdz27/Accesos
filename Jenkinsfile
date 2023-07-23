pipeline {
	agent any
	tools {
	    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
	}
    stages {
        stage('Test') {
            steps {
            	script {
	            docker.withRegistry('https://docker.mycorp.com/') { 
         			sh 'docker -v'    
		    
				}    
	            }
    			
            }
        }
    }
}
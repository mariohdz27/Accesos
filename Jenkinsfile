pipeline {
    agent any
    tools {
        jdk "java 17",
        'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'

    }	
  environment {
    MAVEN_ARGS=" -e clean install"
  }

  stages {  	  
	stage('Probanjdo docker'){
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
pipeline {
	tools {
	    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
	}
    stages {
        stage('Test') {
            steps {
                docker.withRegistry('https://docker.mycorp.com/') {
  def myImg = docker.image('myImg')
  // or docker.build, etc.
  sh "docker pull --all-tags ${myImg.imageName()}"
  // runs: docker pull --all-tags docker.mycorp.com/myImg
}
            }
        }
    }
}
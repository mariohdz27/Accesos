pipeline {
    agent any
    tools {
        jdk "java 17"
    }

    stages {
     
        stage('Construir Proyecto') {
            steps {
                // Aquí puedes especificar los comandos de construcción del proyecto Spring
                // Por ejemplo, para Maven:
                sh 'mvn clean package'
            }
        }


        stage('creando imagen ') {
            steps {
                // Agregar aquí los comandos para desplegar el proyecto en el servidor de aplicaciones
                // Por ejemplo, para desplegar en Tomcat:
                sh 'docker build -t backend .'
            }
        }
        stage('ejecuntando docker-compose ') {
            steps {
                // Agregar aquí los comandos para desplegar el proyecto en el servidor de aplicaciones
                // Por ejemplo, para desplegar en Tomcat:
                sh 'docker-compose up -d'
            }
        }
    }

    post {
        // Acciones que se ejecutarán después de la ejecución de las etapas
        success {
            echo 'El despliegue fue exitoso. ¡Felicidades!'
        }
        failure {
            echo 'El despliegue falló. Revise los registros para más información.'
        }
    }
}
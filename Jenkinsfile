pipeline { 
    agent any
    tools { 
        maven 'Maven 3.6.0' 
	gradle "Gradle 4.10.2"
    }
    stages { 
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage('Gradle Build') { 
            steps { 
               echo 'Bulding Supersede IF with Gradle'
	       sh 'gradle build -x test'
            }
        }

	stage ('Maven Build') {
            steps {
                sh 'mvn -s/var/jenkins_home/settings.xml clean package -DskipTests' 
            }
        }
    }
}

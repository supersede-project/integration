pipeline {
    agent { docker { image 'gradle:4.2.0' } }
    stages {
        stage('build') {
            steps {
		sh 'cd IF/API/eu.supersede.if.api'
                sh 'gradle build'
            }
        }
    }
}

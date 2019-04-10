pipeline {
    agent { docker { image 'gradle:4.2.0' } }
    stages {
        stage('build') {
            steps {
                sh 'gradle -p IF/API/eu.supersede.if.api build'
            }
        }
    }
}

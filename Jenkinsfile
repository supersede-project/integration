pipeline {
    agent { docker { image 'gradle:4.2.0' }.withRun('--network=host') }
    stages {
        stage('build') {
            steps {
                sh 'gradle -p IF/API/eu.supersede.if.api build'
            }
        }
    }
}

pipeline {
    agent { 
	docker { 
	    image 'gradle:4.2.0' 
	    args '--network=host'
	} 
    }
    stages {
        stage('build') {
            steps {
                sh 'gradle -p IF/API/eu.supersede.if.api build'
            }
        }
    }
}

pipeline {
    agent none
    stages {
        stage('build') {
	    agent { 
		docker { 
	    	   image 'gradle:4.2.0' 
	    	   args '--network=host'
		} 
    	    }
            steps {
                sh 'gradle -p IF/API/eu.supersede.if.api build'
            }
        }
	stage ('descartes') {
	    agent { 
		docker { 
	    	   image 'maven:3.6.0' 
	    	   args '--network=host -v /var/jenkins_home:/supersede'
		} 
    	    }	    
	    steps {	
		sh 'mvn -s /supersede/settings.xml -f IF/API/eu.supersede.if.api/pom.xml clean package -DskipTests'
		sh 'mvn -s /supersede/settings.xml -f IF/API/eu.supersede.if.api/pom_descartes.xml org.pitest:pitest-maven:mutationCoverage -DmutationEngine=descartes'
	    }
	}
    }
}

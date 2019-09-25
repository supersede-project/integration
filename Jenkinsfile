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
/*	stage ('descartes') {
	    agent { 
		docker { 
	    	   image 'maven:3.6.0' 
	    	   args '--network=host -v /var/jenkins_home:/supersede'
		} 
    	    }	    
	    steps {	
		echo 'Running Descartes on SUPERSEDE IF..'
		sh 'mvn -s /supersede/settings.xml -f IF/API/eu.supersede.if.api/pom.xml clean package'
		sh 'mvn -s /supersede/settings.xml -f IF/API/eu.supersede.if.api/pom_descartes.xml org.pitest:pitest-maven:mutationCoverage -DmutationEngine=descartes'
	    }
	}
*/
/*	stage ('dspot') {
	    when { equals expected: true, actual: false }

	    agent { 
		docker { 
	    	   image 'maven:3.6.0' 
	    	   args '--network=host -v /var/jenkins_home:/supersede'
		} 
    	    }	    
	    steps {	
		echo 'Running Dspot on SUPERSEDE IF..'
		script {
		    sh '''		    
		    
		    	#NOTE: Copy /var/jenkins_home/settings.xml into /roo/.m2 folder of Jenkins container
		    	mvn -s /supersede/settings.xml -f IF/API/eu.supersede.if.api/pom.xml clean package -DskipTests

		    	#Time out:
		    	TIMEOUT = 30000

			#Selectors: PitMutantScoreSelector,JacocoCoverageSelector,TakeAllSelector,ChangeDetectorSelector
			DSPOT_SELECTOR = JacocoCoverageSelector

			#Amplifiers: MethodAdd,MethodRemove,TestDataMutator,MethodGeneratorAmplifier,ReturnValueAmplifier,StringLiteralAmplifier,
			#NumberLiteralAmplifier, BooleanLiteralAmplifier,CharLiteralAmplifier,AllLiteralAmplifiers,NullifierAmplifier,None
			SPOT_AMPLIFIERS = AllLiteralAmplifiers,MethodGeneratorAmplifier,ReturnValueAmplifier,NullifierAmplifier

			#Iterations (default=3):
			DSPOT_ITERACTIONS = 3

			#Target Test:
			TARGET_TEST = eu.supersede.integration.api.adaptation.dashboard.proxies.test.AdaptationDashboardProxyTest

			#Number of amplified tests (default=200)
			MAX_TEST_AMPLIFIED = 300

			#Budgetizer (NoBudgetizer|SimpleBudgetizer)
			BUGETIZER = NoBudgetizer

			DSPOT_OPTS = "-Diteration=$DSPOT_ITERACTIONS -Dtest=$TARGET_TEST -Damplifiers=$DSPOT_AMPLIFIERS -Dtest-criterion=$DSPOT_SELECTOR -DtimeOut=$TIMEOUT -Dmax-test-amplified=$MAX_TEST_AMPLIFIED -Dbudgetizer=$BUGETIZER -Dclean -Dverbose"

			echo "DSpot configuration: " $DSPOT_OPTS
			DSPOT_PROPERTIES="./dspot.properties"

			#NOTE: Copy /var/jenkins_home/settings.xml into /roo/.m2 folder of Jenkins container
			mvn -s /supersede/settings.xml -f IF/API/eu.supersede.if.api/pom.xml eu.stamp-project:dspot-maven:amplify-unit-tests -Dpath-to-properties=$DSPOT_PROPERTIES $DSPOT_OPTS

		    '''
		}
	    }
	}
*/
    }
}

pipeline { 
    agent any
    parameters{
	string(name: 'TARGET_TEST', defaultValue: 'eu.supersede.integration.api.adaptation.dashboard.proxies.test.AdaptationDashboardProxyTest', description: 'The target test to amplify with DSpot')
    }
    tools { 
        maven 'Maven 3.6.0' 
	gradle "Gradle 4.10.2"
    }
    stages { 
/*        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
*/
/*        stage('Gradle Build') { 
            steps { 
               echo 'Bulding Supersede IF with Gradle'
	       sh '''
		   cd IF/API/eu.supersede.if.api
		   gradle build -x test
	       '''
            }
        }
*/
	stage ('Maven Build') {
            steps {
                sh '''
		    cd IF/API/eu.supersede.if.api
		    mvn clean package -DskipTests
		''' 
            }
        }

/*	stage ('Descartes') {
            steps {
                sh '''
		    cd IF/API/eu.supersede.if.api
		    mvn clean package -DskipTests
		    cp /var/jenkins_home/ifaccount.properties src/test/resources/
		    DATE=`date '+%Y%m%d%H%M'`
		    DESCARTES_OUT=./target/pit-reports/$DATE
		    mvn -s/var/jenkins_home/settings.xml -f pom_descartes.xml org.pitest:pitest-maven:mutationCoverage -DmutationEngine=descartes

		    #Storing Descartes execution in descartes-usecases-output
		    RESULTS_DIR=/var/jenkins_home/workspace/descartes-usecases-output/atos/supersede/if/mutation-score/baseline/descartes/$DATE/
		    cp -r $DESCARTES_OUT $RESULTS_DIR

		    cd $RESULTS_DIR
		    git checkout master
		    git add *
		    git commit -m "Descartes execution results for Supersede IF"
		''' 
            }
        }
*/
	stage ('Dspot') {
            steps {
		sh '''#!/bin/bash -xe
		    cd IF/API/eu.supersede.if.api
		    cp /var/jenkins_home/ifaccount.properties src/test/resources/
		    mvn clean package -DskipTests

		    #Time out:
		    TIMEOUT=30000

		    #Selectors: PitMutantScoreSelector,JacocoCoverageSelector,TakeAllSelector,ChangeDetectorSelector
		    DSPOT_SELECTOR=JacocoCoverageSelector

		    #Amplifiers: MethodAdd,MethodRemove,TestDataMutator,MethodGeneratorAmplifier,ReturnValueAmplifier,StringLiteralAmplifier,
		    #NumberLiteralAmplifier,BooleanLiteralAmplifier,CharLiteralAmplifier,AllLiteralAmplifiers,NullifierAmplifier,None
		    #AllLiteralAmplifiers,MethodGeneratorAmplifier,ReturnValueAmplifier,NullifierAmplifier
DSPOT_AMPLIFIERS=MethodAdd,MethodRemove,TestDataMutator,MethodGeneratorAmplifier,ReturnValueAmplifier,StringLiteralAmplifier,NumberLiteralAmplifier,BooleanLiteralAmplifier,CharLiteralAmplifier,AllLiteralAmplifiers,NullifierAmplifier

		    #Iterations (default=3):
		    DSPOT_ITERACTIONS=3

		    #Target Test:
		    #TARGET_TEST=eu.supersede.integration.api.adaptation.dashboard.proxies.test.AdaptationDashboardProxyTest

		    #Number of amplified tests (default=200)
		    MAX_TEST_AMPLIFIED=200

		    #Budgetizer (RandomBudgetizer | TextualDistanceBudgetizer | SimpleBudgetizer>)
		    BUGETIZER=RandomBudgetizer

		    DSPOT_OPTS="-Diteration=$DSPOT_ITERACTIONS -Dtest=$TARGET_TEST -Damplifiers=$DSPOT_AMPLIFIERS -Dtest-criterion=$DSPOT_SELECTOR -DtimeOut=$TIMEOUT -Dmax-test-amplified=$MAX_TEST_AMPLIFIED -Dbudgetizer=$BUGETIZER -Dclean -Dverbose"

		    echo "DSpot configuration: " $DSPOT_OPTS
		    DSPOT_PROPERTIES="./dspot.properties"

		    DSPOT_OUT=./dspot-out/
		    DSPOT_AMPLIFIERS_PATH=${DSPOT_AMPLIFIERS//,/-}
		    RESULTS_DIR=/var/jenkins_home/workspace/dspot-usecases-output/atos/supersede/IF/DSpot
		    RESULTS_DIR=$RESULTS_DIR/$DSPOT_SELECTOR/$DSPOT_AMPLIFIERS_PATH/`date '+%Y%m%d%H%M'`
		    mkdir -p $RESULTS_DIR
		    filename=$RESULTS_DIR/dspot.cmd

		    echo "Starting DSpot: reporting in file" + $filename
		    echo "Started DSpot: `date`" > $filename
		    echo "DSpot CLI configuration: " $DSPOT_OPTS >> $filename
		    echo "DSpot properties file: " $DSPOT_PROPERTIES >> $filename

		    mvn -f pom_dspot.xml eu.stamp-project:dspot-maven:amplify-unit-tests -Dpath-to-properties=$DSPOT_PROPERTIES $DSPOT_OPTS

		    #Storing DSpot execution in dspot-usecases-output
		    cp -r $DSPOT_OUT $RESULTS_DIR
		    cp $DSPOT_PROPERTIES $RESULTS_DIR

		    cd $RESULTS_DIR
		    git checkout master
		    git add *
		    git commit -m "DSpot execution results for amplification of test class(es): $TARGET_TEST"
		'''
	    }
	}
    }
}

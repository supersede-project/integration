export MAVEN_HOME=/home/opt/maven
export PATH=$PATH:$MAVEN_HOME/bin
mvn -s/var/jenkins_home/settings.xml clean package -DskipTests
mvn -s/var/jenkins_home/settings.xml -f pom_descartes.xml org.pitest:pitest-maven:mutationCoverage -DmutationEngine=descartes

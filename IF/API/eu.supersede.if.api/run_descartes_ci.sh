export MAVEN_HOME=/usr/local/maven
export PATH=$PATH:$MAVEN_HOME/bin
/usr/local/maven/bin/mvn -s/var/jenkins_home/settings.xml clean package -DskipTests
/usr/local/maven/bin/mvn -s/var/jenkins_home/settings.xml -f pom_descartes.xml org.pitest:pitest-maven:mutationCoverage -DmutationEngine=descartes

FROM openjdk:8
COPY ./supersede-if-botsing/ /home/supersede-if-botsing
COPY ./src /home/src
COPY ./pom.xml /home/pom.xml
COPY ./create_classpath.sh /home/
COPY ./generate_behavioral_models.sh /home/
COPY ./target/dependency/* /home/dependency/
COPY ./run_evosuite.sh /home/
COPY ./run_evosuite_experiment.sh /home/
WORKDIR /home/
RUN apt-get update;apt-get install vim maven -y

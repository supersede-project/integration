#!/bin/sh
mvn -f pom_for_descartes.xml test org.pitest:pitest-maven:mutationCoverage

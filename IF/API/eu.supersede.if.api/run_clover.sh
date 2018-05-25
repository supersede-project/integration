#!/bin/sh
mvn -f pom_clover.xml clean clover:setup test clover:aggregate clover:clover

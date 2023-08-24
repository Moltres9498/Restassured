package com.restassured.genric;
/**
 * This interface stores all required credentials of data base login
 * @author pc
 */
public interface Icredentials {

	String dbURL="jdbc:mysql://rmgtestingserver:3333/projects";
	String dbUN="root@%";
	String dbPQ="root";
	
	String appUN="rmgyantra";
	String appPW="rmgy@9999";
	
	String URL="http://rmgtestingserver:8084";
}
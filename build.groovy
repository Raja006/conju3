#!/usr/bin/groovy
def call(body) {
    // evaluate the body block, and collect configuration into the object
	// configParameters(artifactType,artifactTypeZip)
    def pipelineParams = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    def msg = pipelineParams.get("msg", "Hello World")
if(msg.equals("Gradle")) {
    stage('GRADLE_BUILD') {
     echo "${msg}"
    }
   }
else if(msg.equals("Maven")) {
    stage('MAVEN_BUILD') {
     echo "${msg}"
    }
   }
}
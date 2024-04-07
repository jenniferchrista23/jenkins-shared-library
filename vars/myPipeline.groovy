import com.library.common.*;
import com.library.java.*;

def call(Map pipelineParams) {

    pipeline {
        agent {
            label 'built-in'
        }
        tools {
            maven 'maven-3.9.6'
        } 

        options {
           buildDiscarder(logRotator(numToKeepStr: "$count"))
           disableConcurrentBuilds()
        }   

        stages {
            stage('envParameters') {
                steps {
                    script {
                       def envParam = new javaParams()
                       envParam.variable()
                       def systemVariable = new systemVariables()
                       systemVariable.sysvar()
                    }   
                }
            } 

            stage ('CleanWorkspace') {
                steps {
                    cleanWs()
                }   
            }

            stage('Checkout') {
                steps {
                    script { 
                        def systemVariable = new systemVariables()
                        systemVariable.sysvar()
                        def codeCheckOut = new codeCheckOut()
                        codeCheckOut.gitClone(pipelineParams.branchName, url)
                    }
                }
            } 

            stage('Build') {
                steps {
                    script { 
                        def envParam = new javaParams()
                        envParam.variable()
                        def systemVariable = new systemVariables()
                        systemVariable.sysvar()
                        def build = new buildMaven()
                        build.maven(goals)
                    }
                }
            } 

            stage('Run') {
                steps {
                    script { 
                        def envParam = new javaParams()
                        envParam.variable()
                        def systemVariable = new systemVariables()
                        systemVariable.sysvar()
                        def runJava = new javaRun()
                        runJava.runProcess()
                    }
                }
            } 
          
            
        }
        
        
    }
}
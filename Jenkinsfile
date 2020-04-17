def s = tags
def list = []

pipeline {
        agent any
        stages {
            stage('Test') {
                steps {
                    script{
                        list = s.split("(\\,\\s)")
                        for (int i = 0; i < list.size(); i++){
                        sh "mvn install -Dcucumber.options='--tags ${list[i]}'"
                        }
                    }
                }
            }
        }
}
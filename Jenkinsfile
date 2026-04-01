pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    // Clean and compile the project
                    bat 'mvn clean compile'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run TestNG tests
                    bat 'mvn test'
                }
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
        }
    }
}

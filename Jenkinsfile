pipeline {
    agent any

    parameters {
        choice(
            name: 'TEST_GROUP',
            choices: ['smoke', 'regression'],
            description: 'TestNG group to run'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                bat 'mvn clean test -Dgroups=%TEST_GROUP%'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }

        success {
            echo 'Tests passed'
        }

        failure {
            echo 'Pipeline failed'
        }
    }
}
pipeline {
    agent any

    tools {
        maven 'maven'
    }

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
                echo "Running group: ${params.TEST_GROUP}"

                bat """
                    mvn clean test -Dgroups=${params.TEST_GROUP}
                """
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
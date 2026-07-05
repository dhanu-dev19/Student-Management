pipeline {
    agent any

    stages {
        stage('Clone Code') {
            steps {
                echo 'Pulling the latest codebase from GitHub...'
            }
        }

        stage('Compile & Test') {
            steps {
                echo 'Running compilation and JaCoCo test reporting passes...'
                // Runs your unit tests cleanly inside the automation container
                bat 'mvn clean verify'
            }
        }

        stage('SonarQube Static Analysis') {
            steps {
                echo 'Injecting telemetry matrices to the SonarQube local engine...'
                bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.host.url=http://127.0.0.1:9000 -Dsonar.token=sqp_0d6fe0865e88927e21233da860d5bb1dc1e0030"
            }
        }

        stage('Deploy to Nexus') {
            steps {
                echo 'Pushing the compiled artifact to the Nexus Release vault...'
                bat 'mvn deploy -DskipTests'
            }
        }
    }
}
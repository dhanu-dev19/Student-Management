pipeline {
    agent any

    // Step 2: Global Tool Mappings
    tools {
        // Matches the exact names configured in your Manage Jenkins -> Global Tool Configuration
        jdk 'JDK21'
        maven 'Maven3'
    }

    // Step 6: Using Environment Variables
    environment {
        APP_NAME = 'StudentManagement'
        BUILD_ENV = 'Development'
    }

    stages {
        // Step 2: Checkout source control dynamically based on the hook branch
        stage('Checkout') {
            steps {
                echo "Initializing build for ${APP_NAME} inside the ${BUILD_ENV} pipeline environment..."
                checkout scm
            }
        }

        // Step 2: Clean phase
        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        // Step 2: Compile phase
        stage('Compile') {
            steps {
                bat 'mvn compile'
            }
        }

        // Step 2 & 3: Run Unit Tests
        stage('Unit Test') {
            steps {
                // Runs the tests and generates the target telemetry files
                bat 'mvn test'
            }
        }

        // Step 5: Add SonarQube Analysis Stage
        stage('SonarQube Analysis') {
                   steps {
                       withSonarQubeEnv('LocalSonar') {
                           bat 'mvn sonar:sonar'
                       }
                   }
               }



        // Step 2 & 4: Package Phase
        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        // Optional Bonus Stage: Keeps your Nexus deployment active
        stage('Deploy to Nexus') {
                    steps {
                        echo 'Pushing final compiled release artifact to Sonatype Nexus...'
                        // The "-s" flag explicitly forces Maven to use your authenticated settings file
                        bat 'mvn deploy -s "C:\\Users\\Dhanush\\.m2\\settings.xml" -DskipTests'
                    }
              }
    }

    // Post-Build Condition blocks (Steps 3, 4, and 7 combined)
    post {
        always {
            // Step 3: Publish JUnit Test Results dynamically to show trending graphs on your dashboard
            junit 'target/surefire-reports/*.xml'

            // Step 7: Clean Workspace after extracting all trends to keep your hard drive clean
            cleanWs()
        }

        success {
            echo "Build Successful for ${APP_NAME}!"
            // Step 4: Archive the JAR file directly inside the Jenkins build dashboard history panel
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }

        failure {
            echo "Build Failed for ${APP_NAME}. Check the console output streams."
        }
    }
}
pipeline {
    agent any
    
    tools {
        maven 'Maven3'
        jdk 'JDK11'
    }
    
    stages {
        stage('Git Checkout') {
            steps {
                echo '========================================='
                echo '🔍 Stage 1: Git Checkout Started'
                echo '========================================='
                
                // Checkout code from GitHub
                checkout scm
                
                echo '✅ Code successfully checked out from GitHub!'
            }
        }
        
        stage('Compile') {
            steps {
                echo '========================================='
                echo '⚙️  Stage 2: Compilation Started'
                echo '========================================='
                
                // Compile Java code (Windows batch command)
                bat 'mvn clean compile'
                
                echo '✅ Compilation completed successfully!'
            }
        }
        
        stage('Unit Test') {
            steps {
                echo '========================================='
                echo '🧪 Stage 3: Unit Testing Started'
                echo '========================================='
                
                // Run unit tests (Windows batch command)
                bat 'mvn test'
                
                echo '✅ All unit tests passed!'
            }
            post {
                always {
                    // Publish test results
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Build/Package') {
            steps {
                echo '========================================='
                echo '📦 Stage 4: Build & Package Started'
                echo '========================================='
                
                // Create WAR file (Windows batch command)
                bat 'mvn clean package -DskipTests'
                
                echo '✅ WAR file created successfully!'
                echo '📁 Location: target\\jenkins-demo-app.war'
            }
        }
        
        stage('Deploy to Tomcat') {
            steps {
                echo '========================================='
                echo '🚀 Stage 5: Deployment Started'
                echo '========================================='
                
                script {
                    // Deploy WAR to Tomcat (Windows version)
                    bat '''
                        echo Stopping Tomcat if running...
                        net stop Tomcat9 2>nul || echo Tomcat not running as service
                        
                        echo Removing old deployment...
                        if exist "C:\\Program Files\\Apache\\Tomcat\\apache-tomcat-9.0.111\\webapps\\jenkins-demo-app*" (
                            del /Q "C:\\Program Files\\Apache\\Tomcat\\apache-tomcat-9.0.111\\webapps\\jenkins-demo-app*"
                            rmdir /S /Q "C:\\Program Files\\Apache\\Tomcat\\apache-tomcat-9.0.111\\webapps\\jenkins-demo-app"
                        )
                        
                        echo Copying new WAR file...
                        copy /Y target\\jenkins-demo-app.war "C:\\Program Files\\Apache\\Tomcat\\apache-tomcat-9.0.*\\webapps\\"
                        
                        echo Starting Tomcat...
                        net start Tomcat9
                        
                        echo Waiting for deployment...
                        timeout /t 15 /nobreak
                    '''
                }
                
                echo '✅ Application deployed successfully!'
                echo '🌐 Access at: http://localhost:8081/jenkins-demo-app'
            }
        }
    }
    
    post {
        success {
            echo '========================================='
            echo '🎉 PIPELINE COMPLETED SUCCESSFULLY! 🎉'
            echo '========================================='
            echo 'All stages executed without errors.'
            echo 'Application is now running on Tomcat.'
        }
        failure {
            echo '========================================='
            echo '❌ PIPELINE FAILED!'
            echo '========================================='
            echo 'Check the console output for errors.'
        }
        always {
            echo '========================================='
            echo '🧹 Cleaning up workspace...'
            echo '========================================='
            cleanWs()
        }
    }
}
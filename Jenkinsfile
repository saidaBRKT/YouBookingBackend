pipeline {
  agent any
  stages {
    stage('Log Tool Version') {
      parallel {
        stage('Log Tool Version') {
          steps {
            sh '''mvn --version
git --version
java -version'''
          }
        }

        stage('Check for POM') {
          steps {
            fileExists 'pom.xml'
          }
        }

      }
    }

    stage('Build With Maven') {
      steps {
        sh 'mvn compile test package'
      }
    }

    stage('Post Build Steps') {
      steps {
        writeFile(file: 'status.text', text: 'Hey it worked!!!')
      }
    }

  }
}
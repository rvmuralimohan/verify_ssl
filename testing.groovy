pipeline {
    agent any
    stages{
        stage('git_checkout'){
            steps{
            git credentialsId: '50e08b47-84bd-406b-b681-fad53783f697', url: 'https://github.com/rvmuralimohan/verify_ssl.git'
        }
        }
     stage ('test'){
         steps{
         echo "testing"
         }
     }
     stage('deploy'){
         steps{
             echo "it is habee deploying"
         }
     }
     }
}

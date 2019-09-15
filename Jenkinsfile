#!/usr/bin/groovy
@Library('eos-jenkins-shared') _
import groovy.time.TimeCategory
import java.text.SimpleDateFormat
import java.date.*
import java.time.*
import java.util.*


node('master')
{
   wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'xterm']) {
  // cleanup old deployment files
  deleteDir()
 ;
  // load build functions into a subdirectory
  checkout scm
    def ssl_file = readFile "ssl_check.txt"
    def string = ssl_file.split("\n")
    def stringList = []
    for ( i = 0; i < string.size(); i++)
    {
     try {
        def sitename = string[i].split(":")[0]
        def expiryDateStr = sh (
        script: "true | timeout 5 openssl s_client -servername ${sitename} -connect ${string[i]} 2>/dev/null | openssl x509 -noout -dates| awk -F[=G] '{print \$2}'|tail -1",
        returnStdout: true
      ).trim()  
      echo 'expiryDateStr' + expiryDateStr
      def currentDate =  new Date().format("E MMM dd H:m:s  yyyy")
      echo 'currentDate' + currentDate
      if(expiryDateStr<=currentDate.plus(30)){
          stringList.add[1]
      }
 
     }
    catch (e) {
       echo e
       buildStatus = "UNSTABLE"
        break
   }
    
  def bodyString = stringList.toString()
  echo 'bodyString' + bodyString

  mail (to: ' mailtomrualir@gmail.com',
                        subject: "ATTENTION: SSL certificate expires within 30 days " + bodyString,
                        body: "" + bodyString
                );

}

}

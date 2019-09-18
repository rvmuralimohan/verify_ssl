#!/usr/bin/groovy
import groovy.time.TimeCategory
import java.text.SimpleDateFormat
import java.date.*
import java.time.*
import java.util.*

node("master") {
wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'xterm']) {
  // cleanup old deployment files
  deleteDir()
 ;
  // load build functions into a subdirectory
  checkout scm
 
  // Create buildStatus
  String buildStatus
 
  String ws  = pwd()
 
  sh ("echo $ws")
  sh ("ls")
  def chk = readFile "ssl_check.txt"

  def string = chk.split("\n")
  echo "size is "+string.size()
  //def signedCert = sh ("true | openssl s_client -connect ebs-prd.corp.chartercom.com:443 2>/dev/null | openssl x509 -enddate -noout")
// sh ("true | openssl s_client -connect ebs-prd.corp.chartercom.com:443 2>/dev/null | openssl x509 -enddate -noout | awk -F[=G] '{print \$2}'")
  def endpoint
  def prt
  def stringList = []
  for (i =0; i < string.size(); i++)
  {
     try {
        endpoint = string[i].replace("https://", "")
       
        endpoint = endpoint.split("/")[0]
       
        prt = 443
        if(endpoint.contains(":"))
        {
            prt = endpoint.split(":")[1]
            endpoint = endpoint.split(":")[0]
        }
       
      def expiryDateStr = sh (
        script: "true | true | timeout 5 openssl s_client -servername ${sitename} -connect ${string[i]} 2>/dev/null | openssl x509 -noout -dates| awk -F[=G] '{print \$2}'|tail -1",
        returnStdout: true
      ).trim()
     
  echo 'expiryDateStr' + expiryDateStr

 
 def currentDate = new Date().format("E MMM dd H:m:s z yyyy")

   if(expiryDateStr<=currentDate.plus(30))
     {
      stringList.add[0]      
     }
   }
    catch (e) {
        echo e
        buildStatus = "UNSTABLE"
        break
    }
   
  
  def bodyString = stringList.toString()

  echo 'bodyString' + bodyString

  mail (to: ' rvmuralimohan@yahoo.com',
                        subject: "ATTENTION: SSL certificate expires within 30 days " + bodyString,
                        body: "" + bodyString
                );
}
}
}

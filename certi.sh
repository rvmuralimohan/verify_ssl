#/bin/bash

expiredate =`openssl x509 -in /path/to/cert.pem -inform PEM -text -noout -enddate | grep "Not After" | awk '{print $4, $5, $7}'`
TodayPlus30 =`date -ud "+30 day" | awk '{print $2, $3, $6}'`



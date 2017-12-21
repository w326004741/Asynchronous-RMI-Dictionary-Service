# Asynchronous-RMI-Dictionary-Service
> Module: Distributed Systems / 4th Year  
> Lecturer: Dr Patrick Mannion  
> Project 2017 : Asynchronous RMI Dictionary Service

> Student : Weichen Wang

## Overview
The project use the Servlet/JSP and Java RMI frameworks to develop a remote, asynchronous dictionary lookup service. A JSP page should provide users with the ability to specify a string which will be checked against the dictionary. The HTML form information should be dispatched to a servlet that adds the client request to an in-queue and then returns a job ID to the web client. The web client should poll the web server periodically (every 10 seconds) and query if the request has been processed. Client requests in the inQueue should be periodically removed and processed (every 10 seconds).

[Project Detail](https://github.com/w326004741/Asynchronous-RMI-Dictionary-Service/blob/master/dsAssignment2017.pdf)

## Architecture
![image](https://github.com/w326004741/Asynchronous-RMI-Dictionary-Service/blob/master/image/1961513890869_.pic.jpg)

## How to use this repostory:
1. Click Clone or download and Copy to clipboard
2. Enter your Terminal(for mac) or cmd(for windows), and following below:
```
# Change directory to anywhere just you like put
cd anywhere.....

# Clone this repository
git clone https://github.com/w326004741/Asynchronous-RMI-Dictionary-Service.git
&
cd your folder(Asynchronous-RMI-Dictionary-Service)

# You can import dictionary-service and job-server to eclipse

```
## You should be have components:
- [Tomcat v7.0](https://tomcat.apache.org/download-70.cgi)
- [servlet-api.jar](https://stackoverflow.com/questions/8521851/where-do-i-get-servlet-api-jar-from)

## How to run:
#### 1. Right Click ServiceSetup (dictionary-service) --> Run As --> Java Application ####

#### 2. Right Click job-server project --> Run As --> Run on Server ####


## About Project:
Before you start the project, you need to first add Tomcat server to your Eclipse Project:
```
1. Go to the “Servers” tab in Eclipse, and click the link to create a new server. 

2. Select “Tomcat v7.0 Server” and click Next.

3. Browse to the Tomcat directory from Step 1 and then click Finish – “Tomcat v7.0 Server at localhost” 
   should be displayed on the “Servers” tab.
```
#### Web Application Main Page:
![image](https://github.com/w326004741/Asynchronous-RMI-Dictionary-Service/blob/master/image/1901513889789_.pic.jpg)
![image](https://github.com/w326004741/Asynchronous-RMI-Dictionary-Service/blob/master/image/1951513890559_.pic.jpg)

#### Waiting for Response:
![image](https://github.com/w326004741/Asynchronous-RMI-Dictionary-Service/blob/master/image/1911513889984_.pic.jpg)

#### Response Result:
![image](https://github.com/w326004741/Asynchronous-RMI-Dictionary-Service/blob/master/image/1921513889993_.pic.jpg)

#### String not found:
![image](https://github.com/w326004741/Asynchronous-RMI-Dictionary-Service/blob/master/image/1931513890013_.pic.jpg)
![image](https://github.com/w326004741/Asynchronous-RMI-Dictionary-Service/blob/master/image/1941513890035_.pic.jpg)

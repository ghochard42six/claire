# Installation Guide

This Installation Guide is intended for *nix machines.

Github repo: https://github.com/42sixsolutions/claire

## Dependencies

* [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jre7-downloads-1880261.html)
* [Maven](https://maven.apache.org/download.cgi)
* [NodeJs](https://nodejs.org/download/)
* [FireFox](https://www.mozilla.org/en-US/firefox/new/)

## Claire web app installation guide

Claire can be installed on either a local machine or in a hosted environment. Instructions for both methods are included below.

### Local Tomcat7 (only works on https)
Type the following in a terminal window.
```
git clone https://github.com/42sixsolutions/claire
cd claire/
mvn clean install
  war file is in: claire-web/target/claire.war
cd claire-web/
mvn tomcat7:run
```
Using a browser, navigate to the site:
```
https://localhost:8443/#/
	Will only be accessible through https
	If a warning saying “Your connection is not private” comes up:
		Click "Advanced"
		Click “Proceed to localhost (unsafe)”
```

### Hosted
```
Select your IaaS option:
	openshift.com (Free)
	ARC (Paid)
On Openshift (the PaaS for both IaaS options):
  create new application button
	tomcat 7
	set properties
		public URL
		git url: https://github.com/42sixsolutions/claire.git
		branch: master
		size: small
		no scaling
		pick a region
	create application
```
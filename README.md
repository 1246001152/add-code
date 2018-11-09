## add-code

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.javen205/IJPay/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.UncleCatMySelf/add-code)

QR code generation tool based on zxing for easy web-side development 

## Maven Resources
 
```
<dependency>
    <groupId>com.github.UncleCatMySelf</groupId>
    <artifactId>add-code</artifactId>
    <version>1.0</version>
</dependency>
```

## How to use

This tool is currently used in the version of SpringBoot2.X.

All you need to do is add the corresponding parameters to the configuration file.

> application.yml

```
qrcode:
  handler: "/upload/**" # Front End Resource Listening path(Required Fields)
  location: "file:E:/img/" # Resource Storage Parent Directory(Required Fields)
  parents: "E:\\img/" # Resource Storage Parent Directory(Required Fields)
  suffixname: ".png" # Name of the suffix that generated the picture(Default is PNG)
  suffix: "png" # Format of the generated picture(Default is PNG)
  width: 300 # The width of the QR code(Default is 300px)
  height: 300 # The high of the QR code(Default is 300px)
```

## Core APIs

Inject **CreateQRCodeUtil** into your project, using the **Create** method, the parameters he needs are QR code content and the picture ID that generates the QR code, so you can continue with the rest of your development.
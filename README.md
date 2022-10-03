# Covid-19 Statistics app
This repository is the project for Covid-19 statistics at Pro-ect Ltd.

## Requirements
Make sure that you have installed Java Version 17 (JDK 17) and Intellij IDEA on your local machine.

## Installation
Clone the repository on your local machine.

Use `git clone https://github.com/Nikolay-Daskalov/76bc3e7f-583a-4cfd-898b-2ea4c7d9d110.git`

## Open
Open the folder `/Covid-19-Statistics` as Intellij Project and wait **all dependencies 
to be downloaded and indexed**.

## Run
Go to the main class containing `@SpringBootApplication`annotation and click the play button 
next to it. It will start building and then it will run the app. Make sure 
nothing is running on port **8080**

### Path:
> src / main / java / com / project / Covid19Statistics / Covid19StatisticsApplication.java


### Note: 
If in the logs is printed a message that says:
> API is currently caching...

It means you should wait a few minutes because the API is currently down. 
Just start the application again.

## Access
Type this URL in the browser or in HTTP Client (e.g. Postman).
> http://localhost:8080/country/{CountryCode}

## Tips
 - It uses H2DB in memory database to make it more easily to run the application.
   

 - If you want to access the DB data, go to `application.yml` and uncomment 
   ```
   # h2:
   #    console:
   #        enabled: true
   ```
   To access the DB open the browser and type
   ```
   http://localhost:8080/h2-console
   ```
   
   Type for Username -> **root** and for Password -> **12345** and click **Connect**.
   
   ### Path:
   > src / main / resources / application.yml
   
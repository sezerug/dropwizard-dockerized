Dockerized Dropwizard Example
=====

Sample Dockerized Dropwizard Application.

Requirements
------------
* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)
* [Docker](https://www.docker.com/)

#Running The Application

Follow these steps to start the application

* To package the application
          
        mvn package

* To build docker image

        docker build -t dropwizard-dockerized .

* Run the application as Docker container

        docker run -d -p 8080:8080 -e "ENV_NAME=local" --name dropwizard-dockerized  dropwizard-dockerized

       Note: `ENV_NAME` points to application's config folder(`config.yml` file location) which could be `local` or `prod`.

* Test the running application.
        
       Post a user:

        curl -H "Content-Type: application/json" -X POST -d '{"username":"smith","email":"smith@gmail.com"}'     http://localhost:8080/users

       Get users:
       
        curl -X GET http://localhost:8080/users

       You should get something like this:
       `[{"id":"8bab5c02447b4edc91fb8d87e7eaaba3","username":"smith","email":"smith@gmail.com"}]`

       Get the environment info that the application running (remember the `"ENV_NAME=local"` in `docker run` command):

        curl -X GET http://localhost:8080/admin/environment


 
# songr

## In today lecture we learned  how to start working in spring and deal with it as well as know how we can send requests and show html page in browser using local host.
## Also, we defend the MVC and how they are works.

* ## What we did in our lap as the following: 
    * ### In the `Album` class : we created variables and constructor and setter and getter to use this class and create instance to save data.
    * ### `helloWorld ` class : we have the all functionality  for the web application in this class, and the routes to the html pages.
    * ### `html` pages : we created multi html page to show data in the browser, and we used the thymeleaf to get the data from the routes and show it in the pages 
    
### Run the App :
#### 1. clone the repo.
#### 2. `cd` into the project directory  and run this command `./gradlew bootRun`
#### 3. go to your browser and hit the *localhost:8080*
#### 4. here is the list for the following available routes:
  * ##### The home page : `http://localhost:8080/`: welcoming page 
  * ##### the capitalize page: `http://localhost:8080/capitalize/hello` which take sentence as parameter to show in upper case.
  * ##### Hello world page `http://localhost:8080/hello`.
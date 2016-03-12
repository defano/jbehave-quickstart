# JBehave Tutorial: Improving your agile process with JBehave.

Supplemental materials to the talk given to the Chicago Java User's Group in 2014.

This simple Spring MVC-based web application implements a four function calculator with a look-and-feel similar to Mac OS X's built-in calculator. It's intended to illustrate how you might test a web app with JBehave.

It's worth noting this application's architecture is demonstrably terrible. Building a calculator web-app that makes web service requests to the server to process calculations is problematic for far too many reasons to list here.

## Testing the Application

The app can be built and tested using either Gradle or Maven.

#### With Gradle

Build and execute all of the tests using Gradle with:

```
$ gradle test
```

Upon completion, a Gradle-generated HTML report will be created in the `build/reports/tests/` directory. Alternately, JBehave test results are available in the `target/jbehave/` directory.

#### With Maven

Build and execute all of the tests using Maven with:

```
$ mvn test
```

Unlike Gradle, Maven does not auto-generate an HTML test report. However, the output produced by JBehave will be written to your terminal as the tests execute. Furthermore, upon completion, those same results are available in `target/jbehave/` directory.

## Running the Application

See the calculator in action by following these steps.

#### With Gradle

Running the application with Gradle is as simple as executing:

```
$ gradle jettyRun
```

Then, point your web browser at [http://localhost:8080](http://localhost:8080).

#### With Maven

Maven doesn't support "running" applications directory. (Although you stitch together some plugins to accomplish this, our POM was not written to do so.) Instead...

Build the app's WAR with:
```
$ mvn package
```

Then install the resulting WAR file (from the `target/` directory) into the web container of your choosing (Jetty, Tomcat, etc.).

# KWIC Demo project
This is a [Maven](https://maven.apache.org/index.html) project. You need to install Maven first before coding.
The project is developed with **Java 8**. Make sure you have appropriate [SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed on your machine.

## Install Maven
Maven is a build manager for Java projects. It could help you to install Java libraries, automate the project build process and manage your Java project.

Install Maven on:
* Mac: as simple as `$ brew install maven` (in case you don't know what is [Homebrew](http://brew.sh/), you should use it now).
* Ubuntu: `$ sudo apt-get install maven`
* Windows: refer to this [guide](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)

## Import project to Eclipse
After install Maven, you should be able to Import the project into Eclipse workspace by choosing "Import" -> "Maven" -> "Existing Maven project". Select the path to the `pom.xml` file of your project and click "Finish". Eclipse should be able to automatically install project dependencies if Maven is properly installed.

Refer to [this guide](http://stackoverflow.com/questions/2061094/importing-maven-project-into-eclipse) if you meet any issues for importing.

## Run the project
You can run the program from [App.java](https://github.com/Gisonrg-in-NUS/KWIC-demo/blob/master/src/main/java/sg/edu/nus/comp/cs3219/App.java).
Make sure you have played it before coding :)

## Tasks
You are required to implement the "Required words" feature, and set up the Travis CI with your project repo.
- [ ] You are expected to study the given code structure, and understand how it works first before coding. The example base code for [RequiredWordsFilter.java](https://github.com/Gisonrg/CS3219-KWIC-demo/blob/master/src/main/java/sg/edu/nus/comp/cs3219/module/RequiredWordsFilter.java) is provided to you, or you can implement your own design. All the necessary interactions between UI and logic are provided to you.
- [ ] Set up the [Travis CI](https://travis-ci.org/) for your project repo to make sure all tests are run and passed in the CI. A working travis config file ([.travis.yml](https://github.com/Gisonrg-in-NUS/KWIC-demo/blob/master/.travis.yml)) is provided to you in the repo. You are encouraged to learn more about Travis CI and modify the config file for your need.


# hmrc-example-frontend

Service manager port: 10125

###Install Homebrew
Open Terminal
<pre>ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"</pre>
This will then tell you to run a couple of commands to add brew to your path

###Install GIT
check to see if you already have git installed using
<pre>git —version</pre>
If you don’t have it install it using
<pre>brew install git</pre>
else
<pre>brew upgrade git</pre>

###Install SBT
check to see if you already have sbt installed using
<pre>sbt —version</pre>
If you don’t have it install it using
<pre>brew install sbt</pre>
else
<pre>brew upgrade sbt</pre>

###Update Bash_profile
Create a workspace folder under your User. i.e. Dev then HMRC under that
Open Terminal
<pre>vi ~/.bash_profile</pre>
<pre>export WORKSPACE=~/Dev/HMRC</pre>
We also need to ensure that we’re using Java jdk 1.8 so in bash_profile
<pre>export JAVA_HOME=`/usr/libexec/java_home -v 1.8`</pre>

To test that the export worked
<pre>source ~/.bash_profile</pre>
<pre>cd $WORKSPACE</pre>

###Install MongoDB
<pre>xcode-select —install</pre>
This will probably fail as you should already have it
<pre>brew tap mongodb/brew</pre>
<pre>brew install mongodb-community@6.0</pre>
<pre>brew services start mongodb-community@6.0</pre>
<pre>brew services list</pre>
this showed an error against @6.0, but also that I already had @4.0 so I simply
so instead I ran
<pre>brew services stop mongodb-community@6.0</pre>
<pre>brew services start mongodb-community@4.0</pre>
This is the wrong version for HMRC but seems to work for this

###Download the Code
Navigate in the terminal to your working directory i.e. Dev/HMRC
First setup your SSH Key then download the project using
<pre>git clone git@github.com:testdrivensolutions/hmrc-example-frontend.git</pre>

###Compile and run the code
Move into the new directory
<pre>sbt clean compile test</pre>
<pre>sbt run</pre>
should start this project on port 10125. (set in the config of the project)
You can view the contents by going to
http://localhost:10125/hmrc-example


###RoboMongo
If you want to view the contents of the Mongo database then you can install something like robomongo
The url for the mongodb instance is the default of localhost:27017
If the sbt tests ran successfully you should see some tables have been created
If you have successfully run through the pages of the app you should see the data in the relevant table


###Run Scaffold
giter8 can be used to create some pages. To do that first navigate to the project directory in the terminal and enter
<pre>sbt</pre>
<pre>g8Scaffold yesNoPage</pre>
<pre>exit</pre>
For example if you want a new Yes No Page
You’ll now be prompter for some data such as the className. These have default values

Note: There's an issue where where giter8 will only display the last two characters you enter.
To get around this you instead need to start sbt with a different editor.
However I can't remember how to do that

TODO: Look up the bettwe sbt command and edit this Readme
<pre>./migrate.sh</pre>
updates some of the files

You’ll still need to update the navigation to add the new page into the relevant place in the journey, and update the CheckYourAnswers Page to display that data


### Testing

Run unit tests:
<pre>sbt test</pre>  
Run integration tests:  
<pre>sbt it:test</pre>  
or
<pre>sbt IntegrationTest/test</pre> 

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").


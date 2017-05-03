# exp10_HelloThreads
Example Java project created via STS as Java Project, showing concurrent programming in Java. Showing how to;
- run threads by extending Thread (MyThread)
- run tasks that extend Runnable in threads (MyRunnableTask)
- run threads by creating anonymous inner class instances of Thread implementing run method (UsingAnonymousInnerClassThread)
- run threads by creating anonymous inner class instances of Thread using anonymous inner class instances of Runnable implementing run method (UsingAnonymousInnerClassRunnable)
- submitting Runnable tasks to a thread pool created by executors framework (HelloExecutors)

## Setup dependencies
Make sure on your machine, you have;
- STS installed
- git installed
- a working unix shell (like git bash. If not there install git and use its "git bash")
- working JDK 1.8 installed (with JAVA_HOME env variable added, and PATH env variable prefixed with %JAVA_HOME%/bin)
- make sure JRE System Library is from jdk1.8 (delete it and recrete the JRE System Library if it is not from jdk)

## How to use it  (NOTE in below the directory structure and names are suggested)
### Make sure you created the directory structure you want to store example projects in
As example, at bash command line issue;<br>
mkdir -p /c/fdu/csci3307/projects

### to import the project from github to STS
In github, go to the repository you want to clone<br>
https://github.com/fdu-3307/exp10_HelloThreads.git <br>
click green "Clone or download" on right hand side<br>
click icon with "Copy to clipboard" tooltip (NOTE when you click that later during import in STS most fields of "Source Git Repository" will be auto populated) or copy the URL

In STS
File --> Import --> Git --> Projects from Git + Next --> Clone URI + Next --> URI, Host, Repository path, Protocol of "Source Git Repsitory" will be auto filled, fill in Authentication section, click check box of "Store in Secure Store" + Next --> let "master" be selected in "Branch Selection" + Next --> in "Local Destination" type in Directory or click Browse and select workspace, let "origin" be Remote name + Next  --> in "Select a wizard to use for importing projects" click radio button of "Import using the New Project wizard" + Finish<br>
in "Select a wizard" click Java --> Java Project + Next --> in "Create a Java Project" enter "Project name" value + Finish

Now you should see the project in STS with yellow milk tank on its lower right corner and blue J in its upper right corner  

### or to clone the project from github via command line to a directory
cd to where you put your example projects.<br>
As example, at bash command line issue;<br>
cd /c/fdu/csci3307/projects <br>
git clone https://github.com/fdu-3307/exp10_HelloThreads.git <br>
or<br>
git clone https://github.com/fdu-3307/exp10_HelloThreads.git  whateverDirectoryNameYouWantStuffToBeClonedInto

Now you can import the project into STS via
File --> Import --> General --> Existing Projects into Workspace , then follow the wizard

### to run the project from STS
- Right click on project, Run As --> Java Application, click MyThread or MyRunnableTask or HelloExecutors from list
or
- Right click on MyThread, Run As --> Java Application
- Right click on MyRunnableTask, Run As --> Java Application
- Right click on HelloExecutors, Run As --> Java Application

## Project directory structure
- README.md this read me file
- src directory of java packages
- src/com.mycompany.exp10.common containing MyLanguageEnum, HelloJava8streams (to get a map used in loop)
- src/com.mycompany.exp10.one containing MyThread, MyRunnableTask
- src/com.mycompany.exp10.two containing HelloExecutors
- design directory of design documents, like class diagram

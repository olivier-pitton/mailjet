HOW TO CONFIGURE THE WEB SERVICE

By default, this project includes JBoss RESTEasy, who is an implementation of the JAX-RS specification.
If you have a web app project, just copy the "MailjetWebservice" and "MailjetApplication" classes in your project, but if an application class (like MailjetApplication)
is already defined, just add the "MailjetWebservice" class declaration in your application class.

Next, copy the content of the web.xml declaration in your web.xml declaration, without the "<display-name>" property who is using for test purposes only . The web.xml file is in the folder "src/main/webapp/WEB-INF"

HOW TO USE THE WEB SERVICE

You just have to implement the method named "mailjet" in MailjetWebservice.

RUNNING WITHOUT RESTEasy

If you don't want to use JBoss RESTEasy, just copy the two classes in your project and when you copy the web.xml declaration, change the declaration
of the balise "<servlet-class>" to put your declaration. Example, if you want to use this project with Jersey implementation, put this : 

HOW TO CHANGE THE DEFAULT URL 

The final URL is based on these parameters : 
 - <display-name> property in web.xml
 - <url-pattern> property in web.xml
 - @Path annotation in the class

So, the final URL would be like this : <display-name>/<url-pattern>/@Path. By default, it's Mailjet-event/mailjet/mailjet

You don't have to copy the <display-name> property, as we said before, and put to it your project name.

Finally, just change the other properties to change the default URL.



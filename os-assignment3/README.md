Question 1

Write a multithreaded program that calculates various statistical values for a list of numbers. This program will be passed a series of numbers onthe command line and will then create three separate worker threads. One thread will determine the average of the numbers, the second will determine the maximum value, and the third will determine theminimum value.

For example, suppose your program is passed the integers 9 0 81 78 95 79 72 85

The program will report:

The average value is 82

The minimum value is 72

The maximum value is 95

The variables representing the average, minimum, and maximum values will be stored globally. The worker threads will set these values, and theparent thread will output the values once the workers have exited. (Wecould obviously expand this program by creating additional threadsthat determine other statistical values, such as median and standarddeviation.)
Question 2

To improve modularity, we've written two seperate applications: a server application (EchoServer.java), and a client applcation (EchoClient.java). The Server must be run first, and then the client application. The server should only be running as a single instance, but the client application can handle multiple instances. No adittional arguments need be passed at run time, except for conventional terminal usage (java EchoServer, java EchoClient). The client application can be exited by typing 'exit', while the server application can be exited by entering cmd+c.

Deliverables

The programs should be commented where necessary.

Submit only source code and other necessary documentation.

Please name your files appropriately to make it clear which question you are answering.

Include the names of your group in a comment at the top of each program file.

Your submission should be in a single zip file in the following format, where lastname1 is the lastname of student1 and lastname2 is the lastname of student2: lastname1-lastname2-a2.zip 6.Upload your zip file to the SLATE dropbox.

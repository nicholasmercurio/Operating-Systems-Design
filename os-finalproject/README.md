## OS - Project

General Notes: Error handling - Handle errors using appropriate error handling techniques.

    A bad or missing command line argument should cause the program to exit after it prints usage instructions in the same way many Linux command line utilities do. Ex: “usage: myprog arg1 arg2”

    Regular errors should be printed to stderr by means of fprintf(). The choice of when to terminate the program on specific errors is left to you.

    Failed system calls should use the perror() function for reporting error messages.

Please Read:

When compiling, you will need to use pthread flag. For example, gcc -pthread buffer.c There seems to be issues compiling over a Mac enviroment. Code successfully compiles with no errors/warnings in a Linux enviroment. Please use proper command-line parameters at run time as referenced above.

## OS Assignment #2

## Question #1

An echo server echoes back whatever it receives from a client. For example, if a client sends the server the string Hello there!, the server will respond with Hello there!Write an echo server using the Java networking API described in Section 3.6.1. This server will wait for a client connection using the accept() method. When a client connection is received, the server will loop, performing the following steps: Read data from the socket into a buffer. Write the contents of the buffer back to the client. The server will break out of the loop only when it has determined that the client has closed the connection.

To Run EchoServer.java:

    Open terminal window and compile EchoServer.java
    Run EchoServer
    In another terminal window, use the following command nc localhost 6013
    Enter in the Strings to be sent to the Echo Server
    Type exit to close connection to Echo Server

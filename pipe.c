/* Pipes are used to allow one or more processes to have information "flow" between them.
   A common example of this is the pipelining in Linux shell: $ ls | wc -l

   "Unnamed pipes" are created, used and destroyed within the lifetime of the processes using them.
   Each end of the pipe has its own file descriptor. One end is for reading and the other for writing.
   When you are done with a pipe, it is closed.
   An unnamed pipe is created using the pipe() library function.

   The pipes used in shell command line are unnamed.
   They are just a user-friendly way of connecting the stdout of one process to the stdin of another process.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>

int main(void)
{
    int     fd[2], nbytes;
    pid_t   childpid;
    char    string[] = "Hello, world!\n";
    char    readbuffer[80];

    pipe(fd);  // pipe function takes an array of size 2, for making file descriptors (0: read, 1: write)

    if((childpid = fork()) == -1)
    {
        perror("fork");
        exit(1);
    }

    if(childpid == 0)
    {
        close(fd[0]);  // child process closes the reading (input) side of pipe

        write(fd[1], string, (strlen(string)+1));  // send string through the writing side of pipe
        exit(0);
    }
    else
    {
        close(fd[1]);  // parent process closes the writing (output) side of pipe

        nbytes = read(fd[0], readbuffer, sizeof(readbuffer));  // receive string from the reading side of pipe
        printf("Received string: %s", readbuffer);
    }

    return(0);
}
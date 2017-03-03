/* A regular pipe can only connect two related processes (like a forked processes with its parent).
   It is created by a process and will vanish when the last process closes it.

   A "named pipe" (also called a FIFO) can be used to connect two unrelated processes, not just descendants of the pipe creator.
   It has a "name" and exists as a special file. It exists until removed with rm or unlink().
   It is independent of the processes; meaning it can exist even if no process is using it.
   A FIFO is created using the mkfifo() library function.
*/

#include <fcntl.h>
#include <stdio.h>
#include <sys/stat.h>
#include <unistd.h>

#define MAX_BUF 1024

int main()
{
    int fd;
    char * myfifo = "/tmp/myfifo";  // FIFO buffer file
    char buf[MAX_BUF];

    /* open, read, and display the message from the FIFO */
    fd = open(myfifo, O_RDONLY);
    read(fd, buf, MAX_BUF);
    printf("Received: %s\n", buf);
    close(fd);

    return 0;
}
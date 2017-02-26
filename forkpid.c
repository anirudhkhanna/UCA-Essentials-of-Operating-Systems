#include <stdio.h>
#include <unistd.h>

int main(int argc, char **argv)
{
    pid_t pid = fork();

    if (pid == 0)   // child process (fork returned 0)
    {
        printf("child process:\t pid = %d,\t ppid = %d\n", getpid(), getppid());
    }
    else if (pid > 0)   // parent process (fork returned PID of the child process, i.e. a positive int)
    {
        printf("parent process:\t pid = %d,\t ppid = %d\n", getpid(), getppid());
    }
    else    // error (fork returned -1)
    {
        printf("fork() failed!\n");
        return 1;
    }

    return 0;
}
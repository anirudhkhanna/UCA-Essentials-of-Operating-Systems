// gcc <filename>.c -lpthread
// ./a.out

#include <stdio.h>
#include <pthread.h>

void * myRun (void * s) {
    char * msg = (char *) s;

    printf("%s \n", msg);
    return NULL;
}

int main() {
    pthread_t thread1, thread2;
    int ret1, ret2;
    char *msg1 = "Message 1", *msg2 = "Message 2";


    // Running thread2 first, then thread1:

    ret2 = pthread_create(&thread2, NULL, myRun, (void *) msg2);
    pthread_join(thread2, NULL);

    // thread2 must be completed by now, after join()
    // now run thread1

    ret1 = pthread_create(&thread1, NULL, myRun, msg1);
    pthread_join(thread1, NULL);

    printf("\n----------------\n");
    printf("ret1 = %d \nret2 = %d \n", ret1, ret2);
    return 0;
}

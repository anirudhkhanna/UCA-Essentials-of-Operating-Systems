// gcc <filename>.c -lpthread
// ./a.out

#include <stdio.h>
#include <pthread.h>

void * print_msg(void *ptr) {
    char *message;
    message = (char *) ptr;
    printf("%s \n", message);
    return NULL;
}

int main() {
    pthread_t thread1, thread2;
    char *msg1 = "First msg", *msg2 = "Second msg";
    int ret1, ret2;

    ret1 = pthread_create(&thread1, NULL, print_msg, (void *) msg1); 
    ret2 = pthread_create(&thread2, NULL, print_msg, (void *) msg2);

    // Now join the threads to wait for their completion.
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    printf("First thread returns %d \n", ret1);
    printf("Second thread returns %d \n", ret2);

    return 0;
}

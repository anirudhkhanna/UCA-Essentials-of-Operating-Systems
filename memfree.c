#include <stdio.h>
#include <stdlib.h>
main() {
    int *arr = (int *)malloc(4 * sizeof(int));
    free(arr); // freed
    return 0;
}

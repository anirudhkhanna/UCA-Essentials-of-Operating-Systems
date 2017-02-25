#include <stdio.h>
#include <stdlib.h>

main() {
    int *arr = (int *)malloc(4 * sizeof(int));
    // not freed
    return 0;
}

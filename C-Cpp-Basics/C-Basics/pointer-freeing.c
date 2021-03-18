#include <stdlib.h>
#include <stdio.h>

int main(){

    int num = 5;
    int * p = &num; 
    /** 
     * this will result in an error because we are trying to free a variable 
     * that is no the stack not heap. Free frees the memory location on heap 
     * not the pointer variable. 
     * */
    free(p);

    int * q = malloc(sizeof(int));
    *p = num;
    /**
     * This is totally valid because we are freeing a memory allocation that
     * took place on the heap.
     * */
    free(q);

    return 0;

}
#include <stdlib.h>
#include <stdio.h>

int main(){
    /**
    * As shown in static arrays and dynamic array,
    * we know how to create arrays in C, but it is equally 
    * important to free the memory allocated on heap, since overtime
    * allocation of memory can lead to program crashing or unexpected program performance**/

    /*Take a look at pointer_freeing.c for freeing one dimensional arrays in C*/

    int row = 5, col = 5;
    
    int **array2D = (int **)malloc(row * sizeof(int *)); 
    for(int i = 0; i < row; i++){
        array2D[i] = (int *)calloc(col , sizeof(int));
    }

    // free(array2D);
    /* Simply doing this will not free the allocated memory, we need to loop to free each allocated block followed by freezing array2D
    * Since we allocated them inidividually, we have to free them individually. Each malloc call in your code must have a matching call to free*/

    for(int i = 0; i < row; i++){
        free(array2D[i]);
    }

    free(array2D);
}

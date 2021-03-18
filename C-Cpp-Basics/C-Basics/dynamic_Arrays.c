#include <stdlib.h>
#include <stdio.h>

int main(){
    /*This file demostrates creating dynamic arrays using malloc(), calloc(), and realloc()*/

    //type *ptr = (type *)malloc(size * sizeof(type))

    int size = 5;
    int count = 0;

    int * array1 = (int *)malloc(size * sizeof(int));

    for(int i=0; i < size; i++){
        array1[i] = count++; //User input can be taken, as shown in UserInput.c
    }

    //Printing the result of array
    for(int i=0; i < size; i++){
       printf("%d\n", array1[i]);
    }

    //type *ptr = (type *)calloc(size , sizeof(type))
    
    int * array2 = (int *)calloc(size , sizeof(int));

    for(int i=0; i < size; i++){
        array2[i] = count++; 
    }

    //ptr = realloc (ptr, newSize);
    /*Let's consider the array2 for this example
    * To reallocate or in simple words increase the size of the array,
    * we can simply assign a new size to array2 by using realloc*/

    int newSize = 10;

    array2 = realloc(array2, newSize * sizeof(int)); //Since our array type is int, we multiply the newSize with sizeof(int)

    /*The next part of the file demonstrate, how to create dynamic 2D arrays
    * Let's create a 5x5 2D array*/

    int row = 5;
    int col = 5;

    int **array2D_1 = (int **)malloc(row * sizeof(int *)); 
    /*Simply doing this step will not generate a 2D array
    * Since the above statement just create a pointer pointing to an address with multiple 1D array.
    * So we need to traverse the array2D_1 and allocate memory for each 1D array*/

    /*Assiging memory to 1D array is same as show above*/
    for(int i = 0; i < row; i++){
        array2D_1[i] = (int *)malloc(col * sizeof(int));
    }

    /*We can also use calloc to perform the same operation can we performed by replacing malloc with calloc
    * However, doing calloc initializes an array with value 0, rather than some unwanted value*/

    /*This example uses the combination of both*/
    int **array2D_2 = (int **)malloc(row * sizeof(int *)); 
    for(int i = 0; i < row; i++){
        array2D_2[i] = (int *)calloc(col , sizeof(int));
    }
}
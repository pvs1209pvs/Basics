#include <stdlib.h>
#include <stdio.h>

int main(){
    /*Creating an array in C*/
    int numArray1D_1[4] = {1, 2, 3, 4};

    int numArray1D_2[] = {1, 2, 3, 4};

    /*There are different ways to create a 2D array in a C program*/

    int numArray1[2][3] = {
        {1, 2, 4},
        {3, 6, 7}
    };

    /*OR*/

    int numArray2D_1[2][3] = {1, 2, 4, 3, 6, 7};

    /*Things that need to be considered when initializing array
    * The above mentioned initializations are valid
    * We can also initialize an array as follows*/

    int numArray2D_2[][3] = {1, 2, 4, 3, 6, 7};

    /*But the following intializations will be invalid,
    * since it is important to mentioned the size of the second dimension*/

    int numArray2D_3[][] = {1, 2, 3 ,4};
    
    int numArray2D_4[2][] = {1, 2, 3 ,4};

    /*As the name suggests, the size of static arrays cannot be modified later*/
}
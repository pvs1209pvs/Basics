#include <iostream>
#include "Cat.h"
#include "Dog.h"

void cat_greet(){
    /* that extern std::string cat_name from the Cat.h header file is 
    defined here and is local to this function only. */
    std::string cat_name = "catty"; 
    std::cout << "hi from " << cat_name << std::endl;
}
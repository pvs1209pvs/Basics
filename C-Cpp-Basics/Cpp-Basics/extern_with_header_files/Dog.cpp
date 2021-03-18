#include <iostream>
#include "Dog.h"

/* that extern std::string dog_name from the Dog.h header file is 
defined here and over here is acting like a global variable. */
dog_name = "doggy";

void dog_greet(){
    std::cout << "hi from " << dog_name << std::endl;
}


#include <iostream>
#include <iomanip>
#include <string>
#include "dep.hpp"

void lining_up_text(){

    std::string data[] = {"paramvir", "singh", "87"};

    int width = 8;

    std::cout << std::right << std::setfill('.') 
    << data[0] << std::setw(width)
    << data[1] << std::setw(width)
    << data[2] << std::setw(width)
    << std::endl;

std::cout << std::right 
    << data[0] << std::setw(width)
    << data[1] << std::setw(width)
    << data[2] << std::setw(width)
    << std::endl;

}

int main(){
    lining_up_text();
    hello();
}
#include <iostream>
#include "Person.hpp"
#include "IllegalAgeException.hpp"

// simple throw
double calc_avg_0(int sum, int n){
    if(n==0) throw 0;
    return static_cast<double>(sum)/n;
}

// simple std::string throw
double calc_avg_1(int sum, int n){
     if(sum < 0 || n < 0) throw std::string{"negative value exception"};
    return static_cast<double>(sum)/n;
}

void func_0();
void func_1();
void func_2();
void func_3();

void func_3(){
    std::cout << "starting 3" << std::endl;
    func_2();
    std::cout << "ending 3" << std::endl;
}

void func_2(){
    std::cout << "starting 2" << std::endl;
    try{
    func_1();
    }catch(...){
        std::cout << "exception caought here at 2 during stack unwinding " << std::endl;
    }
    std::cout << "ending 2" << std::endl;
}

void func_1(){
    std::cout << "statring 1" << std::endl;
    func_0();
    std::cout << "ending 1" << std::endl;
}

void func_0(){
    std::cout << "starting 0" << std::endl;
    throw 0;
    std::cout << "ending 0" << std::endl;
}


int main(){

    // simple try-catch
    try{
       std::cout << "1: " << calc_avg_0(89, 0) << std::endl;
    }catch(int &ex){
        std::cout << "exception caught" << std::endl;
    }

    // catching multiple exception
    try{
        std::cout << "2: " << calc_avg_1(90, 8) << std::endl;
    }catch(int &int_ex){
        std::cout << "divide by zero exception" << std::endl;
    }catch(std::string &str_ex){
        std::cout << "negative value exception" << std::endl;
    }

    // usign catch-all
    try{
        std::cout << "3: " << calc_avg_1(90, 0) << std::endl;       
    }catch(...){
        std::cout << "catch call caught it" << std::endl;
    }

    // stack unwinding
    //func_3();

    // what()
    Person p;
    try{
        p = Person{"paramvir", -9};
    }catch(IllegalAgeException &iae){
        std::cout << "5: " << iae.what() << std::endl;
        p = Person{};
    }
    
    return 0;
}
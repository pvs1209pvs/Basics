#include "Person.hpp"
#include "IllegalAgeException.hpp"

Person::Person(std::string n, int a) : name{n}, age{a}{

    // throwing user-defined exception
    if(age < 0)throw IllegalAgeException();

}

Person::Person():Person("", 0){}
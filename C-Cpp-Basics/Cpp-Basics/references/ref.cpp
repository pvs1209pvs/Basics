#include <iostream>

void change_value(int & x){
    x = 100;
}

int main(){

    // this is referencing to the varible num. Loosely speaking  it acts like a
    // pointer to the variable num. Change in value of num can be seen by ref and
    // vice-verse as ref is pointing at the address of num. This is how
    // pass-by-reference works. The parameter value point to the address of the
    // variable passed, making it possible for us to the change the value of the
    // variable.
    int num{100};
    int& ref = num; // int& ref is an lvalue reference.

    return 0;
}

#include<iostream>

class Animal{

    public:

        void birth(){
            std::cout << "animal birth" << std::endl;
        }

        virtual void eat(){
            std::cout << "animal eats" << std::endl;
        }

};


class Cat : public Animal{

    public:

        void birth(){
            std::cout << "i am a cat" << std::endl;
        }

        void eat(){
            std::cout << "cat eats" << std::endl;
        }

};


int main(){

    /* this is will call cat's birth function only if the birth function
    in the animal class is declared as virtual. */
    Animal * obj = new Cat{};
    
    obj->birth();
    obj->eat();


    return 0;
}

main
/*
It is important to remember: When working with inheritance, each derived class should satisfy the condition whether it "is a" base class or not. In the example above, Maths teacher is a Person, Footballer is a Person. You cannot have: Businessman is a Business.
*/
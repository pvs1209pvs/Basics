#include <iostream>

class Account{
    public:
        virtual void display(){
            std::cout << "i am account" << std::endl;
        }
};

class Saving : public Account{
    public:
        virtual void display() override {
            std::cout << "i am saving" << std::endl;
        }
};

class Checking : public Account{
    public:
        virtual void display(){
            std::cout << "i am checking" << std::endl;
        }
};

class Trust : public Saving{
    public:
        virtual void display(){
            std::cout << "i am trust" << std::endl;
        }
};

void call_account(Account &acc){
    acc.display();
}

int main(){

    /* NOTE: virtual only works with * and & */

    Account * account = new Saving();
    Saving saving;
    Checking checking;
    Trust trust;

    call_account(checking);

}
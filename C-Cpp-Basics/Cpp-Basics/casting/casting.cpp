#include<cstdlib>
#include<iostream>

using namespace std;

class Gun{
    public:
        std::string name;

    Gun(int x){
        cout << "this is how many guns I have, " << x << endl;
    }
};

class Rifle : public Gun{
    public:
        std::string type;

        Rifle() {
            Gun(7)
            cout << "i am a rifle" << endl;
        }
};

int main(){


    //Rifle rifle{0};
    //Rifle rifle{};


    return 0;

}
#include<iostream>
#include<string>

class Gun{

    public:
        std::string name;

        std::string operator + (Gun g){
            return name+g.name;
        }

        std::string opertor ++ (){
            return name+name;
        }
};

int main(){

    Gun m4{};
    m4.name = "m4";

    Gun ak{};
    ak.name = "ak";

    std::cout << m4+ak << std::endl;
    std::cout << ++m4 << std::endl;

    return 0;
}
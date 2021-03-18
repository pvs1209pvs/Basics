#include <iostream>
#include <vector>

class Numo{

public:
    int * p;

    Numo(){
        std::cout << "default" << '\n';
        p = new int;
    }

    Numo(int num){
        std::cout << "arg" << '\n';
        p = new int;
        *p = num;
    }

    Numo(const Numo &other){
        std::cout << "copy" << '\n';
        this->p = other.p;
    }

    Numo(Numo&& other) noexcept {
        std::cout << "move" << std::endl;
        p = other.p;
        other.p = nullptr;
    }

};


int main() {

    // Move with std::string

    std::string orig{"param"};
    // when we move orig to moved, we are basically giving orig to move and
    // once that is done, orig is cleared out.
    std::string moved = std::move(orig);

    std::cout << "orig " << orig << std::endl;
    std::cout << "moved " << moved << '\n';


    // My own move
    std::vector<Numo> v{};
    v.push_back(Numo{5});

    return 0;
}

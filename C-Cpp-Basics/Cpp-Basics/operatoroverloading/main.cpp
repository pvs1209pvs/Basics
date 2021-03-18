#include <iostream>

class Line{

    public:

        double len;

        Line(double len) : len{len}{};
        Line() : Line{0.0}{};

        /* Prefix */
        Line operator++(){
            this->len++;
            Line line{this->len};
            return line;
        }

        /* Postfix */
        Line operator++(int){
            Line old{this->len};
            this->len++;
            return old;
        }

        /* Addition */
        // Line operator+(const Line &other){
        //     return Line(this->len + other.len);
        // }

        /* Subtraction */
        Line operator-(const Line &other){
            return Line(this->len - other.len);
        }

        /* Multiplication */
        Line operator*(const Line &other){
            return Line{this->len * other.len};
        }

        /* Negatation, same can be done for ! */
        // Line operator-(){
        //     len = -1 * len;
        //     return Line{len};
        // }

        /* Less than */
        bool operator<(const Line &other){
            return this->len < other.len;
        }

        /* Less than equal */
        bool operator<=(const Line &other){
            return this->len <= other.len;
        }

        /* Greater than > */
        bool operator>(const Line &other){
            return this->len > other.len;
        }

        /* Greater than equal */
        bool operator>=(const Line &other){
            return this->len >= other.len;
        }

        /* Equivalent */
        bool operator==(const Line &other){
            return this->len == other.len;
        }

        /* Output Stream */
        friend std::ostream& operator<<(std::ostream &output, const Line &line){
            output << "Length: " << line.len;
            return output;
        }

        /* Input Stream */
        friend std::istream& operator>>(std::istream &input, Line &line){
            input >> line.len;
            return input;
        }

        /* We can also implement operators as friend function. We dont have
        as this pointer so we have to pass the object, which means passing
        one parameter for unary operator and two parameters for binary
        operators. */
        friend Line operator-(const Line &l);

        friend Line operator+(const Line &a, const Line &b);

        friend Line operator+=( Line &a, const Line &b);

};

Line operator-(const Line &l){
    return Line{-1*l.len};
}

Line operator+(const Line &a, const Line &b){
    return Line{a.len + b.len};
}

Line operator+=(Line &a, const Line &b){
    a.len += b.len;
    return Line{a.len + b.len};
}

int main(){

    Line l1{10.0}, l2{3};

    l2 +=  l1;
    std::cout << l2 <<std::endl;
    return 0;
    
}
class IllegalAgeException:public std::exception{

    public:
        virtual const char* what() const noexcept{
            return "Age cannot be negative";
        }
};
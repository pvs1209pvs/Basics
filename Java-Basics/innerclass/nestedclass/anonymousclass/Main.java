public class Main{

    Main(){

        /* Overriding a class using anonymous class. */
        Animal animal = new Animal("cow"){

            int times;
    
            @Override
            void eat(){
                times = 90;
                this.status = "alive";
                System.out.println("I am a " + this.type + " and I want to eat " + times + " seeds because I am " + this.status);
            }

        };

        animal.eat();
        

        /* Implementating an interface using anonymous class. */
        Mammal mammal = new Mammal(){
          
            @Override
            public void birth(){
                System.out.println("Mammals give birth to young ones.");
            }

            @Override
            public void death(){
                System.out.println("Mammals don't die in a specific way");
            }
            
        };

        mammal.birth();
        mammal.death();

    }

    public static void main(String[] args) {
        new Main();
    }

}

class Animal{

    String type;
    String status;

    Animal(String type){
        this.type = type;
    }

    void eat(){
        System.out.println("I eat food.");
    }

}

interface Mammal{

    void birth();
    void death();

}


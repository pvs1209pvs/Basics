public class Main{

    private Main(){

        Friends simar = Friends.SIMAR;
        Friends asma = Friends.ASMA;

        System.out.println(simar.age + " " + simar.isHuman);

        simar.displayOrdinal();
        asma.displayOrdinal();

    }

    enum Friends {

        SIMAR(21), DEA(20), FAHAD(22), ASMA(21), CHAHAT(20, false);

        /* even the private variables act as public. */
        private int age;
        private boolean isHuman;
        
        /* Constructors can be created and called automatically 
        depending upon on how we create the enum values (SIMAR, DEA ...). */
        Friends(int age){
            this.age = age;
            this.isHuman = true;
        }

        Friends(int age, boolean isHuman){
            this.age = age;
            this.isHuman = isHuman;
        }

        /* We can add our own methods but they need to go after the enum
        values. */
        public void displayOrdinal(){
            /* Enums inherit from lang.Enum and gets some method from 
            that inheritance. */
            System.out.println(this + " " + this.ordinal());
        }

    }

    public static void main(String[] args) {
        new Main();
    }
    
}
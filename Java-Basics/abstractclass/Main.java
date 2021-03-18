public class Main{

    private Main(){

        Coder param = new Coder("param", 1500, "Kotlin");
        System.out.println(param.getName() + ", " + param.getPayRate() + ", " + param.getFavLang() + ", " + param.calcPay(2));
    }

    private abstract class Emp{

        private String name;
        private double payRate;

        public Emp(String name, double payRate){
            this.name = name;
            this.payRate = payRate;
        }

        public abstract double calcPay(int hours);

        public String getName(){
            return this.name;
        }

        public double getPayRate(){
            return this.payRate;
        }

    } // Emp

    private class Coder extends Emp{

        private String favLang;

        Coder(String name, double payRate, String favLang){
            super(name, payRate);
            this.favLang = favLang;
        }

        public double calcPay(int hours){
            return super.payRate*hours;
        }

        public String getFavLang(){
            return this.favLang;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
    
}

2 on high
3 on med
8 on low

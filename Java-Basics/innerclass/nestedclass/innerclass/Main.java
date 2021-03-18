class Motherboard{

    int model;

    Motherboard(){
        this.model = 1;
    }

    class CPU{

        int cores;
        String manuf;

        CPU(int cores, String manuf){
            this.cores = cores*Motherboard.this.model;
            this.manuf = manuf;
        }

        private void overclock(){
            System.out.println("cpu is being overclocked");
        }

        @Override
        public String toString(){
            return "cores:" + cores + " " + "manuf:" + manuf;
        }

    }

    class RAM{

        int memory;

        RAM(){
            this.memory = model*20;
        }

        @Override
        public String toString(){
            return "memory:" + memory;
        }

    }

    @Override
    public String toString(){
        return "model:" + model;
    }

    static class USB{

        double version;

        USB(double version){
            this.version = version;
        }
        
    }

}

public class Main{

    Main(){

        Motherboard mb = new Motherboard();
        mb.model = 3;

        Motherboard.CPU cpu = mb.new CPU(4, "intel");
    
        Motherboard.RAM ram = mb.new RAM();

        Motherboard.USB usb = new Motherboard.USB(8.9);
        System.out.println(usb.version);
        
        
    }

    public static void main(String[] args) {
        new Main();
    }
    
    
}
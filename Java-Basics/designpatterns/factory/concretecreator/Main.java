public class Main{

  private Main(){

    ShapeFactory sf = new ShapeFactory();
    sf.factoryMethod("square").draw();

  }

  public static void main(String[] args){
    new Main();
  }

}

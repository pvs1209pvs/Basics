public class Main{

  private Main(){

    ShapeFactory.factoryMethod("circle").draw();

  }

  public static void main(String[] args) {
    new Main();
  }

}

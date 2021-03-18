public class Main{

  public Main(){

    /*
      CircleFactory will call ShapeFactory's factoryMethod because
      it doesn't have one of its own. Inside ShapeFactory's
      factoryMethod CircleFactory's build method is called because
      the we have an instantiate of CircleFactory.
    */
    Shape myShape = new CircleFactory().factoryMethod();


  }



  public static void main(String[] args){
    new Main();
  }

}

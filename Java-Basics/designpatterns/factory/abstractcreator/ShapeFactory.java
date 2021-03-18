public abstract class ShapeFactory{

  abstract Shape buildShape();

  public Shape factoryMethod(){
    return buildShape();
  }

}

class RectangleFactory extends ShapeFactory{

  public Shape buildShape(){
    return new Rectangle();
  }

}

class SquareFactory extends ShapeFactory{

  public Shape buildShape(){
    return new Square();
  }

}

class CircleFactory extends ShapeFactory{

  public Shape buildShape(){
    return new Circle();
  }

}

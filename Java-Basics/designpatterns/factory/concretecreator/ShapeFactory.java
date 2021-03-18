public class ShapeFactory{

  public Shape factoryMethod(String shapeType){

    shapeType = shapeType.toLowerCase();

    switch (shapeType) {
      case "circle":
        return new Circle();
      case "rectangle":
        return new Rectangle();
      case "square":
        return new Square();
      default:
        return null;
    }

  };

}

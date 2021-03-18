public interface Shape{

  public void draw();

};

class Rectangle implements Shape{

  @Override
  public void draw(){
    System.out.println("this is rect");
  }

};

class Circle implements Shape{

  @Override
  public void draw(){
    System.out.println("this is circle");
  }

};

class Square implements Shape{

  @Override
  public void draw(){
    System.out.println("this is square");
  }

};

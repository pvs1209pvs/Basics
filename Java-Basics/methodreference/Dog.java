public class Dog {

public String name;
public int age;

public Dog(String name, int age){
  this.name = name;
  this.age = age;
}

  // instance method
  public void dogAge(Dog other){
    System.out.println(this.age + "," + other.age);
  }

}

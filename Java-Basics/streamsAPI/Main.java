import java.util.*;
import java.util.stream.*;

public class Main{

  public Main(){

    List<String> items = new ArrayList<>();
    items.add("one");
    items.add("two");
    items.add("three");

    /* --------------------------------------------------------------------- */

    // original stream -> toUpperCase lambda -> toUpperCaseStream -> forEach lambda.
    /* items.stream().map(String::toUpperCase).forEach(System.out::println); */

    /* --------------------------------------------------------------------- */

    /* calling non-terminal operation more than once of a stream is not allowed.
    We can chain the non-terminal operations if we want to call the same
    non-terminal operation more than once as every non-terminal operatsion returns
    a new stream. */
    Stream<String> stream = items.stream();
    /* stream.map(String::toUpperCase);
       stream.map(String::toLowerCase);
       stream.forEach(System.out::println); */

    // work-around.
    stream.map(String::toUpperCase).map(String::toLowerCase).forEach(System.out::println);

    /* --------------------------------------------------------------------- */

     class Emp{
      public String salaray;
      public Emp(String salaray){
        this.salaray = salaray;
      }
    }

    List<Emp> empList = new ArrayList<>();
    empList.add(new Emp("4000"));
    empList.add(new Emp("5000"));
    empList.add(new Emp("6000"));

    /* --------------------------------------------------------------------- */

    Comparator<Integer> comp = new Comparator<Integer>(){
        public int compare(Integer o1, Integer o2){
          return o1.compareTo(o2);
        }
    };

    Integer a =
    empList.stream().
    map((e)->e.salaray).
    map(Integer::parseInt).
    min(comp).
    get();

    System.out.println(a);




  }
  public static void main(String[] args) {
    new Main();
  }
}

/*

JAVA STREAM USAGE
1. obtain a stream.
2. call zero or more non-terminal operations on the Stream.
3. Call a terminal operation on the Stream.

*/

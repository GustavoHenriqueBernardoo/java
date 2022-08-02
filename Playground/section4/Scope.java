public class Scope {

  static int dogs = 5;

  public static void main(String[] args) {
    System.out.println(dogs);
    someFunctions();
  }

  public static void someFunctions() {
    System.out.println(dogs);
  }
}

public class ReturnValues {
  public static void main(String[] args) {
    double measure = measureRectangle(-1, 4.3, "area");
    double measure2 = measureRectangle(3.5, 1.2, "perimeter");


    stringPrinter(2.2, 4.3, measure, "area");
    stringPrinter(3.5, 1.2, measure2, "perimeter");


  }

  public static double measureRectangle(double length, double width, String option){

    if(length < 0 || width < 0){
      System.out.println("Length or width cannot be negative");
      System.exit(0);
    } 

    switch (option){
      case "area": return length * width;
      case "perimeter": return 2 * (length *width);
      default: return 404;
    }

    // System.out.println("The area of the rectangle is: " + area +"\n");
  }

  public static void stringPrinter(double length, double width, double measure, String option){
    System.out.println("\nThe "+option+" of the rectangle length "+length+" and width " + width +" is equal to: " +measure +"\n");
  }
}
